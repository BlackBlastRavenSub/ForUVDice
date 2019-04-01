package com.blackblastraven.foruvdice

import android.content.Context
import android.util.Log
import androidx.room.Room
import kotlin.random.Random

fun roll(context: Context, inputNumber: Int, typeOfDecision: Int): Int {
    /*
    ダイスのロールをする中核部分。ダイスの面数やそれぞれの出現確率を入力して実行すると結果を入手する事が出来る。
    inputNumber=何面ダイスか
    typeOfDecision=どの判定方法を使用するか
     */
    //まずデータベースにアクセスするルートを確保
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name2"
    ).allowMainThreadQueries()
        .build()
    //まずダイス面分のDiceDataを格納する配列を用意してそこにデータベースから取ってきた値をセット!
    val numbers = Array<DiceData>(inputNumber, {db.DiceDataDao().getAll()})
    when (typeOfDecision) {
        0 -> directDecision()
        1 -> probabilityDecision()
        2 -> multipleDecision()
        else -> Log.d("TAG", "typeOfDecision:不正な値")
    }
    //テスト
    return inputNumber
}

//直接判定(1/ダイス面)
fun directDecision() {

}

//100分率判定(16.6..%)
fun probabilityDecision() {
    //1~100までの乱数を作成
    val random = Random.nextInt(100) + 1

}

//最小公倍数判定(どうやるんだっけ・・・)
fun multipleDecision() {}