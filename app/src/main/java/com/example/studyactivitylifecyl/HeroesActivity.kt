package com.example.studyactivitylifecyl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.ArrayAdapter
import com.example.studyactivitylifecyl.Model.HeroesList
import com.example.studyactivitylifecyl.Model.TestHero
import com.example.studyactivitylifecyl.Services.DataService
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_heroes.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.mozambiquehe.re"

class HeroesActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<HeroesList>
    private val TAG = "HeroesActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)



        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            DataService.heroesList)
        heroesListView.adapter = adapter
        getCurrentData()
    }

    private fun getCurrentData(){
       /* val gson = GsonBuilder()
            .setLenient()
            .create()*/
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)



        GlobalScope.launch(Dispatchers.IO) {
            val response = api.herList().awaitResponse()
            if (response.isSuccessful) {
                val data = response.body()!!
                Log.d(TAG, data.toString())
            }
        }


    }
}