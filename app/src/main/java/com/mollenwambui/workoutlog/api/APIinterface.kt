package com.mollenwambui.workoutlog.api

import com.mollenwambui.workoutlog.models.LoginRequest
import com.mollenwambui.workoutlog.models.LoginResponse
import com.mollenwambui.workoutlog.models.RegisterRequest
import com.mollenwambui.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface APIinterface {
    @POST("/register")
   suspend fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>

    @POST("/login")
   suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>



}
