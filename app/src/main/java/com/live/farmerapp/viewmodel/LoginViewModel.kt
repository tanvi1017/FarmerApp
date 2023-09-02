package com.live.farmerapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.live.countrysearch.util.validator.NetworkResult
import com.live.farmerapp.others.MyApplication
import com.live.farmerapp.others.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel:ViewModel() {
    private val restApiInterface = MyApplication.getnstance().provideAuthservice()
    var verifyOtp: MutableLiveData<NetworkResult<String>> = MutableLiveData()

    fun callOtpVerify(map: HashMap<String, String>) {
        if (Utils.isNetworkConnected(MyApplication.getnstance())) {
            viewModelScope.launch {
                val response = restApiInterface.otpVerify(map)
                verifyOtp.postValue(handleLoginResponse(response)) } }
    }
    private fun handleLoginResponse(response: Response<String>): NetworkResult<String>? {
        return when {
            response.isSuccessful -> response.body()?.let {
                val response = "messsge"
                Log.v("OtpResponse", response)
                NetworkResult.Success(it)
            }
            else ->  {
                Log.v("OtppResponse", "error")
                NetworkResult.Error(response.message()) } }
    }
}