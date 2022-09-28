package com.mollenwambui.workoutlog.Repository

import com.mollenwambui.workoutlog.api.APIinterface
import com.mollenwambui.workoutlog.api.ApiClient
import com.mollenwambui.workoutlog.models.LoginRequest
import com.mollenwambui.workoutlog.models.LoginResponse
import com.mollenwambui.workoutlog.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {

    var apiClient =ApiClient.buildApiClient(APIinterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>
    = withContext(Dispatchers.IO){
        val response=apiClient.loginUser(loginRequest)
        return@withContext response
    }
    suspend fun registerUser(registerRequest:RegisterRequest)=
        withContext(Dispatchers.IO) {
            return@withContext apiClient.registerUser(registerRequest)
        }
}