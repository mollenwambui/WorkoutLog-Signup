package com.mollenwambui.workoutlog.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Exercise")
data class Exercise(
    @PrimaryKey @SerializedName("description")var description :String,
    @SerializedName("exercise_Id") var exerciseId:String,
    @SerializedName("category_id") var categoryId:String,
    @SerializedName("exercise_name") var  exerciseName: String
)


