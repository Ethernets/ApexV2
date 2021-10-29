package com.example.apextracker.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.apextracker.R
import com.example.apextracker.databinding.ActivityAuthorizationBinding
import com.example.apextracker.model.entities.Profile

class AuthorizationActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityAuthorizationBinding

    private var mPofile: Profile? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnSignIn.setOnClickListener{

            val username = mBinding.etUsername.text.toString()

            val mFragment = Fragment()

            val tt = savedInstanceState?.putString("username", username)
           // mFragment.arguments?.putBundle(tt?.toString())
            //mFragment.arguments = bundleOf("username" to username)
           // mFragment.arguments?.putString("username", username)

            startActivity(Intent(this@AuthorizationActivity, MainActivity::class.java)

            )
            finish()
        }
    }
}