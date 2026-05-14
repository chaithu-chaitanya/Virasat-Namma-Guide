package com.mindmatrix.virasatnamma.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        HeritageSite::class,
        CheckIn::class,
        UserProgress::class,
        Favorite::class,
        UserAchievement::class,
    ],
    version = 2,
    exportSchema = false,
)
abstract class VirasatDatabase : RoomDatabase() {
    abstract fun heritageSiteDao(): HeritageSiteDao
    abstract fun checkInDao(): CheckInDao
    abstract fun userProgressDao(): UserProgressDao
    abstract fun favoriteDao(): FavoriteDao
    abstract fun userAchievementDao(): UserAchievementDao
}
