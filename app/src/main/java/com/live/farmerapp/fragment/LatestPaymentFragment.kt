package com.live.farmerapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.farmerapp.R
import com.live.farmerapp.core.BaseFragment
import com.live.farmerapp.databinding.FragmentLatestPaymentBinding


class LatestPaymentFragment : BaseFragment<FragmentLatestPaymentBinding>() {

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        return inflater.inflate(R.layout.fragment_latest_payment, container, false)
//    }

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLatestPaymentBinding {
        return FragmentLatestPaymentBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}