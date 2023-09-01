package com.live.farmerapp.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.live.farmerapp.core.BaseFragment
import com.live.farmerapp.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(layoutInflater)
    }
}