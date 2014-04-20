package com.example.banknote.view;

import iView.iWelcomeScreen;
import presenter.WelcomePresenter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.banknote.R;

/**
 * First screen a user encounters. Contains login and register buttons.
 * 
 *
 */
public class WelcomeScreen extends Activity implements iWelcomeScreen
{
	WelcomePresenter presenter;
	String filePath;
	Button buttonLogin;
	Button buttonRegister;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        
        
        /*
         *             VERY IMPORTANT
         *The next two lines must be called in this order.
         *Otherwise --> NULLPOINTEREXCEPTION
         */
        filePath = this.getFilesDir() + "data.db4o"; // this = context
        presenter = new WelcomePresenter(this);
        
       
                                                           
        buttonLogin = (Button) findViewById(R.id.login_button);
        buttonLogin.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) 
            {
                notifyPresenterLoginClick();
            }
        });
        
        buttonRegister = (Button) findViewById(R.id.reg_button);
        buttonRegister.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) 
            {
                notifyPresenterRegisterClick();
            }
        });
    }

    protected void notifyPresenterRegisterClick() 
    {
    	presenter.registerClicked();
	}

	protected void notifyPresenterLoginClick() 
    {
    	presenter.loginClicked();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome_screen, menu);

        return true;
    }
    

	@Override
	public String getFilePath() 
	{
		return filePath;
	}

	@Override
	public void gotoLogin() 
	{
		startActivity(new Intent(getApplicationContext(),
				LoginScreen.class));
        finish();
	}

	@Override
	public void gotoRegister() 
	{
		startActivity(new Intent(getApplicationContext(),
				RegisterScreen.class)); 
        finish();
	}

}
