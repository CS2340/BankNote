package com.example.banknote.view;

import com.example.banknote.R;
import com.example.banknote.model.AddAccountHandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * The Class AddFinAccount.
 */
public class AddFinAccount extends Activity {

    /** The display name. */
    private String displayName = "";
    
    /** The full name. */
    private String fullName = "";
    
    /** The balance. */
    private String balance = "";
    
    /** The interest rate. */
    private String interestRate = "";

    /** The display name et. */
    private EditText displayNameET;
    
    /** The full name et. */
    private EditText fullNameET;
    
    /** The balance et. */
    private EditText balanceET;
    
    /** The interest rate et. */
    private EditText interestRateET;
    
    /** The btn add account. */
    private Button btnAddAccount;

    /** The next activity. */
    private String nextActivity = "";

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fin_account);

        displayNameET = (EditText) findViewById(R.id.text_field_finacc_displayname);
        fullNameET = (EditText) findViewById(R.id.text_field_fullname);
        balanceET = (EditText) findViewById(R.id.text_field_finacc_balance);
        interestRateET = (EditText) findViewById(R.id.text_field_finacc_interest_rate);
        btnAddAccount = (Button) findViewById(R.id.button_finacc_add);

    }

    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_fin_account, menu);

        findViewById(R.id.button_finacc_add).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (makeNewFinAcc()) {
                            goNextActivity(view);
                        }

                    }
                });
        return true;
    }

    /**
     * Make new fin acc.
     * 
     * @return true, if successful
     */
    public boolean makeNewFinAcc() {

        displayName = displayNameET.getText().toString();
        fullName = fullNameET.getText().toString();
        balance = balanceET.getText().toString();
        interestRate = interestRateET.getText().toString();

        CharSequence text;

        if (!AddAccountHandler.isValidName(fullName)) {
            text = "Invalid Full Name";
        }

        else if (AddAccountHandler.nameAlreadyExists(fullName, displayName)) {
            text = "Account with that name already exists.";
        }

        else if (!AddAccountHandler.isValidInterestRate(interestRate)) {
            text = "Interest rate cannot be negative";
        } else if (!AddAccountHandler.isValidAmount(balance)) {
            text = "Please input the valid type of amount!";
        } else {
            Context c = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(c, "Hello", duration);
            toast.show();

            AddAccountHandler.addAccount(fullName, displayName, balance,
                    interestRate);

            // Next Activity
            nextActivity = "com.example.banknote.view.FinancialAccountMain";
            text = "New Account Created!";

            // Account is added successfully
            return true;
        }

        Context c = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(c, text, duration);
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
        intent.setClassName("com.example.banknote", nextActivity);
        startActivity(intent);
        finish();
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Dashboard.class));
    }

}
