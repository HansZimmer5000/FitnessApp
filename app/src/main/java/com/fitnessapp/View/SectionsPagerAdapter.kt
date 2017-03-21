package com.fitnessapp.View

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.fitnessapp.View.Fragments.OverviewFragment
import com.fitnessapp.View.Fragments.ExerciseFragment
import com.fitnessapp.View.Fragments.TrainDayFragment

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val overviewFragment = OverviewFragment()
    private val exerciseFragment = ExerciseFragment()
    private val trainDayFragment = TrainDayFragment()

    val overviewPos = 0
    val newExercisePos = 1
    val trainDayPos = 2
    private val fragmentCount = 3

    override fun getCount(): Int {
        return fragmentCount
    }

    override fun getItem(pos: Int): Fragment? {

        when (pos) {
            0 -> return this.overviewFragment
            1 -> return this.exerciseFragment
            2 -> return this.trainDayFragment
        }
        return null
    }
}
