package com.example.banknote.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.banknote.R;
import com.example.banknote.model.LoginHandler;

/**
 * The Class Login_screen.
 */
public class LoginScreen extends Activity {
    // Used to pass the name of user logging in to dashboard
    /** The Constant USER. */
    public static final String USER = "com.example.banknote.presenter.USER";

    // Values for email and password at the time of the login attempt.
    /** The m email. */
    private String mEmail;

    /** The m password. */
    private String mPassword;

    // UI references.
    /** The m email view. */
    private EditText mEmailView;

    /** The m password view. */
    private EditText mPasswordView;

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        // makes sign in button actually work
        findViewById(R.id.sign_in_button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { // this "view" is the
                                                     // button
                        attemptLogin(view);
                    }
                });
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.login_screen, menu);
        return true;
    }

    /**
     * Attempt login.
     * 
     * @param view
     *            the view
     */
    public void attemptLogin(View view) {

        // Store values at the time of the login attempt.
        mEmail = mEmailView.getText().toString();
        mPassword = mPasswordView.getText().toString();

        boolean loginSuccess = LoginHandler.attemptLogin(mEmail, mPassword);
        if (loginSuccess) {
            Intent successIntent = new Intent();
            successIntent.setClassName("com.example.banknote",
                    "com.example.banknote.view.Dashboard");
            // attach the name of the user who has successfully logged in
            successIntent.putExtra(USER, mEmail);
            startActivity(successIntent);
            finish();
        } else // stay on login screen and notify user with toast
        {
            Context context = getApplicationContext();
            CharSequence text = "Try again!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), WelcomeScreen.class));
    }

}
