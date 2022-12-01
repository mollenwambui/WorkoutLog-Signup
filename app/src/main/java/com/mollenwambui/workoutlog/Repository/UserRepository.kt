package com.mollenwambui.workoutlog.Repository

import androidx.lifecycle.ViewModel
import com.mollenwambui.workoutlog.api.APIinterface
import com.mollenwambui.workoutlog.api.ApiClient
import com.mollenwambui.workoutlog.models.LoginRequest
import com.mollenwambui.workoutlog.models.LoginResponse
import com.mollenwambui.workoutlog.models.RegisterRequest
import com.mollenwambui.workoutlog.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository :ViewModel(){

    var apiClient = ApiClient.buildApiClient(APIinterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> =
        withContext(Dispatchers.IO) {
            val response = apiClient.loginUser(loginRequest)
            return@withContext response
        }
    suspend fun registerUser(registerRequest: RegisterRequest)
    = withContext(Dispatchers.IO){
        val request=apiClient.registerUser(registerRequest)
        return@withContext request
    }
}
