package com.example.studyactivitylifecyl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        getStartedBtn.setOnClickListener{
            val heroesIntents  = Intent(this, HeroesActivity::class.java)
            val player = editTextTextMultiLine.text.toString()
            heroesIntents.putExtra("player", player)
            startActivity(heroesIntents)


        }
    }

}