package com.fitnessapp.View

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.fitnessapp.View.Fragments.OverviewFragment
import com.fitnessapp.View.Fragments.ExerciseFragment
import com.fitnessapp.View.Fragments.TrainDayEnterSetsFragment
import com.fitnessapp.View.Fragments.TrainDaySelectExercisesFragment

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val overviewFragment = OverviewFragment()
    private val exerciseFragment = ExerciseFragment()
    private val trainDayEnterSetsFragment = TrainDayEnterSetsFragment()
    private val trainDaySelectExercisesFragment = TrainDaySelectExercisesFragment()

    val overviewPos = 0
    val newExercisePos = 1
    val trainDayEnterSetsPos = 3
    val trainDaySelectExercisesPos = 2
    private val fragmentCount = 4

    override fun getCount(): Int {
        return fragmentCount
    }

    override fun getItem(pos: Int): Fragment? {
        //TODO: Only show trainDayEnterSets if SelectExercises-Btn was pressed and Exercises have been selected!

        when (pos) {
            overviewPos -> return this.overviewFragment
            newExercisePos -> return this.exerciseFragment
            trainDayEnterSetsPos -> return this.trainDayEnterSetsFragment
            trainDaySelectExercisesPos -> return this. trainDaySelectExercisesFragment
        }

        return null
    }
}
