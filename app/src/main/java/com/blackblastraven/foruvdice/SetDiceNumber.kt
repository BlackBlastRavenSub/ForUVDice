package com.blackblastraven.foruvdice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_set_dice_number.*

class SetDiceNumber : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_dice_number)

        //INPUTボタンが押された
        input.setOnClickListener {
            if (inputNumberEditText.text.toString() == "") {
                //もし値が空だったら
                Toast.makeText(applicationContext, "値を入力してください!", Toast.LENGTH_LONG).show()
            } else {
                val inputNumber: Int = Integer.parseInt(inputNumberEditText.text.toString())
                if (inputNumber <= 0 || inputNumber > 100) {
                    //値が0だったら
                    Toast.makeText(applicationContext, "1~100面の範囲で入力してください", Toast.LENGTH_LONG).show()
                } else {
                    //成立!!
                    val intent = Intent(applicationContext, RollActivity::class.java)
                    intent.putExtra("inputNumber", inputNumber)
                    startActivity(intent)
                }
            }
        }
    }

    fun diceDataCreate(inputNumber: Int) {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name3"
        ).build()
        for (i in 0 until inputNumber) {
            val diceId = inputNumber.toString() + "_" + i
            //もし登録しようとしているidが既に存在していたら、追加ではなく更新する。
            if (!db.DiceDataDao().existsCheck(diceId)) {
                db.DiceDataDao().createDiceDaia(DiceData(diceId, 1, 6, 1, 16, 0))
            } else {
                db.DiceDataDao().updateDiceData(DiceData(diceId, 1, 6, 1, 16, 0))
            }
        }
    }
}
