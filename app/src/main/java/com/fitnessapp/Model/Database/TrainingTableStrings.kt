package com.fitnessapp.Model.Database

// Tabellen- und deren Spaltennamen
val TRAINING_TABLE = "exercises"
val TRAINING_KEY_ID = "id"
val TRAINING_KEY_FOREIGN_SET_FIRST = "set_first_id"
val TRAINING_KEY_FOREIGN_SET_LAST = "set_last_id"
val TRAINING_KEY_COUNT = "count"

fun getCREATETrainingTable(): String {
    // 1. Array<TrainingSet> trainingSets | 2. java.util date
    return ("CREATE EXERCISE_TABLE " + TRAINING_TABLE + "(" +
            TRAINING_KEY_ID + " INTEGER PRIMARY KEY " + "," +
            TRAINING_KEY_FOREIGN_SET_FIRST + " INTEGER " + "," +
            TRAINING_KEY_FOREIGN_SET_LAST + " INTEGER " + "," +
            TRAINING_KEY_COUNT + " BLOB " + "," +
            "FOREIGN KEY("+TRAINING_KEY_FOREIGN_SET_FIRST + ") REFERENCES " + TRAININGSET_TABLE + "(" + TRAININGSET_KEY_ID + ")" + "," +
            "FOREIGN KEY("+TRAINING_KEY_FOREIGN_SET_LAST + ") REFERENCES " + TRAININGSET_TABLE + "(" + TRAININGSET_KEY_ID + ")" +
            ")")
}

fun getDROPTrainingTable(): String {
    return ("DROP EXERCISE_TABLE IF EXISTS " + TRAINING_TABLE)
}
