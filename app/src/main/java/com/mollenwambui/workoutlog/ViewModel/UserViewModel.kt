package com.mollenwambui.workoutlog.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mollenwambui.workoutlog.Repository.UserRepository
import com.mollenwambui.workoutlog.models.LoginRequest
import com.mollenwambui.workoutlog.models.LoginResponse
import com.mollenwambui.workoutlog.models.RegisterRequest
import com.mollenwambui.workoutlog.models.RegisterResponse
import kotlinx.coroutines.launch

class UserViewModel :ViewModel(){
    val userRepository=UserRepository()
    val loginResponseLiveData=MutableLiveData<LoginResponse>()
    val errorLiveData=MutableLiveData<String>()
    val registerResponseLiveData=MutableLiveData<RegisterResponse>()
    val errorLiveDatas=MutableLiveData<String>()




    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponseLiveData.postValue(response.body())

            }
            else {
                errorLiveData.postValue(response.errorBody()?.string())

            }
        }
    }
    fun registerUser(registerRequest: RegisterRequest){
            viewModelScope.launch {
                val response = userRepository.registerUsers(registerRequest)
                if (response.isSuccessful){
                    registerResponseLiveData.postValue(response.body())
                }
                else{
                    errorLiveData.postValue(response.errorBody()?.string())
                }
            }

        }
    }




