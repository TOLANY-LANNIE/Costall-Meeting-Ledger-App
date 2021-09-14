package com.m.costallmeetingslogger.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.m.costallmeetingslogger.databinding.FragmentLoginBinding
import com.m.costallmeetingslogger.repository.AuthRepository
import com.m.costallmeetingslogger.retrofit.AuthApi
import com.m.costallmeetingslogger.ui.base.BaseFragment

class LoginFragment: BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun getViewModel() = AuthViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentLoginBinding.inflate(inflater,container, false)

    override fun getFragmentRepository()= AuthRepository(remoteDataSource.builApi(AuthApi::class.java))

}