package com.mollenwambui.workoutlog.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mollenwambui.workoutlog.models.Exercise
import com.mollenwambui.workoutlog.models.ExerciseCategory
@Dao
interface ExerciseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExercise(exercise: Exercise)

//    @Query(SELECT * FROM )
}