package com.live.farmerapp.model

import com.google.gson.annotations.SerializedName

data class OtpResponse(
    @SerializedName("Data")
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
        val companyCode: Any,
        @SerializedName("CompanyName")
        val companyName: Any,
        @SerializedName("DefaultLanguage")
        val defaultLanguage: Int,
        @SerializedName("DistrictCode")
        val districtCode: Any,
        @SerializedName("DistrictName")
        val districtName: Any,
        @SerializedName("EmailAddress")
        val emailAddress: Any,
        @SerializedName("EncToken")
        val encToken: String,
        @SerializedName("FatherName")
        val fatherName: Any,
        @SerializedName("FullName")
        val fullName: Any,
        @SerializedName("IsRegistered")
        val isRegistered: Int,
        @SerializedName("MccCode")
        val mccCode: Any,
        @SerializedName("MccName")
        val mccName: Any,
        @SerializedName("MemberCode")
        val memberCode: Any,
        @SerializedName("MemberTrCode")
        val memberTrCode: Any,
        @SerializedName("MobileNumber")
        val mobileNumber: String,
        @SerializedName("MppCode")
        val mppCode: Any,
        @SerializedName("MppName")
        val mppName: Any,
        @SerializedName("OTP")
        val oTP: String,
        @SerializedName("Pincode")
        val pincode: Any,
        @SerializedName("PlantCode")
        val plantCode: Any,
        @SerializedName("PlantName")
        val plantName: Any,
        @SerializedName("RegistrationDate")
        val registrationDate: Any,
        @SerializedName("StateCode")
        val stateCode: Any,
        @SerializedName("StateName")
        val stateName: Any,
        @SerializedName("VillageCode")
        val villageCode: Any,
        @SerializedName("VillageName")
        val villageName: Any
    )
}
