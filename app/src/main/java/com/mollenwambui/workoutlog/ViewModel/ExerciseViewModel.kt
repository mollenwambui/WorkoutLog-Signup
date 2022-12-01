package com.mollenwambui.workoutlog.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mollenwambui.workoutlog.Repository.ExerciseRepository
import com.mollenwambui.workoutlog.models.Exercise
import com.mollenwambui.workoutlog.models.ExerciseCategory
import kotlinx.coroutines.launch

class ExerciseViewModel:ViewModel() {
    var exerciseRepository=ExerciseRepository()
    var  exerciseCategoryLiveData=MutableLiveData<List<ExerciseCategory>>()
    val errorLiveData=MutableLiveData<String>()
    var exerciseLiveData = MutableLiveData<List<Exercise>>()


    fun fetchExerciseCategories(accessToken:String){
        viewModelScope.launch {
            val response=exerciseRepository.fetchExerciseCategories(accessToken)
            if (response.isSuccessful){
                exerciseCategoryLiveData.postValue((response.body()))
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }

    }


    fun fetchExercise(accessToken: String){
        viewModelScope.launch {
            val response=exerciseRepository.fetchExercise(accessToken)
            if (response.isSuccessful){
                exerciseLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }    }

   fun fetchDbCategories(){
       exerciseCategoryLiveData
   }

}