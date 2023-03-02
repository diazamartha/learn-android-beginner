package com.androidstudioproject.explicit_intent_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
// catatan: setelah activity ini dibuat, segera lakukan perubahan di XML activity ini
// 1. ganti menjadi Relativelayout
// 2. biasanya kita butuh textView untuk menampilkan data yg dikirimkan, buat juga!

class MoveWithDataActivity : AppCompatActivity() {

    // inisiasi companion object untuk menerima data activity asal
    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        // skrg kita kenalkan textView di XML activity ini
        val tvDataReceived: TextView =  findViewById(R.id.tv_data_received)

        // gunakan methode getStringExtra() untuk mendapatkan data dari MainActivity
        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "Name : $name, Your Age : $age"
        tvDataReceived.text = text

    }
}