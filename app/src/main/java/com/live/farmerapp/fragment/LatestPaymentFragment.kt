package com.live.farmerapp.fragment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.live.farmerapp.R
import com.live.farmerapp.activity.drawerItem.DetailedPaymentActivity
import com.live.farmerapp.core.BaseFragment
import com.live.farmerapp.databinding.FragmentLatestPaymentBinding


class LatestPaymentFragment : BaseFragment<FragmentLatestPaymentBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLatestPaymentBinding {
        return FragmentLatestPaymentBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSpinner()
        onClicks()
    }

    private fun onClicks() {
        binding.ivNextOne.setOnClickListener {
            val intent = Intent(requireContext(), DetailedPaymentActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setSpinner() {
        val menuList = mutableListOf("2022-23", "2021-22", "2020-21", "2019-20", "2018-19", "2017-18")
        val arrayAdapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            menuList
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerType.adapter = arrayAdapter

        binding.spinnerType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                view?.let {
                    (it as TextView).setTextColor(Color.BLACK) // Change selected text color
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}
