package com.sametersoyoglu.kbfilmlerapp.data.repo

import com.sametersoyoglu.kbfilmlerapp.data.datasource.FilmlerDataSource
import com.sametersoyoglu.kbfilmlerapp.data.entity.Filmler

class FilmlerRepository (var filmlerDataSource : FilmlerDataSource) {

    //val filmlerDataSource = FilmlerDataSource() bu bağımlılığı hilt kullanmak için yukarıda tanımladık

    suspend fun filmleriYukle() : List<Filmler> = filmlerDataSource.filmleriYukle()

}