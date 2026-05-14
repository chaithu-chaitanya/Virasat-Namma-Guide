package com.mindmatrix.virasatnamma.data;

@kotlin.Metadata(k = 1, mv = {2, 0, 0}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000E\n\u0002\u0008\r\n\u0002\u0010\u000B\n\u0002\u0008\u0004\u0008\u0087\u0008\u0012\u0001\u0000\u0018\u0000B?\u0012\u0006\u0008\u0002\u0010\u0002(\u0001\u0012\u0006\u0008\u0002\u0010\u0004(\u0001\u0012\u0006\u0008\u0002\u0010\u0005(\u0001\u0012\u0006\u0008\u0002\u0010\u0006(\u0001\u0012\u0006\u0008\u0002\u0010\u0007(\u0002\u0012\u0006\u0008\u0002\u0010\t(\u0002\u0012\u0006\u0008\u0002\u0010\n(\u0002\u00A2\u0006\u0004\u0008\u000B\u0010\u000CJ\u0007\u0010\r8\u0001H\u00C6\u0003J\u0007\u0010\u000E8\u0001H\u00C6\u0003J\u0007\u0010\u000F8\u0001H\u00C6\u0003J\u0007\u0010\u00108\u0001H\u00C6\u0003J\u0007\u0010\u00118\u0002H\u00C6\u0003J\u0007\u0010\u00128\u0002H\u00C6\u0003J\u0007\u0010\u00138\u0002H\u00C6\u0003J?\u0010\u00142\u0006\u0008\u0002\u0010\u0002(\u00012\u0006\u0008\u0002\u0010\u0004(\u00012\u0006\u0008\u0002\u0010\u0005(\u00012\u0006\u0008\u0002\u0010\u0006(\u00012\u0006\u0008\u0002\u0010\u0007(\u00022\u0006\u0008\u0002\u0010\t(\u00022\u0006\u0008\u0002\u0010\n(\u00028\u0003H\u00C6\u0001J\r\u0010\u00152\u0004\u0010\u0017(\u00058\u0004H\u00D6\u0003J\u0007\u0010\u00188\u0001H\u00D6\u0001J\u0007\u0010\u00198\u0002H\u00D6\u0001R\u000E\u0010\u00028\u0006H\u0001X\u0087\u0004\u00A2\u0006\u0002\n\u0000R\t\u0010\u0004H\u0001\u00A2\u0006\u0002\n\u0000R\t\u0010\u0005H\u0001\u00A2\u0006\u0002\n\u0000R\t\u0010\u0006H\u0001\u00A2\u0006\u0002\n\u0000R\t\u0010\u0007H\u0002\u00A2\u0006\u0002\n\u0000R\t\u0010\tH\u0002\u00A2\u0006\u0002\n\u0000R\t\u0010\nH\u0002\u00A2\u0006\u0002\n\u0000\u00F2\u0001\u001A\n\u00020\u0001\n\u00020\u0003\n\u00020\u0008\n\u00020\u0000\n\u00020\u0016\n\u0004\u0018\u00010\u0001\u00A8\u0006\u001A"}, d2 = {"Lcom/mindmatrix/virasatnamma/data/UserProgress;", "", "userId", "", "totalVisits", "sitesVisited", "hiddenFactsUnlocked", "favoriteLanguage", "", "displayName", "placeFrom", "<init>", "(IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, xs= "", pn = "", xi = 48)
@androidx.room.Entity(tableName = "user_progress")
public final class UserProgress {
    @androidx.room.PrimaryKey()
    private final int userId = 0;

    private final int totalVisits = 0;

    private final int sitesVisited = 0;

    private final int hiddenFactsUnlocked = 0;

    @org.jetbrains.annotations.NotNull()
    private final java.lang.String favoriteLanguage = null;

    @org.jetbrains.annotations.NotNull()
    private final java.lang.String displayName = null;

    @org.jetbrains.annotations.NotNull()
    private final java.lang.String placeFrom = null;

    public UserProgress() {
        super();
    }

    @org.jetbrains.annotations.NotNull()
    public final com.mindmatrix.virasatnamma.data.UserProgress copy(int userId, int totalVisits, int sitesVisited, int hiddenFactsUnlocked, @org.jetbrains.annotations.NotNull() java.lang.String favoriteLanguage, @org.jetbrains.annotations.NotNull() java.lang.String displayName, @org.jetbrains.annotations.NotNull() java.lang.String placeFrom) {
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

    public UserProgress(int userId, int totalVisits, int sitesVisited, int hiddenFactsUnlocked, @org.jetbrains.annotations.NotNull() java.lang.String favoriteLanguage, @org.jetbrains.annotations.NotNull() java.lang.String displayName, @org.jetbrains.annotations.NotNull() java.lang.String placeFrom) {
        super();
    }

    public final int component1() {
        return 0;
    }

    public final int getUserId() {
        return 0;
    }

    public final int component2() {
        return 0;
    }

    public final int getTotalVisits() {
        return 0;
    }

    public final int component3() {
        return 0;
    }

    public final int getSitesVisited() {
        return 0;
    }

    public final int component4() {
        return 0;
    }

    public final int getHiddenFactsUnlocked() {
        return 0;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFavoriteLanguage() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDisplayName() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlaceFrom() {
        return null;
    }
}
