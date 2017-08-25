package com.ferre.lopez.sebas.exportfinancetools;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ECACalculatorActivity extends AppCompatActivity {

    int spanish_content = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecacalculator);

       final EditText a = (EditText) findViewById(R.id.editText);
       final EditText b = (EditText) findViewById(R.id.editText2);
       EditText c = (EditText) findViewById(R.id.editText3);

        a.setText(String.valueOf(0));
        b.setText(String.valueOf(0));
        c.setText(String.valueOf(0));

       FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
       button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                spanish_content = Integer.parseInt(a.getText().toString());
                calculate(spanish_content,spanish_content);
            }
        });
    }

       public void calculate (int a, int b)
            {

               int c =  a + b;
               String d = String.valueOf(c);
                int duration = Toast.LENGTH_LONG;
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, d, duration);
                toast.show();
             }

    }





