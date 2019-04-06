package com.blackblastraven.foruvdice

import android.content.Context
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.gridlayout.widget.GridLayout
import kotlinx.android.synthetic.main.button_row.*

class ConfidentialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val inputNumber: Int = intent.getIntExtra("inputNumber", -1)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confidential)
        val gridGroup = findViewById<View>(R.id.button_grid_layout) as GridLayout
        val buttonPack = arrayOfNulls<Button>(inputNumber)
        //画面サイズを取得してボタンサイズを設定・・・なんか強引
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x
        for (i in 0 until inputNumber) {
            buttonPack[i] = Button(applicationContext)
            buttonPack[i]?.tag = i
            //とりあえずの大きさ合わせ、これでは強引だ
            buttonPack[i]?.textSize = 11F
            buttonPack[i]?.text = "Button$i"
            gridGroup.addView(
                buttonPack[i]
                , ViewGroup.LayoutParams(width / 4, ViewGroup.LayoutParams.WRAP_CONTENT)
            )
            buttonPack[i]?.setOnClickListener {
                Toast.makeText(
                    applicationContext,
                    buttonPack[i]?.text,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

/*
        var line = (inputNumber / 4)
        if (inputNumber % 4 != 0) {
            line += 1
        }
        for (i in 0 until line) {
            val buttonRow = layoutInflater.inflate(R.layout.button_row, null,false) as TableRow
            for (j in 0 until 4) {
                buttonRow.addView(
                    buttonPack[j + i * 4],
                    LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                )
                //あまりが発生した時の最終行設定
                if (i == line - 1 && inputNumber % 4 in 1..3 && inputNumber % 4 == j + 1) {
                    break
                }
            }
            tableGroup.addView(buttonRow)
        }
        */
        /*
        if (i == line - 1) {
                when (inputNumber % 4) {
                    0 -> print("nothing")
                    1 -> {
                        layoutInflater.inflate(R.layout.button_row, tableGroup)
                        val buttonrow = tableGroup.getChildAt(i) as TableRow
                        buttonrow.addView(buttonPack[i * 4 + 1])
                    }
                    2 -> {
                        layoutInflater.inflate(R.layout.button_row, tableGroup)
                        val buttonrow = tableGroup.getChildAt(i) as TableRow
                        buttonrow.addView(buttonPack[i * 4 + 1])
                        buttonrow.addView(buttonPack[i * 4 + 2])
                    }
                    3 -> {
                        layoutInflater.inflate(R.layout.button_row, tableGroup)
                        val buttonrow = tableGroup.getChildAt(i) as TableRow
                        buttonrow.addView(buttonPack[i * 4 + 1])
                        buttonrow.addView(buttonPack[i * 4 + 2])
                        buttonrow.addView(buttonPack[i * 4 + 3])
                    }
                }
            }
         */
        //buttonXml.addView(insertView)
        //setContentView(R.layout.activity_confidential)

        /*
        Viewの追加
        val root = layoutInflater.inflate(R.layout.activity_confidential, null) as LinearLayout
        val buttonLayout = layoutInflater.inflate(R.layout.setting_button, null) as LinearLayout
        for (i in 0 until inputNumber) {
            root.addView(buttonLayout)
            //layoutInflater.inflate(R.layout.setting_button, button_liner_layout)
        }
        Viewの追加(どちらもうまくいかず)
        for (i in 0 until inputNumber) {
            val buttonLayout = layoutInflater.inflate(R.layout.setting_button, null) as LinearLayout
            val input = ViewGroup.LayoutParams(300, 150)
            addContentView(buttonLayout, input)
        }
        */
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

/*
val buttonXml = findViewById<TableLayout>(R.id.button_table_layout)
        val insertView = TableLayout(this)
        val buttonPack = arrayOfNulls<Button>(inputNumber)
        for (i in 0 until inputNumber - 1) {
            buttonPack[i] = Button(applicationContext)
            buttonXml.addView(buttonPack[i])
        }
 */
/*
val tableGroup = findViewById<View>(R.id.button_table_layout) as ViewGroup
        val buttonPack = arrayOfNulls<Button>(inputNumber)
        for (i in 0 until inputNumber - 1) {
            buttonPack[i] = Button(applicationContext)
        }
        for (i in 0 until (inputNumber - 1) / 4) {
            layoutInflater.inflate(R.layout.button_row, tableGroup)
            val buttonrow = tableGroup.getChildAt(i) as TableRow
            for (j in 0 until 3) {
            }
        }
 */
/*
val inputNumber: Int = intent.getIntExtra("inputNumber", -1)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confidential)
        //今回何行になるか
        var line = (inputNumber / 4)
        if (inputNumber % 4 != 0) {
            line += 1
        }
        val tableGroup = findViewById<View>(R.id.button_table_layout) as TableLayout
        val buttonPack = arrayOfNulls<Button>(inputNumber)
        for (i in 0 until inputNumber) {
            buttonPack[i] = Button(applicationContext)
            buttonPack[i]?.text = "Button$i"
        }

        for (i in 0 until line) {
            layoutInflater.inflate(R.layout.button_row, tableGroup)
            val buttonRow = tableGroup.getChildAt(i) as TableRow
            for (j in 0 until 4) {
                buttonRow.addView(
                    buttonPack[j + i * 4],
                    LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                )
                //あまりが発生した時の最終行設定
                if (i == line - 1 && inputNumber % 4 in 1..3 && inputNumber % 4 == j + 1) {
                    break
                }
            }

        }
 */