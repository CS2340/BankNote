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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banknote.R;
import com.example.banknote.model.Account;
import com.example.banknote.model.ReportEntry;
import com.example.banknote.model.ReportSingle;
import com.example.banknote.model.Reports;
import com.example.banknote.model.UserSingle;

/**
 * The Class SelectDateActivity.
 */
public class ReportActivity extends FragmentActivity implements iReportView {
    
    ReportPresenter presenter;
    
    static boolean startDateSelected;
    static Date endDate;
    static Date startDate;
	
    
    /** The chart button. */
    Button chartButton;
    
    /** The statement button. */
    Button statementButton;
    
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
    ArrayList<ReportEntry> reportList;
    
    /** The spinner. */
    private Spinner spinner;
    
    /** The text. */
    private String text = "";

    // Spinner helper to retrieve the selected Account as String
    /** The selected account. */
    private Account selectedAccount = null;

    /** The list. */
    List<Account> list = new ArrayList<Account>();
    
    /** The adapter. */
    ArrayAdapter<Account> adapter;
    

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
        
        spinner = (Spinner) findViewById(R.id.account_spinner);

        /*
         * selectedType Spinner
         */
        spinnerUpdate();

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

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
        
        chartButton = (Button) findViewById(R.id.chart_button);
        chartButton.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) {

                presenter.reportChartsButtonClicked();
            }
        });
        
        statementButton = (Button) findViewById(R.id.statement_button);
        statementButton.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) {

                presenter.reportStatementButtonClicked();
            }
        });

    }


    /**
     * Adds the listener on spinner item selection.
     */
    public void addListenerOnSpinnerItemSelection() {
        
        CustomOnItemSelectedListener selectTypeListener = new CustomOnItemSelectedListener();
        spinner.setOnItemSelectedListener(selectTypeListener);

        // Update the selectedAccount with the string of DisplayName
        CustomOnItemSelectedListener.getSelected(selectedAccount);

    }


 // Initialize the options in spinner with Accounts List in User
    /**
     * Spinner update.
     */
    private void spinnerUpdate() {

        // Create an ArrayAdapter using the string array and a default spinner
        // layout
        adapter = new ArrayAdapter<Account>(this,
                android.R.layout.simple_spinner_item, list);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
    
    @Override
    public void setAccountList(List<Account> accounts) 
	{
		for ( Account a: accounts){
			list.add(a);
		}
		Account allLableAccount = new Account("All Accounts", "All Accounts", 0, 0);
		if (list.indexOf(allLableAccount) == -1){
			list.add(allLableAccount);
		}
		
	}
    
    @Override
	public Account getAccount() 
	{
		return (Account) spinner.getSelectedItem();
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
	public void displayMessage(String message) 
	{
        Toast toast = Toast.makeText(getApplicationContext(),
                message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
	}

	@Override
	public void gotoChartReport(List<ReportEntry> list) 
	{
		Reports report = new Reports(startDate, endDate, list);
		ReportSingle.setCurrentReport(report); 
		startActivity(new Intent(getApplicationContext(), ReportChartsActivity.class));
		finish();
	}
	
	@Override
	public void gotoStatementReport(List<ReportEntry> list) 
	{
		Reports report = new Reports(startDate, endDate, list);
		ReportSingle.setCurrentReport(report); 
		startActivity(new Intent(getApplicationContext(), ReportStatementActivity.class));
		finish();
	}
}
