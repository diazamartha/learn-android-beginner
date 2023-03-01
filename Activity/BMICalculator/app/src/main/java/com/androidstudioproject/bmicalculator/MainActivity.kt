package com.androidstudioproject.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // store data for every input in this activity
    private lateinit var edtHeight : EditText
    private lateinit var edtWeight : EditText
    private lateinit var btncalculate : Button
    private lateinit var tvResult : TextView
    private lateinit var tvBmiCategory : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtHeight = findViewById(R.id.edt_Height)
        edtWeight = findViewById(R.id.edt_Weight)
        btncalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        tvBmiCategory = findViewById(R.id.bmi_category)

        btncalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate) {
            val dataHeight = edtHeight.text.toString().trim()
            val dataWeight = edtWeight.text.toString().trim()

            val bmi = dataWeight.toDouble() / (dataHeight.toDouble() * dataHeight.toDouble())
            tvResult.text = bmi.toString()
        }

    }

}
