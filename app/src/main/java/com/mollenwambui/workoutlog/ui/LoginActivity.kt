package com.mollenwambui.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mollenwambui.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
    }
  fun castView()  {
   binding.btnLogin.setOnClickListener { validateLogin()
       startActivity(Intent(this, HomeActivity::class.java)) }
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
  }


}