package com.mindmatrix.virasatnamma.data;

@kotlin.Metadata(k = 1, mv = {2, 0, 0}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\u0008\u000C\u0008\u0087\u0008\u0012\u0001\u0000\u0018\u0000B#\u0012\u0006\u0008\u0002\u0010\u0002(\u0001\u0012\u0004\u0010\u0004(\u0002\u0012\u0004\u0010\u0006(\u0003\u0012\u0006\u0008\u0002\u0010\u0008(\u0004\u00A2\u0006\u0004\u0008\n\u0010\u000BJ\u0007\u0010\u000C8\u0001H\u00C6\u0003J\u0007\u0010\r8\u0002H\u00C6\u0003J\u0007\u0010\u000E8\u0003H\u00C6\u0003J\u0007\u0010\u000F8\u0004H\u00C6\u0003J'\u0010\u00102\u0006\u0008\u0002\u0010\u0002(\u00012\u0006\u0008\u0002\u0010\u0004(\u00022\u0006\u0008\u0002\u0010\u0006(\u00032\u0006\u0008\u0002\u0010\u0008(\u00048\u0005H\u00C6\u0001J\r\u0010\u00112\u0004\u0010\u0012(\u00068\u0004H\u00D6\u0003J\u0007\u0010\u00138\u0001H\u00D6\u0001J\u0007\u0010\u00148\u0002H\u00D6\u0001R\u000E\u0010\u00028\u0006H\u0001X\u0087\u0004\u00A2\u0006\u0002\n\u0000R\t\u0010\u0004H\u0002\u00A2\u0006\u0002\n\u0000R\t\u0010\u0006H\u0003\u00A2\u0006\u0002\n\u0000R\t\u0010\u0008H\u0004\u00A2\u0006\u0002\n\u0000\u00F2\u0001\u001E\n\u00020\u0001\n\u00020\u0003\n\u00020\u0005\n\u00020\u0007\n\u00020\t\n\u00020\u0000\n\u0004\u0018\u00010\u0001\u00A8\u0006\u0015"}, d2 = {"Lcom/mindmatrix/virasatnamma/data/CheckIn;", "", "id", "", "siteId", "", "timestamp", "", "hasUnlockedHiddenFact", "", "<init>", "(ILjava/lang/String;JZ)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, xs= "", pn = "", xi = 48)
@androidx.room.Entity(tableName = "check_ins")
public final class CheckIn {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int id = 0;

    @org.jetbrains.annotations.NotNull()
    private final java.lang.String siteId = null;

    private final long timestamp = 0L;

    private final boolean hasUnlockedHiddenFact = false;

    @org.jetbrains.annotations.NotNull()
    public final com.mindmatrix.virasatnamma.data.CheckIn copy(int id, @org.jetbrains.annotations.NotNull() java.lang.String siteId, long timestamp, boolean hasUnlockedHiddenFact) {
        return null;
    }

    public boolean equals(@org.jetbrains.annotations.Nullable() java.lang.Object other) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }

    public CheckIn(int id, @org.jetbrains.annotations.NotNull() java.lang.String siteId, long timestamp, boolean hasUnlockedHiddenFact) {
        super();
    }

    public final int component1() {
        return 0;
    }

    public final int getId() {
        return 0;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSiteId() {
        return null;
    }

    public final long component3() {
        return 0L;
    }

    public final long getTimestamp() {
        return 0L;
    }

    public final boolean component4() {
        return false;
    }

    public final boolean getHasUnlockedHiddenFact() {
        return false;
    }
}
