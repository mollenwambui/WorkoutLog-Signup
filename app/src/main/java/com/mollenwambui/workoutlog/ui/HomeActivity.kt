package com.mollenwambui.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mollenwambui.workoutlog.R
import com.mollenwambui.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    lateinit var sharePrefs:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomnav()

        binding.tvLogout.setOnClickListener {
            val editor=sharePrefs.edit()
            editor.putString("ACCESS_TOKEN","")
            editor.putString("USER_ID","")
            editor.putString("PROFILE_ID","")
            editor.apply()
            startActivity(Intent(this,LoginActivity::class.java))
            logOutRequest()

        }
    }

    fun setupBottomnav(){
       binding.bnvHome.setOnItemSelectedListener { item->
          when(item.itemId) {
              R.id.plan ->{
                  var transaction=supportFragmentManager.beginTransaction()
                  transaction.replace(R.id.fcvhome, PlanFragment())
                  transaction.commit()
                  true
              }
              R.id.track ->{
                  supportFragmentManager.beginTransaction().replace(R.id.fcvhome, TrackFragment()).commit()
                  true
              }
              R.id.profile ->{
                  supportFragmentManager.beginTransaction().replace(R.id.fcvhome, ProfileFragment()).commit()
                  true
              }
              else->false



          }
        }

    }
    fun logOutRequest(){
        sharePrefs.edit().clear().commit()
    }
}
