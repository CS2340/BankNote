package com.example.banknote.view;

import java.util.ArrayList;
import java.util.Date;

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
import com.example.banknote.model.DateSingle;
import com.example.banknote.model.ReportEntry;
import com.example.banknote.model.SpendingCategoryReport;

/**
 * The Class SelectDateActivity.
 */
public class SelectDateActivity extends FragmentActivity {
    
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
    TextView displayStart;
    
    /** The display end. */
    TextView displayEnd;

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

        displayStart = (TextView) findViewById(R.id.displayStart);
        displayEnd = (TextView) findViewById(R.id.displayEnd);

        reportButton = (Button) findViewById(R.id.get_report_button);
        reportButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                if (DateSingle.getInstance().getStartDate() == null
                        || DateSingle.getInstance().getEndDate() == null) {
                    String message = "Must select at least one date";
                    Toast toast = Toast.makeText(getApplicationContext(),
                            message, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else // (dates are set)
                {
                    Date start = DateSingle.getInstance().getStartDate();
                    Date end = DateSingle.getInstance().getEndDate();

                    SpendingCategoryReport sCReport = new SpendingCategoryReport(
                            start, end);
                    list = sCReport.getCatArray();
                    displayListVeiw();

                    displayStart.setText(DateSingle.getInstance()
                            .getStartDate().toString());
                    displayEnd.setText(DateSingle.getInstance().getEndDate()
                            .toString());

                }
            }
        });

        startButton = (Button) findViewById(R.id.button_startDate);
        startButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                DateSingle.getInstance().selectStartDate();
                showDatePickerDialog(v);
            }
        });

        endButton = (Button) findViewById(R.id.button_endDate);
        endButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                DateSingle.getInstance().selectEndDate();
                showDatePickerDialog(v);
            }
        });

    }

    /**
     * Display list veiw.
     */
    protected void displayListVeiw() {
        listView = (ListView) findViewById(R.id.listView1);

        listAdapter = new ArrayAdapter<ReportEntry>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(listAdapter);

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
}
