package com.example.apextracker.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Heroes (    val name: String,
                       val data: AllHeroes.All
):Parcelable