package com.ferre.lopez.sebas.exportfinancetools;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ECACalculatorActivity extends AppCompatActivity {

    int spanish_content;
    int third_country_content;
    int local_costs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecacalculator);

       final EditText a = (EditText) findViewById(R.id.editText);
       final EditText b = (EditText) findViewById(R.id.editText2);
       final EditText c = (EditText) findViewById(R.id.editText3);

        //Use the class NumberTextWatcher to format the text, but after calculate() need ints, and does not generate ints
      /*  a.addTextChangedListener(new NumberTextWatcher(a));
        b.addTextChangedListener(new NumberTextWatcher(b));
        c.addTextChangedListener(new NumberTextWatcher(c)); */

       FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
       button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                spanish_content = Integer.parseInt(a.getText().toString());
                third_country_content = Integer.parseInt(b.getText().toString());
                local_costs = Integer.parseInt(c.getText().toString());

               double result= calculate(spanish_content,third_country_content,local_costs);

                String d = String.valueOf(result);
                int duration = Toast.LENGTH_LONG;
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, d, duration);
                toast.show();
            }
        });
    }

       public double calculate (double spanish_content, double third_country_content,double local_costs)
            {

                //TO-DO : Include OECD Consensus Limits
                //TO-DO : Include the commercial loan; probably needs return an array with both values

                double total_contract_value = spanish_content + third_country_content + local_costs;
                double export_contract_value = spanish_content + third_country_content;

                double spanish_content_ECA = spanish_content * 0.85;
                double third_country_content_ECA = export_contract_value * 0.85 * 0.30 ;
                double local_costs_ECA = export_contract_value * 0.30;

                if (third_country_content_ECA > third_country_content)
                {
                    third_country_content_ECA = third_country_content;
                }

                if (local_costs_ECA > local_costs)
                {
                    local_costs_ECA = local_costs;
                }

                double ECA_loan = spanish_content_ECA + third_country_content_ECA + local_costs_ECA;

                Log.d("Total Contract Value", String.valueOf(total_contract_value));
                Log.d("Spanish_Content", String.valueOf(spanish_content_ECA));
                Log.d("3er_COUNTRY_CONTENT_ECA", String.valueOf(third_country_content_ECA));
                Log.d("Local_costs_ECA", String.valueOf(local_costs_ECA));

                return ECA_loan;

            }

    }





