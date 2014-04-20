package com.example.banknote.view;

import iView.iReportView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import presenter.ReportPresenter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banknote.R;
import com.example.banknote.model.ReportEntry;

/**
 * The Class SelectDateActivity.
 */
public class ReportActivity extends FragmentActivity implements iReportView {
    
    ReportPresenter presenter;
    
    static boolean startDateSelected;
    static Date endDate;
    static Date startDate;
	
	/** The report button. */
    Button reportButton;
    
    /** The start button. */
    Button startButton;
    
    /** The end button. */
    Button endButton;
    
    /** The start id. */
    int startId = 0;
    
    /** The end id. */
    int endId = 1;
    
    /** The display start. */
    static TextView displayStart;
    
    /** The display end. */
    static TextView displayEnd;

    /** The start set. */
    boolean startSet = false;
    
    /** The end set. */
    boolean endSet = false;
    // For next step
    /** The list view. */
    ListView listView;
    
    /** The list adapter. */
    ListAdapter listAdapter;
    
    /** The list. */
    ArrayList<ReportEntry> list;

    /**
     * Method to be executed upon creation of this screen.
     * 
     * @param savedInstanceState auto-created from android
     * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
     */
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_screen);
        
        startDate = null;
        endDate = null;

        displayStart = (TextView) findViewById(R.id.displayStart);
        displayEnd = (TextView) findViewById(R.id.displayEnd);
        
        presenter = new ReportPresenter(this);

        reportButton = (Button) findViewById(R.id.get_report_button);
        reportButton.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) {

                presenter.reportButtonClicked();
            }
        });

        startButton = (Button) findViewById(R.id.button_startDate);
        startButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                
            	startDateSelected = true;
            	showDatePickerDialog(v);
            }
        });

        endButton = (Button) findViewById(R.id.button_endDate);
        endButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startDateSelected = false;
        	  	showDatePickerDialog(v);

            }
        });

    }


    /**
     * Show date picker dialog.
     * 
     * @param v the v
     */
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    /* (non-Javadoc)
     * @see android.support.v4.app.FragmentActivity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Dashboard.class));
    }
    

	@Override
	public Date getStartDate() 
	{
		return startDate;
	}

	@Override
	public Date getEndDate() 
	{
		return endDate;
	}

	@Override
	public void displyMessage(String message) 
	{
        Toast toast = Toast.makeText(getApplicationContext(),
                message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
	}

	@Override
	public void displayListVeiw(List<ReportEntry> l) 
	{
		list = (ArrayList<ReportEntry>) l;
        listView = (ListView) findViewById(R.id.listView1);

        listAdapter = new ArrayAdapter<ReportEntry>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(listAdapter);
    	displayEnd.setText(endDate.toString());
    	displayStart.setText(startDate.toString());
        
	}
}
