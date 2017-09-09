package com.ferre.lopez.sebas.exportfinancetools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class getcirratesActivity extends AppCompatActivity {

    WebView browser;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getcirrates);

        browser =(WebView) findViewById(R.id.Browser);
        url = "http://docs.google.com/gview?embedded=true&url=http://www.oecd.org/tad/xcred/cirrs.pdf";
        browser.loadUrl(url);


    }
}
