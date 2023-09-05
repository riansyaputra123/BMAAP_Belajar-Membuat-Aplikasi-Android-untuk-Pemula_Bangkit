package com.rian.myclubapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(
    val name: String,
    val description: String,
    val photo: String,
    val berdiri: String,
    val negara: String,
    val liga: String,
    val kota: String,
    val urlNegara: String,
    val urlLiga: String
) : Parcelable
