package com.minseop.exercise.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minseop.exercise.R

class TempFragment : Fragment(){

    companion object {
        fun newInstance() : TempFragment{
            Log.d("kms","create TempFragment")
            var fragment:TempFragment = TempFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_temp, container, false)
        Log.d("kms","create TempFragment")
        return view
    }
}