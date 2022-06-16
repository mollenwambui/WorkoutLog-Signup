package com.mollenwambui.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var btmHome:BottomNavigationView
    lateinit var fcvhome:FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        castViews()
        setupBottomnav()
    }
    fun castViews(){
        btmHome=findViewById(R.id.bottom_navigation)
        fcvhome=findViewById(R.id.fcvhome)
    }
    fun setupBottomnav(){
        btmHome.setOnItemSelectedListener { item->
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
