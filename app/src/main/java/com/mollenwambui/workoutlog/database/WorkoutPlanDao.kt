package com.mollenwambui.workoutlog.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mollenwambui.workoutlog.ui.WorkoutPlan

@Dao
interface WorkoutPlanDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWorkoutPLan(workoutPlan: WorkoutPlan)
}