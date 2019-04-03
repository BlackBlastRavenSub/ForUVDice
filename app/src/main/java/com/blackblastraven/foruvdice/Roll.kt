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
    val db = Room.databaseBuilder(context, AppDatabase::class.java, "database-name2").allowMainThreadQueries().build()
    //まずダイス面分のDiceDataを格納する配列を用意してそこにデータベースから取ってきた値をセット!
    var numbers: Array<DiceData?> = arrayOfNulls(inputNumber)
    for (i in 0 until inputNumber) {
        numbers[i] = db.DiceDataDao().searchFromId(0)
    }
    when (typeOfDecision) {
        0 -> directDecision()
        1 -> probabilityDecision(numbers)
        2 -> multipleDecision()
        else -> Log.d("TAG", "typeOfDecision:不正な値")
    }
    //テスト
    //return inputNumber
    return numbers[0]!!.number!!
}

//直接判定(1/ダイス面)
fun directDecision() {

}

//100分率判定(16.6..%)
fun probabilityDecision(numbers: Array<DiceData?>) {
    //今合計何パーセントになっているか
    var per = 0
    //1~100までの乱数を作成
    val random = Random.nextInt(100) + 1
    for (number in numbers) {
        if (random in per..per + number.probability) {
            //ここに来た値が出た目
            return number.number
        }
        per = +number.probability
    }
}

//最小公倍数判定(どうやるんだっけ・・・)
fun multipleDecision() {}