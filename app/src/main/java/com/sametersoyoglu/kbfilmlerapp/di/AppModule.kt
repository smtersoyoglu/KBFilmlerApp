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

    @Provides // @ApplicationContext context: Context bunu kullanmamızın sebebi bize Context gerekiyor bunu dışarıdan ver dedik.(içeride oluşturamıyoruz)
    @Singleton // bunu normalde dışarıdan sağlamamız gerekiyor fakat @ApplicationContext bu notasyon sayesinde hilt kütüphanesi bize bunu kendisi vericek.
    fun provideFilmlerDao(@ApplicationContext context:Context) : FilmlerDao {
        // veri tabanı ile ilgili çalışma yapmamız gerek onu tetiklemek çalıştırmak ve kopyalama işlemleri için
        val veriTabani = Room.databaseBuilder(context,Veritabani::class.java,"filmler_app.sqlite")  // ilk satırda veritabanına erişme işlemini ,
            .createFromAsset("filmler_app.sqlite").build() // .createFromAsset("rehber.sqlite").build() bölümündede kopyalama işlemini yaptık. uygulama ilk çalıştığında 1 kere kopyalama yapıcak daha sonra erişmeye başlıcak
        return veriTabani.getFilmlerDao() // bu fonksiyon sayesinde KisilerDao'u KisilerDataSource'a orda tanımladığımız kisilerDao 'a ileticez.
    }


}