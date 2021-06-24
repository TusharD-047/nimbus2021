package com.codewithroronoa.crypto.markets.network

import com.codewithroronoa.crypto.markets.mark
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {
    @GET("markets")
    suspend fun getDataFromApi() : mark
}