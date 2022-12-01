package com.mollenwambui.workoutlog.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mollenwambui.workoutlog.ui.WorkoutPlatItem

@Dao
interface WorkoutPlanItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWorkoutPlanItem(workoutPlatItem: WorkoutPlatItem)
}
