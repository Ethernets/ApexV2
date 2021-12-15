package com.example.apextracker.model.network.apex_API

import com.example.apextracker.model.entities.apex.AllHeroes
import com.example.apextracker.utils.Constants
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AllInfoApexAPI {
    @GET(Constants.API_ENDPOINT)
    fun getHeroes(
        @Query(Constants.API_PLATFORM) platform: String,
        @Query(Constants.API_PLAYER) player: String,
        @Query(Constants.API_KEY) apiKey: String
    ): Single<AllHeroes.Heroes>
}