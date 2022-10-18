package com.tuncaksoy.invioodevyedi.room

import androidx.room.*
import com.tuncaksoy.invioodevyedi.data.entity.Yapilacaklar

@Dao
interface YapilacaklarDao { // Database Access Object
    @Query("SELECT * FROM yapilacaklar")
    suspend fun yapilacaklariYukle() : List<Yapilacaklar>

    @Insert
    suspend fun kaydet(yapilacakIs: Yapilacaklar)

    @Update
    suspend fun guncelle(yapilacakIs: Yapilacaklar)

    @Delete
    suspend fun sil(yapilacakIs: Yapilacaklar)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar>
}