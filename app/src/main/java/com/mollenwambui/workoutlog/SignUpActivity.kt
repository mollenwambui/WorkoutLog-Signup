package com.mollenwambui.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var tvLogin: TextView
    lateinit var tilFirstName: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var tilLastName: TextInputLayout
    lateinit var etLastName: TextInputEditText
    lateinit var etEmail: TextInputEditText
    lateinit var tilEmailSignup: TextInputLayout
    lateinit var etpassword: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etConfirmPassword: TextInputEditText
    lateinit var tilConfirmPassword: TextInputLayout
    lateinit var btnSignUp:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        viewCast()
    }

    fun viewCast() {
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword)
        tilPassword = findViewById(R.id.tilPassword)
        tilFirstName = findViewById(R.id.tilFirstName)
        etFirstName = findViewById(R.id.etFirstName)
        tilLastName = findViewById(R.id.tilLastName)
        etpassword = findViewById(R.id.etpassword)
        etEmail = findViewById(R.id.etEmail)
        tilEmailSignup = findViewById(R.id.tilEmailSignup)
        etEmail = findViewById(R.id.etEmail)
        tvLogin = findViewById(R.id.tvLogin)
        etLastName = findViewById(R.id.etLastName)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        tilEmailSignup = findViewById(R.id.tilEmailSignup)
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword)
       btnSignUp=findViewById(R.id.btnSignUp)
        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)


        }
        btnSignUp.setOnClickListener { validating() }
    }

    fun validating() {
        var error = false
        tilFirstName.error = null
        tilEmailSignup.error = null
        tilPassword.error = null
        tilConfirmPassword.error = null
        tilLastName.error = null
        var firstname = etFirstName.text.toString()
        if (firstname.isBlank()) {
            tilFirstName.error = "Firstname  is required"

        }
        var lastname=etLastName.text.toString()
        if (lastname.isBlank()){
            tilLastName.error="Lastname is required"

        }
        var email=etEmail.text.toString()
        if (email.isBlank()){
            tilEmailSignup.error="Email is required"

        }
        var password=etpassword.text.toString()
        if (password.isBlank()){
            tilPassword.error="Password is required"
        }
        var confirmPassword=etConfirmPassword.text.toString()
        if (confirmPassword.isBlank()){
            tilConfirmPassword.error="Confirm Password is required"
        }
        var equals=etpassword==etConfirmPassword
         if (etpassword !=etConfirmPassword){
             tilConfirmPassword.error="Wrong password"
         }

    }
}