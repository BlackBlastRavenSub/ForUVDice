package com.blackblastraven.foruvdice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_set_dice_number.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
                    diceDataCreate(inputNumber)
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
        GlobalScope.launch(Dispatchers.IO) {
            for (i in 1 until inputNumber + 1) {
                val diceId = inputNumber.toString() + "_" + i
                //初期データ
                val preset: DiceData = DiceData(diceId, i, inputNumber, 1, 100 / inputNumber, 0)
                //もし登録しようとしているidが既に存在していたら、追加しない。
                if (!db.DiceDataDao().existsCheck(diceId)) {
                    db.DiceDataDao().createDiceDaia(preset)
                }
            }
        }
    }
}
