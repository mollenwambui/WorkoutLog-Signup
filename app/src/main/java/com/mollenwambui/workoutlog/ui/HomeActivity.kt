package com.mollenwambui.workoutlog.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mollenwambui.workoutlog.R
import com.mollenwambui.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomnav()
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
}
