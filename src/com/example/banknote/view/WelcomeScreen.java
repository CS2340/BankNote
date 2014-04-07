package com.example.banknote.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.banknote.R;
import com.example.banknote.model.DB;

/**
 * First screen a user encounters. Contains login and register buttons.
 * 
 *
 */
public class WelcomeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        String filePath = this.getFilesDir() + "data.db4o"; // this is the
                                                            // context
        DB.getInstance().setDB(filePath);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome_screen, menu);

        return true;
    }

    /** Called when the user clicks the Log In button.
     * @param view Current screen
     */
    public void goToLogInScreen(View view) {
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);

        finish();
    }

    /** Called when the user clicks the Register button.
     * @param view Current screen
     */
    public void goToRegisterScreen(View view) {
        Intent intent = new Intent(this, RegisterScreen.class);
        startActivity(intent);
        finish();
    }

}
