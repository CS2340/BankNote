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

public class AddFinAccount extends Activity {
	
	private String displayName = "";
	private String fullName = "";
	private String balance ="";
	private String interestRate ="";

	private EditText displayNameET;
	private EditText fullNameET;
	private EditText balanceET;
	private EditText interestRateET;
	private Button btnAddAccount;
	
	private String nextActivity = "";

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_fin_account);
		
		
		displayNameET = (EditText) findViewById(R.id.text_field_finacc_displayname);
		fullNameET = (EditText) findViewById(R.id.text_field_fullname);
		balanceET = (EditText) findViewById(R.id.text_field_finacc_balance);
		interestRateET = (EditText) findViewById(R.id.text_field_finacc_interest_rate);
		btnAddAccount= (Button) findViewById(R.id.button_finacc_add);
	
	}

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
	
	public boolean makeNewFinAcc()
	{
		
		displayName = displayNameET.getText().toString();
		fullName = fullNameET.getText().toString();
		balance = balanceET.getText().toString();
		interestRate = interestRateET.getText().toString();

		CharSequence text;
		
		if (!AddAccountHandler.isValidName(fullName))
		{
			text = "Invalid Full Name";
		}
		
		else if (AddAccountHandler.nameAlreadyExists(fullName, displayName))
		{
			text = "Account with that name already exists.";
		}

		else if (!AddAccountHandler.isValidInterestRate(interestRate))
		{
			text = "Interest rate cannot be negative";
		}
		else if (!AddAccountHandler.isValidAmount(balance))
		{
			text = "Please input the valid type of amount!";
		} 
		else
		{
			Context c = getApplicationContext();
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(c,"Hello", duration);
			toast.show();
			
			AddAccountHandler.addAccount(fullName, displayName, balance, interestRate);
			
			// Next Activity
			nextActivity = "com.example.banknote.view.FinancialAccountMain";
			text = "New Account Created!";
			
			//Account is added successfully
			return true;
		}
		
		Context c = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(c, text, duration);
		toast.show();
		
		return false;
	}
	
	public void goNextActivity(View view){
		Intent intent = new Intent();
		intent.setClassName("com.example.banknote", nextActivity);
		startActivity(intent);
	}

}
