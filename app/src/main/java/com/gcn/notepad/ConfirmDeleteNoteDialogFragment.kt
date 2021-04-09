package com.gcn.notepad

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ConfirmDeleteNoteDialogFragment(val noteTitle: String="") : DialogFragment() {

    interface ConfirmDeleteDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    var listener: ConfirmDeleteDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)

        builder.setMessage("Are you sure you want to delete this note \"$noteTitle\"?")
            .setPositiveButton("Delete", DialogInterface.OnClickListener { dialog, id -> listener?.onDialogPositiveClick()  })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id -> listener?.onDialogNegativeClick()  })

        return builder.create()
    }
}