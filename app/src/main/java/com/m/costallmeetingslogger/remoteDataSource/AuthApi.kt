package com.m.costallmeetingslogger.remoteDataSource

import com.m.costallmeetingslogger.models.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @FormUrlEncoded
    @POST("v1/login")
    suspend fun login(
        @Field("username")email:String,
        @Field("password")password:String
    ):LoginResponse


    /*fun signup(
        @Field("name")name:String,
        @Field("surname")surname:String,
        @Field("dob")dob:String,
        @Field("email")email:String,
        @Field("profession")profession:String,
        @Field("hourlyrate")hourlyRate:String,
        @Field("cellnumber")cellNumber:String,
        @Field("organisation")organisation:String,
        @Field("username")username:String,
        @Field("password")password:String
    ):Any */
}