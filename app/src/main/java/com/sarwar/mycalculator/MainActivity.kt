package com.sarwar.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickListener {

    var firstNumber: String = ""
    var secondNumber: String = ""
    var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
        btnZero.setOnClickListener(this)

        btnDel.setOnClickListener {
            tvResult.text = ""
            clearAll()
        }


        btnPlus.setOnClickListener {
            operation = "+"
            updateCalculation()
        }
        btnMinus.setOnClickListener {
            operation = "-"
            updateCalculation()
        }
        btnMultiply.setOnClickListener {
            operation = "*"
            updateCalculation()
        }
        btnDivide.setOnClickListener {
            operation = "/"
            updateCalculation()
        }

        btnEquals.setOnClickListener {
            try {
                val result = when(operation){
                    "+" -> {
                        firstNumber.toInt() + secondNumber.toInt()
                    }
                    "-" -> {
                        firstNumber.toInt() - secondNumber.toInt()
                    }
                    "*" -> {
                        firstNumber.toInt() * secondNumber.toInt()
                    }
                    "/" -> {
                        firstNumber.toInt() / secondNumber.toInt()
                    }
                    else -> {
                        ""
                    }
                }
                tvResult.text = result.toString()
            }catch (e: ArithmeticException){
                tvResult.text = "Error, Cannot divide by zero"
            }catch (e: java.lang.NumberFormatException){
                tvResult.text = "Enter Second Number"
            }catch (e: Exception){
                tvResult.text = "Error.."
            }

            clearAll()
        }


    }

    private fun clearAll() {
        firstNumber = ""
        secondNumber = ""
        operation = ""
    }

    override fun onClick(v: View?) {
        val button = v as AppCompatButton

        if(operation.isNullOrEmpty()){
            firstNumber += button.text
        }else{
            secondNumber += button.text
        }

        updateCalculation()
    }

    private fun updateCalculation() {
        tvResult.text = firstNumber + operation + secondNumber
    }


}