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
        //buttonECACalculator.setOnClickListener((View.OnClickListener) this);
        Button buttonCIRRRates = (Button)findViewById(R.id.buttonCIRRRates);
        //buttonCIRRRates.setOnClickListener((View.OnClickListener) this);
        Button buttonOECDConsensus = (Button) findViewById(R.id.buttonOECDConsensus);
        //buttonOECDConsensus.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.buttonEcaCalculator:
            {
                gotoECACalculator();
                break;
            }

            case R.id.buttonCIRRRates:
            {
                getCIRRRates();
                break;
            }

            case R.id.buttonOECDConsensus:
            {
                getOECDConsensus();
                break;
            }
        }
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
