package com.example.apextracker.model.database

import androidx.annotation.WorkerThread
import com.example.apextracker.model.entities.Profile
import kotlinx.coroutines.flow.Flow

class ProfileRepository(private val profileDao: IProfileDao) {
    @WorkerThread
    suspend fun insertProfileData(profile: Profile){
        profileDao.insertUserProfileDetails(profile)
    }

    val allUsersList: Flow<List<Profile>> = profileDao.getAllUsersList()
}