package com.example.apextracker.model.network.youtube_API

import com.example.apextracker.model.entities.youtube.AllVideo
import com.example.apextracker.utils.Constants
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class InfoYoutubeVideoAPIService {
    private val api = Retrofit.Builder()
        .baseUrl(Constants.BASE_YOUTUBE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(IInfoYoutubeVideoAPI::class.java)

    fun getInfoYoutubeVideo(): Single<AllVideo.AllVideoX>{
        return api.getVideos(Constants.API_YOUTUBE_PLAYLIST_ID_VALUE,
            Constants.API_YOUTUBE_KEY_VALUE)
    }
}