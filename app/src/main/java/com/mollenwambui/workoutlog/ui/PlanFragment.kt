package com.mollenwambui.workoutlog.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.mollenwambui.workoutlog.R
import com.mollenwambui.workoutlog.databinding.FragmentPlanBinding


class PlanFragment : Fragment() {
     var  binding:FragmentPlanBinding?=null
     var bind get() = binding!!

//     var  bind get()=binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentPlanBinding.inflate(inflater,container,false)
        return  bind.root
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plan, container, false)
    }
    fun setUpSpinner(){
        setUpDaySpinner()
    }
    fun setUpDaySpinner(){
        val daysList= listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Sartuday","Sunday")
        val dayAdapter=ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,daysList)

        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.spDay.adapter=dayAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }


fun setUpExerciseSpinner(){

}


}
