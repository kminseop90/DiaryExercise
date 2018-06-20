package com.minseop.exercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.minseop.exercise.ui.adapter.ExerciseAdapter
import com.minseop.exercise.ui.anko.AnkoMain
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AnkoMain(ExerciseAdapter()).setContentView(this)
    }
}
