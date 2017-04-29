package com.fitnessapp.Controll.TrainDaySelect

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fitnessapp.Controll.ExercisesClickListener
import com.fitnessapp.Model.Exercise
import ownuse.fitnessapp.R
import java.util.*

class ExercisesAdapter : RecyclerView.Adapter<ExercisesViewHolder>() {

    private var dataset: List<Exercise> = ArrayList()
    private var clickListener: ExercisesClickListener? = null

    fun setClickListener(clickListener: ExercisesClickListener) {
        this.clickListener = clickListener
    }

    fun setNotes(notes: List<Exercise>) {
        this.dataset = notes
        notifyDataSetChanged()
    }

    fun getNote(position: Int): Exercise {
        return this.dataset[position]
    }

    override fun getItemCount(): Int {
        return this.dataset.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercisesViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_note, parent, false)
        return ExercisesViewHolder(view, clickListener, this)
    }

    override fun onBindViewHolder(holder: ExercisesViewHolder, position: Int) {
        val exe = dataset[position]

        /*TODO: replace
        holder.titleTV.text = exe
        holder.textTV.text = text
        holder.dateTV.text = date.toString()*/
    }
}