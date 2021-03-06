package com.ferre.lopez.sebas.exportfinancetools;

import android.icu.text.DecimalFormat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.ParseException;

/**
 * Created by sebas on 26/08/2017.
 */

@SuppressWarnings("SpellCheckingInspection")
public class NumberTextWatcher implements TextWatcher {

    private DecimalFormat df;
    private DecimalFormat dfnd;

    private boolean hasFractionalpart;

    private EditText et;

    public NumberTextWatcher(EditText et)
    {
        df = new DecimalFormat("#,###.##");
        df.setDecimalSeparatorAlwaysShown(true);
        dfnd = new DecimalFormat("#,###");
        this.et = et;
        hasFractionalpart= false;

    }

    @SuppressWarnings("unused")
    private static final String TAG = "NumberTextWatcher";

    @Override
    public void afterTextChanged(Editable s)
    {
        et.removeTextChangedListener(this);

        try
        {
            int inilen, endlen;
            inilen = et.getText().length();

            String v = s.toString().replace(String.valueOf(df.getDecimalFormatSymbols().getGroupingSeparator()),"");
            Number n = df.parse(v);
            int cp = et.getSelectionStart();
            if (hasFractionalpart)
            {
                et.setText(df.format(n));
            }
            else
            {
                et.setText(dfnd.format(n));
            }
            endlen = et.getText().length();
            int sel = (cp + (endlen - inilen));
            if (sel > 0 && sel <= et.getText().length())
            {
                et.setSelection(sel);
            }
            else
            {
                et.setSelection(et.getText().length() - 1);
            }
        }
        catch (NumberFormatException nfe)
        {
            //Do nothing
        }
        catch (ParseException e)
        {
            //Do nothing
        }

        et.addTextChangedListener(this);
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after)
    {

    }

    public void onTextChanged (CharSequence s, int start, int before, int count)
    {
        if (s.toString().contains(String.valueOf(df.getDecimalFormatSymbols().getDecimalSeparator())))
        {
            hasFractionalpart = true;
        }
        else
        {
            hasFractionalpart = false;
        }
    }


}
