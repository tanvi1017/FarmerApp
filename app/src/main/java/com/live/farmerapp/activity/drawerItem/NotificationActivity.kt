package com.live.farmerapp.activity.drawerItem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.live.farmerapp.activity.MainActivity
import com.live.farmerapp.activity.util.show
import com.live.farmerapp.adapter.NotificationsAdapter
import com.live.farmerapp.databinding.ActivityNotificationBinding
import com.live.farmerapp.model.NotificationItem

class NotificationActivity : AppCompatActivity() {
    companion object{
        fun launch(activity: Activity){
            val intent = Intent(activity,NotificationActivity::class.java)
            activity.startActivity(intent)
        }
    }
    private lateinit var binding:ActivityNotificationBinding
    var items = emptyList<NotificationItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateRecyclerView()
    }

    private fun updateRecyclerView(){
        items = mutableListOf<NotificationItem>(
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08"),
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08"),
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08"),
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08"),
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08"),
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08"),
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08"),
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08"),
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08"),
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08"),
            NotificationItem("Hellow this is notification from Company","15-08-2023","13:08")

        )
        val notificationAdapter = NotificationsAdapter(items)
        binding.rvNotification.apply {
            adapter = notificationAdapter
        }
    }
}