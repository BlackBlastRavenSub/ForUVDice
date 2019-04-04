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
                AppDatabase::class.java, "database-name3"
            ).allowMainThreadQueries()
                .build()
            //GlobalScope.launch {

            //テスト用データ
            if (!db.DiceDataDao().existsCheck(0)) {
                thread { db.DiceDataDao().createDiceDaia(DiceData(0, 1, 6, 1, 16, 0)) }
            }
            val output = db.DiceDataDao().searchFromId(0)
            for (i in 0..5) {
                Toast.makeText(applicationContext, "${output.number}", Toast.LENGTH_LONG).show()
            }
            /*
            for (item in output) {
                Toast.makeText(applicationContext, "$item", Toast.LENGTH_LONG).show()
            }
             */
        }
    }
}
