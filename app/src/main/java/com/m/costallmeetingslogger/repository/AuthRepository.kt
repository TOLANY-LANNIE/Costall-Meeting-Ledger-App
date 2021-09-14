package com.m.costallmeetingslogger.repository

import com.m.costallmeetingslogger.retrofit.AuthApi

class AuthRepository(
    private val api:AuthApi
) : BaseRepository(){
    suspend fun login(
        username:String,
        password:String
    )= safeApiCall {
        api.login(username,password)
    }
}