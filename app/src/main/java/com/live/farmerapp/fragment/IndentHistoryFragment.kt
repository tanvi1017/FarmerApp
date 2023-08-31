package com.live.farmerapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.farmerapp.R
import com.live.farmerapp.core.BaseFragment
import com.live.farmerapp.databinding.FragmentIndentHistoryBinding


class IndentHistoryFragment : BaseFragment<FragmentIndentHistoryBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentIndentHistoryBinding {
        return FragmentIndentHistoryBinding.inflate(layoutInflater)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}