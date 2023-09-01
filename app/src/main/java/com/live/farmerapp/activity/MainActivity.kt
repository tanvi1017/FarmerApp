package com.live.farmerapp.activity

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
import android.text.style.StyleSpan
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.live.farmerapp.R
import com.live.farmerapp.activity.drawerItem.NotificationActivity
import com.live.farmerapp.activity.drawerItem.PassbookActivity
import com.live.farmerapp.activity.drawerItem.PaymentActivity
import com.live.farmerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
    }
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.myToolbar)
        drawerLayout = binding.myDrawerLayout
        navView = binding.navView

        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.myToolbar, R.string.nav_open, R.string.nav_close
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()


    }

    private fun setLogOutDialog() {
        var reviewDialog = Dialog(this@MainActivity)
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
//            R.id.nav_notification -> {
//                NotificationActivity.launch(this@MainActivity)
//            }
//            R.id.nav_payment -> {
//                PaymentActivity.launch(this@MainActivity)
//            }
//
//            R.id.nav_passbook -> {
//                PassbookActivity.launch(this@MainActivity)
//
//            }
//            R.id.nav_logout -> {
//                setLogOutDialog()
//
//            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}

// override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//    val logoutMenuItem = menu?.findItem(R.id.nav_logout)
//    val redTextMenuStyle = R.style.RedTextMenu
//    if (logoutMenuItem != null) {
//        logoutMenuItem.title = SpannableString(logoutMenuItem.title).apply {
//            setSpan(StyleSpan(redTextMenuStyle), 0, length, 0)
//        }
//    }
//    return super.onPrepareOptionsMenu(menu)
//}










