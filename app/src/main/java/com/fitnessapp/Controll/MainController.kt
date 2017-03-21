package com.fitnessapp.Controll

import android.content.Context
import com.fitnessapp.Model.*
import com.fitnessapp.Model.Database.DatabaseHelper

class MainController(private val mContext: Context) {

    /*//////////////////
    VARIABLES
     *//////////////////
    private var databaseHelper: DatabaseHelper = DatabaseHelper(mContext)

    private var exercises = ArrayList<Exercise>()
    private var trainingSets = ArrayList<TrainingSet>()
    private var trainings = ArrayList<Training>()

    init{
        updateExercises()
        updateTrainingSets()
        updateTrainings()
    }

    /*//////////////////
    FUNCTIONS for database
     *//////////////////
    fun updateExercises() {
        exercises = databaseHelper.getAllExercises()
    }

    fun updateTrainingSets() {
        trainingSets = databaseHelper.getAllTrainingSets()
    }

    fun updateTrainings() {
        trainings = databaseHelper.getAllTrainings()
    }
}
