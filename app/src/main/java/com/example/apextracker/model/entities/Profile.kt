package com.example.apextracker.model.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "all_users_profile")
data class Profile (
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo val avatar: String,
    @ColumnInfo(name = "user_logout") val userLogout: Boolean,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
    ):Parcelable