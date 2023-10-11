package com.sametersoyoglu.kbfilmlerapp.data.datasource

import com.sametersoyoglu.kbfilmlerapp.data.entity.Filmler
import com.sametersoyoglu.kbfilmlerapp.retrofit.FilmlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDataSource (var filmlerDao: FilmlerDao) {

    suspend fun filmleriYukle() : List<Filmler> =
        withContext(Dispatchers.IO) {
            // filmlerDao ile FilmlerDao interface inde ki filmleriYukle() fonksiyonuna eriştik. bize listeyi getirdi

            return@withContext filmlerDao.filmleriYukle().filmler
        }


}