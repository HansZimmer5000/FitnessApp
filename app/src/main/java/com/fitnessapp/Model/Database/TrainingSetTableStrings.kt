package com.fitnessapp.Model.Database

// Tabellen- und deren Spaltennamen
val TRAININGSET_TABLE = "exercises"
val TRAININGSET_KEY_ID = "id"
val TRAININGSET_KEY_FOREIGN_EXERCISE = "exercise_id"
val TRAININGSET_KEY_COUNT = "count"

fun getCREATETrainingSetTable(): String {
    // 1. Array<TrainingSet> trainingSets | 2. java.util date
    return ("CREATE EXERCISE_TABLE " + TRAININGSET_TABLE + "(" +
            TRAININGSET_KEY_ID + " INTEGER PRIMARY KEY, " +
            TRAININGSET_KEY_FOREIGN_EXERCISE + " INTEGER, " +
            TRAININGSET_KEY_COUNT + " INTEGER " +
            "FOREIGN KEY("+TRAININGSET_KEY_FOREIGN_EXERCISE + ") REFERENCES " + EXERCISE_TABLE + "(" + EXERCISE_KEY_ID + ")" +
            ")")
}

fun getDROPTrainingSetTable(): String {
    return ("DROP EXERCISE_TABLE IF EXISTS " + TRAININGSET_TABLE)
}
