package com.mollenwambui.workoutlog.Repository

import androidx.lifecycle.LiveData
import com.mollenwambui.workoutlog.WorkoutLog
import com.mollenwambui.workoutlog.api.APIinterface
import com.mollenwambui.workoutlog.api.ApiClient
import com.mollenwambui.workoutlog.database.WorkoutDb
import com.mollenwambui.workoutlog.models.Exercise
import com.mollenwambui.workoutlog.models.ExerciseCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ExerciseRepository {
    val apiClient=ApiClient.buildApiClient(APIinterface::class.java)
    val database=WorkoutDb.getDatabase(WorkoutLog.appContext)
    val exerciseCategoryDao=database.exerciseCategoryDao()
    val exerciseDao=database.excerciseDao()

    suspend fun fetchExerciseCategories(accessToken:String):Response<List<ExerciseCategory>>{

        return withContext(Dispatchers.IO){
             apiClient.fetchExerciseCategories(accessToken)
            val response=apiClient.fetchExerciseCategories(accessToken)
            if(response.isSuccessful){
                var categories=response.body()
                categories?.forEach{
                    category->
                    exerciseCategoryDao.insertExerciseCategory(category)
                }
            }
            response
        }
    }

    suspend fun  fetchExercise(accessToken: String):Response<List<Exercise>>{
        return  withContext(Dispatchers.IO){
            apiClient.fetchExercise(accessToken)
            val response=apiClient.fetchExercise(accessToken)
            if (response.isSuccessful){
                var exercises=response.body()
                exercises?.forEach{
                    exercise->
                    exerciseDao.insertExercise(exercise)
                }


            }
            response
        }
    }
    fun getDbCategory():LiveData<List<ExerciseCategory>>{
        return  exerciseCategoryDao.getExerciseCategories()
    }
//    fun getDbExercises():LiveData<List<Exercise>>{
//
//    }
 fun getExerciseCategory(categoryId:String){

 }
}


