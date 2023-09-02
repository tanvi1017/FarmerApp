package com.live.farmerapp.service

import retrofit2.Retrofit


object RetrofitClient {
    private const val BASE_URL = "http://192.168.29.30/Fapp/api/"
    val api: ApiInterface = Retrofit.Builder()
        .baseUrl(BASE_URL)
            /** As the response has a forward slash which needs to be removed before actual parsing
             * i've added a custom gson converter **/
        .addConverterFactory(JsonCleanConverter.create())
        .build()
        .create(ApiInterface::class.java)
}