package com.example.apextracker.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "all_users_profile")
data class Profile (
    @ColumnInfo val avatar: String,
    @ColumnInfo(name = "avatar_source") val avatarSource: String,
    @ColumnInfo val username: String,
    @ColumnInfo val userDivision: String,
    @ColumnInfo val userBanInfo: String,
    @ColumnInfo(name = "user_online") val userOnline: Boolean = false,
    @ColumnInfo val favoriteHero: Boolean = false,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
    )