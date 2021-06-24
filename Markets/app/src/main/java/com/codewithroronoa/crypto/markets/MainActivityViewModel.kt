package com.codewithroronoa.crypto.markets

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewithroronoa.crypto.markets.network.RetroInstance
import com.codewithroronoa.crypto.markets.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    lateinit var marketListLiveData : MutableLiveData<mark>

    init {
        marketListLiveData = MutableLiveData()
    }
    fun getmarketListObserver() : MutableLiveData<mark>{
        return marketListLiveData
    }
    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi()
            Log.e("get", response.toString());
            marketListLiveData.postValue(response)
        }
    }
}

