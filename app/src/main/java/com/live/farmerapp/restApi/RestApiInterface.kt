package com.live.farmerapp.restApi



import com.live.farmerapp.util.Constant
import retrofit2.Response
import retrofit2.http.*

interface RestApiInterface {

    @FormUrlEncoded
    @POST(Constant.AboutUs)
    suspend fun aboutUs(@FieldMap map: HashMap<String, String>):Response<String>

    @FormUrlEncoded
    @POST(Constant.VerifyOtp)
     suspend fun otpVerify(@Field("MobileNumber") mobileNumber: HashMap<String, String>): Response<String>

}