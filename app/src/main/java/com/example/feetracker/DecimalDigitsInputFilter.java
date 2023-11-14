package com.example.feetracker;

import android.text.InputFilter;
import android.text.Spanned;

public class DecimalDigitsInputFilter implements InputFilter {
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String currentText = dest.toString();
        String newText = currentText.substring(0, dstart) + source.subSequence(start, end) + currentText.substring(dend);

        // Remove leading zeros
        newText = newText.replaceFirst("^0+(?!$)", "");

        // Validate input using a regular expression
        String regex = "^[0-9]+(\\.[0-9]{0,2})?$";
        if (!newText.matches(regex)) {
            return "";
        }

        return null;
    }
}
