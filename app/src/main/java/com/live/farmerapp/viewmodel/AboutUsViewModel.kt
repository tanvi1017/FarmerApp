package com.live.farmerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.live.countrysearch.util.mLog
import com.live.countrysearch.util.validator.NetworkResult
import com.live.farmerapp.model.AboutUsResponse
import com.live.farmerapp.others.MyApplication
import com.live.farmerapp.others.Utils
import kotlinx.coroutines.launch
import retrofit2.Response

class AboutUsViewModel:ViewModel() {
    private val restApiInterface = MyApplication.getnstance().provideAuthservice()
    var fetchAboutUs: MutableLiveData<NetworkResult<AboutUsResponse>> = MutableLiveData()

    fun callAboutUsApi(map: HashMap<String, String>) {
        if (Utils.isNetworkConnected(MyApplication.getnstance())) {
            viewModelScope.launch {
                val response = restApiInterface.aboutUs(map)
                fetchAboutUs.postValue(handleLoginResponse(response))
            }
        }
    }
    private fun handleLoginResponse(response: Response<AboutUsResponse>): NetworkResult<AboutUsResponse>? {
        return when {
            response.isSuccessful -> response.body()?.let { NetworkResult.Success(it) }
            else ->  NetworkResult.Error(response.message())
        }
    }
}