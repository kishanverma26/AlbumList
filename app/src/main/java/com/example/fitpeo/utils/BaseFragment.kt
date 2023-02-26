package com.example.fitpeo.utils

import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment(layout:Int):Fragment(layout) {

    // Extension Functions
    fun View.show() {
        this.visibility = View.VISIBLE
    }

    fun View.hide() {
        this.visibility = View.GONE
    }
}