package com.live.farmerapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.farmerapp.R
import com.live.farmerapp.core.BaseFragment
import com.live.farmerapp.databinding.FragmentNewsBinding


class NewsFragment : BaseFragment<FragmentNewsBinding>() {


    override fun inflateBinding(inflater: LayoutInflater,container: ViewGroup?): FragmentNewsBinding {
        return FragmentNewsBinding.inflate(layoutInflater)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}