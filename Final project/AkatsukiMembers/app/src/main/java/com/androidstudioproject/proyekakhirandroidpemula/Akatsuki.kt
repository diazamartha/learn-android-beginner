package com.androidstudioproject.proyekakhirandroidpemula

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Akatsuki(
    val name: String,
    val backstory: String,
    val photo: Int,
    val specialjutsu: String
): Parcelable
