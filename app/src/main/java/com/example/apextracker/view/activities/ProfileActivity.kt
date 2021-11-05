package com.example.apextracker.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.apextracker.application.ApexTrackerApplication
import com.example.apextracker.databinding.ActivityProfileBinding
import com.example.apextracker.model.entities.AllHeroes
import com.example.apextracker.model.entities.Profile
import com.example.apextracker.viewmodel.ProfileViewModel
import com.example.apextracker.viewmodel.ProfileViewModelFactory

class ProfileActivity : AppCompatActivity(){
    private lateinit var myBinding: ActivityProfileBinding

    private val mProfileViewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((application as ApexTrackerApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(myBinding.root)

        val global = intent.getParcelableExtra("profile") as? AllHeroes.Global
        Log.i("Apex Info 3", global.toString())
        myBinding.tvUsername.text = global?.name
        myBinding.tvDivision.text = ("${global?.rank?.rankName} ${global?.rank?.rankDiv}")
        Glide.with(this)
            .load(global?.avatar)
            .into(myBinding.ivAvatar)


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