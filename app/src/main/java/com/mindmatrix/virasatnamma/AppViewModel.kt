package com.mindmatrix.virasatnamma

import android.app.Application
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.provider.Settings
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.mindmatrix.virasatnamma.data.Achievement
import com.mindmatrix.virasatnamma.data.CheckInWithSite
import com.mindmatrix.virasatnamma.data.HeritageSite
import com.mindmatrix.virasatnamma.data.SiteWithState
import com.mindmatrix.virasatnamma.data.UserAchievement
import com.mindmatrix.virasatnamma.data.UserProgress
import com.mindmatrix.virasatnamma.data.VirasatRepository
import com.mindmatrix.virasatnamma.util.ImageCompressor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import java.io.File

data class AudioUiState(
    val visible: Boolean = false,
    val siteName: String = "",
    val isPlaying: Boolean = false,
    val message: String = "Ready",
)

@HiltViewModel
class AppViewModel @Inject constructor(
    application: Application,
    private val repository: VirasatRepository,
) : AndroidViewModel(application) {
    val sites: StateFlow<List<SiteWithState>> = repository.sitesWithState()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
    val favorites: StateFlow<List<HeritageSite>> = repository.favoriteSites()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
    val history: StateFlow<List<CheckInWithSite>> = repository.checkInHistory()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
    val progress: StateFlow<UserProgress?> = repository.userProgress()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)
    val achievements: StateFlow<List<UserAchievement>> = repository.achievements()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    private val _audio = MutableStateFlow(AudioUiState())
    val audio = _audio.asStateFlow()
    private var mediaPlayer: MediaPlayer? = null

    init {
        viewModelScope.launch { repository.ensureSeedData() }
    }

    fun siteState(siteId: String): StateFlow<SiteWithState?> = repository.siteState(siteId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    fun toggleFavorite(siteId: String, favorite: Boolean) {
        viewModelScope.launch { repository.toggleFavorite(siteId, favorite) }
    }

    fun checkIn(siteId: String) {
        viewModelScope.launch { repository.checkIn(siteId) }
    }

    fun deleteSite(site: HeritageSite) {
        viewModelScope.launch {
            site.imageUris.split("|").filter { it.isNotBlank() }.forEach(ImageCompressor::deleteIfInternal)
            repository.deleteSite(site.siteId)
        }
    }

    fun saveSite(site: HeritageSite) {
        viewModelScope.launch { repository.saveSite(site) }
    }

    fun setLanguage(language: String) {
        viewModelScope.launch { repository.setLanguage(language) }
    }

    fun updateProfile(displayName: String, placeFrom: String) {
        viewModelScope.launch { repository.updateProfile(displayName, placeFrom) }
    }

    fun validateQrAndUnlock(payload: String, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            runCatching {
                val json = Gson().fromJson(payload, JsonObject::class.java)
                val type = json.get("type")?.asString
                val siteId = json.get("siteId")?.asString
                if (type != "virasat_namma" || siteId.isNullOrBlank()) error("This is not a Virasat-Namma QR code")
                val site = repository.siteById(siteId) ?: error("QR code not recognized")
                repository.unlockHiddenFact(site.siteId)
                onSuccess(site.siteId)
            }.onFailure { onError(it.message ?: "Invalid QR code") }
        }
    }

    fun playOrPauseAudio(site: HeritageSite, kannada: Boolean) {
        val current = mediaPlayer
        if (current != null && _audio.value.siteName == site.name) {
            if (current.isPlaying) {
                current.pause()
                _audio.value = _audio.value.copy(isPlaying = false, message = "Paused")
            } else {
                current.start()
                _audio.value = _audio.value.copy(isPlaying = true, message = "Playing")
            }
            return
        }
        stopAudio()
        val path = if (kannada) site.audioFilePathKn else site.audioFilePathEn
        runCatching {
            val player = MediaPlayer().apply {
                setAudioAttributes(AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build())
                if (path.isNullOrBlank()) {
                    setDataSource(getApplication(), Settings.System.DEFAULT_NOTIFICATION_URI)
                } else {
                    setDataSource(getApplication(), Uri.fromFile(File(path)))
                }
                setOnCompletionListener {
                    _audio.value = _audio.value.copy(isPlaying = false, message = "Finished")
                }
                prepare()
                start()
            }
            mediaPlayer = player
            _audio.value = AudioUiState(true, site.name, true, if (path.isNullOrBlank()) "Playing demo audio" else "Playing")
        }.onFailure {
            _audio.value = AudioUiState(true, site.name, false, "Audio unavailable, app stayed stable")
        }
    }

    fun stopAudio() {
        runCatching {
            mediaPlayer?.stop()
            mediaPlayer?.release()
        }
        mediaPlayer = null
        _audio.value = _audio.value.copy(isPlaying = false, visible = false)
    }

    override fun onCleared() {
        stopAudio()
        super.onCleared()
    }

    fun achievementInfo(id: String): Achievement? = Achievement.entries.firstOrNull { it.id == id }
}
