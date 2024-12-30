package com.example.anuncioslaborales.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anuncioslaborales.model.repository.LoginRepository

class LoginViewModel: ViewModel() {
    private val loginRepository = LoginRepository()

    private val _showBottomNav = MutableLiveData<Boolean>()
    val showBottomNav: LiveData<Boolean> get() = _showBottomNav

    fun hideBottomNav(){
        _showBottomNav.value = false
    }
}