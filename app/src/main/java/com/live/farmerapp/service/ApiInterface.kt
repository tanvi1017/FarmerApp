package com.live.farmerapp.service

import com.live.farmerapp.model.AboutUsResponse
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("Init/GetInitialData?")
    fun getAboutUs(): Call<AboutUsResponse>
}