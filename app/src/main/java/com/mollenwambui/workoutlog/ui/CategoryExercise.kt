package com.mollenwambui.workoutlog.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.mollenwambui.workoutlog.models.Exercise
import com.mollenwambui.workoutlog.models.ExerciseCategory

class CategoryExercise(context: Context, var exercises:List<Exercise>):
ArrayAdapter<Exercise>(context,0,exercises){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getDropDownView(position, convertView, parent)
    }
    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup){
        val view=LayoutInflater.from(context)
    }

}
