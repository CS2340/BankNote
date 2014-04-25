package com.example.banknote.view;

import iView.iAccountMainScreen;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import presenter.AccountMainPresenter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.banknote.R;
import com.example.banknote.model.ReportEntry;
import com.example.banknote.model.Transaction;
import com.example.banknote.model.TransactionsReport;

/**
 * The Class FinancialAccountMain.
 */
public class FinancialAccountMain extends Activity implements iAccountMainScreen {

    /** The btn add trans. */
    private Button btnAddTrans;
    
    /** The text. */
    private String text = "";
    
    /** The display name tv. */
    private TextView displayNameTV;
    
    /** The balance tv. */
    private TextView balanceTV;
    
    private AccountMainPresenter presenter;
    
    private TransactionsReport reportHandler = new TransactionsReport() ;
    
    /** The list view. */
    ListView listView;
    
    /** The list adapter. */
    ListAdapter listAdapter;
    
    /** The list. */
    private ArrayList<Transaction> list;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_account_main);
        displayNameTV = (TextView) findViewById(R.id.displayt_name_textView);
        balanceTV = (TextView) findViewById(R.id.balance_textView);
        btnAddTrans = (Button) findViewById(R.id.add_new_trans);
       
        presenter = new AccountMainPresenter(this);
        
        

        btnAddTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	presenter.addTransClicked();
            }
        });
        
        getRecentTransactionReport();
        
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.financial_account_main, menu);
        
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

	@Override
	public void setDisplayName(String accName) 
	{
		displayNameTV.setText("Account: "+accName);
	}

	@Override
	public void setBalance(double bal) 
	{
	    NumberFormat baseFormat = NumberFormat.getCurrencyInstance();
	    String balance = baseFormat.format(bal);
		balanceTV.setText(String.valueOf(balance));	
	}

	@Override
	public void gotoAddTrans() 
	{
		 startActivity(new Intent(getApplicationContext(), AddTransScreen.class));
		 finish();
	}
	
	private void getRecentTransactionReport(){
		
		this.list = (ArrayList<Transaction>) reportHandler.getRecentTransactionsByAccount(10);
		listView = (ListView) findViewById(R.id.listView1);

        listAdapter = new ArrayAdapter<Transaction>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(listAdapter);
		
	}

}
