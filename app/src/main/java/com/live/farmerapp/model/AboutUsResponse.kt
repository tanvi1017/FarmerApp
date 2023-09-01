package com.live.farmerapp.model

data class AboutUsResponse(
    val Data: Data,
    val Message: String,
    val Status: String
)
    data class Data(
        val AboutApplicationEn: String,
        val AboutApplicationHi: String,
        val AboutCompanyEn: String,
        val AboutCompanyHi: String,
        val AboutID: Int,
        val Email: String,
        val Mobile: String,
        val Website: String
    )
