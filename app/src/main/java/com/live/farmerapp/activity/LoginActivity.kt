package com.live.farmerapp.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.live.countrysearch.util.mLog
import com.live.countrysearch.util.validator.NetworkResult
import com.live.farmerapp.R
import com.live.farmerapp.activity.util.hide
import com.live.farmerapp.activity.util.show
import com.live.farmerapp.databinding.ActivityLoginBinding
import com.live.farmerapp.others.PreferenceFile
import com.live.farmerapp.others.PreferenceFile.AUTH_TOKEN
import com.live.farmerapp.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    companion object{
        fun launch(activity: Activity){
            val intent = Intent(activity, LoginActivity::class.java)
            activity.startActivity(intent)
        }
    }
    private lateinit var binding:ActivityLoginBinding
    private lateinit var  viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this@LoginActivity)[LoginViewModel::class.java]
        onClicks()
        initObserver()
        binding.tvSentOtp.setOnClickListener {
            //OtpActivity.launch(this@LoginActivity)
            callApi()
        }
    }
    private fun onClicks(){
        binding.tb.apply {
            toolbarTitle. show()
                toolbarTitle.text ="Login"
            ivBack.hide()
        }
    }
    private fun callApi(){
        val map = HashMap<String, String>()
        map["MobileNumber"] = "9999999999"
        map["MobileNumber"] = PreferenceFile.getData(this@LoginActivity,AUTH_TOKEN) ?:""
        viewModel.callOtpVerify(map)

    }
    private fun initObserver(){
        viewModel.verifyOtp.observe(this@LoginActivity){
            when (it) {
                is NetworkResult.Success -> {
                    val response = it.data
                    Log.v("OtpResponse", response ?: "Response is null")
                }
                is NetworkResult.Error -> {
                    Toast.makeText(this, "Error: ${it.message}", Toast.LENGTH_LONG).show()
                }
                is NetworkResult.Loading -> {

                }
            }
        }
    }

}