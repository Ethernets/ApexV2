package com.example.apextracker.view.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.example.apextracker.R
import com.example.apextracker.application.ApexTrackerApplication
import com.example.apextracker.databinding.ActivitySplashBinding
import com.example.apextracker.view.fragments.HeroesFragment
import com.example.apextracker.viewmodel.ProfileViewModel
import com.example.apextracker.viewmodel.ProfileViewModelFactory


class SplashActivity : AppCompatActivity() {

    private val mProfileViewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((application as ApexTrackerApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val splashBinding: ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_splash)
        setContentView(splashBinding.root)

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R)
{
    window.insetsController?.hide(WindowInsets.Type.statusBars())
}
        else{
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }

    val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        splashBinding.tvAppName.animation = splashAnimation

        splashAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
               Handler(Looper.getMainLooper()).postDelayed({
                   mProfileViewModel.allUsersList.observe(this@SplashActivity){
                           profile -> profile.let {
                       if (profile.isNotEmpty()) {
                           HeroesFragment.newInstanceUsername(profile.first().username)
                           HeroesFragment.newInstanceChkBxState(profile.first().userLogout)
                           Log.i("Apex Splash Info isNotEmpty", profile.toString())
                           startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                           finish()
                       }else{
                           Log.i("Apex Splash Info", profile.toString())
                           startActivity(Intent(this@SplashActivity, AuthorizationActivity::class.java))
                           finish()
                       }

                   }
                   }

               }, 1000)
            }

            override fun onAnimationRepeat(animation: Animation?) {
                TODO("Not yet implemented")
            }

        })
    }
}