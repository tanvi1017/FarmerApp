package com.live.farmerapp.restApi



import com.live.farmerapp.util.Constant
import com.live.farmerapp.model.AboutUsResponse
import retrofit2.Response
import retrofit2.http.*

interface RestApiInterface {

    @FormUrlEncoded
    @POST(Constant.AboutUs)
   suspend fun aboutUs(map: HashMap<String, String>):Response<AboutUsResponse>

}