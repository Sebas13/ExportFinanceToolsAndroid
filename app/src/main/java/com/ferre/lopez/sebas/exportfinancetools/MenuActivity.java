package com.ferre.lopez.sebas.exportfinancetools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button buttonECACalculator = (Button)findViewById(R.id.buttonEcaCalculator);
        Button buttonCIRRRates = (Button)findViewById(R.id.buttonCIRRRates);
        Button buttonOECDConsensus = (Button) findViewById(R.id.buttonOECDConsensus);
        //buttonOECDConsensus.setOnClickListener((View.OnClickListener) this);
    }

    public void gotoECACalculator()
    {
        //Rellenar para pasar a la actividad ECA Calculator
    }

    public void getCIRRRates ()
    {
        //Rellenar con el enlace con el cual se obtienen los CIRR Rates
    }

    public void getOECDConsensus()
    {
        //Rellenar con el enlace para obtener el consenso de la OCDE
    }
}
