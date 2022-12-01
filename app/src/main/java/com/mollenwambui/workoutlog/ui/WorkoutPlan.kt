package com.mollenwambui.workoutlog.ui

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WorkoutPlan")
data class WorkoutPlan(
    @PrimaryKey var workoutPLanId:String,
    var userId:String
)
