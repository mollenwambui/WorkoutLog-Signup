package com.mollenwambui.workoutlog.ui

import androidx.room.Entity


@Entity(tableName = "WorkoutPlanItems")
data class WorkoutPlatItem(
    var workoutPlanItemId:String,
    var workoutPlanId:String,
    var day:Int,
    var exerciseIds:List<String>,

)
