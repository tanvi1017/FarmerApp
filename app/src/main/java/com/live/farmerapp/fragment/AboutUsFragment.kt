package com.live.farmerapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.live.countrysearch.util.mLog
import com.live.countrysearch.util.validator.NetworkResult
import com.live.farmerapp.core.BaseFragment
import com.live.farmerapp.databinding.FragmentAboutUsBinding
import com.live.farmerapp.model.Data
import com.live.farmerapp.others.PreferenceFile
import com.live.farmerapp.viewmodel.AboutUsViewModel


class AboutUsFragment : BaseFragment<FragmentAboutUsBinding>() {
    var data= mutableListOf<Data>()
    private lateinit var  viewModel: AboutUsViewModel
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentAboutUsBinding {
        return FragmentAboutUsBinding.inflate(layoutInflater)
}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[AboutUsViewModel::class.java]

        callApi()
        //initObserver()

    }

    private fun callApi(){
        val map = HashMap<String, String>()
        viewModel.callAboutUsApi(map)
    }
    private fun initObserver(){
        viewModel.fetchAboutUs.observe(requireActivity()){
            mLog(it.message?:"")
            when(it){
                is NetworkResult.Success -> {
//                   // val data = result.data // Assuming data is of type OtpResponse
//                    val aboutApplicationEn = data.Data.AboutApplicationEn?:""
//                    val aboutCompanyEn = data.Data.AboutCompanyEn
//                    val aboutUsText = data.Data.EmailAddress ?: "Default About Us Text"
//                    val aboutMobileNo = data.Data.Mobile?: "Default Company Text"
//                    val reachUsText = data.Data.Website ?: "Default Website Text"
//
//                    binding.tvAboutUs.text = aboutUsText
//                    binding.tvAboutCompany.text = aboutCompanyEn
//                    binding.tvTextPhone.text = aboutMobileNo
//                    binding.tvTextUrl.text = reachUsText
//                    binding.tvAboutUs.text =aboutApplicationEn
                }
                is NetworkResult.Error -> {
                    Toast.makeText(requireContext(), "error ", Toast.LENGTH_LONG).show()

                }
                is NetworkResult.Loading -> {}

            }
        }
    }
}