package com.live.farmerapp.model

import com.google.gson.annotations.SerializedName

data class AboutUsResponse(
    @SerializedName("Data")
    val data: Data,
    @SerializedName("Message")
    val message: String,
    @SerializedName("Status")
    val status: String
)
    data class Data(
        @SerializedName("AboutApplicationEn")
        val aboutApplicationEn: String,
        @SerializedName("AboutApplicationHi")
        val aboutApplicationHi: String,
        @SerializedName("AboutCompanyEn")
        val aboutCompanyEn: String,
        @SerializedName("AboutCompanyHi")
        val aboutCompanyHi: String,
        @SerializedName("AboutID")
        val aboutID: Int,
        @SerializedName("Email")
        val email: String,
        @SerializedName("Mobile")
        val mobile: String,
        @SerializedName("Website")
        val website: String
    )
