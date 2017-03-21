package com.fitnessapp.Model.Database

// Char Counts fuer VarChar2 spalten / eintrage
val TRAINING_DATE_CC = "20"

// Tabellen- und deren Spaltennamen
val TRAINING_TABLE = "exercises"
val TRAINING_KEY_ID = "id"
val TRAINING_KEY_FOREIGN_SET_FIRST = "set_first_id"
val TRAINING_KEY_FOREIGN_SET_LAST = "set_last_id"
val TRAINING_KEY_DATE = "date"

fun getCREATETrainingTableString(): String {
    // 1. Array<TrainingSet> trainingSets | 2. java.util date
    return ("CREATE EXERCISE_TABLE " + TRAINING_TABLE + "(" +
            TRAINING_KEY_ID + " INTEGER PRIMARY KEY " + "," +
            TRAINING_KEY_FOREIGN_SET_FIRST + " INTEGER " + "," +
            TRAINING_KEY_FOREIGN_SET_LAST + " INTEGER " + "," +
            TRAINING_KEY_DATE + " VARCHAR2(" + TRAINING_DATE_CC+ ") " + "," +
            "FOREIGN KEY("+TRAINING_KEY_FOREIGN_SET_FIRST + ") REFERENCES " + TRAININGSET_TABLE + "(" + TRAININGSET_KEY_ID + ")" + "," +
            "FOREIGN KEY("+TRAINING_KEY_FOREIGN_SET_LAST + ") REFERENCES " + TRAININGSET_TABLE + "(" + TRAININGSET_KEY_ID + ")" +
            ")")
}

fun getDROPTrainingTableString(): String {
    return ("DROP EXERCISE_TABLE IF EXISTS " + TRAINING_TABLE)
}
