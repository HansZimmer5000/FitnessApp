package com.fitnessapp.View.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.fitnessapp.Controll.MainController
import com.fitnessapp.Controll.TrainDayController

import ownuse.fitnessapp.R

class TrainDaySelectExercisesFragment : Fragment() {

    private lateinit var mRVAllExes: RecyclerView
    private lateinit var mBtnStartTrain: Button
    private lateinit var mController: TrainDayController

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_newtraining_select_exercises, container, false)

        mRVAllExes = view.findViewById(R.id.rvNewTrainAllExes) as RecyclerView
        //TODO: If pressed on a item of the recyclerView, show Exercise with Title and Description in a Dialog! (item_dialog)
        //TODO: Set Adapter

        mBtnStartTrain = view.findViewById(R.id.btnNewTrainStart) as Button
        mBtnStartTrain.setOnClickListener(mController.provideOnBtnClickListener())

        mController = TrainDayController()

        return view
    }

    //TODO: everything
}

