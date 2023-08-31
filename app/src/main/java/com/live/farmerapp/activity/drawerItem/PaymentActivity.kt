package com.live.farmerapp.activity.drawerItem

import android.R
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.live.farmerapp.activity.LoginActivity
import com.live.farmerapp.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity(){
    companion object{
        fun launch(activity: Activity){
            val intent = Intent(activity, PaymentActivity::class.java)
            activity.startActivity(intent)
        }
    }
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var binding:ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClicks()
        setSpinner()
        setSupportActionBar(binding.myToolbar)

    }
    private fun onClicks(){
        binding.ivNextOne.setOnClickListener {
            DetailedPaymentActivity.launch(this@PaymentActivity)
        }
        binding.ivMenu.setOnClickListener {

        }

    }
    private fun setSpinner(){
        val menuList = mutableListOf("2022-23", "2021-22","2020-21","2019-20","2018-19","2017-18")
        val arrayAdapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_dropdown_item,
            menuList
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerType.adapter = arrayAdapter

        binding.spinnerType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,view: View,position: Int,id: Long) {
                (view as TextView).setTextColor(Color.BLACK) //Change selected text color
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
    
    }

