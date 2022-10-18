package com.tuncaksoy.invioodevyedi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.tuncaksoy.invioodevyedi.R
import com.tuncaksoy.invioodevyedi.data.entity.Yapilacaklar
import com.tuncaksoy.invioodevyedi.databinding.CardTasarimBinding
import com.tuncaksoy.invioodevyedi.ui.fragment.AnasayfaFragmentDirections
import com.tuncaksoy.invioodevyedi.ui.viewmodel.AnasayfaViewModel
import com.tuncaksoy.invioodevyedi.utils.gecisYap

class YapilacaklarAdapter(
    var mContext: Context,
    var yapilacaklarListesi: List<Yapilacaklar>,
    var viewModel: AnasayfaViewModel
) :
    RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim: CardTasarimBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.card_tasarim, parent, false
        )
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacakIs =
            yapilacaklarListesi[position]
        val t = holder.tasarim
        t.yapilacakIsNesnesi = yapilacakIs

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(yapilacakIs)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${yapilacakIs.yapilacak_is} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    viewModel.sil(yapilacakIs.yapilacak_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }
}