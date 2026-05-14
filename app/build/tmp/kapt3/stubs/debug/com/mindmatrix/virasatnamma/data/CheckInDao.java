package com.mindmatrix.virasatnamma.data;

@kotlin.Metadata(k = 1, mv = {2, 0, 0}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008g\u0012\u0001\u0000\u0018\u0000J\u0012\u0010\u00022\u0004\u0010\u0004(\u00028\u0001H\u00A7@\u00A2\u0006\u0002\u0010\u0006J\u0006\u0010\u00078\u0004H'J\u000C\u0010\n2\u0004\u0010\u000B(\u00058\u0004H'J\u000C\u0010\r2\u0004\u0010\u000B(\u00058\u0007H'J\u000C\u0010\u000F2\u0004\u0010\u000B(\u00058\u0007H'J\u0006\u0010\u00108\tH'J\u0006\u0010\u00128\tH'J\u0006\u0010\u00138\tH'J\u0012\u0010\u00142\u0004\u0010\u000B(\u00058\nH\u00A7@\u00A2\u0006\u0002\u0010\u0016J\u0012\u0010\u00172\u0004\u0010\u000B(\u00058\nH\u00A7@\u00A2\u0006\u0002\u0010\u0016J\u0006\u0010\u00188\rH'\u00F2\u0001P\n\u00020\u0001\n\u00020\u0003\n\u00020\u0005\n\u0006\u0012\u0002\u0018\u00020\t\n\u0006\u0012\u0002\u0018\u00030\u0008\n\u00020\u000C\n\u00020\u000E\n\u0006\u0012\u0002\u0018\u00060\u0008\n\u00020\u0011\n\u0006\u0012\u0002\u0018\u00080\u0008\n\u00020\u0015\n\u00020\u0019\n\u0006\u0012\u0002\u0018\u000B0\t\n\u0006\u0012\u0002\u0018\u000C0\u0008\u00A8\u0006\u001A"}, d2 = {"Lcom/mindmatrix/virasatnamma/data/CheckInDao;", "", "insertCheckIn", "", "checkIn", "Lcom/mindmatrix/virasatnamma/data/CheckIn;", "(Lcom/mindmatrix/virasatnamma/data/CheckIn;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCheckIns", "Lkotlinx/coroutines/flow/Flow;", "", "getCheckInsForSite", "siteId", "", "isVisited", "", "isHiddenFactUnlocked", "getTotalSitesVisited", "", "getTotalVisits", "getTotalHiddenFactsUnlocked", "unlockHiddenFact", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteForSite", "getCheckInHistory", "Lcom/mindmatrix/virasatnamma/data/CheckInWithSite;", "app_debug"}, xs= "", pn = "", xi = 48)
@androidx.room.Dao()
public abstract interface CheckInDao {

    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCheckIn(@org.jetbrains.annotations.NotNull() com.mindmatrix.virasatnamma.data.CheckIn checkIn, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super java.lang.Long> $completion);

    @androidx.room.Query(value = "SELECT * FROM check_ins ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.virasatnamma.data.CheckIn>> getAllCheckIns();

    @androidx.room.Query(value = "SELECT * FROM check_ins WHERE siteId = :siteId ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.virasatnamma.data.CheckIn>> getCheckInsForSite(@org.jetbrains.annotations.NotNull() java.lang.String siteId);

    @androidx.room.Query(value = "SELECT EXISTS(SELECT 1 FROM check_ins WHERE siteId = :siteId)")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> isVisited(@org.jetbrains.annotations.NotNull() java.lang.String siteId);

    @androidx.room.Query(value = "SELECT EXISTS(SELECT 1 FROM check_ins WHERE siteId = :siteId AND hasUnlockedHiddenFact = 1)")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> isHiddenFactUnlocked(@org.jetbrains.annotations.NotNull() java.lang.String siteId);

    @androidx.room.Query(value = "SELECT COUNT(DISTINCT siteId) FROM check_ins")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getTotalSitesVisited();

    @androidx.room.Query(value = "SELECT COUNT(*) FROM check_ins")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getTotalVisits();

    @androidx.room.Query(value = "SELECT COUNT(*) FROM check_ins WHERE hasUnlockedHiddenFact = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getTotalHiddenFactsUnlocked();

    @androidx.room.Query(value = "UPDATE check_ins SET hasUnlockedHiddenFact = 1 WHERE siteId = :siteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object unlockHiddenFact(@org.jetbrains.annotations.NotNull() java.lang.String siteId, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);

    @androidx.room.Query(value = "DELETE FROM check_ins WHERE siteId = :siteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteForSite(@org.jetbrains.annotations.NotNull() java.lang.String siteId, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);

    @androidx.room.Transaction()
    @androidx.room.Query(value = "\n        SELECT hs.*, ci.id AS checkInId, ci.timestamp AS timestamp, ci.hasUnlockedHiddenFact AS hasUnlockedHiddenFact\n        FROM check_ins ci\n        INNER JOIN heritage_sites hs ON ci.siteId = hs.siteId\n        ORDER BY ci.timestamp DESC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.virasatnamma.data.CheckInWithSite>> getCheckInHistory();
}
