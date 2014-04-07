package com.example.banknote.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * The listener interface for receiving customOnItemSelected events. The class
 * that is interested in processing a customOnItemSelected event implements this
 * interface, and the object created with that class is registered with a
 * component using the component's
 * addCustomOnItemSelectedListener method. When
 * the customOnItemSelected event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see CustomOnItemSelectedEvent
 */

public class CustomOnItemSelectedListener implements OnItemSelectedListener {

    /** The selected item. */
    private static String selectedItem;

    /* (non-Javadoc)
     * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(android.widget.AdapterView, android.view.View, int, long)
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos,
            long id) {
        // TODO Auto-generated method stub
        selectedItem = parent.getItemAtPosition(pos).toString();

        // Toast.makeText(parent.getContext(),
        // "On Item Select : \n" + parent.getItemAtPosition(pos).toString(),
        // Toast.LENGTH_LONG).show();

    }

    /* (non-Javadoc)
     * @see android.widget.AdapterView.OnItemSelectedListener#onNothingSelected(android.widget.AdapterView)
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

    }

    /**
     * Gets the selected.
     * 
     * @param returnString the return string
     */
    public static String getSelected(String returnString) {
        return returnString; //removed returnString = selectedItem; ???
    }

}
