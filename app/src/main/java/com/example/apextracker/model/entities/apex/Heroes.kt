package com.example.apextracker.model.entities.apex

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Heroes (    val name: String,
                       val data: AllHeroes.All
):Parcelable