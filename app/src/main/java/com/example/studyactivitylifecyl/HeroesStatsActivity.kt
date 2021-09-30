package com.example.studyactivitylifecyl

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studyactivitylifecyl.Model.LegendWrapper
import com.squareup.picasso.Picasso


class HeroesStatsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout. activity_heroes_stats)
        val textNameHero = findViewById<TextView>(R.id.textNameHero)
        val imageHeroesAvatar = findViewById<ImageView>(R.id.imageHeroesAvatar)

        val imageKills = findViewById<ImageView>(R.id.imageKills)
        val imageWins = findViewById<ImageView>(R.id.imageWins)
        val imageDamages = findViewById<ImageView>(R.id.imageDamages)
        val imageAllStats6 = findViewById<ImageView>(R.id.imageAllStats_6)

        val textViewBigValueKills = findViewById<TextView>(R.id.textViewBigValueKills)
        val textViewBigValueKills2 = findViewById<TextView>(R.id.textViewBigValueKills2)
        val textViewBigValueKills3 = findViewById<TextView>(R.id.textViewBigValueKills3)
        val textViewBigValueKills4 = findViewById<TextView>(R.id.textViewBigValueKills4)
        val textViewBigValueKills5 = findViewById<TextView>(R.id.textViewBigValueKills5)
        val textViewBigValueKills6 = findViewById<TextView>(R.id.textViewBigValueKills6)
        val textViewBigNameKills = findViewById<TextView>(R.id.textViewBigNameKills)
        val textViewBigNameKills2 = findViewById<TextView>(R.id.textViewBigNameKills2)
        val textViewBigNameKills3 = findViewById<TextView>(R.id.textViewBigNameKills3)
        val textViewBigNameKills4 = findViewById<TextView>(R.id.textViewBigNameKills4)
        val textViewBigNameKills5 = findViewById<TextView>(R.id.textViewBigNameKills5)
        val textViewBigNameKills6 = findViewById<TextView>(R.id.textViewBigNameKills6)

        val textNameValueKills = findViewById<TextView>(R.id.textValueNameKills)
        val textValueKills = findViewById<TextView>(R.id.textValueKills)
        val textNameValueWins = findViewById<TextView>(R.id.textNameValueWins)
        val textValueWins = findViewById<TextView>(R.id.textValueWins)
        val textNameValueDamage = findViewById<TextView>(R.id.textNameValueDamage)
        val textValueDamage = findViewById<TextView>(R.id.textValueDamage)

        val nicknameHeroes = intent.extras?.getString("nicknameHeroes")
        textNameHero.text = nicknameHeroes

        val test = intent.getParcelableExtra<LegendWrapper>("data")

       // println(test?.ImgAssets)
        Picasso.get().load(test?.ImgAssets?.icon).into(imageHeroesAvatar)

        imageAllStats6.visibility = View.INVISIBLE
        textViewBigValueKills.visibility = View.INVISIBLE
        textViewBigValueKills2.visibility = View.INVISIBLE
        textViewBigValueKills3.visibility = View.INVISIBLE
        textViewBigValueKills4.visibility = View.INVISIBLE
        textViewBigValueKills5.visibility = View.INVISIBLE
        textViewBigValueKills6.visibility = View.INVISIBLE
        textViewBigNameKills.visibility = View.INVISIBLE
        textViewBigNameKills2.visibility = View.INVISIBLE
        textViewBigNameKills3.visibility = View.INVISIBLE
        textViewBigNameKills4.visibility = View.INVISIBLE
        textViewBigNameKills5.visibility = View.INVISIBLE
        textViewBigNameKills6.visibility = View.INVISIBLE

          if (test?.data != null) {
              if (test.data.size <= 3 ){
                  imageKills.visibility = View.VISIBLE
                  imageWins.visibility = View.VISIBLE
                  imageDamages.visibility = View.VISIBLE

                  imageAllStats6.visibility = View.INVISIBLE
                  textViewBigValueKills.visibility = View.INVISIBLE
                  textViewBigValueKills2.visibility = View.INVISIBLE
                  textViewBigValueKills3.visibility = View.INVISIBLE
                  textViewBigValueKills4.visibility = View.INVISIBLE
                  textViewBigValueKills5.visibility = View.INVISIBLE
                  textViewBigValueKills6.visibility = View.INVISIBLE
                  textViewBigNameKills.visibility = View.INVISIBLE
                  textViewBigNameKills2.visibility = View.INVISIBLE
                  textViewBigNameKills3.visibility = View.INVISIBLE
                  textViewBigNameKills4.visibility = View.INVISIBLE
                  textViewBigNameKills5.visibility = View.INVISIBLE
                  textViewBigNameKills6.visibility = View.INVISIBLE

                  textNameValueKills.visibility = View.VISIBLE
                  textValueKills.visibility = View.VISIBLE
                  textNameValueWins.visibility = View.VISIBLE
                  textValueWins.visibility = View.VISIBLE
                  textNameValueDamage.visibility = View.VISIBLE
                  textValueDamage.visibility = View.VISIBLE

                  //textNameValueKills.layout                      //layout_constraintBottom_toTopOf

                  textNameValueKills.text = test.data[0].name
                  textValueKills.text = test.data[0].value.toString()
                  textNameValueWins.text = test.data[1].name
                  textValueWins.text = test.data[1].value.toString()
                  textNameValueDamage.text = test.data[2].name
                  textValueDamage.text = test.data[2].value.toString()



              } else {
                  imageKills.visibility = View.INVISIBLE
                  imageWins.visibility = View.INVISIBLE
                  imageDamages.visibility = View.INVISIBLE
                  imageAllStats6.visibility = View.VISIBLE

                  textNameValueKills.visibility = View.INVISIBLE
                  textValueKills.visibility = View.INVISIBLE
                  textNameValueWins.visibility = View.INVISIBLE
                  textValueWins.visibility = View.INVISIBLE
                  textNameValueDamage.visibility = View.INVISIBLE
                  textValueDamage.visibility = View.INVISIBLE

                  textViewBigValueKills.visibility = View.VISIBLE
                  textViewBigValueKills2.visibility = View.VISIBLE
                  textViewBigValueKills3.visibility = View.VISIBLE
                  textViewBigValueKills4.visibility = View.VISIBLE
                  textViewBigValueKills5.visibility = View.VISIBLE
                  textViewBigValueKills6.visibility = View.VISIBLE
                  textViewBigNameKills.visibility = View.VISIBLE
                  textViewBigNameKills2.visibility = View.VISIBLE
                  textViewBigNameKills3.visibility = View.VISIBLE
                  textViewBigNameKills4.visibility = View.VISIBLE
                  textViewBigNameKills5.visibility = View.VISIBLE
                  textViewBigNameKills6.visibility = View.VISIBLE

                  textViewBigValueKills.text = test.data[0].value.toString()
                  textViewBigValueKills2.text = test.data[1].value.toString()
                  textViewBigValueKills3.text = test.data[2].value.toString()
                  textViewBigValueKills4.text = test.data[3].value.toString()
                  textViewBigValueKills5.text = test.data[4].value.toString()
                  textViewBigValueKills6.text = test.data[5].value.toString()

                  textViewBigNameKills.text = test.data[0].name
                  textViewBigNameKills2.text = test.data[1].name
                  textViewBigNameKills3.text = test.data[2].name
                  textViewBigNameKills4.text = test.data[3].name
                  textViewBigNameKills5.text = test.data[4].name
                  textViewBigNameKills6.text = test.data[5].name

                  println(test.data.size)
              }
        }
    }
}