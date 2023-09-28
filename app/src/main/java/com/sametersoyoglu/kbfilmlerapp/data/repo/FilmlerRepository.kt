package com.sametersoyoglu.kbfilmlerapp.data.repo

import com.sametersoyoglu.kbfilmlerapp.data.datasource.FilmlerDataSource
import com.sametersoyoglu.kbfilmlerapp.data.entity.Filmler

class FilmlerRepository {

    val filmlerDataSource = FilmlerDataSource()

    suspend fun filmleriYukle() : List<Filmler> = filmlerDataSource.filmleriYukle()

}