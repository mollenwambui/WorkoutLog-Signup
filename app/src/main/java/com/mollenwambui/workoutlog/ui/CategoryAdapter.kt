package com.mollenwambui.workoutlog.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.mollenwambui.workoutlog.R
import com.mollenwambui.workoutlog.models.ExerciseCategory
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

class CategoryAdapter(context: Context,var categories:List<ExerciseCategory>):
 ArrayAdapter<ExerciseCategory>(context,0,categories){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getDropDownView(position, convertView, parent)
    }
    fun getCustomView(position: Int,convertView: View?,parent: ViewGroup):View{
        val view=LayoutInflater.from(context).inflate(R.layout.categoryspinnertext,parent,false)
        val tvSpinnerText=view.findViewById<TextView>(R.tvSpinnerText)
        tvSpinnerText.text=categories.get(position).categoryName
    }

}
