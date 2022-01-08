package com.example.calall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.objecthunter.exp4j.ExpressionBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        num1.setOnClickListener { appendOnExpresstion("1", true) }
        num2.setOnClickListener { appendOnExpresstion("2", true) }
        num3.setOnClickListener { appendOnExpresstion("3", true) }
        num4.setOnClickListener { appendOnExpresstion("4", true) }
        num5.setOnClickListener { appendOnExpresstion("5", true) }
        num6.setOnClickListener { appendOnExpresstion("6", true) }
        num7.setOnClickListener { appendOnExpresstion("7", true) }
        num8.setOnClickListener { appendOnExpresstion("8", true) }
        num9.setOnClickListener { appendOnExpresstion("9", true) }
        num0.setOnClickListener { appendOnExpresstion("0", true) }

        //Operators
        plus.setOnClickListener { appendOnExpresstion("+", false) }
        minus.setOnClickListener { appendOnExpresstion("-", false) }
        multiply.setOnClickListener { appendOnExpresstion("*", false) }
        divide.setOnClickListener { appendOnExpresstion("/", false) }
        open.setOnClickListener { appendOnExpresstion("(", false) }
        close.setOnClickListener { appendOnExpresstion(")", false) }
        dot.setOnClickListener { appendOnExpresstion(".", true) }


        mod.setOnClickListener{ appendOnExpresstion("%", false) }
        cos.setOnClickListener{ appendOnExpresstion("cos(", true) }
        sin.setOnClickListener{ appendOnExpresstion("sin(", false)}
        tan.setOnClickListener{ appendOnExpresstion("tan(", false) }

        Clear.setOnClickListener {
            Solution.text = ""
            Result.text = ""
        }

        Delete.setOnClickListener {
            val numstring = Solution.text.toString()
            if(numstring.isNotEmpty()){
                Solution.text = numstring.substring(0,numstring.length-1)
            }
            Result.text = ""
        }

        equal.setOnClickListener {
            try {
                val expression = ExpressionBuilder(Solution.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    Result.text = longResult.toString()
                else
                    Result.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }

    }

    private fun appendOnExpresstion(string: String, canClear: Boolean) {

        if (Result.text.isNotEmpty()) {
            Solution.text = ""
        }

        if (canClear) {
            Result.text = ""
            Solution.append(string)
        } else {
            Solution.append(Result.text)
            Solution.append(string)
            Result.text = ""
        }
    }

}