package com.minseop.exercise.contract

import com.minseop.exercise.base.BasePresenter
import com.minseop.exercise.base.BaseView

interface SampleContract {

    interface View : BaseView<Presenter> {
        fun showSamples()
    }

    interface  Presenter : BasePresenter {
        fun selectSample()
    }

}