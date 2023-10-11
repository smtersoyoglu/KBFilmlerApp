package com.sametersoyoglu.kbfilmlerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.sametersoyoglu.kbfilmlerapp.R
import com.sametersoyoglu.kbfilmlerapp.data.entity.Filmler
import com.sametersoyoglu.kbfilmlerapp.databinding.CardTasarimBinding
import com.sametersoyoglu.kbfilmlerapp.ui.fragment.AnasayfaFragmentDirections

class FilmlerAdapter(var mContext: Context, var filmlerListesi : List<Filmler>) : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding : CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position) // listenin içerisindeki filmleri sırasıyla almaya yarar.
        val t = holder.tasarim

        // alttaki resim tanımlama kodunu internetten resim çekmek için Glide kullanıcaz Glide kodunu yazıcaz aşşağıda.
        //t.imageViewCVFilm.setImageResource(mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))
        val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${film.resim}"
        Glide.with(mContext).load(url).override(500,750).into(t.imageViewCVFilm)


        //t.textViewCVFiyat.text = "${film.fiyat} ₺" DataBinding ile xml filmNesnesi oluşturup orda tanımladık
        t.filmNesnesi = film

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