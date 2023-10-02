package com.example.edokotlinproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DataBerita(
    val gambarBerita: String,
    val gambarUser: Int,
    val judulBerita: String,
    val isiBerita: String
) : Parcelable