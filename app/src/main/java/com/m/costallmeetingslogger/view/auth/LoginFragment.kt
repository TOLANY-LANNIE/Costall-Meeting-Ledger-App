package com.m.costallmeetingslogger.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.m.costallmeetingslogger.databinding.FragmentLoginBinding
import com.m.costallmeetingslogger.repository.AuthRepository
import com.m.costallmeetingslogger.remoteDataSource.AuthApi
import com.m.costallmeetingslogger.remoteDataSource.Resource
import com.m.costallmeetingslogger.view.base.BaseFragment

class LoginFragment: BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success ->{
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                }
                is Resource.Failure ->{
                    Toast.makeText(requireContext(),it.toString(), Toast.LENGTH_LONG).show()
                }
            }
        })

        binding.buttonLogin.setOnClickListener {
            val username = binding.usernameTF.text.toString().trim()
            val password = binding.passwordTF.text.toString().trim()
            //@todo validations
            viewModel.login(username,password)

        }
    }
    override fun getViewModel() = AuthViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentLoginBinding.inflate(inflater,container, false)

    override fun getFragmentRepository()= AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))

}