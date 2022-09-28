package com.mollenwambui.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mollenwambui.workoutlog.ViewModel.UserViewModel

import com.mollenwambui.workoutlog.api.APIinterface
import com.mollenwambui.workoutlog.databinding.ActivityLoginBinding
import com.mollenwambui.workoutlog.models.LoginRequest
import com.mollenwambui.workoutlog.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var sharedprefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
        sharedprefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer {
            loginResponse->
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG)
            saveLoginDetails(loginResponse!!)
            startActivity(Intent(baseContext,HomeActivity::class.java))
        })
        userViewModel.errorLiveData.observe(this, Observer { errorMessage->
            Toast.makeText(baseContext,errorMessage,Toast.LENGTH_LONG).show()

        })

    }
  fun castView()  {
   binding.btnLogin.setOnClickListener { validateLogin()

   }
      binding.tvSignUp.setOnClickListener { startActivity(Intent(this, SignUpActivity::class.java)) }
  }
  fun validateLogin(){
      var error=false
     binding.tilEmail.error=null
     binding.tilpassword.error=null
      var email=binding.etEmail.text.toString()
      if (email.isBlank()){
         binding.tilEmail.error="Email  is required"
          error=true
      }
      var password= binding.etpassword.text.toString()

      if (password.isBlank()){
          binding.tilpassword.error="Password is required"
          return
      }
      if (!error){
          val loginRequest=LoginRequest(email,password,)
          binding.pbLogin.visibility=View.VISIBLE
          userViewModel.loginUser(loginRequest)
      }

  }

    fun saveLoginDetails(LoginResponse:LoginResponse){
        val editor=sharedprefs.edit()
        editor.putString("ACCESS_TOKEN",LoginResponse.accessToken)
        editor.putString("USER_ID",LoginResponse.userId)
        editor.putString("PROFILE_ID",LoginResponse.profileId)
        editor.apply()

    }



}