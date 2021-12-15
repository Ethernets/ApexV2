package com.example.apextracker.model.network.youtube_API

import com.example.apextracker.model.entities.youtube.AllVideo
import com.example.apextracker.utils.Constants
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IInfoYoutubeVideoAPI {
    @GET(Constants.API_YOUTUBE_ENDPOINT)
    fun getVideos(
        @Query(Constants.API_YOUTUBE_PLAYLIST_ID) playlistId: String,
        @Query(Constants.API_YOUTUBE_KEY) apiKey: String
    ): Single<AllVideo.AllVideoX>
}