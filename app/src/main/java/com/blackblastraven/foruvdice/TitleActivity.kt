package com.blackblastraven.foruvdice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_title.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TitleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)

        moveToRoll.setOnClickListener {
            val intent = Intent(application, SetDiceNumber::class.java)
            startActivity(intent)
        }
        accesshome.setOnClickListener {
            //テスト!
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
            ).build()
            val dicedata = DiceData(0, 0, 0)
            GlobalScope.launch {
                db.DiceDataDao().insertDiceData(dicedata)
            }
            val output = db.DiceDataDao().getAll()
            for (item in output) {
                Toast.makeText(applicationContext, "$item", Toast.LENGTH_LONG).show()
            }

        }
    }
}
