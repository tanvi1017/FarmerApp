package com.live.farmerapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.farmerapp.R
import com.live.farmerapp.adapter.NotificationsAdapter
import com.live.farmerapp.core.BaseFragment
import com.live.farmerapp.databinding.FragmentNotificationBinding
import com.live.farmerapp.model.NotificationItem

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    var items = emptyList<NotificationItem>()

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        return inflater.inflate(R.layout.fragment_notification, container, false)
//    }

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentNotificationBinding {
       return FragmentNotificationBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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