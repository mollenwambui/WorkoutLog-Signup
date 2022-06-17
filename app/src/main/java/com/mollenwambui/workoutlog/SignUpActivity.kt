package com.mollenwambui.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mollenwambui.workoutlog.databinding.ActivitySignUpBinding
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
        if (firstname.isBlank()) {
            binding.tilFirstName.error = "Firstname  is required"

        }
        var lastname=binding.etLastName.text.toString()
        if (lastname.isBlank()){
            binding.tilLastName.error="Lastname is required"

        }
        var email=binding.etEmail.text.toString()
        if (email.isBlank()){
            binding.tilEmailSignup.error="Email is required"

        }
        if( !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilEmailSignup.error="Not a valid email address"
        }


        var password=binding.etpassword.text.toString()
        if (password.isBlank()){
           binding.tilPassword.error="Password is required"
        }
        var confirmPassword=binding.etConfirmPassword.text.toString()
        if (confirmPassword.isBlank()){
            binding.tilConfirmPassword.error="Confirm Password is required"
        }
        var equals=binding.etpassword==binding.etConfirmPassword

        if(password!=confirmPassword){
            binding.tilConfirmPassword.error="Wrong password"
        }

    }


    }
