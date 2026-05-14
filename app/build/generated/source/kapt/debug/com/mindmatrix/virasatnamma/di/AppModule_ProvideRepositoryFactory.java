package com.mindmatrix.virasatnamma.di;

import com.mindmatrix.virasatnamma.data.VirasatDatabase;
import com.mindmatrix.virasatnamma.data.VirasatRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class AppModule_ProvideRepositoryFactory implements Factory<VirasatRepository> {
  private final Provider<VirasatDatabase> databaseProvider;

  public AppModule_ProvideRepositoryFactory(Provider<VirasatDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public VirasatRepository get() {
    return provideRepository(databaseProvider.get());
  }

  public static AppModule_ProvideRepositoryFactory create(
      Provider<VirasatDatabase> databaseProvider) {
    return new AppModule_ProvideRepositoryFactory(databaseProvider);
  }

  public static VirasatRepository provideRepository(VirasatDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideRepository(database));
  }
}
