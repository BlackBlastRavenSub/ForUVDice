package com.blackblastraven.foruvdice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConfidentialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val inputNumber: Int = intent.getIntExtra("inputNumber", -1)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confidential)

        //動的にボタンを作成中(最適解かはまだ不明)
        val buttonPack = Array<Button>(inputNumber) { Button(applicationContext) }
        for (i in 0..inputNumber-1) {
            buttonPack[i].setText("Button" + (i+1))
            setContentView(buttonPack[i])
        }
    }
}
