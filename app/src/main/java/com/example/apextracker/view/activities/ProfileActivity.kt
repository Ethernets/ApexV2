package com.example.apextracker.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.apextracker.R
import com.example.apextracker.application.ApexTrackerApplication
import com.example.apextracker.databinding.ActivityProfileBinding
import com.example.apextracker.model.entities.AllHeroes
import com.example.apextracker.model.entities.IProfileToActivity
import com.example.apextracker.model.entities.Profile
import com.example.apextracker.viewmodel.ProfileViewModel
import com.example.apextracker.viewmodel.ProfileViewModelFactory

class ProfileActivity : AppCompatActivity(), IProfileToActivity {
    private lateinit var myBinding: ActivityProfileBinding

    private var mProfileDetails: Profile? = null

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

    override fun profileInfo(data: AllHeroes.Global) {
        myBinding.tvUsername.text = data.name
        myBinding.tvDivision.text = data.rank.rankName
        Log.i("Apex Info 3", data.toString())
    }
}