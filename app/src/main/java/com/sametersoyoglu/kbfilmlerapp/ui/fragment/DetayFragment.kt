package com.sametersoyoglu.kbfilmlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.sametersoyoglu.kbfilmlerapp.R
import com.sametersoyoglu.kbfilmlerapp.databinding.FragmentDetayBinding


class DetayFragment : Fragment() {

    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetayBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // gönderilen verileri alma
        val bundle : DetayFragmentArgs by navArgs()
        val film = bundle.film

        // toolbar'a film nesnesinden ad ı cekerek her resimde o resmin adını toolbarda gösterme
        binding.toolbarDetay.title = film.ad

        // resmi cekme
        binding.imageViewFilm.setImageResource(resources.getIdentifier(film.resim,"drawable",requireContext().packageName))

        // her resmin kendine özgü fiyatını cekme detay sayfasında
        binding.textViewFiyat.text = "${film.fiyat} ₺"

    }
}