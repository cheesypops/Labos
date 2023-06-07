package com.example.laboratorio11.network.dto.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("token") val token: String,
    @SerializedName("msg") val message: String
)