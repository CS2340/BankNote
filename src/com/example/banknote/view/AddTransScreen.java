package com.example.banknote.view;

import com.example.banknote.R;
import com.example.banknote.model.AddTransactionHandler;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioButton;

// TODO: Auto-generated Javadoc
/**
 * The Class AddTransScreen.
 */
public class AddTransScreen extends Activity {

    /** The selected type. */
    private String selectedType;
    
    /** The amount. */
    private String amount;
    
    /** The description. */
    private String description;

    /** The is income. */
    private boolean isIncome = false;

    /** The amount et. */
    private EditText amountET;
    
    /** The description et. */
    private EditText descriptionET;

    /** The spinner. */
    private Spinner spinner;
    
    /** The btn add trans. */
    private Button btnAddTrans;

    // this variable to check either income or outcome radio buttons is checked
    /** The is radio checked. */
    private boolean isRadioChecked = false;

    /** The adapter. */
    ArrayAdapter<CharSequence> adapter;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trans_screen);

        spinner = (Spinner) findViewById(R.id.types_spinner);
        amountET = (EditText) findViewById(R.id.amount_text_field);
        btnAddTrans = (Button) findViewById(R.id.add_transaction_button);
        descriptionET = (EditText) findViewById(R.id.description_editext);

        /*
         * selectedType Spinner
         */
        spinnerUpdate();

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

        /*
         * addButton click Listener
         */
        findViewById(R.id.add_transaction_button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addListenerOnSpinnerItemSelection();
                        if (attemptAddTrans(view)) {
                            goNextActivity(view);
                        }

                    }
                });
    }

    /*
     * Initialize the options in spinner with string array list of types
     * isIncome = true : transaction_incometype_array isIncome = false:
     * transaction_outcometype_array
     */
    /**
     * Spinner update.
     */
    private void spinnerUpdate() {
        // TODO Auto-generated method stub
        // ArrayAdapter<CharSequence> adapter;
        if (isIncome) {
            // Create an ArrayAdapter using the string array and a default
            // spinner layout
            adapter = ArrayAdapter.createFromResource(this,
                    R.array.transaction_incometype_array,
                    android.R.layout.simple_spinner_item);
        } else {
            // Create an ArrayAdapter using the string array and a default
            // spinner layout
            adapter = ArrayAdapter.createFromResource(this,
                    R.array.transaction_outcometype_array,
                    android.R.layout.simple_spinner_item);

        }

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    /**
     * Adds the listener on spinner item selection.
     */
    public void addListenerOnSpinnerItemSelection() {
        // TODO Auto-generated method stub
        CustomOnItemSelectedListener selectTypeListener = new CustomOnItemSelectedListener();
        spinner.setOnItemSelectedListener(selectTypeListener);

    }

    /**
     * On radio button clicked.
     * 
     * @param view
     *            the view
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        Context context = getApplicationContext();
        CharSequence text = "";
        int duration = Toast.LENGTH_SHORT;

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_income:
                if (checked) {
                    // income are the best
                    isIncome = true;
                    isRadioChecked = true;
                    text = "INCOME";
                    spinnerUpdate();
                }
                break;
            case R.id.radio_outcome:
                if (checked) {
                    // outcome rule
                    isIncome = false;
                    isRadioChecked = true;
                    text = "OUTCOME";
                    spinnerUpdate();
                }
                break;
        }
    }

    /**
     * Attempt add trans.
     * 
     * @param view
     *            the view
     * @return true, if successful
     */
    public boolean attemptAddTrans(View view) {
        // TODO Auto-generated method stub

        amount = amountET.getText().toString();
        description = descriptionET.getText().toString();

        // Save the string of selected type to the variable
        selectedType = (String) spinner.getSelectedItem();

        // Toast constructor
        Context context = getApplicationContext();
        CharSequence text = "";

        // checking if radio buttons is checked
        if (isRadioChecked) {

            // Checking if the amount has the valid input type
            if (AddTransactionHandler.isValidDescription(description)) {
                if (AddTransactionHandler.isValidAmount(amount)) {

                    AddTransactionHandler.addNewTrans(selectedType,
                            description, isIncome, amount);

                    // Transaction is added successfully
                    return true;

                } else {
                    text = "Please type the valid amount of transaction.";
                }

            } else {
                text = "A transaction's description is needed. ";
            }

        } else {
            text = "Please check either Income or Outcome!";
        }

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        return false;
    }

    /**
     * Go next activity.
     * 
     * @param view
     *            the view
     */
    public void goNextActivity(View view) {
        Intent intent = new Intent();
        intent.setClassName("com.example.banknote",
                "com.example.banknote.view.FinancialAccountMain");
        startActivity(intent);
        finish();
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_trans_screen, menu);
        return true;
    }

    /**
     * Setup action bar.
     */

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),
                FinancialAccountMain.class));
    }
}
