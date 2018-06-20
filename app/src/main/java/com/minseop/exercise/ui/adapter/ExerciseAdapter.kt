package com.minseop.exercise.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.minseop.exercise.model.Exercise
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.verticalPadding
import org.jetbrains.anko.wrapContent


class ExerciseAdapter : RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    private var items = ArrayList<Exercise>()


    fun add(item: Exercise) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder(TextView(parent.context).apply {
            textSize = 20f
            verticalPadding = context.dip(8)
            layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
        })
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val item = items.get(position)

        holder.textView.text = item.day
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ExerciseViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}