package com.live.farmerapp.core

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.live.farmerapp.R
import com.live.farmerapp.databinding.ActivityCoreBinding

class CoreActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCoreBinding
    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, CoreActivity::class.java)
            activity.startActivity(intent)
        }
    }
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private val navController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)
        navView = binding.navView
        drawerLayout = binding.myDrawerLayout
        setupDrawerLayout()
    }

    override fun onSupportNavigateUp() = NavigationUI.navigateUp(navController, drawerLayout)

    private fun setupDrawerLayout() {

        navView.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}