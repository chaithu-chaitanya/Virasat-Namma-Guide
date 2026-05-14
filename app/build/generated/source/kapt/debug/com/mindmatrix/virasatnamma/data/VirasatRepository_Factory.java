package com.mindmatrix.virasatnamma.data;

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
public final class VirasatRepository_Factory implements Factory<VirasatRepository> {
  private final Provider<VirasatDatabase> dbProvider;

  public VirasatRepository_Factory(Provider<VirasatDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public VirasatRepository get() {
    return newInstance(dbProvider.get());
  }

  public static VirasatRepository_Factory create(Provider<VirasatDatabase> dbProvider) {
    return new VirasatRepository_Factory(dbProvider);
  }

  public static VirasatRepository newInstance(VirasatDatabase db) {
    return new VirasatRepository(db);
  }
}
