package com.fitnessapp.View.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.fitnessapp.Controll.MainController

import ownuse.fitnessapp.R

class ExerciseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_newexercise, container, false)


        return view
    }

    //TODO: everything
}

