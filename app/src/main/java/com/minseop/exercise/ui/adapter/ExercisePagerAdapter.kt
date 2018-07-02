package com.minseop.exercise.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.minseop.exercise.ui.fragments.HistoryFragment
import com.minseop.exercise.ui.fragments.RecordFragment
import com.minseop.exercise.ui.fragments.TempFragment

class ExercisePagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> HistoryFragment.newInstance()
                1 -> RecordFragment.newInstance()
                else -> TempFragment.newInstance()
            }

    override fun getCount(): Int = 3
}