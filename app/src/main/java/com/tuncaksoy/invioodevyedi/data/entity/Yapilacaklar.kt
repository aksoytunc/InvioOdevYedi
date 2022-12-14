package com.tuncaksoy.invioodevyedi.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "yapilacaklar")
data class Yapilacaklar(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "yapilacak_id") @NotNull var yapilacak_id: Int,
    @ColumnInfo(name = "yapilacak_is") @NotNull var yapilacak_is: String
) : java.io.Serializable {
}