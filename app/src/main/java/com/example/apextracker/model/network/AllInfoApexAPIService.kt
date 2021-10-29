package com.example.apextracker.model.network

import android.media.AsyncPlayer
import com.example.apextracker.model.entities.AllHeroes
import com.example.apextracker.utils.Constants
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class AllInfoApexAPIService {
    private val api = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(AllInfoApexAPI::class.java)

    fun getAllInfoApexTracker(player: String): Single<AllHeroes.Heroes>{
        return api.getHeroes(Constants.API_PLATFORM_VALUE,
            player,
            Constants.API_KEY_VALUE
        )
    }
}