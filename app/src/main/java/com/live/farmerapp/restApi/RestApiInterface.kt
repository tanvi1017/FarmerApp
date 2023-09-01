package com.live.farmerapp.restApi



import android.database.Observable
import com.live.countrysearch.util.Constant
import com.live.farmerapp.model.AboutUsResponse
import retrofit2.Response
import retrofit2.http.*

interface RestApiInterface {

    @FormUrlEncoded
    @POST(Constant.AboutUs)
    fun aboutUs(map: HashMap<String, String>):Response<AboutUsResponse>

}