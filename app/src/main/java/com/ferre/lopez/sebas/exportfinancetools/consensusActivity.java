package com.ferre.lopez.sebas.exportfinancetools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class consensusActivity extends AppCompatActivity {

    WebView browser;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consensus);

        browser =(WebView) findViewById(R.id.Browser);
        url = "http://www.oecd.org/tad/xcred/theexportcreditsarrangementtext.htm";
        browser.loadUrl(url);
    }
}
