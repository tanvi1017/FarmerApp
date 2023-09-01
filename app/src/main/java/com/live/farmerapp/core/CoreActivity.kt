package com.live.farmerapp.core

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.live.farmerapp.R
import com.live.farmerapp.activity.LoginActivity
import com.live.farmerapp.databinding.ActivityCoreBinding
import com.live.farmerapp.fragment.NotificationFragment

class CoreActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
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
        logoutMenuItem.setOnMenuItemClickListener {
            showLogoutConfirmationDialog()
            return@setOnMenuItemClickListener true

        }
        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            val icon = menuItem.icon
            icon?.setTint(redColor)
            menuItem.icon = icon
        }
        val drawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        val dashboardMenuItem = menu?.findItem(R.id.dashboardFragment)
        val customView = dashboardMenuItem?.actionView
        return true
    }

    private fun changeToolbarColor() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
//                R.id.nav_logout ->{
//                       // showLogoutConfirmationDialog()
//                        Toast.makeText(this@CoreActivity,"logout",Toast.LENGTH_LONG).show()
//                }

                R.id.dashboardFragment -> {
                    binding.myToolbar.apply {
                        setBackgroundColor(ContextCompat.getColor(this@CoreActivity, R.color.red))
                        binding.tvDashboard.text = "Dashboard"
                    }
                }

                R.id.notificationFragment -> {
                    binding.myToolbar.apply {
                        setBackgroundColor(ContextCompat.getColor(this@CoreActivity, R.color.red))
                        binding.tvDashboard.text = "Notification"
                    }
                }
                R.id.latestPaymentFragment -> {
                    binding.myToolbar.apply {
                        setBackgroundColor(
                            ContextCompat.getColor(this@CoreActivity, R.color.red)
                        )
                        binding.tvDashboard.text = "LatestPayment"
                    }
                }
                R.id.passbookFragment -> {
                    binding.myToolbar.apply {
                        setBackgroundColor(
                            ContextCompat.getColor(this@CoreActivity, R.color.red)
                        )
                        binding.tvDashboard.text = "Passbook"
                    }
                }
                R.id.reportFragment -> {
                    binding.myToolbar.apply {
                        setBackgroundColor(
                            ContextCompat.getColor(this@CoreActivity, R.color.red)
                        )
                        binding.tvDashboard.text = "Report"
                    }
                }

                R.id.aboutUsFragment-> {
                    binding.myToolbar.apply {
                        setBackgroundColor(
                            ContextCompat.getColor(this@CoreActivity, R.color.red)
                        )
                        binding.tvDashboard.text = "AboutUs"
                    }
                }

                R.id.settingsFragment -> {
                    binding.myToolbar.apply {
                        setBackgroundColor(
                            ContextCompat.getColor(this@CoreActivity, R.color.red)
                        )
                        binding.tvDashboard.text = "Settings"
                    }


                    binding.myToolbar.apply {
                        setBackgroundColor(
                            ContextCompat.getColor(this@CoreActivity, R.color.red)
                        )
                        binding.tvDashboard.text = "AboutUs"
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

    private fun showLogoutConfirmationDialog() {
        val reviewDialog = Dialog(this@CoreActivity)
        reviewDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        reviewDialog.setContentView(R.layout.dialog_verification)
        reviewDialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        reviewDialog.setCancelable(true)
        reviewDialog.setCanceledOnTouchOutside(true)
        reviewDialog.window!!.setGravity(Gravity.CENTER)
        reviewDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val dialogOk = reviewDialog.findViewById<TextView>(R.id.btnOkay)
        dialogOk.setOnClickListener {
            reviewDialog.dismiss()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        reviewDialog.show()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_logout -> {

                Log.e("TAG", "logout: ")
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}