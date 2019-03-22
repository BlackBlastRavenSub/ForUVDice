package com.blackblastraven.foruvdice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_how_to.*

class HowToActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to)
        //注意事項
        noticeButton.setOnClickListener {
            AlertDialog.Builder(applicationContext)
                .setTitle("注意事項")
                .setMessage(
                    "このアプリは個人が開発しています。\n" +
                            "そのため予告のないサービスの終了・修復不可能なバグ\n" +
                            "等が発生する可能性があります。予めご了承してから当サービスをご利用してください！"
                )
                .setPositiveButton("確認") { dialog, which ->
                }.show()
        }//注意事項(ここまで)
    }
}
