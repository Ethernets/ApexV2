package com.example.apextracker.model.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.apextracker.model.entities.Profile
import kotlinx.coroutines.flow.Flow

@Dao
interface IProfileDao {
    @Insert
    suspend fun insertUserProfileDetails(profile: Profile)

    @Query("SELECT * FROM ALL_USERS_PROFILE ORDER BY ID")
    fun getAllUsersList(): Flow<List<Profile>>

    @Query("DELETE FROM ALL_USERS_PROFILE")
    suspend fun deleteUserProfileDetails()

}