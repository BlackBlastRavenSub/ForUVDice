package com.blackblastraven.foruvdice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DiceData(
    /*
    diceId=識別id(ダイスの面数)
    Number=ダイスの特定の目(1,2,3...)
    Probability=その目の出る確率(100分率)

     */
    @PrimaryKey var diceId: Int,
    @ColumnInfo(name = "number") var number: Int?,
    @ColumnInfo(name = "probability") var probability: Int?
)