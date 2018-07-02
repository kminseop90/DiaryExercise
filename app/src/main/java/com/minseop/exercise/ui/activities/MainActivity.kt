package com.minseop.exercise.ui.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.minseop.exercise.R
import com.minseop.exercise.ui.adapter.ExercisePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, ViewPager.OnPageChangeListener {

    private lateinit var screenNavigator : BottomNavigationView
    private lateinit var pager : ViewPager
    private val containerResId = R.id.main_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
    }

    private fun initializeViews() {
        pager = findViewById(containerResId)
        screenNavigator = findViewById(R.id.main_navigator)

        toolbar.title = resources.getString(R.string.app_name)

        pager.adapter = ExercisePagerAdapter(supportFragmentManager)
        pager.addOnPageChangeListener(this)
        pager.currentItem = 0
        selectedNavigationItem = screenNavigator.menu.getItem(0)
        pager.offscreenPageLimit = 3

        screenNavigator.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_navigation_history -> pager.currentItem = 0
                R.id.action_navigation_record -> pager.currentItem = 1
                else -> pager.currentItem = 2
            }
            true
        }
        pager.adapter?.notifyDataSetChanged()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
        }
    }

    private var selectedNavigationItem: MenuItem? = null

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        Log.d("kms", "onPageSelected position = $position")
        selectedNavigationItem?.isChecked = false
        selectedNavigationItem = screenNavigator.menu.getItem(position)
        selectedNavigationItem?.isChecked = true
        pager.adapter?.notifyDataSetChanged()
    }

}
