package com.example.studyactivitylifecyl

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studyactivitylifecyl.Model.LegendWrapper
import com.squareup.picasso.Picasso


class HeroesStatsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes_stats)
        val textNameHero = findViewById<TextView>(R.id.textNameHero)
        val imageHeroesAvatar = findViewById<ImageView>(R.id.imageHeroesAvatar)


        val nicknameHeroes = intent.extras?.getString("nicknameHeroes")
        textNameHero.text = nicknameHeroes

        val test = intent.getParcelableExtra<LegendWrapper>("data")

        println(test?.ImgAssets)
        Picasso.get().load(test?.ImgAssets?.icon).into(imageHeroesAvatar)

       println(test?.data!!)

                  for ((value) in test?.data!!){
            println(value)
        }
    }
}