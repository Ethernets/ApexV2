package com.example.studyactivitylifecyl

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.studyactivitylifecyl.Adapters.HeroesAdapter
import com.example.studyactivitylifecyl.Model.TestHero
import kotlinx.android.synthetic.main.activity_heroes.*
import kotlinx.android.synthetic.main.list_hero_view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

const val BASE_URL = "https://api.mozambiquehe.re"

class HeroesActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<TestHero>
    lateinit var adapt: ArrayAdapter<String>
    lateinit var heroesAdapt : HeroesAdapter
    val listHero = ArrayList<TestHero>()
    private val TAG = "HeroesActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)



       // val adapterr = ArrayAdapter(this, android.R.layout.simple_list_item_1,)


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            LinkedList<TestHero>())
       // heroesListView.adapter = adapter

        adapt = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            LinkedList<String>())
        //heroesListView.adapter = adapt


        getCurrentData()

        heroesAdapt = HeroesAdapter(this, listHero)
        heroesListView.adapter = heroesAdapt


    }

    private fun getCurrentData() {
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

                withContext(Dispatchers.Main){
                   // adapter.add(data.global.name)
                    adapt.add(data.global.platform)

                    listHero.add(data)
                    heroesAdapt.notifyDataSetChanged()
                }

            }
        }
    }
}