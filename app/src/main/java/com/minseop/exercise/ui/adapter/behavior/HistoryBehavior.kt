package com.minseop.exercise.ui.adapter.behavior

import android.animation.ValueAnimator
import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.view.View
import android.view.animation.Interpolator
import com.minseop.exercise.R

class HistoryBehavior(context: Context?, attrs: AttributeSet?) : CoordinatorLayout.Behavior<View>(context, attrs) {

    companion object {
        private val INTERPOLATOR: Interpolator = FastOutSlowInInterpolator()
    }

    private var mDySinceDirectionChange: Int = 0
    private var isShowing: Boolean = false
    private var isHiding: Boolean = false


    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, axes: Int, type: Int): Boolean = axes == ViewCompat.SCROLL_AXIS_VERTICAL

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        isShowing = dy < 0
        var bottomTy: Float = child.translationY
        var bottomHeight: Int = child.height

        if (bottomTy == bottomHeight.toFloat() && dy > 0 || bottomTy == 0f && dy < 0) {
        } else if (bottomTy + dy < 0) {
            child.translationY = 0f
        } else if (bottomTy + dy > bottomHeight) {
            child.translationY = bottomHeight.toFloat()
        } else {
            child.translationY = bottomTy + dy
        }
    }


    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, type: Int) {
        super.onStopNestedScroll(coordinatorLayout, child, target, type)

        val appBarLayout = coordinatorLayout.findViewById<View>(R.id.appbar) as AppBarLayout
        if (isShowing) {
            appBarLayout.setExpanded(true, true)
            val animator = ValueAnimator.ofFloat(child.translationY, 0f)
            animator.addUpdateListener { valueAnimator ->
                val f = valueAnimator.animatedValue as Float
                child.translationY = f
            }
            animator.start()
        } else {
            appBarLayout.setExpanded(false, true)
            val animator = ValueAnimator.ofFloat(child.translationY, child.height.toFloat())
            animator.addUpdateListener { valueAnimator ->
                val f = valueAnimator.animatedValue as Float
                child.translationY = f
            }
            animator.start()
        }
    }

}