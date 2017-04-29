package com.fitnessapp.Controll

import android.support.v4.app.FragmentManager
import com.fitnessapp.Model.Exercise
import com.fitnessapp.View.Fragments.ShowExerciseDialogFragment

class ExercisesClickListener(var mFragmentManager: FragmentManager) {
    fun onNoteClick(exercise: Exercise) {
        val listDialog: ShowExerciseDialogFragment = ShowExerciseDialogFragment()
        listDialog.setItem(exercise)
        listDialog.show(mFragmentManager, "")
    }
}
