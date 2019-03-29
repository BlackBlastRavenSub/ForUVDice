package com.blackblastraven.foruvdice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_confidential.*

class ConfidentialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val inputNumber: Int = intent.getIntExtra("inputNumber", -1)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confidential)
        for (i in 0 until inputNumber) {
            layoutInflater.inflate(R.layout.setting_button, button_liner_layout)
        }

        //動的にボタンを作成中(最適解かはまだ不明)
        /*
        val buttonPack = Array<Button>(inputNumber) { Button(applicationContext) }
        for (i in 0..inputNumber - 1) {
            buttonPack[i].setText("Button" + (i + 1))
            //buttonPack[i].layout(0, 0, 100, 50)
            buttonPack[i].height = 5
            buttonPack[i].width = 10
            setContentView(buttonPack[i])
        }
  */
    }
}
