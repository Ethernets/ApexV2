package com.example.apextracker.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apextracker.model.entities.Profile

@Database(entities = [Profile::class], version = 1)
abstract class ProfileRoomDatabase: RoomDatabase() {
    abstract fun profileDao(): IProfileDao

    companion object{
        @Volatile
        private var INSTANCE: ProfileRoomDatabase? = null

        fun getDatabase(context: Context): ProfileRoomDatabase{

            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProfileRoomDatabase::class.java,
                    "apex_tracker_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}