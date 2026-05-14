package com.mindmatrix.virasatnamma.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class VirasatRepository @Inject constructor(
    private val db: VirasatDatabase,
) {
    private val sites = db.heritageSiteDao()
    private val checkIns = db.checkInDao()
    private val progress = db.userProgressDao()
    private val favorites = db.favoriteDao()
    private val achievements = db.userAchievementDao()

    fun allSites(): Flow<List<HeritageSite>> = sites.getAllSites()
    fun favoriteSites(): Flow<List<HeritageSite>> = favorites.getFavoriteSites()
    fun checkInHistory(): Flow<List<CheckInWithSite>> = checkIns.getCheckInHistory()
    fun achievements(): Flow<List<UserAchievement>> = achievements.getAchievements()
    fun userProgress(): Flow<UserProgress?> = progress.getUserProgress()

    fun siteState(siteId: String): Flow<SiteWithState?> =
        combine(
            sites.getSiteById(siteId),
            favorites.isFavorite(siteId),
            checkIns.isVisited(siteId),
            checkIns.isHiddenFactUnlocked(siteId),
        ) { site, favorite, visited, unlocked ->
            site?.let { SiteWithState(it, favorite, visited, unlocked) }
        }

    fun sitesWithState(): Flow<List<SiteWithState>> =
        combine(sites.getAllSites(), favorites.getAllFavorites(), checkIns.getAllCheckIns()) { siteList, favs, visits ->
            val favIds = favs.map { it.siteId }.toSet()
            val visitedIds = visits.map { it.siteId }.toSet()
            val unlockedIds = visits.filter { it.hasUnlockedHiddenFact }.map { it.siteId }.toSet()
            siteList.map { SiteWithState(it, it.siteId in favIds, it.siteId in visitedIds, it.siteId in unlockedIds) }
        }

    suspend fun ensureSeedData() {
        if (sites.countSites() == 0) {
            sites.insertSites(SeedData.sites)
            progress.insertUserProgress(UserProgress())
        }
    }

    suspend fun saveSite(site: HeritageSite) {
        sites.insertSite(site)
    }

    suspend fun deleteSite(siteId: String) {
        favorites.deleteForSite(siteId)
        checkIns.deleteForSite(siteId)
        sites.deleteSite(siteId)
        refreshProgress()
    }

    suspend fun toggleFavorite(siteId: String, nowFavorite: Boolean) {
        if (nowFavorite) favorites.insertFavorite(Favorite(siteId, System.currentTimeMillis())) else favorites.removeFavorite(siteId)
    }

    suspend fun checkIn(siteId: String) {
        checkIns.insertCheckIn(CheckIn(siteId = siteId, timestamp = System.currentTimeMillis()))
        refreshProgress()
        unlockAchievementIfNeeded(Achievement.FIRST_VISIT, 1)
    }

    suspend fun unlockHiddenFact(siteId: String) {
        val existing = checkIns.getCheckInsForSite(siteId).first()
        if (existing.isEmpty()) {
            checkIns.insertCheckIn(CheckIn(siteId = siteId, timestamp = System.currentTimeMillis(), hasUnlockedHiddenFact = true))
        } else {
            checkIns.unlockHiddenFact(siteId)
        }
        refreshProgress()
    }

    suspend fun setLanguage(language: String) {
        val current = progress.getUserProgress().first() ?: UserProgress()
        progress.insertUserProgress(current.copy(favoriteLanguage = language))
    }

    suspend fun updateProfile(displayName: String, placeFrom: String) {
        val current = progress.getUserProgressOnce() ?: UserProgress()
        progress.insertUserProgress(
            current.copy(
                displayName = displayName.trim(),
                placeFrom = placeFrom.trim(),
            ),
        )
    }

    suspend fun siteById(siteId: String): HeritageSite? = sites.getSiteByIdOnce(siteId)

    private suspend fun refreshProgress() {
        val visits = checkIns.getTotalVisits().first()
        val distinct = checkIns.getTotalSitesVisited().first()
        val facts = checkIns.getTotalHiddenFactsUnlocked().first()
        val current = progress.getUserProgress().first() ?: UserProgress()
        progress.insertUserProgress(current.copy(totalVisits = visits, sitesVisited = distinct, hiddenFactsUnlocked = facts))
        if (facts >= Achievement.FACT_HUNTER.requirement) unlockAchievementIfNeeded(Achievement.FACT_HUNTER, facts)
        if (distinct >= Achievement.HERITAGE_MASTER.requirement) unlockAchievementIfNeeded(Achievement.HERITAGE_MASTER, distinct)
    }

    private suspend fun unlockAchievementIfNeeded(achievement: Achievement, progressValue: Int) {
        achievements.upsert(UserAchievement(achievement.id, System.currentTimeMillis(), progressValue))
    }
}
