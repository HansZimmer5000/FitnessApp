package com.fitnessapp.Model.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.*

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, this.DATABASE_NAME, null, this.DATABASE_VERSION) {

    companion object {

        // Allgemein gueltige public Konstanten
        private val ARR_CC = 30
        private val DATE_CC = 20

        // Allgemein gueltige private Konstanten
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "MyNoteDb"

        // Anzahl der Chars, muss-Angabe fuer VarChar2, zu String konvertiert
        private val ARR_CCSTR = ARR_CC.toString()
        private val DATE_CCSTR = DATE_CC.toString()

        // Tabellen- und deren Spaltennamen
        private val TABLE = "note"
        private val KEY_ID = "id"
        private val KEY_ARR = "arr"
        private val KEY_DATE = "date"

        private fun createTableNOTE(db: SQLiteDatabase) {
            // 1. Array<Set> sets | 2. java.util date
            db.execSQL("CREATE TABLE " + TABLE + "(" +
                    KEY_ID + " INTEGER PRIMARY KEY, " +
                    KEY_ARR + " VARCHAR(" + ARR_CCSTR + "), " +
                    KEY_DATE + " VARCHAR(" + DATE_CCSTR + ")" +
                    ")")
        }

        private fun dropTableNOTE(db: SQLiteDatabase) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE)
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        createTableNOTE(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        dropTableNOTE(db)
        onCreate(db)
    }

    /*/////////////////
    CRUD Methods = Create, Read, Update, Delete
    Schreiben, Lesen, Updaten und Loeschen von Eintraegen
    *//////////////////











    /*fun insertNote(trainDay: TrainDay): Long? {
        val db = writableDatabase
        val values = ContentValues()

        val dateStr = trainDay.date.time.toString()
        values.put(KEY_ARR, trainDay.sets)
        values.put(KEY_DATE, dateStr)

        val id = db.insertOrThrow(TABLE, null, values)

        Log.println(Log.ASSERT, "insertNote", "new  Id = " + id)

        trainDay.id = id.toInt()

        db.close()
        return id
    }

    fun deleteNote(idStr: String): Boolean {
        val oldNoteCount = this.noteCount

        val db = writableDatabase
        db.delete(TABLE, KEY_ID + " = ?", arrayOf(idStr))
        db.close()

        val newNoteCount = this.noteCount

        return newNoteCount + 1 == oldNoteCount
    }

    fun updateNote(trainDay: TrainDay): Long? {
        val db = writableDatabase
        val values = ContentValues()

        val dateStr = trainDay.date.time.toString()
        values.put(KEY_ARR, trainDay.sets)
        values.put(KEY_DATE, dateStr)

        val idStr = trainDay.id.toString()
        val res = db.update(TABLE, values, KEY_ID + "= ?", arrayOf(idStr))

        Log.println(Log.ASSERT, "setUpdatingId", "setUpdatingId affected Rows: " + res)

        db.close()

        return res.toLong()
    }

    val allNotes: ArrayList<TrainDay>
        get() {
            val db = readableDatabase
            val cursor = db.rawQuery("SELECT * FROM " + TABLE, null)

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
            val cursor = db.rawQuery("SELECT * FROM " + TABLE, null)

            val count = cursor.count
            db.close()
            cursor.close()

            return count
        }
        */
}