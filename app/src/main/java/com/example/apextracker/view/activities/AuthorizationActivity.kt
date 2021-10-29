package com.example.apextracker.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.apextracker.R
import com.example.apextracker.databinding.ActivityAuthorizationBinding
import com.example.apextracker.model.entities.Profile

class AuthorizationActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityAuthorizationBinding

    private var mPofile: Profile? = null

    lateinit var mFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnSignIn.setOnClickListener{

            val username = mBinding.etUsername.text.toString()

            mFragment.arguments?.putString("username", username)

            startActivity(Intent(this@AuthorizationActivity, MainActivity::class.java)

            )
            finish()
        }
    }
}