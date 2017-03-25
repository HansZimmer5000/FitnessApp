package com.fitnessapp.Model.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.fitnessapp.Model.*
import java.util.*
import kotlin.collections.ArrayList

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, this.DATABASE_NAME, null, this.DATABASE_VERSION) {

    /*//////////////////////////////////////////////////////////
                Variables and methods mainly used by "super" class or the system.
    */////////////////////////////////////////////////////////
    companion object {

        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "TrainingDatabase"

        private fun createAllTables(db: SQLiteDatabase) {
            db.execSQL(getCREATEExerciseTableString())
            db.execSQL(getCREATETrainingSetTableString())
            db.execSQL(getCREATETrainingTableString())
        }

        private fun dropAllTables(db: SQLiteDatabase) {
            db.execSQL(getDROPExerciseTableString())
            db.execSQL(getDROPTrainingSetTableString())
            db.execSQL(getDROPTrainingTableString())
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        createAllTables(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        dropAllTables(db)
        onCreate(db)
    }

    /*//////////////////////////////////////////////////////////
                    GENERAL CRUD
    */////////////////////////////////////////////////////////
    fun insert(table: String, values: ContentValues): Long {
        val db = writableDatabase
        val res = db.insertOrThrow(table, null, values)
        db.close()

        Log.println(Log.ASSERT, "insert", "Table: " + table + " new id: " + res)

        return res
    }

    fun get(table: String, key_id: String, id: Int): Cursor? {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + table + " WHERE " + key_id + " = " + id.toString(), null)
        db.close()

        Log.println(Log.ASSERT, "get", "Table: " + table + " cursor.count: " + cursor.count)

        return cursor
    }

    fun getAll(table: String, first_id: Int?, last_id: Int?, key_id: String?): Cursor? {
        val db = readableDatabase
        val cursor: Cursor
        if (first_id == null || last_id == null || key_id == null) {
            cursor = db.rawQuery("SELECT * FROM " + table, null)
            Log.println(Log.ASSERT, "getAll", "Table: " + table + " cursor.count: " + cursor.count + " cursor.columnCount " + cursor.columnCount)
        } else {
            cursor = db.rawQuery("SELECT * FROM " + table + " WHERE " + key_id + " >= " + first_id + " AND " + key_id + " <= " + last_id, null)
            Log.println(Log.ASSERT, "getAll With Range", "Table: " + table + "first/last id: " + first_id + "/" + last_id + " cursor.count: " + cursor.count + " cursor.columnCount " + cursor.columnCount)
        }

        db.close()

        return cursor
    }

    fun update(table: String, values: ContentValues, id: Int): Boolean {
        val db = writableDatabase
        val res = db.update(EXERCISE_TABLE, values, EXERCISE_KEY_ID + "= ?", arrayOf(id.toString()))
        db.close()

        Log.println(Log.ASSERT, "update", "Table: " + table + " affected Rows: " + res)

        return (res == 1)
    }

    fun delete(table: String, key_id: String, id: Int): Boolean {
        val oldCount = getEntryCount(table)

        val db = writableDatabase
        db.delete(table, key_id + " = ?", arrayOf(id.toString()))
        db.close()

        val newCount = getEntryCount(table)

        Log.println(Log.ASSERT, "delete", "Table: " + table + " entry differenc (before-after): " + (oldCount - newCount))

        return newCount + 1 == oldCount
    }

    /*//////////////////////////////////////////////////////////
                    EXERCISE CRUD
    */////////////////////////////////////////////////////////
    fun insertExercise(exe: Exercise): Long? {
        val values = ContentValues()

        values.put(EXERCISE_KEY_NAME, exe.name)
        values.put(EXERCISE_KEY_DESC, exe.desc)

        val id = insert(EXERCISE_TABLE, values)

        exe.id = id.toInt()

        return id
    }

    fun getExercise(id: Int): Exercise? {
        val cursor = get(EXERCISE_TABLE, EXERCISE_KEY_ID, id)
        var res: Exercise? = null

        if (cursor != null && cursor.moveToFirst()) {
            val id = cursor.getInt(0)
            val name = cursor.getString(1)
            val desc = cursor.getString(2)

            res = Exercise(id, name, desc)

            cursor.close()
        }

        return res
    }

    fun deleteExercise(id: Int): Boolean {
        return delete(EXERCISE_TABLE, EXERCISE_KEY_ID, id)
    }

    fun updateExercise(exe: Exercise): Boolean {
        val values = ContentValues()

        values.put(EXERCISE_KEY_NAME, exe.name)
        values.put(EXERCISE_KEY_DESC, exe.desc)

        return update(EXERCISE_TABLE, values, exe.id)
    }

    fun getAllExercises(): ArrayList<Exercise> {
        var cursor = getAll(EXERCISE_TABLE, null, null, null)
        var res = ArrayList<Exercise>()

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val desc = cursor.getString(2)

                res.add(Exercise(id, name, desc))

            } while (cursor.moveToNext())
            cursor.close()
        }
        return res
    }

    /*//////////////////////////////////////////////////////////
                    TRAININGSET CRUD
    */////////////////////////////////////////////////////////
    fun insertTrainingSet(set: TrainingSet): Long? {
        val values = ContentValues()

        values.put(TRAININGSET_KEY_FOREIGN_EXERCISE, set.exercise.id)
        values.put(TRAININGSET_KEY_COUNT, set.reps)

        val id = insert(TRAININGSET_TABLE, values)

        set.id = id.toInt()

        return id
    }

    fun getTrainingSet(id: Int): TrainingSet? {
        val cursor = get(TRAININGSET_TABLE, TRAININGSET_KEY_ID, id)
        var res: TrainingSet? = null

        if (cursor != null && cursor.moveToFirst()) {
            val id = cursor.getInt(0)
            val exercise_id = cursor.getInt(1)
            val reps = cursor.getInt(2)

            val exercise = getExercise(exercise_id)

            if (exercise != null) {
                res = TrainingSet(id, exercise, reps)
            }

            cursor.close()
        }

        return res
    }

    fun deleteTrainingSet(id: Int): Boolean {
        return delete(TRAININGSET_TABLE, TRAININGSET_KEY_ID, id)
    }

    fun updateTrainingSet(set: TrainingSet): Boolean {
        val values = ContentValues()

        values.put(TRAININGSET_KEY_FOREIGN_EXERCISE, set.exercise.id)
        values.put(TRAININGSET_KEY_COUNT, set.reps)

        return update(TRAININGSET_TABLE, values, set.id)
    }

    fun getAllTrainingSets(): ArrayList<TrainingSet> {
        var cursor = getAll(TRAININGSET_TABLE, null, null, null)
        var res = ArrayList<TrainingSet>()

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val exercise_id = cursor.getInt(1)
                val reps = cursor.getInt(2)

                val exercise = getExercise(exercise_id)

                if (exercise != null) {
                    res.add(TrainingSet(id, exercise, reps))
                }

            } while (cursor.moveToNext())
            cursor.close()
        }
        return res
    }

    fun getAllTrainingSets(first_id: Int, last_id: Int): ArrayList<TrainingSet> {
        var cursor = getAll(TRAININGSET_TABLE, first_id, last_id, TRAININGSET_KEY_ID)
        var res = ArrayList<TrainingSet>()

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val exercise_id = cursor.getInt(1)
                val reps = cursor.getInt(2)

                val exercise = getExercise(exercise_id)

                if (exercise != null) {
                    res.add(TrainingSet(id, exercise, reps))
                }

            } while (cursor.moveToNext())
            cursor.close()
        }
        return res
    }

    /*//////////////////////////////////////////////////////////
                    TRAINING CRUD
    */////////////////////////////////////////////////////////
    fun insertTraining(training: Training): Long? {
        val values = ContentValues()

        values.put(TRAINING_KEY_FOREIGN_SET_FIRST, training.trainingSets.get(0).id)
        values.put(TRAINING_KEY_FOREIGN_SET_LAST, training.trainingSets.get(training.trainingSets.lastIndex).id)
        values.put(TRAINING_KEY_DATE, training.date.toString())

        val id = insert(TRAININGSET_TABLE, values)

        training.id = id.toInt()

        return id
    }

    fun getTraining(id: Int): Training? {
        val cursor = get(TRAINING_TABLE, TRAINING_KEY_ID, id)
        var res: Training? = null

        if (cursor != null && cursor.moveToFirst()) {
            val id = cursor.getInt(0)
            val first_set_id = cursor.getInt(1)
            val last_set_id = cursor.getInt(2)
            val date = Date(java.lang.Long.valueOf(cursor.getString(3))!!)

            var trainingSets = getAllTrainingSets(first_set_id, last_set_id)

            if (!trainingSets.isEmpty()) {
                res = Training(id, trainingSets, date)
            }

            cursor.close()
        }

        return res
    }

    fun deleteTraining(id: Int): Boolean {
        return delete(TRAINING_TABLE, TRAINING_KEY_ID, id)
    }

    fun updateTraining(training: Training): Boolean {
        val values = ContentValues()

        values.put(TRAINING_KEY_FOREIGN_SET_FIRST, training.trainingSets.get(0).id)
        values.put(TRAINING_KEY_FOREIGN_SET_LAST, training.trainingSets.get(training.trainingSets.lastIndex).id)
        values.put(TRAINING_KEY_DATE, training.date.toString())

        return update(TRAININGSET_TABLE, values, training.id)
    }

    fun getAllTrainings(): ArrayList<Training> {
        var cursor = getAll(TRAINING_TABLE, null, null, null)
        var res = ArrayList<Training>()

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val first_set_id = cursor.getInt(1)
                val last_set_id = cursor.getInt(2)
                val date = Date(java.lang.Long.valueOf(cursor.getString(3))!!)

                var trainingSets = getAllTrainingSets(first_set_id, last_set_id)

                if (!trainingSets.isEmpty()) {
                    res.add(Training(id, trainingSets, date))
                }

            } while (cursor.moveToNext())
            cursor.close()
        }
        return res
    }

    /*//////////////////////////////////////////////////////////
                    NOT CRUD METHODS
    */////////////////////////////////////////////////////////
    private fun getEntryCount(table: String): Int {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + table, null)
        val count = cursor.count

        db.close()
        cursor.close()

        return count
    }

}