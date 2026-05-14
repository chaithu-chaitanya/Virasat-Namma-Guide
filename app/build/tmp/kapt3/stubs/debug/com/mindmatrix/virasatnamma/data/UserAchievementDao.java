package com.mindmatrix.virasatnamma.data;

@kotlin.Metadata(k = 1, mv = {2, 0, 0}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008g\u0012\u0001\u0000\u0018\u0000J\u0006\u0010\u00028\u0003H'J\u0012\u0010\u00062\u0004\u0010\u0008(\u00018\u0004H\u00A7@\u00A2\u0006\u0002\u0010\t\u00F2\u0001\u001C\n\u00020\u0001\n\u00020\u0005\n\u0006\u0012\u0002\u0018\u00010\u0004\n\u0006\u0012\u0002\u0018\u00020\u0003\n\u00020\u0007\u00A8\u0006\n"}, d2 = {"Lcom/mindmatrix/virasatnamma/data/UserAchievementDao;", "", "getAchievements", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/mindmatrix/virasatnamma/data/UserAchievement;", "upsert", "", "achievement", "(Lcom/mindmatrix/virasatnamma/data/UserAchievement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, xs= "", pn = "", xi = 48)
@androidx.room.Dao()
public abstract interface UserAchievementDao {

    @androidx.room.Query(value = "SELECT * FROM user_achievements")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.virasatnamma.data.UserAchievement>> getAchievements();

    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull() com.mindmatrix.virasatnamma.data.UserAchievement achievement, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
