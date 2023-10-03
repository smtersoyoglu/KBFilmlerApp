package com.sametersoyoglu.kbfilmlerapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sametersoyoglu.kbfilmlerapp.data.entity.Filmler

@Database(entities = [Filmler::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    // abstract class yapmak zorundayız interface özelliği olan bir sınıf yapmak için
    // Veritabani erişim sınıfı : room veritabanına erişmek için oluşturduğumuz sınıf bu sınıf hem erişim hem de kopyalama işlemi yapıcak. veritabanımızı temsil eden sınıftır.
    // bu sınıf sayesinde veritabanı üzerinde işlemler yapabiliriz.

    // FilmlerDao interface'ine erişmek için fonksiyon tanımladık
    abstract fun getFilmlerDao() : FilmlerDao

}