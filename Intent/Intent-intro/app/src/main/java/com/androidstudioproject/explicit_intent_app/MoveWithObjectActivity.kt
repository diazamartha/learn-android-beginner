package com.androidstudioproject.explicit_intent_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi

// catatan: setelah activity ini dibuat, segera lakukan perubahan di XML activity ini
// 1. ganti menjadi Relativelayout
// 2. biasanya kita butuh textView untuk menampilkan data yg dikirimkan, buat juga!
class MoveWithObjectActivity : AppCompatActivity() {

    // kita gunakan getParcelableExtra untuk menerima objek dari activity asal
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        // skrg kita kenalkan textView di activity ini
        val tvObject: TextView = findViewById(R.id.tv_object_received)

        // line 28-37 : kita gunakan getParcelableExtra untuk menerima objek dari Activity asal.
        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PERSON)
        }

        if (person != null) {
            val text = "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
            tvObject.text = text
        }
    }
}