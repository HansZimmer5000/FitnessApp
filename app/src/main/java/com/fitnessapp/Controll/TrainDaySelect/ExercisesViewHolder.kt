package com.fitnessapp.Controll.TrainDaySelect

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.fitnessapp.Controll.ExercisesClickListener
import ownuse.fitnessapp.R


class ExercisesViewHolder(itemView: View, clickListener: ExercisesClickListener?, mAdapter: ExercisesAdapter) : RecyclerView.ViewHolder(itemView) {

    var titleTV: TextView
    var textTV: TextView
    var dateTV: TextView

    init {
        /*TODO: replace
        titleTV = itemView.findViewById(R.id.TVNoteTitle) as TextView
        textTV = itemView.findViewById(R.id.TVNoteText) as TextView
        dateTV = itemView.findViewById(R.id.TVNoteDate) as TextView
        itemView.setOnClickListener {
            clickListener?.onNoteClick(mAdapter.getNote(adapterPosition))
        }
        */
    }
}
