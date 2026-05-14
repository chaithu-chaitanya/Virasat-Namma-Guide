package com.mindmatrix.virasatnamma.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface HeritageSiteDao {
    @Query("SELECT * FROM heritage_sites ORDER BY name")
    fun getAllSites(): Flow<List<HeritageSite>>

    @Query("SELECT * FROM heritage_sites WHERE siteId = :siteId")
    fun getSiteById(siteId: String): Flow<HeritageSite?>

    @Query("SELECT * FROM heritage_sites WHERE siteId = :siteId")
    suspend fun getSiteByIdOnce(siteId: String): HeritageSite?

    @Query("""
        SELECT * FROM heritage_sites
        WHERE (6371 * acos(
            cos(radians(:userLat)) * cos(radians(latitude)) *
            cos(radians(longitude) - radians(:userLng)) +
            sin(radians(:userLat)) * sin(radians(latitude))
        )) < :radiusKm
        ORDER BY name
    """)
    fun getSitesNearby(userLat: Double, userLng: Double, radiusKm: Double): Flow<List<HeritageSite>>

    @Query("SELECT * FROM heritage_sites WHERE category = :category ORDER BY name")
    fun getSitesByCategory(category: String): Flow<List<HeritageSite>>

    @Query("SELECT COUNT(*) FROM heritage_sites")
    suspend fun countSites(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSite(site: HeritageSite)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSites(sites: List<HeritageSite>)

    @Update
    suspend fun updateSite(site: HeritageSite)

    @Query("DELETE FROM heritage_sites WHERE siteId = :siteId")
    suspend fun deleteSite(siteId: String)
}

@Dao
interface CheckInDao {
    @Insert
    suspend fun insertCheckIn(checkIn: CheckIn): Long

    @Query("SELECT * FROM check_ins ORDER BY timestamp DESC")
    fun getAllCheckIns(): Flow<List<CheckIn>>

    @Query("SELECT * FROM check_ins WHERE siteId = :siteId ORDER BY timestamp DESC")
    fun getCheckInsForSite(siteId: String): Flow<List<CheckIn>>

    @Query("SELECT EXISTS(SELECT 1 FROM check_ins WHERE siteId = :siteId)")
    fun isVisited(siteId: String): Flow<Boolean>

    @Query("SELECT EXISTS(SELECT 1 FROM check_ins WHERE siteId = :siteId AND hasUnlockedHiddenFact = 1)")
    fun isHiddenFactUnlocked(siteId: String): Flow<Boolean>

    @Query("SELECT COUNT(DISTINCT siteId) FROM check_ins")
    fun getTotalSitesVisited(): Flow<Int>

    @Query("SELECT COUNT(*) FROM check_ins")
    fun getTotalVisits(): Flow<Int>

    @Query("SELECT COUNT(*) FROM check_ins WHERE hasUnlockedHiddenFact = 1")
    fun getTotalHiddenFactsUnlocked(): Flow<Int>

    @Query("UPDATE check_ins SET hasUnlockedHiddenFact = 1 WHERE siteId = :siteId")
    suspend fun unlockHiddenFact(siteId: String)

    @Query("DELETE FROM check_ins WHERE siteId = :siteId")
    suspend fun deleteForSite(siteId: String)

    @Transaction
    @Query("""
        SELECT hs.*, ci.id AS checkInId, ci.timestamp AS timestamp, ci.hasUnlockedHiddenFact AS hasUnlockedHiddenFact
        FROM check_ins ci
        INNER JOIN heritage_sites hs ON ci.siteId = hs.siteId
        ORDER BY ci.timestamp DESC
    """)
    fun getCheckInHistory(): Flow<List<CheckInWithSite>>
}

@Dao
interface UserProgressDao {
    @Query("SELECT * FROM user_progress WHERE userId = 1")
    fun getUserProgress(): Flow<UserProgress?>

    @Query("SELECT * FROM user_progress WHERE userId = 1")
    suspend fun getUserProgressOnce(): UserProgress?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProgress(progress: UserProgress)

    @Update
    suspend fun updateUserProgress(progress: UserProgress)
}

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorites ORDER BY addedTimestamp DESC")
    fun getAllFavorites(): Flow<List<Favorite>>

    @Query("""
        SELECT hs.* FROM heritage_sites hs
        INNER JOIN favorites f ON hs.siteId = f.siteId
        ORDER BY f.addedTimestamp DESC
    """)
    fun getFavoriteSites(): Flow<List<HeritageSite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Query("DELETE FROM favorites WHERE siteId = :siteId")
    suspend fun removeFavorite(siteId: String)

    @Query("DELETE FROM favorites WHERE siteId = :siteId")
    suspend fun deleteForSite(siteId: String)

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE siteId = :siteId)")
    fun isFavorite(siteId: String): Flow<Boolean>
}

@Dao
interface UserAchievementDao {
    @Query("SELECT * FROM user_achievements")
    fun getAchievements(): Flow<List<UserAchievement>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(achievement: UserAchievement)
}
