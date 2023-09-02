package com.live.farmerapp.model

import com.google.gson.annotations.SerializedName

data class OtpResponse(
    @SerializedName("data")
    val data: Data,
    @SerializedName("Message")
    val message: String,
    @SerializedName("Status")
    val status: String
) {
    data class Data(
        @SerializedName("Address")
        val address: Any,
        @SerializedName("BmcCode")
        val bmcCode: Any,
        @SerializedName("BmcName")
        val bmcName: Any,
        @SerializedName("City")
        val city: Any,
        @SerializedName("CompanyCode")
        val CompanyCode: Any,
        val CompanyName: Any,
        val DefaultLanguage: Int,
        val DistrictCode: Any,
        val DistrictName: Any,
        val EmailAddress: Any,
        val EncToken: String,
        val FatherName: Any,
        val FullName: Any,
        val IsRegistered: Int,
        val MccCode: Any,
        val MccName: Any,
        val MemberCode: Any,
        val MemberTrCode: Any,
        val MobileNumber: String,
        val MppCode: Any,
        val MppName: Any,
        val OTP: String,
        val Pincode: Any,
        val PlantCode: Any,
        val PlantName: Any,
        val RegistrationDate: Any,
        val StateCode: Any,
        val StateName: Any,
        val VillageCode: Any,
        val VillageName: Any
    )
}