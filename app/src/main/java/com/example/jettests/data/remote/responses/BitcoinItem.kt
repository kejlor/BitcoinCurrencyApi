package com.example.jettests.data.remote.responses


import com.google.gson.annotations.SerializedName

data class BitcoinItem(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rate")
    val rate: Double
)