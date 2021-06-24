package com.codewithroronoa.crypto.markets.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        var baseUrl = "https://www.cryptingup.com/api/"
        fun getRetroInstance(): Retrofit{
            return Retrofit.Builder().
                    baseUrl(baseUrl).
                    addConverterFactory(GsonConverterFactory.create()).
                    build()
        }
    }
}