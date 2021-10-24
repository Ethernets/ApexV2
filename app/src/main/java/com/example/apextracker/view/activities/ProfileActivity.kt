package com.example.apextracker.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.apextracker.R
import com.example.apextracker.application.ApexTrackerApplication
import com.example.apextracker.databinding.ActivityProfileBinding
import com.example.apextracker.viewmodel.ProfileViewModel
import com.example.apextracker.viewmodel.ProfileViewModelFactory

class ProfileActivity : AppCompatActivity() {
    private lateinit var myBinding: ActivityProfileBinding

    private val mProfileViewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((application as ApexTrackerApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(myBinding.root)
        setupActionBar()
    }

    private fun setupActionBar() {
        setSupportActionBar(myBinding.toolbarProfile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        myBinding.toolbarProfile.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}