package com.androidstudioproject.explicit_intent_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Inisiasi textView
    private lateinit var tvResult: TextView


    // Selanjutnya kita buat launcher registerForActivityResult untuk menerima nilai bali
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. setelah buat tombol di XML, di sini kita inisialisasi tombol tsb (yg "berinteraksi")
        // 2. setelah inisiasi, segera buat activity baru tempat di mana halaman yg akna dituju oleh tombol di bawah ini

        val btnMoveActivity : Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity : Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject : Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone:Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        // Inisiasi button
        val btnMoveForResult:Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

    }

    override fun onClick(v: View?) {
        when (v?.id) {

            // setelah kita selesai setting up di class MoveActivity, selanjutnya kita tambahkan intent di sini
            // Ini explicit intent biasa
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                // startActivity digunakan untuk mengeksekusi intent
                startActivity(moveIntent)
            }

            // setelah kita selesai setting up di class MoveWithDataActivity, selanjutnya kita tambahkan intent di sini
            // Ini intent dengan mengirimkan data
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                // gunakan methode putExtra() untuk mengirimkan data ke Activity yg dituju dalam bentuk (Key, Value)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }

            // setelah kita selesai setting up di class MoveWithObjectActivity, selanjutnya kita tambahkan intent di sini
            R.id.btn_move_activity_object -> {
                // kita buat objek data class Person bernama person
                // Kita atur semua data sesuai dengan propertinya.
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )

                // Kemudian kita akan mengirimkan objek tersebut ke MoveWithObjectActivity melalui sebuah Intent di bawah ini:
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)

            }

            // Ini untuk menambhkan action pada tombol implicit intent
            R.id.btn_dial_number -> {
                val phoneNumber = "081221345687"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }


            // ini untuk mengembalikan nilai data
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }

        }
    }
}