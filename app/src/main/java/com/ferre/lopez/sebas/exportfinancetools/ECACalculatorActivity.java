package com.ferre.lopez.sebas.exportfinancetools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ECACalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecacalculator);

        EditText a = (EditText)findViewById(R.id.editText);
        EditText b = (EditText)findViewById(R.id.editText2);
        EditText c = (EditText)findViewById(R.id.editText3);

        String spanish_content = a.getText().toString();
        String third_country_content = b.getText().toString();
        String get_local_cost = c.getText().toString();

       
    }





}
