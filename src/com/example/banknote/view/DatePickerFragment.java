package com.example.banknote.view;

import java.util.Calendar;
import java.util.Date;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import com.example.banknote.model.DateSingle;

/**
 * The Class DatePickerFragment.
 */
public class DatePickerFragment extends DialogFragment implements
        DatePickerDialog.OnDateSetListener {
    
    /** The year. */
    private int year;
    
    /** The month. */
    private int month;
    
    /** The day. */
    private int day;

    /* (non-Javadoc)
     * @see android.support.v4.app.DialogFragment#onCreateDialog(android.os.Bundle)
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    /* (non-Javadoc)
     * @see android.app.DatePickerDialog.OnDateSetListener#onDateSet(android.widget.DatePicker, int, int, int)
     */
    @Override
    public void onDateSet(DatePicker view, int aYear, int aMonth, int aDay) {
        this.year = aYear - 1900;
        this.month = aMonth;
        this.day = aDay;

        @SuppressWarnings("deprecation")
        Date d = new Date(this.year, this.month, this.day);
        DateSingle.getInstance().setSelectedtDate(d);

    }

}
