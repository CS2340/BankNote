package com.example.banknote.view;

import iView.iDashboardActivity;

import java.util.ArrayList;
import java.util.List;

import presenter.DashboarPresenter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.banknote.R;
import com.example.banknote.model.Account;
import com.example.banknote.model.AccountSingle;
import com.example.banknote.model.ChartCodeGenerator;
import com.example.banknote.model.DashboardModelHelper;
import com.example.banknote.model.ReportEntry;
import com.example.banknote.model.User;
import com.example.banknote.model.UserSingle;

/**
 * The Class Dashboard.
 */
public class Dashboard extends Activity implements iDashboardActivity{
    
    private DashboarPresenter presenter;
	
	/** The button to view acc. */
    private Button btnViewAcc;
    
    /** The button to add a fin. acc. */
    private Button btnAddFinAcc;
    
    /** The button for reports. */
    private Button btnReports;
    
    /** The spinner. */
    private Spinner spinner;
    
    /** The text. */
    private String text = "";

    // Spinner helper to retrieve the selected Account as String
    /** The selected account. */
    private Account selectedAccount = null;

    /** The list. */
    List<Account> list = new ArrayList<Account>();
    
    /** The adapter. */
    ArrayAdapter<Account> adapter;
    
    WebView webview;
    String content;
    
    private DashboardModelHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        presenter = new DashboarPresenter(this);
        helper = new DashboardModelHelper();
        content ="";
        
        btnViewAcc = (Button) findViewById(R.id.view_fin_account);
        btnAddFinAcc = (Button) findViewById(R.id.finacc_add_button);
        btnReports = (Button) findViewById(R.id.goto_reports_button);
        btnReports.setOnClickListener(new OnClickListener() {
            public void onClick(View v) 
            {
                presenter.reportClicked();
            }
        });

        spinner = (Spinner) findViewById(R.id.account_spinner);

        /*
         * selectedType Spinner
         */
        spinnerUpdate();

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

        findViewById(R.id.view_fin_account).setOnClickListener(
                new View.OnClickListener() {
                    @Override                                                             
                    public void onClick(View view) {
                    	 presenter.viewAccountsClicked();	
                    }
                });

        findViewById(R.id.finacc_add_button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.createAccountClicked();
                    	
                    	//text = "com.example.banknote.view.AddFinAccount";

                    }
                });
        
        List<ReportEntry> inList = new ArrayList<ReportEntry>();
        inList.add(new ReportEntry ("4"));
        inList.get(0).addToAmount(-3.00);
        inList.add(new ReportEntry ("Kien"));
        inList.add(new ReportEntry ("Nghia"));
        inList.add(new ReportEntry ("Kien"));
        webview = (WebView) findViewById(R.id.webView1);
        helper.getChartDataList();
		content = ChartCodeGenerator.updateAreaChart(helper.getchartIncomeList(),helper.getchartOutcomeList());
		//content = ChartCodeGenerator.updateAreaChart(inList,inList);
		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webview.getSettings().setUseWideViewPort(true);
		//webview.getSettings().setLoadWithOverviewMode(true);
		webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webview.setScrollbarFadingEnabled(true);
		webview.requestFocusFromTouch();
		webview.loadDataWithBaseURL( "file:///android_asset/", content, "text/html", "utf-8", null );

    }


    // Initialize the options in spinner with Accounts List in User
    /**
     * Spinner update.
     */
    private void spinnerUpdate() {

        // Create an ArrayAdapter using the string array and a default spinner
        // layout
        adapter = new ArrayAdapter<Account>(this,
                android.R.layout.simple_spinner_item, list);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    /**
     * Adds the listener on spinner item selection.
     */
    public void addListenerOnSpinnerItemSelection() {
        
        CustomOnItemSelectedListener selectTypeListener = new CustomOnItemSelectedListener();
        spinner.setOnItemSelectedListener(selectTypeListener);

        // Update the selectedAccount with the string of DisplayName
        CustomOnItemSelectedListener.getSelected(selectedAccount);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);

        return true;
    }

    /**
     * Pop toast in the center.
     * 
     * @param message the message on the toast
     */
    protected void popToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * Go to next activity.
     * 
     * @param view the current view
     */
    public void goNextActivity(View view) {
        if (!text.equals("")) {
            Intent intent = new Intent();
            intent.setClassName("com.example.banknote", text);
            startActivity(intent);
            finish();
        } else {
            popToast("Create account first");
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), LoginScreen.class));
    }

	@Override
	public void setAccountList(List<Account> accounts) 
	{
		list = accounts;		
	}

	@Override
	public Account getAccount() 
	{
		return (Account) spinner.getSelectedItem();
	}

	@Override
	public void gotoViewAccounts() 
	{
		 startActivity(new Intent(getApplicationContext(), FinancialAccountMain.class));
		 finish();
	}

	@Override
	public void displayMessage(String string) 
	{
		popToast(string);
	}

	@Override
	public void gotoCreateAccount() 
	{
		 startActivity(new Intent(getApplicationContext(), AddFinAccount.class));
		 finish();
	}

	@Override
	public void gotoReports() 
	{
		startActivity(new Intent(getApplicationContext(),
                ReportActivity.class));
		finish();
	}
	

}
