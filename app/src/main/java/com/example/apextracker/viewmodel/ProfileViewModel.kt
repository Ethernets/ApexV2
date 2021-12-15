package com.example.apextracker.viewmodel

import androidx.lifecycle.*
import com.example.apextracker.model.database.ProfileRepository
import com.example.apextracker.model.entities.apex.Profile
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ProfileViewModel(private val repository: ProfileRepository): ViewModel() {
    fun insert(profile: Profile) = viewModelScope.launch {
        repository.insertProfileData(profile)
    }

    val allUsersList: LiveData<List<Profile>> = repository.allUsersList.asLiveData()

    fun delete() = viewModelScope.launch {
        repository.deleteUserProfile()
    }
}

class ProfileViewModelFactory(private val repository: ProfileRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ProfileViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}