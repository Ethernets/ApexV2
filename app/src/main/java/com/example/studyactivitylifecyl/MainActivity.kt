package com.example.studyactivitylifecyl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val getStartedBtn = findViewById<Button>(R.id.getStartedBtn)
         val editTextTextMultiLine = findViewById<EditText>(R.id.editTextTextMultiLine)


        getStartedBtn.setOnClickListener{
            val heroesIntents  = Intent(this, HeroesActivity::class.java)
            val player = editTextTextMultiLine.text.toString()
            heroesIntents.putExtra("player", player)
            startActivity(heroesIntents)


        }
    }

}