package com.live.farmerapp.viewmodel

import androidx.lifecycle.ViewModel
import com.live.farmerapp.service.Repository


class MainViewModel(private val repository: Repository) : ViewModel() {
    /** request repository to fetch data from server */
    fun getAboutUs() = repository.getDataFromServer()
}