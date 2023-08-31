package com.live.farmerapp.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.live.farmerapp.core.CoreActivity
import com.live.farmerapp.databinding.ActivityOtpBinding

class OtpActivity : AppCompatActivity() {
    companion object{
        fun launch(activity: Activity){
            val intent = Intent(activity, OtpActivity::class.java)
            activity.startActivity(intent)
        }
    }
    private lateinit var binding:ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tb.ivBack.setOnClickListener {
            finish()
        }
        binding.btnVerify.setOnClickListener {
            CoreActivity.launch(this@OtpActivity)

        }
    }
}