package com.sametersoyoglu.kbfilmlerapp.di


import com.sametersoyoglu.kbfilmlerapp.data.datasource.FilmlerDataSource
import com.sametersoyoglu.kbfilmlerapp.data.repo.FilmlerRepository
import com.sametersoyoglu.kbfilmlerapp.retrofit.ApiUtils
import com.sametersoyoglu.kbfilmlerapp.retrofit.FilmlerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideFilmlerDao() : FilmlerDao {
        return ApiUtils.getFilmlerDao()
    }


}