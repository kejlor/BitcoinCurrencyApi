package com.example.jettests.data.remote

import com.example.jettests.data.remote.responses.BitcoinItem
import retrofit2.http.GET
import retrofit2.http.Query

interface BitcoinApi {
    @GET("rates")
    suspend fun getRates(): List<BitcoinItem>
    @GET("rates/usd")
    suspend fun getUsd(): BitcoinItem
}