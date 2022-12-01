package com.mollenwambui.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mollenwambui.workoutlog.R
import com.mollenwambui.workoutlog.ViewModel.ExerciseViewModel
import com.mollenwambui.workoutlog.databinding.ActivityHomeBinding
import com.mollenwambui.workoutlog.models.ExerciseCategory
import com.mollenwambui.workoutlog.utils.Constants

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    lateinit var sharePrefs:SharedPreferences
    val exerciseViewModel:ExerciseViewModel by viewModels()
    val token=sharePrefs.getString(Constants.ACCESS_TOKEN,"")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupBottomnav()

        exerciseViewModel.fetchExerciseCategories(token!!)
        exerciseViewModel.exerciseCategoryLiveData.observe(this, Observer { categories->
            Toast.makeText(this,"fetched ${categories.size}categories",Toast.LENGTH_LONG)
         })
        exerciseViewModel.errorLiveData.observe(this, Observer { error->
            Toast.makeText(this,error,Toast.LENGTH_LONG).show()
        })


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

