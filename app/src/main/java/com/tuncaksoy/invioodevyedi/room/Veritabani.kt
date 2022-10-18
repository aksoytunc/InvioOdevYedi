package com.tuncaksoy.invioodevyedi.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tuncaksoy.invioodevyedi.data.entity.Yapilacaklar

@Database(entities = [Yapilacaklar::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getYapilacaklarDao() : YapilacaklarDao
}