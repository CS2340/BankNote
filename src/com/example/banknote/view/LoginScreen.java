package com.example.banknote.view;

import iView.iLoginScreen;
import presenter.LoginPresenter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.banknote.R;

/**
 * The Class Login_screen.
 */
public class LoginScreen extends Activity implements iLoginScreen
{
	// UI references.
    /** The m email view. */
    private EditText mEmailView;

    /** The m password view. */
    private EditText mPasswordView;
    
    LoginPresenter presenter;

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        presenter = new LoginPresenter(this);
        
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        // makes sign in button actually work
        findViewById(R.id.sign_in_button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { // this "view" is the
                                                     // button
                        presenter.loginClicked();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.login_screen, menu);
        return true;
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
	public String getPassword() 
	{
		return mPasswordView.getText().toString();
	}

	@Override
	public void gotoDashboardScreen() 
	{
		startActivity(new Intent(getApplicationContext(), Dashboard.class));
		finish();
	}

	@Override
	public void displayMessage(String string) 
	{
        CharSequence text = string;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();	
	}
}
