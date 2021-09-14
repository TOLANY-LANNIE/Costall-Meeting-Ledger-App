package com.m.costallmeetingslogger.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    companion object{
        private const val BASE_URL ="http://localhost/Costall-Meeting-Ledger-REST-API/costall_backend/public"
    }
    fun <Api>builApi(
        api:Class<Api>
    ):Api{
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}