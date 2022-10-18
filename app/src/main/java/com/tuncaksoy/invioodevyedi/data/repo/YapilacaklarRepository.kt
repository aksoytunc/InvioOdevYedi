package com.tuncaksoy.invioodevyedi.data.repo

import com.tuncaksoy.invioodevyedi.data.datasource.YapilacaklarDataSource
import com.tuncaksoy.invioodevyedi.data.entity.Yapilacaklar

class YapilacaklarRepository(var yds: YapilacaklarDataSource) {

    suspend fun kaydet(yapilacak_is: String) = yds.kaydet(yapilacak_is)

    suspend fun guncelle(yapilacak_id: Int, yapilacak_is: String) = yds.guncelle(yapilacak_id,yapilacak_is)

    suspend fun yapilacaklariYukle(): List<Yapilacaklar> = yds.yapilacaklariYukle()

    suspend fun ara(aramaKelimesi: String): List<Yapilacaklar> = yds.ara(aramaKelimesi)

    suspend fun sil(yapilacak_id: Int) = yds.sil(yapilacak_id)
}