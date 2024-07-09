package com.example.studyactivitylifecyl

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studyactivitylifecyl.Adapters.HeroesRecyclerAdapter
import com.example.studyactivitylifecyl.Adapters.TestRecyclerAdapter
import com.example.studyactivitylifecyl.Model.TestHero
import kotlinx.android.synthetic.main.activity_heroes.*
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

    lateinit var heroesAdapt : HeroesRecyclerAdapter

    val listHero = ArrayList<TestHero>()
    val recList = ArrayList<String>()

    private val TAG = "HeroesActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        getCurrentData()

        heroesAdapt = HeroesRecyclerAdapter(this, recList)
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

                    listHero.add(data)

                    heroesAdapt.apply {

                        for((key) in data.legends.all){
                            Log.d("HeroesActivity", key)
                            //holder.heroesName?.text = key
                            recList.add(key)
                        }

                        notifyDataSetChanged()
                    }



                    textNickname.text = "${data.global.name} (${data.global.rank.rankDiv} divisions)"
                    textLvl.text = "Level: ${data.global.level.toString()}"
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