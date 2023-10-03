package com.sametersoyoglu.kbfilmlerapp.room

import androidx.room.Dao
import androidx.room.Query
import com.sametersoyoglu.kbfilmlerapp.data.entity.Filmler

@Dao
interface FilmlerDao {
    // Dao interface'i Veritabanı üzerindeki tablolarımızda yapacağımız işlemleri temsil eden sınıf.Örn; Silme, Ekleme vb işlemleri yaptığımız yer.
    // veritabanı üzerinde bizim sorgular oluşturmamızı sağlayan yerdir bu sorgularla veritabanı üzerinde işlemler yaparız.

    @Query("SELECT * FROM filmler")
    suspend fun filmleriYukle() : List<Filmler>

}