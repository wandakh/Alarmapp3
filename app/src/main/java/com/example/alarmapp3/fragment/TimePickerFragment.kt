package com.example.alarmapp3.fragment


import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import java.util.*


class TimePickerFragment {
    fun show(supportFragmentManager: FragmentManager, timePickerOnceTag: String) {
    }

    class TimePickerFrgament : DialogFragment(), DatePickerDialog.OnDateSetListener{
        private var mListener : DialogDateListener? = null
        override fun onAttach(context: Context){
            super.onAttach(context)
            mListener = context as DialogDateListener?
        }

        override fun onDetach() {
            super.onDetach()
            if (mListener!= null){
                mListener = null
            }
        }

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val date = calendar.get(Calendar.DATE)
            return DatePickerDialog(activity as Context, this, year, month, date)
        }

        override fun onDateSet(p0: DatePicker?, year : Int, month: Int, dayOfMonth: Int) {
            mListener?.onDialogDateSet(tag, year, month, dayOfMonth)
        }
        interface DialogDateListener{
            fun onDialogDateSet(tag : String?, year: Int, month: Int, dayOfMonth: Int)
        }

    }

    interface DialogTimeListener {

        fun onDialogTimeSet(tag: String?, hourOfDay: Int, minute: Int)
    }

}
