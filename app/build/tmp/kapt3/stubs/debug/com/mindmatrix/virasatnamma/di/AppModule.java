package com.mindmatrix.virasatnamma.di;

@kotlin.Metadata(k = 1, mv = {2, 0, 0}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u00C7\u0002\u0012\u0001\u0000\u0018\u0000B\t\u0008\u0002\u00A2\u0006\u0004\u0008\u0002\u0010\u0003J\u000E\u0010\u00042\u0006\u0008\u0001\u0010\u0006(\u00028\u0001H\u0007J\u000C\u0010\u00082\u0004\u0010\n(\u00018\u0003H\u0007\u00F2\u0001\u0010\n\u00020\u0001\n\u00020\u0005\n\u00020\u0007\n\u00020\t\u00A8\u0006\u000B"}, d2 = {"Lcom/mindmatrix/virasatnamma/di/AppModule;", "", "<init>", "()V", "provideDatabase", "Lcom/mindmatrix/virasatnamma/data/VirasatDatabase;", "context", "Landroid/content/Context;", "provideRepository", "Lcom/mindmatrix/virasatnamma/data/VirasatRepository;", "database", "app_debug"}, xs= "", pn = "", xi = 48)
@dagger.Module()
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.mindmatrix.virasatnamma.di.AppModule INSTANCE = null;

    private AppModule() {
        super();
    }

    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.mindmatrix.virasatnamma.data.VirasatDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext() @org.jetbrains.annotations.NotNull() android.content.Context context) {
        return null;
    }

    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.mindmatrix.virasatnamma.data.VirasatRepository provideRepository(@org.jetbrains.annotations.NotNull() com.mindmatrix.virasatnamma.data.VirasatDatabase database) {
        return null;
    }
}
