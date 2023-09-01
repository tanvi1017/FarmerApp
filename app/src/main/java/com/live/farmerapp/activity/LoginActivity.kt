package com.live.farmerapp.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.live.farmerapp.R
import com.live.farmerapp.activity.util.hide
import com.live.farmerapp.activity.util.show
import com.live.farmerapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    companion object{
        fun launch(activity: Activity){
            val intent = Intent(activity, LoginActivity::class.java)
            activity.startActivity(intent)
        }
    }
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClicks()
        binding.tvSentOtp.setOnClickListener {
            OtpActivity.launch(this@LoginActivity)
        }
    }
    private fun onClicks(){
        binding.tb.apply {
            toolbarTitle. show()
                toolbarTitle.text ="Login"
            ivBack.hide()
        }

    }
}