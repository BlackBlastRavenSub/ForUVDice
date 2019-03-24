package com.blackblastraven.foruvdice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_title.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class TitleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)
        //Rollボタン
        moveToRoll.setOnClickListener {
            val intent = Intent(application, SetDiceNumber::class.java)
            startActivity(intent)
        }
        //ホームページにリンク
        accesshome.setOnClickListener {
            //テスト!
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
            ).allowMainThreadQueries()
                .build()
            val dicedata = DiceData(10, 1, 2)
            //GlobalScope.launch {
            //thread{db.DiceDataDao().insertDiceData(dicedata)}
            val output = db.DiceDataDao().getAll()
            for (item in output) {
                Toast.makeText(applicationContext, "$item", Toast.LENGTH_LONG).show()
            }
        }
    }
}
