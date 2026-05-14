package com.mindmatrix.virasatnamma.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heritage_sites")
data class HeritageSite(
    @PrimaryKey val siteId: String,
    val name: String,
    val nameKannada: String,
    val description: String,
    val descriptionKannada: String,
    val latitude: Double,
    val longitude: Double,
    val audioFilePathEn: String?,
    val audioFilePathKn: String?,
    val imageUris: String,
    val hiddenFact: String,
    val hiddenFactKannada: String,
    val category: String,
    val era: String,
    val significance: String,
    val isUserCreated: Boolean = false,
)

@Entity(tableName = "check_ins")
data class CheckIn(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val siteId: String,
    val timestamp: Long,
    val hasUnlockedHiddenFact: Boolean = false,
)

@Entity(tableName = "user_progress")
data class UserProgress(
    @PrimaryKey val userId: Int = 1,
    val totalVisits: Int = 0,
    val sitesVisited: Int = 0,
    val hiddenFactsUnlocked: Int = 0,
    val favoriteLanguage: String = "en",
    val displayName: String = "",
    val placeFrom: String = "",
)

@Entity(tableName = "favorites")
data class Favorite(
    @PrimaryKey val siteId: String,
    val addedTimestamp: Long,
)

@Entity(tableName = "user_achievements")
data class UserAchievement(
    @PrimaryKey val achievementId: String,
    val unlockedAt: Long,
    val progress: Int,
)

data class CheckInWithSite(
    @Embedded val site: HeritageSite,
    val checkInId: Int,
    val timestamp: Long,
    val hasUnlockedHiddenFact: Boolean,
)

data class SiteWithState(
    val site: HeritageSite,
    val isFavorite: Boolean,
    val isVisited: Boolean,
    val hiddenUnlocked: Boolean,
)

enum class Achievement(
    val id: String,
    val titleEn: String,
    val titleKn: String,
    val description: String,
    val requirement: Int,
) {
    FIRST_VISIT("first_visit", "First Steps", "ಮೊದಲ ಹೆಜ್ಜೆ", "Check in at your first heritage site", 1),
    TEMPLE_EXPLORER("temple_explorer", "Temple Explorer", "ದೇವಾಲಯ ಪರಿಶೋಧಕ", "Visit 10 temples", 10),
    FACT_HUNTER("fact_hunter", "Fact Hunter", "ಸತ್ಯ ಬೇಟೆಗಾರ", "Unlock 5 hidden facts", 5),
    HERITAGE_MASTER("heritage_master", "Heritage Master", "ಪರಂಪರೆ ಗುರು", "Visit 50 different sites", 50),
    WEEKEND_WARRIOR("weekend_warrior", "Weekend Warrior", "ವಾರಾಂತ್ಯ ಯೋಧ", "Visit 3 sites in one weekend", 3),
}

fun HeritageSite.imageList(): List<String> = imageUris.split("|").map { it.trim() }.filter { it.isNotBlank() }
