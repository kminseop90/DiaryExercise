package com.minseop.exercise.presenter

import com.minseop.exercise.contract.SampleContract

class SamplePresenter(var view: SampleContract.View): SampleContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun start() {

    }

    override fun selectSample() {
        view.showSamples()
    }
}