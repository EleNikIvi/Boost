package com.eugene.boost.util

import android.app.Dialog
import android.content.Context
import com.eugene.boost.R

object DialogUtil {

    fun getProgressDialog(context: Context): Dialog {

        return Dialog(context).apply {
            setCancelable(false)
            setContentView(R.layout.dialog_progress)
        }
    }
}
