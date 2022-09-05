package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.example.calculatorapp.databinding.ActivityMainBinding
import java.lang.Exception


class MainActivity : AppCompatActivity(), ClickSaveData {

    private lateinit var biding : ActivityMainBinding
    var input: String = ""
    var answer: String =""
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)


        biding.switchchangetheme.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Log.e("Check","ON")
                biding.txtswitch.text = "SWITCH TO LIGH THEME"
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else{
                Log.e("Check","OFF")
                biding.txtswitch.text = "SWITCH TO DARK THEME"
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        biding.btnsave?.setOnClickListener{
            val createbottomsheet : BottomSheetDialog = BottomSheetDialog(this)

            createbottomsheet.show(supportFragmentManager,"OK")
        }
        biding.btnzero.setOnClickListener{
            ButtonClick(biding.btnzero.text.toString())
        }
        biding.btn1.setOnClickListener{
            ButtonClick(biding.btn1.text.toString())
        }
        biding.btn2.setOnClickListener{
            ButtonClick(biding.btn2.text.toString())
        }
        biding.btn3.setOnClickListener{
            ButtonClick(biding.btn3.text.toString())
        }
        biding.btn4.setOnClickListener{
            ButtonClick(biding.btn4.text.toString())
        }
        biding.btn5.setOnClickListener{
            ButtonClick(biding.btn5.text.toString())
        }
        biding.btn6.setOnClickListener{
            ButtonClick(biding.btn6.text.toString())
        }
        biding.btn7.setOnClickListener{
            ButtonClick(biding.btn7.text.toString())
        }
        biding.btn8.setOnClickListener{
            ButtonClick(biding.btn8.text.toString())
        }
        biding.btn9.setOnClickListener{
            ButtonClick(biding.btn9.text.toString())
        }
        biding.btnclear.setOnClickListener{
            ButtonClick(biding.btnclear.text.toString())
        }
        biding.btnadd.setOnClickListener{
            ButtonClick(biding.btnadd.text.toString())
        }
        biding.btnminus.setOnClickListener{
            ButtonClick(biding.btnminus.text.toString())
        }
        biding.btnmulti.setOnClickListener{
            ButtonClick(biding.btnmulti.text.toString())
        }
        biding.btndiv.setOnClickListener{
            ButtonClick(biding.btndiv.text.toString())
        }
        biding.btnbackspace.setOnClickListener{
            ButtonClick(biding.btnbackspace.text.toString())
        }
        biding.btnequal.setOnClickListener{
            ButtonClick(biding.btnequal.text.toString())
        }
        biding.btnpercent.setOnClickListener{
            ButtonClick(biding.btnpercent.text.toString())
        }
        biding.btndot.setOnClickListener{
            ButtonClick(biding.btndot.text.toString())
        }



    }
    fun ButtonClick(s: String){
//        var button: Button = view as Button
//        var  data = button.text.toString()
        when(s){
            "AC" -> {input = ""
                     answer ="00"
                    }
            "C"  -> if(input.isNotEmpty()){
                var newtext: String = input.substring(0, input.length - 1)
                input = newtext
            }
            "=" -> {
                Solve()
                answer = input
                }
            "x" -> {
                Solve()
                input+= "*"
                }
            else -> {
                if (input ==null){
                    input =""
                }

                if (s.equals("+") || s.equals("-") || s.equals("/")){
                    //in kq
                    Solve()
                }
                input += s
            }

        }
        biding.inputnumber.setText(input)
        biding.resulttxt.text = answer
    }

    fun Solve(){
        if(input.split("*").size == 2){
            var  s: List<String> = input.split("*")
            try {
                var mul:Double = (s[0].toDouble() * s[1].toDouble())
                input = mul.toString() +""
            }
            catch (e: Exception){

            }
        }
        if(input.split("/").size == 2){
            var  s: List<String> = input.split("/")
            try {
                var mul:Double = (s[0].toDouble() / s[1].toDouble())
                input = mul.toString() +""
            }
            catch (e: Exception){

            }
        }
        if(input.split("+").size == 2){
            var  s: List<String> = input.split("+")
            try {
                var mul:Double = (s[0].toDouble() + s[1].toDouble())
                input = mul.toString() +""
            }
            catch (e: Exception){

            }
        }
        if(input.split("-").size == 2){
            var  s: List<String> = input.split("-")
            try {
                var mul:Double = (s[0].toDouble() - s[1].toDouble())
                input = mul.toString() +""
            }
            catch (e: Exception){

            }
        }
        if(input.split("%").size == 2){
            var  s: List<String> = input.split("%")
            try {
                var mul:Double = (s[0].toDouble() % s[1].toDouble())
                input = mul.toString() +""
            }
            catch (e: Exception){

            }
        }

        var listtmp: List<String> = input.split(".")
        if(listtmp.size > 1){
            if(listtmp[1].equals("0")){
                input = listtmp[0]
            }
        }
    }

    override fun savedata(data: String) {
        Log.e("Hh",data)
    }

}