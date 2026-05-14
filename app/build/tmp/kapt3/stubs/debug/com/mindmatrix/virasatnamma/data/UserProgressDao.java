package com.mindmatrix.virasatnamma.data;

@kotlin.Metadata(k = 1, mv = {2, 0, 0}, d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008g\u0012\u0001\u0000\u0018\u0000J\u0006\u0010\u00028\u0002H'J\u000C\u0010\u00058\u0001H\u00A7@\u00A2\u0006\u0002\u0010\u0006J\u0012\u0010\u00072\u0004\u0010\t(\u00048\u0003H\u00A7@\u00A2\u0006\u0002\u0010\nJ\u0012\u0010\u000B2\u0004\u0010\t(\u00048\u0003H\u00A7@\u00A2\u0006\u0002\u0010\n\u00F2\u0001\u001A\n\u00020\u0001\n\u0004\u0018\u00010\u0004\n\u0006\u0012\u0002\u0018\u00010\u0003\n\u00020\u0008\n\u00020\u0004\u00A8\u0006\u000C"}, d2 = {"Lcom/mindmatrix/virasatnamma/data/UserProgressDao;", "", "getUserProgress", "Lkotlinx/coroutines/flow/Flow;", "Lcom/mindmatrix/virasatnamma/data/UserProgress;", "getUserProgressOnce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUserProgress", "", "progress", "(Lcom/mindmatrix/virasatnamma/data/UserProgress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProgress", "app_debug"}, xs= "", pn = "", xi = 48)
@androidx.room.Dao()
public abstract interface UserProgressDao {

    @androidx.room.Query(value = "SELECT * FROM user_progress WHERE userId = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.mindmatrix.virasatnamma.data.UserProgress> getUserProgress();

    @androidx.room.Query(value = "SELECT * FROM user_progress WHERE userId = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserProgressOnce(@org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super com.mindmatrix.virasatnamma.data.UserProgress> $completion);

    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUserProgress(@org.jetbrains.annotations.NotNull() com.mindmatrix.virasatnamma.data.UserProgress progress, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);

    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUserProgress(@org.jetbrains.annotations.NotNull() com.mindmatrix.virasatnamma.data.UserProgress progress, @org.jetbrains.annotations.NotNull() kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
