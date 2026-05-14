package com.mindmatrix.virasatnamma;

import android.app.Application;
import com.mindmatrix.virasatnamma.data.VirasatRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AppViewModel_Factory implements Factory<AppViewModel> {
  private final Provider<Application> applicationProvider;

  private final Provider<VirasatRepository> repositoryProvider;

  public AppViewModel_Factory(Provider<Application> applicationProvider,
      Provider<VirasatRepository> repositoryProvider) {
    this.applicationProvider = applicationProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AppViewModel get() {
    return newInstance(applicationProvider.get(), repositoryProvider.get());
  }

  public static AppViewModel_Factory create(Provider<Application> applicationProvider,
      Provider<VirasatRepository> repositoryProvider) {
    return new AppViewModel_Factory(applicationProvider, repositoryProvider);
  }

  public static AppViewModel newInstance(Application application, VirasatRepository repository) {
    return new AppViewModel(application, repository);
  }
}
