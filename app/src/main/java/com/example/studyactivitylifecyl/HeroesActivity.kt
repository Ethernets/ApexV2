package com.example.studyactivitylifecyl

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studyactivitylifecyl.Adapters.HeroesRecyclerAdapter
import com.example.studyactivitylifecyl.Model.TestList
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.ArrayList

const val BASE_URL = "https://api.mozambiquehe.re"

class HeroesActivity : AppCompatActivity() {

    private lateinit var heroesAdapt : HeroesRecyclerAdapter
    
    private val recList = ArrayList<TestList>()

    private val TAG = "HeroesActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)


        getCurrentData()

        heroesAdapt = HeroesRecyclerAdapter(this, recList){
            testList -> val heroesStatsActivity = Intent(this,HeroesStatsActivity::class.java)

            heroesStatsActivity.putExtra("nicknameHeroes", testList.name)
            heroesStatsActivity.putExtra("data", testList.data)
            //heroesStatsActivity.putExtra("data", testList.data)
            startActivity(heroesStatsActivity)
        }
        val heroesListView = findViewById<RecyclerView>(R.id.heroesListView)
        heroesListView.adapter = heroesAdapt

        val layoutManager = LinearLayoutManager(this)
        heroesListView.layoutManager = layoutManager




    }

    private fun getCurrentData() {
        val nicknamePlayer = intent.extras?.getString("player")
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getList(nicknamePlayer.toString()).awaitResponse()
            if (response.isSuccessful) {
                val data = response.body()!!
                Log.d(TAG, data.toString())

                withContext(Dispatchers.Main){

                    heroesAdapt.apply {

                        for((key, value ) in data.legends.all){
                            recList.add(TestList(key, value))
                            println(value)
                        }
                      //  Log.d("HeroesActivity", recList.toString())
                        notifyDataSetChanged()
                    }


                    val textNickname = findViewById<TextView>(R.id.textNickname)

                    val textLvl = findViewById<TextView>(R.id.textLvl)

                    val avatarPlayer = findViewById<ImageView>(R.id.imageAvatarPlayer)

                    textNickname.text = "${data.global.name} (${data.global.rank.rankDiv} divisions)"
                    textLvl.text = "Level: ${data.global.level.toString()}"
                    Picasso.get().load(data.global.avatar).into(avatarPlayer)
                    when(data.global.rank.rankName){
                        "Silver" -> textNickname.setTextColor(Color.parseColor("#7A7A79"))
                        "Gold" ->   textNickname.setTextColor(Color.parseColor("#E6D600"))
                        "Platinum" -> textNickname.setTextColor(Color.parseColor("#36BBCE"))
                    }

                }

            }
        }
    }
}