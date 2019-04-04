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
    //結果を保存する変数
    var result = -1
    //まずデータベースにアクセスするルートを確保
    val db = Room.databaseBuilder(context, AppDatabase::class.java, "database-name3").allowMainThreadQueries().build()
    //ダイス面分のDiceDataを格納する配列を用意してそこにデータベースから取ってきた値をセット!
    //ダミーデータ
    val dummy: DiceData = DiceData(-1, -1, -1, -1, -1, -1)
    //var numbers: Array<DiceData?> = arrayOfNulls(inputNumber)
    var numbers = Array(inputNumber) { dummy }
    for (i in 0 until inputNumber) {
        //テストデータ
        numbers[i] = db.DiceDataDao().searchFromId(i)
    }
    when (typeOfDecision) {
        0 -> result = directDecision(inputNumber, numbers)
        1 -> result = probabilityDecision(numbers)
        2 -> result = multipleDecision(numbers)
        else -> Log.d("TAG", "typeOfDecision:不正な値")
    }
    return result
}

//直接判定(1/ダイス面)
fun directDecision(inputNumber: Int, numbers: Array<DiceData>): Int {
    //今合計何パーセントになっているか
    var per = 0
    //1~inputNumberまでの乱数を作成
    val random = Random.nextInt(inputNumber)
    for (number in numbers) {
        if (random in per..per + number.fraction) {
            //ここに来た値が出目
            return number.number
        }
        per += number.fraction
    }
    //どれにも引っかからなかった、つまり問題が発生している。
    Log.d("TAG", "単純判定結果:当てはまる値が無い!")
    return -1
}

//100分率判定(16.6..%)
fun probabilityDecision(numbers: Array<DiceData>): Int {
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
    //どれにも引っかからなかった、つまり問題が発生している。
    Log.d("TAG", "100分率判定結果:当てはまる値が無い!")
    return -1
}

//最小公倍数判定(どうやるんだっけ・・・)
fun multipleDecision(numbers: Array<DiceData>): Int {
    Log.d("TAG", "最小公倍数判定結果:当てはまる値が無い!")
    return -1
}