package com.yash.weather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {
    @GET("weather?i&appid=db4e26739039d06b122e98fc96cf4ab9")
    fun callGET(@Query ("q") city:String):Call<WeatherDataResponse>
}