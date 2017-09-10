package com.ferre.lopez.sebas.exportfinancetools;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton;

import java.util.Locale;

public class ECACalculatorActivity extends AppCompatActivity {

    double spanish_content;
    double third_country_content;
    double local_costs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecacalculator);

        final EditText a = (EditText) findViewById(R.id.editText);
        final EditText b = (EditText) findViewById(R.id.editText2);
        final EditText c = (EditText) findViewById(R.id.editText3);
        final EditText d = (EditText) findViewById(R.id.editText4);
        final TextView a1 = (TextView) findViewById(R.id.spanish_content_CESCE);
        final TextView a2 = (TextView) findViewById(R.id.third_country_content_CESCE);
        final TextView a3 = (TextView) findViewById(R.id.local_costs_CESCE);
        final TextView a4 = (TextView)findViewById(R.id.Eca_loan);
        final TextView a5 = (TextView) findViewById(R.id.commercial_loan);
        final TableLayout table_layout = (TableLayout) findViewById(R.id.TableLayout);

        table_layout.setVisibility(View.GONE);

        final Switch angola_switch = (Switch) findViewById(R.id.switch1);
        Switch premium_switch = (Switch) findViewById(R.id.switch2);

        premium_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

               if (isChecked)
               {
                   d.setVisibility(View.VISIBLE);
               }
               else
               {
                   d.setVisibility(View.GONE);
                   d.setText("0");
               }
           }
       });

        //TODO: To fix the format of the numbers
        //TODO: Make the second button to do a share intent to share the results
        //TODO: Make the calculation of the premium: Problems, is not getting decimals points and the iterative calculation

       FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
       button.setOnClickListener(new View.OnClickListener()
       {
            public void onClick(View v)
            {
                 try
                    {
                        spanish_content = Integer.parseInt(a.getText().toString());
                        third_country_content = Integer.parseInt(b.getText().toString());
                        local_costs = Integer.parseInt(c.getText().toString());

                        if (angola_switch.isChecked())
                        {
                            a.setAlpha(0.2f);
                            b.setAlpha(0.2f);
                            c.setAlpha(0.2f);
                            d.setAlpha(0.2f);

                            double [] result = calculate_angola_deal(spanish_content,third_country_content,local_costs);

                            a1.setText(String.format(Locale.ENGLISH,"%.2f",result[0]));
                            a2.setText(String.format(Locale.ENGLISH, "%.2f",result[1]));
                            a3.setText(String.format(Locale.ENGLISH, "%.2f", result[2]));
                            a4.setText(String.format(Locale.ENGLISH, "%.2f", result[4]));
                            a5.setText(String.format(Locale.ENGLISH, "%.2f", result[5]));

                            table_layout.setVisibility(View.VISIBLE);

                        }
                        else
                        {
                            a.setAlpha(0.2f);
                            b.setAlpha(0.2f);
                            c.setAlpha(0.2f);
                            d.setAlpha(0.2f);

                            double [] result= calculate(spanish_content,third_country_content,local_costs);

                            a1.setText(String.format(Locale.ENGLISH,"%.2f",result[0]));
                            a2.setText(String.format(Locale.ENGLISH, "%.2f",result[1]));
                            a3.setText(String.format(Locale.ENGLISH, "%.2f", result[2]));
                            a4.setText(String.format(Locale.ENGLISH, "%.2f", result[4]));
                            a5.setText(String.format(Locale.ENGLISH, "%.2f", result[5]));

                            table_layout.setVisibility(View.VISIBLE);

                        }
                    }
                    catch(Exception e )
                    {
                        String a = "Input not found";
                        int duration = Toast.LENGTH_SHORT;
                        Context context = getApplicationContext();
                        Toast toast = Toast.makeText(context,a, duration);
                        toast.show();
                    }
                }
            }
        );


    }

    public double[] calculate (double spanish_content,double third_country_content,double local_costs)
            {

                double total_contract_value = (spanish_content + third_country_content + local_costs);
                double export_contract_value = (spanish_content + third_country_content);

                double spanish_content_ECA = (spanish_content * 0.85);
                double third_country_content_ECA =(export_contract_value * 0.85 * 0.30) ;
                double local_costs_ECA = (export_contract_value * 0.30);

                double ECA_Consensus_limit = export_contract_value * 0.85;

                if (third_country_content_ECA > third_country_content)
                {
                    third_country_content_ECA = third_country_content;
                }

                if (spanish_content_ECA + third_country_content_ECA > ECA_Consensus_limit)
                {
                    third_country_content_ECA = third_country_content * 0.85;
                }

                if (local_costs_ECA > local_costs)
                {
                    local_costs_ECA = local_costs;
                }

                double ECA_loan = ((spanish_content_ECA + third_country_content_ECA + local_costs_ECA));
                double Commercial_Loan = ((total_contract_value - ECA_loan));

                double [] results = {spanish_content_ECA, third_country_content_ECA, local_costs_ECA, total_contract_value, ECA_loan, Commercial_Loan};

                return results;
          }

    public double[] calculate_angola_deal (double spanish_content, double third_country_content, double local_costs)
        {
            double total_contract_value = spanish_content + third_country_content + local_costs;
            double export_contract_value = spanish_content + third_country_content;

            double spanish_content_ECA = spanish_content * 0.85;
            double third_country_content_ECA = export_contract_value * 0.85 * 0.15 ;
            double local_costs_ECA = export_contract_value * 0.15;

            double ECA_Consensus_limit = export_contract_value * 0.85;

            if (third_country_content_ECA > third_country_content)
            {
                third_country_content_ECA = third_country_content;
            }

            if (spanish_content_ECA + third_country_content_ECA > ECA_Consensus_limit)
            {
                third_country_content_ECA = third_country_content * 0.85;
            }

            if (local_costs_ECA > local_costs)
            {
                local_costs_ECA = local_costs;
            }

            double ECA_loan = spanish_content_ECA + third_country_content_ECA + local_costs_ECA;
            double Commercial_Loan = total_contract_value - ECA_loan;

            double [] results = {spanish_content_ECA, third_country_content_ECA, local_costs_ECA, total_contract_value, ECA_loan, Commercial_Loan};

            return results;
        }

}





