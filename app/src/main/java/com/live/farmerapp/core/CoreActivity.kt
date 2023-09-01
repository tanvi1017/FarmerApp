package com.live.farmerapp.core

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.live.farmerapp.R
import com.live.farmerapp.databinding.ActivityCoreBinding
import com.live.farmerapp.fragment.NotificationFragment

class CoreActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityCoreBinding


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
        binding = ActivityCoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)
        navView = binding.navView
        drawerLayout = binding.myDrawerLayout
        val menu = navView.menu
        val redColor = ContextCompat.getColor(this, R.color.red)
        val logoutMenuItem = menu.findItem(R.id.nav_logout)
        val largeSizeSpan = RelativeSizeSpan(1.3f)
        val spannableTitle = SpannableString(logoutMenuItem.title)
        spannableTitle.setSpan(largeSizeSpan, 0, spannableTitle.length, 0)
        spannableTitle.setSpan(ForegroundColorSpan(redColor), 0, spannableTitle.length, 0)
        logoutMenuItem.title = spannableTitle
        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            val icon = menuItem.icon
            icon?.setTint(redColor)
            menuItem.icon = icon
        }
        val drawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.myToolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        setupDrawerLayout()
        drawerToggle.drawerArrowDrawable.color = ContextCompat.getColor(this, R.color.white)
        changeToolbarColor()
    }
    override fun onSupportNavigateUp(): Boolean {
        val handled = NavigationUI.navigateUp(navController, drawerLayout)

        if (!handled) {
            // Handle the case when the back button doesn't navigate up (e.g., you're on the root fragment)
            // Update the toolbar as needed
            binding.myToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.brown))
            binding.tvDashboard.text = "Dashboard"
        }

        return handled
    }

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

    private fun changeToolbarColor(){
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.notificationFragment->{
                    binding.myToolbar.apply {
                        setBackgroundColor(ContextCompat.getColor(this@CoreActivity, R.color.red))
                        binding.tvDashboard.setText("Notification")
                    }
                } R.id.latestPaymentFragment->{
                binding.myToolbar.apply {
                    setBackgroundColor(
                        ContextCompat.getColor(this@CoreActivity, R.color.red))
                    binding.tvDashboard.setText("LatestPayment")
                }
                }R.id.passbookFragment->{
                binding.myToolbar.apply {
                    setBackgroundColor(
                        ContextCompat.getColor(this@CoreActivity, R.color.red))
                    binding.tvDashboard.setText("Passbook")
                }
                }R.id.reportFragment -> {
                binding.myToolbar.apply {
                    setBackgroundColor(
                        ContextCompat.getColor(this@CoreActivity, R.color.red))
                    binding.tvDashboard.setText("Report")
                }
                }
                else -> {
                    binding.myToolbar.setBackgroundColor(
                        ContextCompat.getColor(this, R.color.brown)
                    )
                }
            }
        }
    }
}