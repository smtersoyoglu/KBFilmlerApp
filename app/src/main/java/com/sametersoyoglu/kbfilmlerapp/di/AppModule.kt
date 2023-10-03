package com.sametersoyoglu.kbfilmlerapp.di

import android.content.Context
import androidx.room.Room
import com.sametersoyoglu.kbfilmlerapp.data.datasource.FilmlerDataSource
import com.sametersoyoglu.kbfilmlerapp.data.repo.FilmlerRepository
import com.sametersoyoglu.kbfilmlerapp.room.FilmlerDao
import com.sametersoyoglu.kbfilmlerapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFilmlerDataSource(filmlerDao: FilmlerDao) : FilmlerDataSource {
        return FilmlerDataSource(filmlerDao)
    }

    @Provides
    @Singleton // tek bir nesne oluşturup bir çok yerde kullanabiliyoruz.
    fun provideFilmlerRepository (filmlerDataSource : FilmlerDataSource) : FilmlerRepository {
        return FilmlerRepository(filmlerDataSource)
    }

    @Provides
    @Singleton
    fun provideFilmlerDao(@ApplicationContext context:Context) : FilmlerDao {
        val veriTabani = Room.databaseBuilder(context,Veritabani::class.java,"filmler_app.sqlite")
            .createFromAsset("filmler_app.sqlite").build()
        return veriTabani.getFilmlerDao()
    }

}