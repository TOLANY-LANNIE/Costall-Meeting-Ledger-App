package com.m.costallmeetingslogger.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m.costallmeetingslogger.repository.AuthRepository
import com.m.costallmeetingslogger.models.LoginResponse
import com.m.costallmeetingslogger.network.Resource
import kotlinx.coroutines.launch


class AuthViewModel(
    private val repository: AuthRepository
):ViewModel() {
    private val _loginResponse:MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse:LiveData<Resource<LoginResponse >>
        get() = _loginResponse

    fun login(
        userName:String,
        passWord:String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(userName,passWord)
    }
}