package com.example.apextracker.view.activities

import android.content.Intent
import android.graphics.Color
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
import kotlinx.coroutines.flow.Flow

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
        if(global?.bans?.isActive == true){
            myBinding.tvUsername.setTextColor(Color.parseColor("#78002e"))
            myBinding.tvUsername.text = ("${global.name} (Banned for ${global.bans.remainingSeconds / 60} time)")
        }else {
            myBinding.tvUsername.text = global?.name
        }
        myBinding.tvDivision.text = ("${global?.rank?.rankName} ${global?.rank?.rankDiv} " +
                                    "(Rank Score: ${global?.rank?.rankScore})")
        myBinding.tvLevel.text = ("Level: ${global?.level} (Next level ${global?.toNextLevelPercent}%)")
        Glide.with(this)
            .load(global?.avatar)
            .into(myBinding.ivAvatar)

        Glide.with(this)
            .load(global?.rank?.rankImg)
            .circleCrop()
            .into(myBinding.ivDevision)

//myBinding.btExitProfile.setOnClickListener{

//    mProfileViewModel.delete()
//}


            setupActionBar()
        deleteUserProfile()
    }

    private fun setupActionBar() {
        setSupportActionBar(myBinding.toolbarProfile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        myBinding.toolbarProfile.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun deleteUserProfile(){
    mProfileViewModel.allUsersList.observe(this){
        Log.i("Delete", it.toString())
        //mProfileViewModel.delete(it)
    }


        myBinding.btExitProfile.setOnClickListener{
          startActivity(Intent(this, AuthorizationActivity::class.java))
            mProfileViewModel.delete()
            finish()
        }
    }
}