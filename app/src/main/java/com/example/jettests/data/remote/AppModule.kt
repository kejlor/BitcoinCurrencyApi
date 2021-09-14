package com.example.jettests.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://bitpay.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(BitcoinApi::class.java)}
}