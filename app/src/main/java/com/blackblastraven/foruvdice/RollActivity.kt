package com.blackblastraven.foruvdice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_roll.*

class RollActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val inputNumber: Int = intent.getIntExtra("inputNumber", -1)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roll)
        //ロールボタンが押されたらサイコロを振る!
        rollButton.setOnClickListener {
            //結果のテスト
            val result = Rool(inputNumber)
            rollResultText.text = result.toString()
        }
    }
}
