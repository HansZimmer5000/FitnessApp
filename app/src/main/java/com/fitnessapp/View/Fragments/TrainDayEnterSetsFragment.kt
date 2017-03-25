package com.fitnessapp.View.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout


import ownuse.fitnessapp.R

class TrainDayEnterSetsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_newtraining_enter_sets, container, false)

        var rl: RelativeLayout = view.findViewById(R.id.rlEnterSets) as RelativeLayout
        var btn: Button = Button(context)
        btn.setText("text")
        btn.layoutParams = (ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ))

        rl.addView(btn)


        return view
    }

    //TODO: everything
}

