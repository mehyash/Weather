package com.yash.weather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiService {
    val base_url="https://api.openweathermap.org/data/2.5/"
    val weatherApi=Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiCall::class.java)
    fun call(city:String)= weatherApi.callGET(city)
}