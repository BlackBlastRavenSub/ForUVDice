package com.blackblastraven.foruvdice

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment

class ConfidentialDialog : DialogFragment() {
    companion object {
        fun newInstance(): ConfidentialDialog {
            return ConfidentialDialog()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //データベースの用意と数値の取り出し


        val content = inflater.inflate(R.layout.layout_confidential_dialog, container)
        //numberPickerの用意
        val numpick = content.findViewById<NumberPicker>(R.id.numberPicker)
        numpick.maxValue = 100
        numpick.minValue = 0
        numpick.value = 0
        //+1ボタンの用意
        val plusOneButton = content.findViewById<Button>(R.id.plusOneButton)
        plusOneButton.setOnClickListener {
            numpick.value = numpick.value + 1
        }
        //+10ボタンの用意
        val plusTenButton = content.findViewById<Button>(R.id.plusTenButton)
        plusTenButton.setOnClickListener {
            numpick.value = numpick.value + 10
        }
        //-1ボタン
        val minusOneButton = content.findViewById<Button>(R.id.minusOneButton)
        minusOneButton.setOnClickListener {
            numpick.value = numpick.value - 1
        }

        //-10ボタン
        val minusTenButton = content.findViewById<Button>(R.id.minusTenButton)
        minusTenButton.setOnClickListener {
            numpick.value = numpick.value - 10
        }

        //OKボタンの用意
        val okButton = content.findViewById<Button>(R.id.okButton)
        okButton.setOnClickListener {
            numpick.value
        }
        return content
    }
}
