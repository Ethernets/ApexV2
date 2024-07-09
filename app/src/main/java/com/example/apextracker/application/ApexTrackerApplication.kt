package com.example.apextracker.application

import android.app.Application
import com.example.apextracker.model.database.ProfileRepository
import com.example.apextracker.model.database.ProfileRoomDatabase

class ApexTrackerApplication: Application() {
    private val database by lazy { ProfileRoomDatabase.getDatabase((this@ApexTrackerApplication))}
    val repository by lazy { ProfileRepository(database.profileDao()) }
}