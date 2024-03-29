package com.example.apextracker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apextracker.model.entities.apex.AllHeroes
import com.example.apextracker.model.network.apex_API.AllInfoApexAPIService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class HeroesViewModel : ViewModel() {

    private val allInfoApexAPIService = AllInfoApexAPIService()

    private val compositeDisposable = CompositeDisposable()

    val loadAllInfoApex = MutableLiveData<Boolean>()
    val allInfoApexResponse = MutableLiveData<AllHeroes.Heroes>()
    val allInfoApexLoadingError = MutableLiveData<Boolean>()

    fun getAllInfoApexFromAPI(username: String) {
        loadAllInfoApex.value = true

        compositeDisposable.add(
            allInfoApexAPIService.getAllInfoApexTracker(player = username)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<AllHeroes.Heroes>() {
                    override fun onSuccess(value: AllHeroes.Heroes) {
                        loadAllInfoApex.value = false
                        allInfoApexResponse.value = value
                        allInfoApexLoadingError.value = false

                    }

                    override fun onError(e: Throwable) {
                        loadAllInfoApex.value = false
                        allInfoApexLoadingError.value = true
                        e.printStackTrace()
                    }

                })
        )
    }

}