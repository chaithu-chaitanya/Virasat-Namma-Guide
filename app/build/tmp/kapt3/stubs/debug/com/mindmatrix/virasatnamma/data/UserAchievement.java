package com.mindmatrix.virasatnamma.data;

@kotlin.Metadata(k = 1, mv = {2, 0, 0}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000B\n\u0002\u0008\u0004\u0008\u0087\u0008\u0012\u0001\u0000\u0018\u0000B\u0019\u0012\u0004\u0010\u0002(\u0001\u0012\u0004\u0010\u0004(\u0002\u0012\u0004\u0010\u0006(\u0003\u00A2\u0006\u0004\u0008\u0008\u0010\tJ\u0007\u0010\n8\u0001H\u00C6\u0003J\u0007\u0010\u000B8\u0002H\u00C6\u0003J\u0007\u0010\u000C8\u0003H\u00C6\u0003J\u001F\u0010\r2\u0006\u0008\u0002\u0010\u0002(\u00012\u0006\u0008\u0002\u0010\u0004(\u00022\u0006\u0008\u0002\u0010\u0006(\u00038\u0004H\u00C6\u0001J\r\u0010\u000E2\u0004\u0010\u0010(\u00068\u0005H\u00D6\u0003J\u0007\u0010\u00118\u0003H\u00D6\u0001J\u0007\u0010\u00128\u0001H\u00D6\u0001R\u000E\u0010\u00028\u0006H\u0001X\u0087\u0004\u00A2\u0006\u0002\n\u0000R\t\u0010\u0004H\u0002\u00A2\u0006\u0002\n\u0000R\t\u0010\u0006H\u0003\u00A2\u0006\u0002\n\u0000\u00F2\u0001\u001E\n\u00020\u0001\n\u00020\u0003\n\u00020\u0005\n\u00020\u0007\n\u00020\u0000\n\u00020\u000F\n\u0004\u0018\u00010\u0001\u00A8\u0006\u0013"}, d2 = {"Lcom/mindmatrix/virasatnamma/data/UserAchievement;", "", "achievementId", "", "unlockedAt", "", "progress", "", "<init>", "(Ljava/lang/String;JI)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, xs= "", pn = "", xi = 48)
@androidx.room.Entity(tableName = "user_achievements")
public final class UserAchievement {
    @androidx.room.PrimaryKey()
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String achievementId = null;

    private final long unlockedAt = 0L;

    private final int progress = 0;

    @org.jetbrains.annotations.NotNull()
    public final com.mindmatrix.virasatnamma.data.UserAchievement copy(@org.jetbrains.annotations.NotNull() java.lang.String achievementId, long unlockedAt, int progress) {
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

    public UserAchievement(@org.jetbrains.annotations.NotNull() java.lang.String achievementId, long unlockedAt, int progress) {
        super();
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAchievementId() {
        return null;
    }

    public final long component2() {
        return 0L;
    }

    public final long getUnlockedAt() {
        return 0L;
    }

    public final int component3() {
        return 0;
    }

    public final int getProgress() {
        return 0;
    }
}
