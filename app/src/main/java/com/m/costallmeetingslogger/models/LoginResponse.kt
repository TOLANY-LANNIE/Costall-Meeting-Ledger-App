package com.m.costallmeetingslogger.models

data class LoginResponse(
    val Api_Key: String,
    val Email: String,
    val Name: String,
    val Registration_ID: String,
    val Surname: String,
    val UserID: String,
    val Username: String,
    val error: Boolean
)