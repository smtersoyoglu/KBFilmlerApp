package com.sametersoyoglu.kbfilmlerapp.retrofit

import com.sametersoyoglu.kbfilmlerapp.data.entity.FilmlerCevap
import retrofit2.http.GET

interface FilmlerDao {
    // http://kasimadalan.pe.hu/filmler_yeni/tum_filmler.php
    // http://kasimadalan.pe.hu/ -> base url
    // filmler_yeni/tum_filmler.php -> webservis url

    @GET("filmler_yeni/tum_filmler.php")
    suspend fun filmleriYukle() : FilmlerCevap
}