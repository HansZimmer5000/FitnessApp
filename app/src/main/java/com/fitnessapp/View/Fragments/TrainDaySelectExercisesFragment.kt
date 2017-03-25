package com.fitnessapp.View.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.fitnessapp.Controll.MainController
import com.fitnessapp.View.MainActivity

import ownuse.fitnessapp.R

class TrainDaySelectExercisesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_newtraining_select_exercises, container, false)

        //TODO: If pressed on a item of the recyclerView, show Exercise with Title and Description in a Dialog! (item_dialog)

        return view
    }

    //TODO: everything
}

