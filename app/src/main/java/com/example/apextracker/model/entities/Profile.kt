package com.example.apextracker.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "all_users_profile")
data class Profile (
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo val avatar: String,
    @ColumnInfo val rankDivision: Int,
    @ColumnInfo val rankImg: String,
    @ColumnInfo val rankName: String,
    @ColumnInfo(name = "user_ban") val userBan: Boolean,
    @ColumnInfo(name = "user_online") val userOnline: Int = 0,
    @ColumnInfo val selectedLegend: String,
    @ColumnInfo val level: Int,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
    )