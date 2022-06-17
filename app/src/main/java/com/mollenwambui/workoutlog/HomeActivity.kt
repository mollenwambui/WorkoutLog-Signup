package com.mollenwambui.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mollenwambui.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        setupBottomnav()
    }
    fun castViews(){

    }
    fun setupBottomnav(){
       binding.btmHome.setOnItemSelectedListener { item->
          when(item.itemId) {
              R.id.plan ->{
                  var transaction=supportFragmentManager.beginTransaction()
                  transaction.replace(R.id.fcvhome,PlanFragment())
                  transaction.commit()
                  true
              }
              R.id.track ->{
                  supportFragmentManager.beginTransaction().replace(R.id.fcvhome,TrackFragment()).commit()
                  true
              }
              R.id.profile->{
                  supportFragmentManager.beginTransaction().replace(R.id.fcvhome,ProfileFragment()).commit()
                  true
              }
              else->false



          }
        }
    }
}
