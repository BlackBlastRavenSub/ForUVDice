package com.blackblastraven.foruvdice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DiceData(
    /*
    プランAのデータベース
    diceId=識別id(ダイスの面数+それがどの面か。6面ダイスの3なら6_3)
    number=ダイスの目(1,2,3...)
    whereUsed=この目がどのダイスで使われているか?(6面ダイスで使用されているなら6)
    fraction=その目の出る確率(単純分数,1/6なら1と表記する)
    probability=その目の出る確率(100分率,16.666..%)
    multiple=その目の出る確率(最小公倍数)
     */
    @PrimaryKey var diceId: String,
    @ColumnInfo(name = "number") var number: Int,
    @ColumnInfo(name = "whereUsed") var whereUsed: Int,
    @ColumnInfo(name = "fraction") var fraction: Int,
    @ColumnInfo(name = "probability") var probability: Int,
    @ColumnInfo(name = "multiple") var multiple: Int
)