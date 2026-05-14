package com.mindmatrix.virasatnamma.di

import android.content.Context
import androidx.room.Room
import com.mindmatrix.virasatnamma.data.VirasatDatabase
import com.mindmatrix.virasatnamma.data.VirasatRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): VirasatDatabase =
        Room.databaseBuilder(context, VirasatDatabase::class.java, "virasat_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideRepository(database: VirasatDatabase): VirasatRepository = VirasatRepository(database)
}
