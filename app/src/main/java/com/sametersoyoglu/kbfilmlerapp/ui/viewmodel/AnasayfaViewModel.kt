package com.sametersoyoglu.kbfilmlerapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sametersoyoglu.kbfilmlerapp.data.entity.Filmler
import com.sametersoyoglu.kbfilmlerapp.data.repo.FilmlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var filmlerRepository : FilmlerRepository) : ViewModel() {

    //var filmlerRepository = FilmlerRepository() bu bağımlılığı yukarıda tanımlıcaz hilt kullanabilmek için.
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