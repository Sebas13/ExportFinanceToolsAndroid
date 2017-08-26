package com.ferre.lopez.sebas.exportfinancetools;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
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

        a.setText(String.valueOf(0));
        b.setText(String.valueOf(0));
        c.setText(String.valueOf(0));

       FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
       button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                spanish_content = Integer.parseInt(a.getText().toString());
                third_country_content = Integer.parseInt(b.getText().toString());
                local_costs = Integer.parseInt(c.getText().toString());

                calculate(spanish_content,third_country_content,local_costs);
            }
        });
    }

       public void calculate (int spanish_content, int third_country_content, int local_costs)
            {

               int result =  spanish_content + third_country_content + local_costs;
               String d = String.valueOf(result);
                int duration = Toast.LENGTH_LONG;
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, d, duration);
                toast.show();
             }

    }





