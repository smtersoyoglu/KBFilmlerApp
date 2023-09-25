package com.sametersoyoglu.kbfilmlerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sametersoyoglu.kbfilmlerapp.data.entity.Filmler
import com.sametersoyoglu.kbfilmlerapp.databinding.CardTasarimBinding
import com.sametersoyoglu.kbfilmlerapp.ui.fragment.AnasayfaFragmentDirections

class FilmlerAdapter(var mContext: Context, var filmlerListesi : List<Filmler>) : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(tasarim)
    }


    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position) // listenin içerisindeki filmleri sırasıyla almaya yarar.
        val t = holder.tasarim

        t.imageViewCVFilm.setImageResource(mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))

        t.textViewCVFiyat.text = "${film.fiyat} ₺"

        t.cardViewFilm.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${film.ad} sepete eklendi",Snackbar.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}