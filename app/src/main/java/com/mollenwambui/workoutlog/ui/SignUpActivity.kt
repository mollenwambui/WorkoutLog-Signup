package com.mollenwambui.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.mollenwambui.workoutlog.api.APIClient
import com.mollenwambui.workoutlog.api.APIinterface
import com.mollenwambui.workoutlog.databinding.ActivitySignUpBinding
import com.mollenwambui.workoutlog.models.RegisterRequest
import com.mollenwambui.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
   lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewCast()
    }

    fun viewCast() {

       binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)


        }
       binding.btnSignUp.setOnClickListener { validating() }
    }

    fun validating() {
        var error = false
      
        binding.tilFirstName.error = null
        binding.tilEmailSignup.error = null
        binding.tilPassword.error = null
        binding.tilConfirmPassword.error = null
        binding.tilLastName.error = null
        var firstname =binding.etFirstName.text.toString()
        error=true
        if (firstname.isBlank()) {
            binding.tilFirstName.error = "Firstname  is required"

        }
        var lastname=binding.etLastName.text.toString()
        error=true
        if (lastname.isBlank()){
            binding.tilLastName.error="Lastname is required"

        }
        var email=binding.etEmail2.text.toString()
        error=true
        if (email.isBlank()){
            binding.tilEmailSignup.error="Email is required"

        }
        if( !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilEmailSignup.error="Not a valid email address"
        }


        var password=binding.etpassword.text.toString()
        error=true
        if (password.isBlank()){
           binding.tilPassword.error="Password is required"
        }
        var phonenumber=binding.etpassword.text.toString()
        error=true
        if (password.isBlank()){
            binding.tilPassword.error="Password is required"
        }
        var confirmPassword=binding.etConfirmPassword.text.toString()
        error=true
        if (confirmPassword.isBlank()){
            binding.tilConfirmPassword.error="Confirm Password is required"
        }
        var equals=binding.etpassword==binding.etConfirmPassword

        if(password!=confirmPassword){
            binding.tilConfirmPassword.error="Wrong password"
        }
        if(!error){
            var registerRequest=RegisterRequest(firstname,lastname,phonenumber,email,password)
            makeRegisterRequest(registerRequest)

        }

    }

    fun makeRegisterRequest(registerRequest: RegisterRequest){
        val apiClient=APIClient.ApiClient.buildApiClient(APIinterface::class.java)
        val request=apiClient.registerUser(registerRequest)

        request.enqueue(object :Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG)
                    //navigate to login



                }
                else{
                    var error=response.errorBody()?.string()
                    Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
              Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }
    }
