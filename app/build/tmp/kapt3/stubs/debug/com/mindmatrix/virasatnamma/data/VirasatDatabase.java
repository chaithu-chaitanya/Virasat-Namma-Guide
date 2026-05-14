package com.mindmatrix.virasatnamma.data;

@kotlin.Metadata(k = 1, mv = {2, 0, 0}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008'\u0012\u0001\u0000\u0018\u0000B\u0007\u00A2\u0006\u0004\u0008\u0002\u0010\u0003J\u0006\u0010\u00048\u0001H&J\u0006\u0010\u00068\u0002H&J\u0006\u0010\u00088\u0003H&J\u0006\u0010\n8\u0004H&J\u0006\u0010\u000C8\u0005H&\u00F2\u0001\u0018\n\u00020\u0001\n\u00020\u0005\n\u00020\u0007\n\u00020\t\n\u00020\u000B\n\u00020\r\u00A8\u0006\u000E"}, d2 = {"Lcom/mindmatrix/virasatnamma/data/VirasatDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "heritageSiteDao", "Lcom/mindmatrix/virasatnamma/data/HeritageSiteDao;", "checkInDao", "Lcom/mindmatrix/virasatnamma/data/CheckInDao;", "userProgressDao", "Lcom/mindmatrix/virasatnamma/data/UserProgressDao;", "favoriteDao", "Lcom/mindmatrix/virasatnamma/data/FavoriteDao;", "userAchievementDao", "Lcom/mindmatrix/virasatnamma/data/UserAchievementDao;", "app_debug"}, xs= "", pn = "", xi = 48)
@androidx.room.Database(entities = {com.mindmatrix.virasatnamma.data.HeritageSite.class, com.mindmatrix.virasatnamma.data.CheckIn.class, com.mindmatrix.virasatnamma.data.UserProgress.class, com.mindmatrix.virasatnamma.data.Favorite.class, com.mindmatrix.virasatnamma.data.UserAchievement.class}, version = 2, exportSchema = false)
public abstract class VirasatDatabase extends androidx.room.RoomDatabase {

    public VirasatDatabase() {
        super();
    }

    @org.jetbrains.annotations.NotNull()
    public abstract com.mindmatrix.virasatnamma.data.HeritageSiteDao heritageSiteDao();

    @org.jetbrains.annotations.NotNull()
    public abstract com.mindmatrix.virasatnamma.data.CheckInDao checkInDao();

    @org.jetbrains.annotations.NotNull()
    public abstract com.mindmatrix.virasatnamma.data.UserProgressDao userProgressDao();

    @org.jetbrains.annotations.NotNull()
    public abstract com.mindmatrix.virasatnamma.data.FavoriteDao favoriteDao();

    @org.jetbrains.annotations.NotNull()
    public abstract com.mindmatrix.virasatnamma.data.UserAchievementDao userAchievementDao();
}
