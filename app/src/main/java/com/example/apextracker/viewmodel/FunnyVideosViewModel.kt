package com.example.apextracker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apextracker.model.entities.apex.AllHeroes
import com.example.apextracker.model.entities.youtube.AllVideo
import com.example.apextracker.model.network.youtube_API.InfoYoutubeVideoAPIService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class FunnyVideosViewModel : ViewModel() {

    private val infoYoutubeVideoAPIService = InfoYoutubeVideoAPIService()
    private val compositeDisposable = CompositeDisposable()

    val loadInfoYoutubeVideo = MutableLiveData<Boolean>()
    val loadInfoYoutubeVideoResponse = MutableLiveData<AllVideo.AllVideoX>()
    val loadInfoYoutubeVideoLoadingError = MutableLiveData<Boolean>()

fun getInfoYoutubeVideoFromAPI(){
    loadInfoYoutubeVideo.value = true

    compositeDisposable.add(
        infoYoutubeVideoAPIService.getInfoYoutubeVideo()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith()
    )
}
}