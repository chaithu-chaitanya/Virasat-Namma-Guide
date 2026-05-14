package com.mindmatrix.virasatnamma.data;

@kotlin.Metadata(k = 1, mv = {2, 0, 0}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000E\n\u0002\u0008\u0004\n\u0002\u0010\u0006\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0008g\u0012\u0001\u0000\u0018\u0000J\u0006\u0010\u00028\u0003H'J\u000C\u0010\u00062\u0004\u0010\u0007(\u00068\u0005H'J\u0012\u0010\t2\u0004\u0010\u0007(\u00068\u0004H\u00A7@\u00A2\u0006\u0002\u0010\nJ\u0018\u0010\u000B2\u0004\u0010\u000C(\u00072\u0004\u0010\u000E(\u00072\u0004\u0010\u000F(\u00078\u0003H'J\u000C\u0010\u00102\u0004\u0010\u0011(\u00068\u0003H'J\u000C\u0010\u00128\u0008H\u00A7@\u00A2\u0006\u0002\u0010\u0014J\u0012\u0010\u00152\u0004\u0010\u0017(\u00018\tH\u00A7@\u00A2\u0006\u0002\u0010\u0018J\u0012\u0010\u00192\u0004\u0010\u001A(\u00028\tH\u00A7@\u00A2\u0006\u0002\u0010\u001BJ\u0012\u0010\u001C2\u0004\u0010\u0017(\u00018\tH\u00A7@\u00A2\u0006\u0002\u0010\u0018J\u0012\u0010\u001D2\u0004\u0010\u0007(\u00068\tH\u00A7@\u00A2\u0006\u0002\u0010\n\u00F2\u00016\n\u00020\u0001\n\u00020\u0005\n\u0006\u0012\u0002\u0018\u00010\u0004\n\u0006\u0012\u0002\u0018\u00020\u0003\n\u0004\u0018\u00010\u0005\n\u0006\u0012\u0002\u0018\u00040\u0003\n\u00020\u0008\n\u00020\r\n\u00020\u0013\n\u00020\u0016\u00A8\u0006\u001E"}, d2 = {"Lcom/mindmatrix/virasatnamma/data/HeritageSiteDao;", "", "getAllSites", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/mindmatrix/virasatnamma/data/HeritageSite;", "getSiteById", "siteId", "", "getSiteByIdOnce", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSitesNearby", "userLat", "", "userLng", "radiusKm", "getSitesByCategory", "category", "countSites", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSite", "", "site", "(Lcom/mindmatrix/virasatnamma/data/HeritageSite;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSites", "sites", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSite", "deleteSite", "app_debug"}, xs= "", pn = "", xi = 48)
@androidx.room.Dao()
public abstract interface HeritageSiteDao {

    @androidx.room.Query(value = "SELECT * FROM heritage_sites ORDER BY name")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.virasatnamma.data.HeritageSite>> getAllSites();

    @androidx.room.Query(value = "SELECT * FROM heritage_sites WHERE siteId = :siteId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.mindmatrix.virasatnamma.data.HeritageSite> getSiteById(@org.jetbrains.annotations.NotNull() java.lang.String siteId);

    @androidx.room.Query(value = "SELECT * FROM heritage_sites WHERE siteId = :siteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSiteByIdOnce(@org.jetbrains.annotations.NotNull() java.lang.String siteId, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super com.mindmatrix.virasatnamma.data.HeritageSite> $completion);

    @androidx.room.Query(value = "\n        SELECT * FROM heritage_sites\n        WHERE (6371 * acos(\n            cos(radians(:userLat)) * cos(radians(latitude)) *\n            cos(radians(longitude) - radians(:userLng)) +\n            sin(radians(:userLat)) * sin(radians(latitude))\n        )) < :radiusKm\n        ORDER BY name\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.virasatnamma.data.HeritageSite>> getSitesNearby(double userLat, double userLng, double radiusKm);

    @androidx.room.Query(value = "SELECT * FROM heritage_sites WHERE category = :category ORDER BY name")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.virasatnamma.data.HeritageSite>> getSitesByCategory(@org.jetbrains.annotations.NotNull() java.lang.String category);

    @androidx.room.Query(value = "SELECT COUNT(*) FROM heritage_sites")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countSites(@org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);

    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSite(@org.jetbrains.annotations.NotNull() com.mindmatrix.virasatnamma.data.HeritageSite site, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);

    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSites(@org.jetbrains.annotations.NotNull() java.util.List<com.mindmatrix.virasatnamma.data.HeritageSite> sites, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);

    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSite(@org.jetbrains.annotations.NotNull() com.mindmatrix.virasatnamma.data.HeritageSite site, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);

    @androidx.room.Query(value = "DELETE FROM heritage_sites WHERE siteId = :siteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSite(@org.jetbrains.annotations.NotNull() java.lang.String siteId, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
