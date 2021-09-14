package com.m.costallmeetingslogger.repository

import com.m.costallmeetingslogger.retrofit.Resource
import com.m.costallmeetingslogger.retrofit.Resource.Failure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend() -> T
    ): Resource<T>{
        return  withContext(Dispatchers.IO){
            try {
                Resource.Success(apiCall.invoke())
            }catch (throwable:Throwable){
                when(throwable){
                    is HttpException ->{
                        Failure(false,throwable.code(), throwable.response()?.errorBody())
                    }else ->{
                        Failure(true,null, null)
                    }
                }
            }
        }
    }
}