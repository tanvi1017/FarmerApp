package com.live.farmerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.live.farmerapp.databinding.NotificationItemRowBinding
import com.live.farmerapp.model.NotificationItem


class NotificationsAdapter(private val items:List<NotificationItem>):RecyclerView.Adapter<NotificationsAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NotificationItemRowBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
    override fun getItemCount(): Int {
        return items.size
    }
    inner class ItemViewHolder(private val binding: NotificationItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NotificationItem) {
            binding.tvNotifyName.text=item.title
            binding.tvDate.text=item.date
            binding.tvTiming.text =item.time

        }
    }
}

