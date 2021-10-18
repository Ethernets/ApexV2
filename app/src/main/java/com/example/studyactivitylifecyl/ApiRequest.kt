package com.example.studyactivitylifecyl


import com.example.studyactivitylifecyl.model.TestHero
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    @GET("bridge?version=5&platform=PC&auth=Gxbp4SE2e5kScsUmwevA")
    fun getList(@Query("player")player : String) : Call<TestHero>
}