package com.minseop.exercise.ui.anko

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.minseop.exercise.MainActivity
import com.minseop.exercise.model.Exercise
import com.minseop.exercise.ui.adapter.ExerciseAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick


class AnkoMain(var exerciseAdapter: ExerciseAdapter) : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {

            var title = textView {
                text = "title"
                textSize = 15f
            }

            recyclerView {
                adapter = exerciseAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
            }.lparams(width = matchParent, height = matchParent)

            floatingActionButton().lparams {
                alignParentBottom()
                alignParentRight()
                bottomMargin = dip(20)
                rightMargin = dip(20)
            }.onClick {
                exerciseAdapter.add(Exercise("20180620"))
                Log.d("kms", "floatingActionButton")
            }
        }
    }
}