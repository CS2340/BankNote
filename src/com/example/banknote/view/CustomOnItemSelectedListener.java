package com.example.banknote.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.banknote.model.Account;

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
    private static Object selectedItem;

    /* (non-Javadoc)
     * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(android.widget.AdapterView, android.view.View, int, long)
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos,
            long id) {
        // TODO Auto-generated method stub
        selectedItem =    parent.getItemAtPosition(pos);
    }

    /* (non-Javadoc)
     * @see android.widget.AdapterView.OnItemSelectedListener#onNothingSelected(android.widget.AdapterView)
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) 
    {
        // TODO Auto-generated method stub
    }

    /**
     * Gets the selected.
     * 
     * @param selectedAccount the return string
     */
    public static Object getSelected(Object selectedAccount) {
        return selectedAccount; //removed returnString = selectedItem; ???
    }

}
