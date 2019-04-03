package com.eugene.boost.util

import android.app.Activity
import android.content.Context
import android.os.IBinder
import android.view.inputmethod.InputMethodManager

object KeyboardUtil {

    fun showKeyboard(activity: Activity) {

        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    fun hideKeyboard(activity: Activity) {

        val view = activity.currentFocus

        if (view != null) {
            hideKeyboard(activity, view.windowToken)
        }
    }


    private fun hideKeyboard(activity: Activity, windowToken: IBinder) {

        val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        inputManager.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}
