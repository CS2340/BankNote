package com.example.banknote.view;

import iView.iAddFinAccountScreen;
import presenter.AddAccountPresenter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.banknote.R;

/**
 * The Class AddFinAccount.
 */
public class AddFinAccount extends Activity implements iAddFinAccountScreen {

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
    
    AddAccountPresenter presenter;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fin_account);
        presenter = new AddAccountPresenter(this);
        
        displayNameET = (EditText) findViewById(R.id.text_field_finacc_displayname);
        fullNameET = (EditText) findViewById(R.id.text_field_fullname);
        balanceET = (EditText) findViewById(R.id.text_field_finacc_balance);
        interestRateET = (EditText) findViewById(R.id.text_field_finacc_interest_rate);
        btnAddAccount = (Button) findViewById(R.id.button_finacc_add);
        btnAddAccount.setOnClickListener(new View.OnClickListener(){
		      @Override
		      public void onClick(View view) 
		      {
		    	  presenter.addAccountClicked();
	          }
	  });
    }
    

    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_fin_account, menu);
        return true;
    }


    /* (non-Javadoc)
     * @see android.app.Activity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Dashboard.class));
    }

	@Override
	public String getFullName() 
	{
		return fullNameET.getText().toString();
	}

	@Override
	public String getDisplayName() 
	{
		return displayNameET.getText().toString();
	}

	@Override
	public String getBalance() 
	{
		return balanceET.getText().toString();
	}

	@Override
	public String getRate() 
	{
		return interestRateET.getText().toString();
	}

	@Override
	public void displayMessage(String string) 
	{
		Toast toast = Toast.makeText(getApplicationContext(), string,
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();		
	}

	@Override
	public void gotoFinAccMain() 
	{
		startActivity(new Intent(getApplicationContext(),
                FinancialAccountMain.class));
		finish();
	}

}
