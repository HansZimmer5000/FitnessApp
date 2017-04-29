package com.fitnessapp.View.Fragments

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fitnessapp.Model.Exercise

class ShowExerciseDialogFragment : DialogFragment() {

    private lateinit var myClickedItem: Exercise

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        /*val view = inflater!!.inflate(R.layout.dialog_fragment, container, false)
        dialog.setTitle(myClickedItem!!.getTitle())

        mainController = MainActivity.mainController

        dialogDelete = view.findViewById(R.id.deleteButton) as Button
        dialogActualize = view.findViewById(R.id.actualizeButton) as Button

        dialogDelete!!.setOnClickListener {
            Toast.makeText(context, myClickedItem!!.getTitle() + " is deleted", Toast.LENGTH_SHORT).show()
            mainController!!.deleteNote(myClickedItem!!.getId(), this@ShowExerciseDialogFragment)
        }

        dialogActualize!!.setOnClickListener { mainController!!.setToBeUpdatedNote(myClickedItem, this@ShowExerciseDialogFragment) }
        */
        return view
    }

    fun setItem(item: Exercise) {
        this.myClickedItem = item
    }
}
