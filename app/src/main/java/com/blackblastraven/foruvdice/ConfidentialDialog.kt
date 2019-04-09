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
        //return super.onCreateView(inflater, container, savedInstanceState)
        //return inflater.inflate(R.layout.layout_confidential_dialog, container)
        val content = inflater.inflate(R.layout.layout_confidential_dialog, container)
        //numberPickerの用意
        val numpick = content.findViewById<NumberPicker>(R.id.numberPicker)
        numpick.maxValue = 50
        numpick.minValue = 0
        numpick.value = 0

        //OKボタンの用意
        val okButton = content.findViewById<Button>(R.id.okButton)
        okButton.setOnClickListener {
            numpick.value
        }
        return content
    }
}
