package com.example.loginkotlinretrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiLoginClient {

    fun create(): ApiLoginInterface {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://reqres.in/")
            .build()

        return retrofit.create(ApiLoginInterface::class.java)
    }
}