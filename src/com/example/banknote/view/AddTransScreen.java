package com.example.banknote.view;

import iView.iAddTransView;

import java.util.List;

import presenter.AddTransPresenter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.banknote.R;

// TODO: Auto-generated Javadoc
/**
 * The Class AddTransScreen.
 */
public class AddTransScreen extends Activity implements iAddTransView {

	private AddTransPresenter presenter;
	
	List<String> incomeTypes = null;
	List<String> expenseTypes = null;


    /** The amount et. */
    private EditText amountET;
    
    /** The description et. */
    private EditText descriptionET;

    /** The spinner. */
    private Spinner spinner;
    
    /** The btn add trans. */
    private Button btnAddTrans;

    // this variable to check either income or outcome radio buttons is checked
    /** The is radio checked. */
    private boolean isRadioChecked = false;
    
    /** The is income. */
    private boolean isIncome = false;

    /** The adapter. */
    ArrayAdapter<String> adapter;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trans_screen);

        
        spinner = (Spinner) findViewById(R.id.types_spinner);
        amountET = (EditText) findViewById(R.id.amount_text_field);
        btnAddTrans = (Button) findViewById(R.id.add_transaction_button);
        descriptionET = (EditText) findViewById(R.id.description_editext);

        presenter = new AddTransPresenter(this);
        
        /*
         * selectedType Spinner
         */
        spinnerUpdate();

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

        /*
         * addButton click Listener
         */
        btnAddTrans = (Button) findViewById(R.id.add_transaction_button);
        btnAddTrans.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addListenerOnSpinnerItemSelection();
                        if (!isRadioChecked)
                        {
                        	displayMessage("Check income or expense.");
                        }
                        else
                        {
                        	presenter.addTransClicked();
                        }
                    }
                });
    }

	@Override
	public void displayMessage(String string) 
	{
        CharSequence text = string;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();	
	}

	/*
     * Initialize the options in spinner with string array list of types
     * isIncome = true : transaction_incometype_array isIncome = false:
     * transaction_outcometype_array
     */
    /**
     * Spinner update.
     */
    private void spinnerUpdate() {
        // TODO Auto-generated method stub
        // ArrayAdapter<CharSequence> adapter;
        if (isIncome) {
            // Create an ArrayAdapter using the string array and a default
            // spinner layout
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, incomeTypes);
        } else {
            // Create an ArrayAdapter using the string array and a default
            // spinner layout
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, expenseTypes);

        }

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    /**
     * Adds the listener on spinner item selection.
     */
    public void addListenerOnSpinnerItemSelection() {
        // TODO Auto-generated method stub
        CustomOnItemSelectedListener selectTypeListener = new CustomOnItemSelectedListener();
        spinner.setOnItemSelectedListener(selectTypeListener);

    }

    /**
     * On radio button clicked.
     * 
     * @param view
     *            the view
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_income:
                if (checked) {
                    // income are the best
                    isIncome = true;
                    isRadioChecked = true;
                    spinnerUpdate();
                }
                break;
            case R.id.radio_outcome:
                if (checked) {
                    // outcome rule
                    isIncome = false;
                    isRadioChecked = true;
                    spinnerUpdate();
                }
                break;
        }
    }


    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_trans_screen, menu);
        return true;
    }


    /* (non-Javadoc)
     * @see android.app.Activity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),
                FinancialAccountMain.class));
    }

	@Override
	public void setIncomeTypes(List<String> iTypes) 
	{
		incomeTypes = iTypes;
	}

	@Override
	public void setExpenseTypes(List<String> eTypes) 
	{
		expenseTypes = eTypes;
	}

	@Override
	public String getAmount() 
	{
		return amountET.getText().toString();
	}

	@Override
	public String getDescription() 
	{
		return descriptionET.getText().toString();
	}

	@Override
	public String getType() 
	{
		return (String) spinner.getSelectedItem();
	}

	@Override
	public boolean getIsIncome() 
	{
		return isIncome;
	}

	@Override
	public void refreshInputs() 
	{
		amountET.setText("");
		descriptionET.setText("");
		
	}
}
