package com.example.banknote.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.banknote.R;
import com.example.banknote.model.RegisterHandler;

/**
 * The Class RegisterScreen.
 */
public class RegisterScreen extends Activity {
    
    /** The m email. */
    private String mEmail;
    
    /** The m password1. */
    private String mPassword1;
    
    /** The m password2. */
    private String mPassword2;

    /** The m email view. */
    private EditText mEmailView;
    
    /** The m password1 view. */
    private EditText mPassword1View;
    
    /** The m password2 view. */
    private EditText mPassword2View;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        // Show the Up button in the action bar.
        setupActionBar();

        mEmailView = (EditText) findViewById(R.id.text_field_new_email);
        mPassword1View = (EditText) findViewById(R.id.text_field_new_password_1);
        mPassword2View = (EditText) findViewById(R.id.text_field_new_password_2);

        findViewById(R.id.button_register).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { // this "view" is the
                                                     // button
                        attemptRegister(view);
                    }
                });
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
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register_screen, menu);
        return true;
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Attempt register.
     * 
     * @param view
     *            the view
     */
    public void attemptRegister(View view) {

        mEmail = mEmailView.getText().toString();
        mPassword1 = mPassword1View.getText().toString();
        mPassword2 = mPassword2View.getText().toString();

        if (mPassword1.equals(mPassword2)
                && RegisterHandler.store(mEmail, mPassword1)) {
            Intent successIntent = new Intent();
            successIntent.setClassName("com.example.banknote",
                    "com.example.banknote.view.LoginScreen");
            startActivity(successIntent);
            finish();
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Try Again!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), WelcomeScreen.class));
    }

}
