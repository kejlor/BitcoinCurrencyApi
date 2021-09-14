package com.example.jettests

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettests.data.remote.AppModule
import com.example.jettests.data.remote.responses.BitcoinItem
import kotlinx.coroutines.launch


class MainActivityViewModel : ViewModel() {

    val myResponse: MutableLiveData<BitcoinItem> = MutableLiveData()
    val myResponseList: MutableLiveData<List<BitcoinItem>> = MutableLiveData()

    fun getRates() {
        viewModelScope.launch {
            myResponseList.value = AppModule.retrofit.getRates()
        }
    }

    fun getUsd() {
        viewModelScope.launch {
            myResponse.value = AppModule.retrofit.getUsd()
        }
    }
}