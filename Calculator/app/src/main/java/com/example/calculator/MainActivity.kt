package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    var lastNumeric = false
    var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View){
//        Toast.makeText(this, "Button works", Toast.LENGTH_SHORT).show()
        // Get the value of the particular button and pass it into the tvInput
        tvInput.append((view as Button).text)
        lastNumeric = true

    }

    fun onClear(view: View){
        tvInput.text = ""
        lastNumeric = false
        lastDot = false
    }

    fun onDecimalPoint(view: View){
        if (lastNumeric && !lastDot){
            tvInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View){
        if (lastNumeric && !isOperatorAdded(tvInput.text.toString())){
            tvInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    private fun isOperatorAdded(value: String) : Boolean{
        return if (value.startsWith("-")){
            false
        } else{
            value.contains("/") || value.contains("+") || value.contains("-") || value.contains("x")
        }
    }

    private fun removeZeroAfterDot(result: String) : String{
        var value = result
        if (result.contains(".0")){
            value = value.substring(0, value.length - 2)
        }

        return value
    }

    fun onEquals(view: View){
        // Last value must be numeric
        if (lastNumeric){
            var tvValue = tvInput.text.toString()
            var prefix = ""

            try{
                if (tvValue.startsWith("-")){
                    prefix="-"
                    tvValue = tvValue.substring(1)
                }

                if (tvValue.contains("-")){
                    val splitValue = tvValue.split("-")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix == "-"){
                        one = prefix + one
                    }

                    tvInput.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                } else if (tvValue.contains("+")){
                    val splitValue = tvValue.split("+")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix == "-"){
                        one = prefix + one
                    }

                    tvInput.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                } else if (tvValue.contains("x")){
                    val splitValue = tvValue.split("x")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix == "-"){
                        one = prefix + one
                    }

                    tvInput.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                } else if (tvValue.contains("/")){
                    val splitValue = tvValue.split("/")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix == "-"){
                        one = prefix + one
                    }

                    tvInput.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                }

            } catch(e: ArithmeticException){
                e.printStackTrace()
            }

        }
    }


}