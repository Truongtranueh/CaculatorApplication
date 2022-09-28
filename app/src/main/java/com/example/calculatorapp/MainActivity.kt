package com.example.calculatorapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.example.calculatorapp.databinding.ActivityMainBinding
import java.lang.Exception


class MainActivity : AppCompatActivity(){

    private lateinit var biding : ActivityMainBinding
    var input: String = ""
    var answer: String =""
    var isChecked: Boolean = true

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        biding.btnmoon.setOnClickListener{
            changeTheme()
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

        var sharedPreference =  getSharedPreferences("DATARES", Context.MODE_PRIVATE)
        var inputShared = sharedPreference.getString("input","")
        var answerShared = sharedPreference.getString("answer","")
        biding.inputnumber.text = inputShared
        biding.resulttxt.text = answerShared
    }
    override fun onStop() {
        super.onStop()

        var sharedPreference =  getSharedPreferences("DATARES", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString("input",input)
        editor.putString("answer",answer)
        editor.commit()
    }
    @SuppressLint("ResourceAsColor")
    fun changeTheme(){
        if(isChecked){
            biding.inputnumber.setTextColor(Color.WHITE)
            biding.resulttxt.setTextColor(Color.WHITE)
            biding.constrainmain.setBackgroundColor(Color.BLACK)
            biding.btnmoon.setBackgroundResource(R.drawable.ic_moonafter)
            isChecked = false
        }
        else if(!isChecked){
            biding.inputnumber.setTextColor(Color.BLACK)
            biding.resulttxt.setTextColor(Color.BLACK)
            biding.constrainmain.setBackgroundColor(Color.WHITE)
            biding.btnmoon.setBackgroundResource(R.drawable.ic_moonbefore)
            isChecked = true
        }
    }

    fun ButtonClick(s: String){
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
//                input = answer
                }
            "x" -> {
                Solve()
                input+= "*"
                }
            else -> {
                if (input == null){
                    input =""
                }
                if (s.equals("+") || s.equals("-") || s.equals("/")){
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
                answer = mul.toString() +""
            }
            catch (e: Exception){
            }
        }
        if(input.split("/").size == 2){
            var  s: List<String> = input.split("/")
            try {
                var mul:Double = (s[0].toDouble() / s[1].toDouble())
                answer = mul.toString() +""
            }
            catch (e: Exception){
            }
        }
        if(input.split("+").size == 2){
            var  s: List<String> = input.split("+")
            try {
                var mul:Double = (s[0].toDouble() + s[1].toDouble())
                answer = mul.toString() +""
            }
            catch (e: Exception){
            }
        }
        if(input.split("-").size == 2){
            var  s: List<String> = input.split("-")
            try {
                var mul:Double = (s[0].toDouble() - s[1].toDouble())
                answer = mul.toString() +""
            }
            catch (e: Exception){

            }
        }
        if(input.split("%").size == 2){
            var  s: List<String> = input.split("%")
            try {
                var mul:Double = (s[0].toDouble() % s[1].toDouble())
                answer = mul.toString() +""
            }
            catch (e: Exception){
            }
        }

        var listtmp: List<String> = answer.split(".")
        if(listtmp.size > 1){
            if(listtmp[1].equals("0")){
                answer = listtmp[0]
            }
        }
    }

}