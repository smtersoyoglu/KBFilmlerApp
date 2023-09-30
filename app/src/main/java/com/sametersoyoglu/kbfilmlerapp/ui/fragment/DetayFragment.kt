package com.sametersoyoglu.kbfilmlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.sametersoyoglu.kbfilmlerapp.R
import com.sametersoyoglu.kbfilmlerapp.databinding.FragmentDetayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {

    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        // gönderilen verileri alma
        val bundle : DetayFragmentArgs by navArgs()
        val film = bundle.film

        binding.filmNesnesi = film // DataBinding ile xml de filmNesnesi oluşturup bilgileri orda çektik.

        // toolbar'a film nesnesinden ad ı cekerek her resimde o resmin adını toolbarda gösterme
        //binding.toolbarDetay.title = film.ad  - DataBinding ile xml de filmNesnesi oluşturarak bu bilgiyi çekiyoruz.

        // resmi cekme
        binding.imageViewFilm.setImageResource(resources.getIdentifier(film.resim,"drawable",requireContext().packageName))

        // her resmin kendine özgü fiyatını cekme detay sayfasında
        //binding.textViewFiyat.text = "${film.fiyat} ₺"  - DataBinding ile xml de filmNesnesi oluşturarak bu bilgiyi çekiyoruz.

    }
}