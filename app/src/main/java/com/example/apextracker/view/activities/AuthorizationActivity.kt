package com.example.apextracker.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.apextracker.application.ApexTrackerApplication
import com.example.apextracker.databinding.ActivityAuthorizationBinding
import com.example.apextracker.view.fragments.HeroesFragment
import com.example.apextracker.viewmodel.ProfileViewModel
import com.example.apextracker.viewmodel.ProfileViewModelFactory

class AuthorizationActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAuthorizationBinding

    private val mProfileViewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((application as ApexTrackerApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnSignIn.setOnClickListener {

            val username = mBinding.etUsername.text.toString()
            val chBoxState = mBinding.chbRemember.isChecked

            HeroesFragment.newInstanceUsername(username)
            HeroesFragment.newInstanceChkBxState(chBoxState)
            startActivity(Intent(this@AuthorizationActivity, MainActivity::class.java))
            finish()
        }
    }
}