package com.live.farmerapp.activity.drawerItem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.live.farmerapp.R
import com.live.farmerapp.activity.util.show
import com.live.farmerapp.databinding.ActivityDetailedPaymentBinding

class DetailedPaymentActivity : AppCompatActivity() {
    companion object{
        fun launch(activity: Activity){
            val intent = Intent(activity,DetailedPaymentActivity::class.java)
            activity.startActivity(intent)
        }
    }
    private lateinit var binding:ActivityDetailedPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailedPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
    }
    private fun onClick(){
        binding.dashToolbar.apply {
            toolbarTitle.show()
            toolbarTitle.text="Latest Payment"
        }
        binding.dashToolbar.ivBack.setOnClickListener {
            finish()
        }
    }
}