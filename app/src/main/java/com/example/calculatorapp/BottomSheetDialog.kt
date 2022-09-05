package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorapp.databinding.BottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialog(var mlistener: ClickSaveData) : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetDialogBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetDialogBinding.inflate(inflater,container,false)

        binding.btncancel.setOnClickListener(){
            dismiss()
            mlistener.savedata("HAHA")
        }


        return binding.root
    }
}