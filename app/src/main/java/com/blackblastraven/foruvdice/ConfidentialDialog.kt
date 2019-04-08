package com.blackblastraven.foruvdice

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class ConfidentialDialog : DialogFragment() {
    companion object {
        fun newInstance(): ConfidentialDialog {
            return ConfidentialDialog()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog=super.onCreateDialog(savedInstanceState)
        //numberPickerの用意
        numberPicker.maxValue = 50
        numberPicker.minValue = 0
        numberPicker.value=0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.layout_confidential_dialog, container)
    }
}
