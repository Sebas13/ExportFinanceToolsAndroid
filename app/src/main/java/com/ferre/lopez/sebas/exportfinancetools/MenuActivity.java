package com.ferre.lopez.sebas.exportfinancetools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void gotoECACalculator(View v)
    {
        startActivity(new Intent(this,ECACalculatorActivity.class));
    }

    public void getCIRRRates(View v)
    {
        startActivity(new Intent(this,getcirratesActivity.class));
    }

    public void getOECDConsensus(View v)
    {
        startActivity(new Intent(this,consensusActivity.class));
    }
}
