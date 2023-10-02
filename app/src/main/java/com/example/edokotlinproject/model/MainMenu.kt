package com.example.edokotlinproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainMenu (
    val gambarMenu: Int,
    val judulMenu: String,
): Parcelable
