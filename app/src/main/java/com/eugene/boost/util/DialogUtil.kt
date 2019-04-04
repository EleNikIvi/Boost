package com.eugene.boost.util

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.eugene.boost.R
import com.google.android.material.snackbar.Snackbar

object DialogUtil {

    fun getProgressDialog(context: Context): Dialog {

        return Dialog(context).apply {
            setCancelable(false)
            setContentView(R.layout.dialog_progress)
        }
    }

    fun getOneButtonDialog(
        context: Context,
        dialogTitle: String,
        dialogMessage: String,
        buttonTitle: String,
        buttonOnClickListener: DialogInterface.OnClickListener? = null,
        view: View? = null,
        isCancelable: Boolean = true,
        dialogOnCancelListener: DialogInterface.OnCancelListener? = null
    ): Dialog {

        return setupDialog(
            context,
            dialogTitle,
            dialogMessage,
            view,
            isCancelable,
            dialogOnCancelListener
        ).apply {
            setNeutralButton(buttonTitle, buttonOnClickListener)
        }.create()
    }

    fun getTwoButtonsDialog(
        context: Context,
        dialogTitle: String,
        dialogMessage: String,
        positiveButtonTitle: String,
        negativeButtonTitle: String,
        positiveButtonOnClickListener: DialogInterface.OnClickListener? = null,
        negativeButtonOnClickListener: DialogInterface.OnClickListener? = null,
        view: View? = null,
        isCancelable: Boolean = true,
        dialogOnCancelListener: DialogInterface.OnCancelListener? = null
    ): Dialog {

        return setupDialog(
            context,
            dialogTitle,
            dialogMessage,
            view,
            isCancelable,
            dialogOnCancelListener
        ).apply {
            setPositiveButton(positiveButtonTitle, positiveButtonOnClickListener)
            setNegativeButton(negativeButtonTitle, negativeButtonOnClickListener)
        }.create()
    }

    fun getThreeButtonsDialog(
        context: Context,
        dialogTitle: String,
        dialogMessage: String,
        positiveButtonTitle: String,
        negativeButtonTitle: String,
        neutralButtonTitle: String,
        positiveButtonOnClickListener: DialogInterface.OnClickListener? = null,
        negativeButtonOnClickListener: DialogInterface.OnClickListener? = null,
        neutralButtonOnClickListener: DialogInterface.OnClickListener? = null,
        view: View? = null,
        isCancelable: Boolean = true,
        dialogOnCancelListener: DialogInterface.OnCancelListener? = null
    ): Dialog {

        return setupDialog(
            context,
            dialogTitle,
            dialogMessage,
            view,
            isCancelable,
            dialogOnCancelListener
        ).apply {
            setPositiveButton(positiveButtonTitle, positiveButtonOnClickListener)
            setNegativeButton(negativeButtonTitle, negativeButtonOnClickListener)
            setNeutralButton(neutralButtonTitle, neutralButtonOnClickListener)
        }.create()
    }

    fun getSnackbar(
        view: View,
        message: String,
        duration: Int = Snackbar.LENGTH_SHORT,
        actionTitle: String = "",
        actionOnClickListener: View.OnClickListener? = null
    ): Snackbar {

        val snb = Snackbar.make(view, message, duration)

        if (actionOnClickListener != null) {
            snb.setAction(actionTitle, actionOnClickListener)
        }

        return snb
    }


    private fun setupDialog(
        context: Context,
        dialogTitle: String,
        dialogMessage: String,
        view: View? = null,
        isCancelable: Boolean = true,
        dialogOnCancelListener: DialogInterface.OnCancelListener? = null
    ): AlertDialog.Builder {

        val builder = AlertDialog.Builder(context)
            .setTitle(dialogTitle)
            .setMessage(dialogMessage)

        if (view != null) {
            builder.setView(view)
        }

        builder.setCancelable(isCancelable)
        builder.setOnCancelListener(dialogOnCancelListener)

        return builder
    }
}
