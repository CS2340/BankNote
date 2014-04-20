package com.example.banknote.view;

import iView.iRegisterScreen;
import presenter.RegisterPresenter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.banknote.R;

/**
 * The Class RegisterScreen.
 */
public class RegisterScreen extends Activity implements iRegisterScreen
{
    
    /** The m email view. */
    private EditText mEmailView;
    
    /** The m password1 view. */
    private EditText mPassword1View;
    
    /** The m password2 view. */
    private EditText mPassword2View;
    
    RegisterPresenter presenter;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        
        presenter = new RegisterPresenter(this);

        
        mEmailView = (EditText) findViewById(R.id.text_field_new_email);
        mPassword1View = (EditText) findViewById(R.id.text_field_new_password_1);
        mPassword2View = (EditText) findViewById(R.id.text_field_new_password_2);
        findViewById(R.id.button_register).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { // this "view" is the
                                                     // button
                        presenter.registerClicked();
                    }
                });
    }


    @Override
    public void onBackPressed() 
    {
        startActivity(new Intent(getApplicationContext(), WelcomeScreen.class));
    }

	@Override
	public String getName() 
	{
		return mEmailView.getText().toString();
	}

	@Override
	public String getPass1() 
	{
		return mPassword1View.getText().toString();
	}

	@Override
	public String getPass2() 
	{
		return mPassword2View.getText().toString();
	}

	@Override
	public void gotoLogin() 
	{
		startActivity(new Intent(getApplicationContext(),
				LoginScreen.class));
        finish();    
	}

	@Override
	public void displayMessage(String message) 
	{
		CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
	}
	
    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register_screen, menu);
        return true;
    }
}
