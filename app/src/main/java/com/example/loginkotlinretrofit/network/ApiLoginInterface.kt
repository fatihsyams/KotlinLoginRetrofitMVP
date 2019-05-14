package com.example.loginkotlinretrofit.network

import com.example.loginkotlinretrofit.model.LoginBody
import com.example.loginkotlinretrofit.model.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiLoginInterface {
    @POST("api/login")
    fun doLogin(@Body loginBody : LoginBody) : Call<ResponseLogin>
}