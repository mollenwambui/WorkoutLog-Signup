package com.mollenwambui.workoutlog.api

import com.mollenwambui.workoutlog.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface APIinterface {
    @POST("/register")
   suspend fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>

    @POST("/login")
   suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>

   @GET("/exercise-categories")
   suspend fun fetchExerciseCategories(@Header("Authorization")accessToken:String):Response<List<ExerciseCategory>>


   @GET("/exercise")
   suspend fun  fetchExercise(@Header("Authorization")accessToken: String):Response<List<Exercise>>

}
