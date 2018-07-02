package com.minseop.exercise.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minseop.exercise.R
import com.minseop.exercise.model.Exercise
import com.minseop.exercise.ui.adapter.ExerciseAdapter

class HistoryFragment : Fragment() {

    private lateinit var list: RecyclerView

    companion object {
        fun newInstance(): HistoryFragment {
            var fragment: HistoryFragment = HistoryFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_history, container, false)
        initializeViews(view)
        initializeDummy(100)
        return view
    }

    private fun initializeViews(view: View) {
        list = view.findViewById(R.id.history_list)
        list.adapter = ExerciseAdapter()
        list.layoutManager = LinearLayoutManager(context)
    }

    private fun initializeDummy(size: Int) {
        for (x in 0..size) {
            (list.adapter as ExerciseAdapter).add(Exercise(x.toString()))
        }
    }
}