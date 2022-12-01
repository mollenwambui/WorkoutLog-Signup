package com.mollenwambui.workoutlog.Repository

import com.mollenwambui.workoutlog.WorkoutLog
import com.mollenwambui.workoutlog.database.WorkoutDb
import com.mollenwambui.workoutlog.ui.WorkoutPlan
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkoutPlanRepository {
    val  database=WorkoutDb.getDatabase(WorkoutLog.appContext)
    val workoutPlanDao=database
    val workoutPlanItemDao=database


  suspend  fun saveWorkoutPlan(workoutPlan: WorkoutPlan){
        withContext(Dispatchers.IO){
            workoutPlanDao
        }

    }
    fun checkForExistingWorkoutPlan(){
        //take your users to login by view models this actually interesting
        //observe(workoutplan)
        ///workoutty.saveworkutplan
    }
}
