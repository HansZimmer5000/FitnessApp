package com.fitnessapp.Model.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.fitnessapp.Model.*
import java.util.*

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, this.DATABASE_NAME, null, this.DATABASE_VERSION) {

    companion object {

        // Allgemein gueltige private Konstanten
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "MyNoteDb"

        private fun createAllTables(db: SQLiteDatabase) {
            db.execSQL(getCREATEExerciseTable())
            db.execSQL(getCREATETrainingSetTable())
            db.execSQL(getCREATETrainingTable())
        }

        private fun dropAllTables(db: SQLiteDatabase) {
            db.execSQL(getDROPExerciseTable())
            db.execSQL(getDROPTrainingSetTable())
            db.execSQL(getDROPTrainingTable())
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        createAllTables(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        dropAllTables(db)
        onCreate(db)
    }

    /*/////////////////
    CRUD Methods = Create, Read, Update, Delete
    Schreiben, Lesen, Updaten und Loeschen von Eintraegen
    *//////////////////

    fun insertExercise(exe: Exercise): Long? {}
    fun getExercise(id: Int): Exercise {}
    fun deleteExercise(id: Int): Boolean {}
    fun updateExercise(id: Int): Boolean {}
    fun getAllExercises(): ArrayList<Exercise> {}

    fun insertSet(set: TrainingSet): Long? {}
    fun getSet(id: Int): TrainingSet {}
    fun deleteSet(id: Int): Boolean {}
    fun updateSet(id: Int): Boolean {}
    fun getAllSets(): ArrayList<TrainingSet> {}

    fun insertTraining(train: Training): Long? {}
    fun getTraining(id: Int): Training {}
    fun deleteTraining(id: Int): Boolean {}
    fun updateTraining(id: Int): Boolean {}
    fun getAllTrainings(): ArrayList<Training> {}





    /*fun insertNote(trainDay: TrainDay): Long? {
        val db = writableDatabase
        val values = ContentValues()

        val dateStr = trainDay.date.time.toString()
        values.put(KEY_ARR, trainDay.trainingSets)
        values.put(KEY_DESC, dateStr)

        val id = db.insertOrThrow(EXERCISE_TABLE, null, values)

        Log.println(Log.ASSERT, "insertNote", "new  Id = " + id)

        trainDay.id = id.toInt()

        db.close()
        return id
    }

    fun deleteNote(idStr: String): Boolean {
        val oldNoteCount = this.noteCount

        val db = writableDatabase
        db.delete(EXERCISE_TABLE, KEY_ID + " = ?", arrayOf(idStr))
        db.close()

        val newNoteCount = this.noteCount

        return newNoteCount + 1 == oldNoteCount
    }

    fun updateNote(trainDay: TrainDay): Long? {
        val db = writableDatabase
        val values = ContentValues()

        val dateStr = trainDay.date.time.toString()
        values.put(KEY_ARR, trainDay.trainingSets)
        values.put(KEY_DESC, dateStr)

        val idStr = trainDay.id.toString()
        val res = db.update(EXERCISE_TABLE, values, KEY_ID + "= ?", arrayOf(idStr))

        Log.println(Log.ASSERT, "setUpdatingId", "setUpdatingId affected Rows: " + res)

        db.close()

        return res.toLong()
    }

    val allNotes: ArrayList<TrainDay>
        get() {
            val db = readableDatabase
            val cursor = db.rawQuery("SELECT * FROM " + EXERCISE_TABLE, null)

            val res = ArrayList<TrainDay>()

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    val id = cursor.getInt(0)
                    val arrStr = cursor.getString(1)
                    val noteDate = Date(java.lang.Long.valueOf(cursor.getString(2))!!)

                    res.add(TrainDay(id, arr, noteDate))

                } while (cursor.moveToNext())
                cursor.close()
            }
            db.close()

            return res
        }

    private
    val noteCount: Int
        get() {
            val db = readableDatabase
            val cursor = db.rawQuery("SELECT * FROM " + EXERCISE_TABLE, null)

            val count = cursor.count
            db.close()
            cursor.close()

            return count
        }
        */
}