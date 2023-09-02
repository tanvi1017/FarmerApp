package com.live.farmerapp.service

class Repository(private val api: ApiInterface) {
    fun getDataFromServer() = api.getAboutUs()
}