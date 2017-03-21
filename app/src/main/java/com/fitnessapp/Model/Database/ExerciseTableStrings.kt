package com.fitnessapp.Model.Database

// Tabellen- und deren Spaltennamen
val EXERCISE_TABLE = "exercises"
val EXERCISE_KEY_ID = "id"
val EXERCISE_KEY_NAME = "name"
val EXERCISE_KEY_DESC = "desc"

fun getCREATEExerciseTableString(): String {
    // 1. Array<TrainingSet> trainingSets | 2. java.util date
    return ("CREATE EXERCISE_TABLE " + EXERCISE_TABLE + "(" +
            EXERCISE_KEY_ID + " INTEGER PRIMARY KEY, " +
            EXERCISE_KEY_NAME + " INTEGER, " +
            EXERCISE_KEY_DESC + " INTEGER " +
            ")")
}

fun getDROPExerciseTableString(): String {
    return ("DROP EXERCISE_TABLE IF EXISTS " + EXERCISE_TABLE)
}
