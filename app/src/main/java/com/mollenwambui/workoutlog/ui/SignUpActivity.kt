package com.mollenwambui.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mollenwambui.workoutlog.ViewModel.UserViewModel
import com.mollenwambui.workoutlog.api.APIinterface
import com.mollenwambui.workoutlog.api.ApiClient
import com.mollenwambui.workoutlog.databinding.ActivitySignUpBinding
import com.mollenwambui.workoutlog.models.RegisterRequest
import com.mollenwambui.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
   lateinit var binding:ActivitySignUpBinding
    lateinit var sharedprefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewCast()
        sharedprefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
    }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer {
            registerResponcse ->
            Toast.makeText(baseContext,registerResponcse?.message,Toast.LENGTH_LONG)
            startActivity(Intent(baseContext, LoginActivity::class.java))
        })
        userViewModel.errorLiveDatas.observe(this, Observer {
            errorMessage->
            Toast.makeText(baseContext,errorMessage,Toast.LENGTH_LONG).show()
        })
    }



    fun viewCast() {

       binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)


        }
       binding.btnSignUp.setOnClickListener { validating()
           }
    }

    fun validating() {
        var error = false
      
        binding.tilFirstName.error = null
        binding.tilEmailSignup.error = null
        binding.tilPassword.error = null
        binding.tilConfirmpassword.error = null
        binding.tilLastName.error = null
        var firstname =binding.etName.text.toString()
        error=true
        if (firstname.isBlank()) {
            binding.tilFirstName.error = "Firstname  is required"

        }
        var lastname=binding.etLastName.text.toString()
        error=true
        if (lastname.isBlank()){
            binding.tilLastName.error="Lastname is required"

        }
        var email=binding.etEmail.text.toString()
        error=true
        if (email.isBlank()){
            binding.tilEmailSignup.error="Email is required"

        }
        if( !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilEmailSignup.error="Not a valid email address"
        }


        var password=binding.etPassword.text.toString()
        error=true
        if (password.isBlank()){
           binding.tilPassword.error="Password is required"
        }
        var phonenumber=binding.etPhoneNumber.text.toString()
        error=true
        if (password.isBlank()){
            binding.tilPhone.error="Password is required"
        }
        var confirmPassword=binding.etConfirmpassword.text.toString()
        error=true
        if (confirmPassword.isBlank()){
            binding.tilConfirmpassword.error="Confirm Password is required"
        }
        var equals=binding.etPassword==binding.etConfirmpassword

        if(password!=confirmPassword){
            binding.tilConfirmpassword.error="Wrong password"
        }
        if(!error){
            var registerRequest=RegisterRequest(firstname,lastname,phonenumber,email,password)
            userViewModel.registerUser(registerRequest)

        }

    }


    }

