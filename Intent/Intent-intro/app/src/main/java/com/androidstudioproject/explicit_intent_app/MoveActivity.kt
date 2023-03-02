package com.androidstudioproject.explicit_intent_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// catatan: setelah activity ini dibuat, segera lakukan perubahan di XML activity ini
// 1. ganti menjadi Relativelayout
// 2. biasanya kita butuh textView untuk menampilkan data yg dikirimkan, buat juga!
class MoveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)


    }
}