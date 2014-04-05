package com.example.banknote.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.banknote.R;
import com.example.banknote.model.DB;

public class Welcome_screen extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_screen);
		String filePath = this.getFilesDir() + "data.db4o"; //this is the context
		DB.getInstance().setDB(filePath); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_screen, menu);
		
		return true;
	}
	
	/** Called when the user clicks the Log In button */
	public void goToLogInScreen(View view)	
	{
		Intent intent = new Intent(this, Login_screen.class);
		startActivity(intent);
		
		finish();
	}
	
	/** Called when the user clicks the Register button */
	public void goToRegisterScreen(View view) 
	{
		Intent intent = new Intent(this, Register_screen.class);
		startActivity(intent);
		finish();
	}

}
