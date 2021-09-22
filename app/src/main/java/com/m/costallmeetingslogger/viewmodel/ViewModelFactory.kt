package com.m.costallmeetingslogger.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.m.costallmeetingslogger.repository.AuthRepository
import com.m.costallmeetingslogger.repository.BaseRepository
import com.m.costallmeetingslogger.ui.auth.AuthViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository:BaseRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java)->AuthViewModel(repository as AuthRepository) as T
            else-> throw IllegalArgumentException("ViewModelClass not found")
        }
    }
}