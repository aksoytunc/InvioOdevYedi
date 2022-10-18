package com.tuncaksoy.invioodevyedi.data.datasource

import com.tuncaksoy.invioodevyedi.data.entity.Yapilacaklar
import com.tuncaksoy.invioodevyedi.room.YapilacaklarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacaklarDataSource(var ydao:YapilacaklarDao) {

    suspend fun kaydet(yapilacak_is: String) {
        val yeniIs = Yapilacaklar(0,yapilacak_is)
        ydao.kaydet(yeniIs)
    }

    suspend fun guncelle(yapilacak_id: Int, yapilacak_is: String) {
        val guncellenenIs = Yapilacaklar(yapilacak_id,yapilacak_is)
        ydao.guncelle(guncellenenIs)
    }

    suspend fun yapilacaklariYukle(): List<Yapilacaklar> =
        withContext(Dispatchers.IO) {
           ydao.yapilacaklariYukle()
        }

    suspend fun ara(aramaKelimesi: String): List<Yapilacaklar> =
        withContext(Dispatchers.IO) {
            ydao.ara(aramaKelimesi)
        }

    suspend fun sil(yapilacak_id: Int) {
        val silinenIs = Yapilacaklar(yapilacak_id,"")
        ydao.sil(silinenIs)
    }
}