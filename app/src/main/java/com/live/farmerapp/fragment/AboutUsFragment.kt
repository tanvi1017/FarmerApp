package com.live.farmerapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.live.farmerapp.core.BaseFragment
import com.live.farmerapp.databinding.FragmentAboutUsBinding
import com.live.farmerapp.model.AboutUsResponse
import com.live.farmerapp.model.Data
import com.live.farmerapp.service.Repository
import com.live.farmerapp.service.RetrofitClient.api
import com.live.farmerapp.viewmodel.MainViewModel
import com.live.farmerapp.viewmodel.MainViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AboutUsFragment : BaseFragment<FragmentAboutUsBinding>() {
    private var modelList = emptyList<Data>()
    private lateinit var viewModel: MainViewModel

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentAboutUsBinding {
        return FragmentAboutUsBinding.inflate(layoutInflater)
}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = Repository(api) // Assuming 'api' is already initialized
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getAboutUs().enqueue(object : Callback<AboutUsResponse> {
            override fun onResponse(call: Call<AboutUsResponse>, response: Response<AboutUsResponse>) {
                if (response.isSuccessful) {
                    val aboutUsResponse = response.body()
                    if (aboutUsResponse != null) {
                      binding.tvAboutUs.text =aboutUsResponse.data.aboutApplicationEn
                        binding.tvAboutCompany.text =aboutUsResponse.data.aboutCompanyEn
                        binding.tvTextUrl.text = aboutUsResponse.data.website
                        binding.tvTextEmail.text = aboutUsResponse.data.email
                        binding.tvTextPhone.text =aboutUsResponse.data.mobile
                    }
                } else {

                }
            }

            override fun onFailure(call: Call<AboutUsResponse>, t: Throwable) {
          Toast.makeText(requireContext(),"smething went wrong",Toast.LENGTH_LONG).show()
            }
        })
    }


    }

