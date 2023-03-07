package com.androidstudioproject.proyekakhirandroidpemula

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName : TextView = findViewById(R.id.tv_detail_name)
        val tvDetailBackstory : TextView = findViewById(R.id.tv_detail_backstory)
        val tvDetailPhoto : ImageView = findViewById(R.id.tv_detail_photo)
        val tvSpecialJutsu: TextView = findViewById(R.id.tv_detail_specialjutsu)

        val dataAkatsuki = intent.getParcelableExtra<Parcelable>("key_akatsuki") as Akatsuki

        tvDetailName.text = dataAkatsuki.name
        tvDetailBackstory.text = dataAkatsuki.backstory
        tvDetailPhoto.setImageResource(dataAkatsuki.photo)
        tvSpecialJutsu.text = dataAkatsuki.specialjutsu
    }
}