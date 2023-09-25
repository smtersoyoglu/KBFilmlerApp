package com.sametersoyoglu.kbfilmlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sametersoyoglu.kbfilmlerapp.R
import com.sametersoyoglu.kbfilmlerapp.data.entity.Filmler
import com.sametersoyoglu.kbfilmlerapp.databinding.FragmentAnasayfaBinding
import com.sametersoyoglu.kbfilmlerapp.ui.adapter.FilmlerAdapter


class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarAnasayfa.title = "Filmler"
        binding.filmRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1,"Django","django",24)
        val f2 = Filmler(2,"Interstellar","interstellar",32)
        val f3 = Filmler(3,"Inception","inception",16)
        val f4 = Filmler(4,"The Hateful Eight","thehatefuleight",28)
        val f5 = Filmler(5,"The Pianist","thepianist",18)
        val f6 = Filmler(6,"Anadoluda","anadoluda",10)
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)

        val filmlerAdapter = FilmlerAdapter(requireContext(),filmlerListesi)
        binding.filmRv.adapter = filmlerAdapter

    }
}