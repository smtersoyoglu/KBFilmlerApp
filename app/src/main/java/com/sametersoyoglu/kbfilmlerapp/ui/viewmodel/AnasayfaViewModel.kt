package com.sametersoyoglu.kbfilmlerapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sametersoyoglu.kbfilmlerapp.data.entity.Filmler
import com.sametersoyoglu.kbfilmlerapp.data.repo.FilmlerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {

    var filmlerRepository = FilmlerRepository()
    var filmlerListesi = MutableLiveData<List<Filmler>>()

    init {
        //init -AnasayfaViewModel den nesne oluşturduğumuz anda filmleri getir demek. uygulama ilk açıldığında filmleri getir demek.
        filmleriYukle()
    }
    fun filmleriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            filmlerListesi.value = filmlerRepository.filmleriYukle()

        }
    }
}