package com.example.studyactivitylifecyl


import com.example.studyactivitylifecyl.Model.TestHero
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequest {
    @GET("bridge?version=5&platform=PC&player=Ethernetss&auth=Gxbp4SE2e5kScsUmwevA")
    fun herList() : Call<TestHero>
}