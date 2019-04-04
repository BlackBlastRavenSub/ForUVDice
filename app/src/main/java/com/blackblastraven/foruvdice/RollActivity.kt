package com.blackblastraven.foruvdice

import android.content.Intent
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
            val result = roll(applicationContext,inputNumber, 1)
            rollResultText.text = result.toString()
        }
        //再設定ボタンが押されたらfinishして前の画面に戻る。
        reSettingButton.setOnClickListener {
            finish()
        }
        //Confidentialボタンが押されたら機密設定画面へ
        confidentialButton.setOnClickListener {
            val intent = Intent(application, ConfidentialActivity::class.java)
            intent.putExtra("inputNumber", inputNumber)
            startActivity(intent)
        }
    }
}
