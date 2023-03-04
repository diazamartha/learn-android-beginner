package com.androidstudioproject.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize   // 2. tidak lupa kita pakai parcelize

// setelah selesai membuat list item hero pada xml,
// lalu kita buat kelas baru yg akan menampung property data yg akan ditampilkan

data class Hero(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable   // 2.1 pakai parcelize
