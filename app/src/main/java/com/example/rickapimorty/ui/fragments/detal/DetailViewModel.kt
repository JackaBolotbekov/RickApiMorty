package com.example.rickapimorty.ui.fragments.detal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickapimorty.App
import com.example.rickapimorty.data.model.detail.CharactersDetail
import com.example.rickapimorty.data.repositories.RickAndMortyRepository

class DetailViewModel : ViewModel() {

    private val repository = RickAndMortyRepository(App.retrofitClient.rickAndMortyApiService)

    private val _detailLiveData = MutableLiveData<CharactersDetail>()
    val detailLiveData: LiveData<CharactersDetail> = _detailLiveData

    private val _errorDetailLiveData = MutableLiveData<String>()
    val errorDetailLiveData: LiveData<String> = _errorDetailLiveData

    fun getSingleCharacter(id: Int) {
        repository.getSingleCharacter(
            onSuccess = {
                _detailLiveData.value = it
            },
            onFailure = {
                _errorDetailLiveData.value = it
            },
            id = id
        )
    }
}