package com.mindmatrix.virasatnamma.data;

@kotlin.Metadata(k = 1, mv = {2, 0, 0}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000E\n\u0002\u0008\u0003\n\u0002\u0010\u000B\n\u0000\u0008g\u0012\u0001\u0000\u0018\u0000J\u0006\u0010\u00028\u0003H'J\u0006\u0010\u00068\u0006H'J\u0012\u0010\u00082\u0004\u0010\n(\u00018\u0007H\u00A7@\u00A2\u0006\u0002\u0010\u000BJ\u0012\u0010\u000C2\u0004\u0010\r(\u00088\u0007H\u00A7@\u00A2\u0006\u0002\u0010\u000FJ\u0012\u0010\u00102\u0004\u0010\r(\u00088\u0007H\u00A7@\u00A2\u0006\u0002\u0010\u000FJ\u000C\u0010\u00112\u0004\u0010\r(\u00088\nH'\u00F2\u0001@\n\u00020\u0001\n\u00020\u0005\n\u0006\u0012\u0002\u0018\u00010\u0004\n\u0006\u0012\u0002\u0018\u00020\u0003\n\u00020\u0007\n\u0006\u0012\u0002\u0018\u00040\u0004\n\u0006\u0012\u0002\u0018\u00050\u0003\n\u00020\t\n\u00020\u000E\n\u00020\u0012\n\u0006\u0012\u0002\u0018\t0\u0003\u00A8\u0006\u0013"}, d2 = {"Lcom/mindmatrix/virasatnamma/data/FavoriteDao;", "", "getAllFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/mindmatrix/virasatnamma/data/Favorite;", "getFavoriteSites", "Lcom/mindmatrix/virasatnamma/data/HeritageSite;", "insertFavorite", "", "favorite", "(Lcom/mindmatrix/virasatnamma/data/Favorite;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFavorite", "siteId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteForSite", "isFavorite", "", "app_debug"}, xs= "", pn = "", xi = 48)
@androidx.room.Dao()
public abstract interface FavoriteDao {

    @androidx.room.Query(value = "SELECT * FROM favorites ORDER BY addedTimestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.virasatnamma.data.Favorite>> getAllFavorites();

    @androidx.room.Query(value = "\n        SELECT hs.* FROM heritage_sites hs\n        INNER JOIN favorites f ON hs.siteId = f.siteId\n        ORDER BY f.addedTimestamp DESC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.virasatnamma.data.HeritageSite>> getFavoriteSites();

    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertFavorite(@org.jetbrains.annotations.NotNull() com.mindmatrix.virasatnamma.data.Favorite favorite, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);

    @androidx.room.Query(value = "DELETE FROM favorites WHERE siteId = :siteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeFavorite(@org.jetbrains.annotations.NotNull() java.lang.String siteId, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);

    @androidx.room.Query(value = "DELETE FROM favorites WHERE siteId = :siteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteForSite(@org.jetbrains.annotations.NotNull() java.lang.String siteId, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);

    @androidx.room.Query(value = "SELECT EXISTS(SELECT 1 FROM favorites WHERE siteId = :siteId)")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> isFavorite(@org.jetbrains.annotations.NotNull() java.lang.String siteId);
}
