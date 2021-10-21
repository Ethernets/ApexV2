package com.example.apextracker.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apextracker.R
import com.example.apextracker.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var myBinding: ActivityProfileBinding

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