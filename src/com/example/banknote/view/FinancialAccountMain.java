package com.example.banknote.view;

import java.text.NumberFormat;

import com.example.banknote.R;
import com.example.banknote.model.AccountSingle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * The Class FinancialAccountMain.
 */
public class FinancialAccountMain extends Activity {

    /** The btn add trans. */
    private Button btnAddTrans;
    
    /** The text. */
    private String text = "";
    
    /** The display name. */
    private String displayName;
    
    /** The balance. */
    private String balance;

    /** The display name tv. */
    private TextView displayNameTV;
    
    /** The balance tv. */
    private TextView balanceTV;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_account_main);

        displayName = AccountSingle.getCurrentAccount().getDisplayName();

        NumberFormat baseFormat = NumberFormat.getCurrencyInstance();
        balance = baseFormat.format(AccountSingle.getCurrentAccount()
                .getBalance());

        displayNameTV = (TextView) findViewById(R.id.displayt_name_textView);
        balanceTV = (TextView) findViewById(R.id.balance_textView);
        btnAddTrans = (Button) findViewById(R.id.add_new_trans);

        displayNameTV.setText(String.valueOf(displayName));
        balanceTV.setText(String.valueOf(balance));
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.financial_account_main, menu);

        btnAddTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = "com.example.banknote.view.AddTransScreen";
                goNextActivity(view);
            }
        });
        return true;
    }

    /**
     * Go next activity.
     * 
     * @param view
     *            the view
     */
    public void goNextActivity(View view) {
        Intent intent = new Intent();
        intent.setClassName("com.example.banknote", text);
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
