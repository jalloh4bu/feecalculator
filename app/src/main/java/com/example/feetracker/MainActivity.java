package com.example.feetracker;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
   ProfitCalculator profitCalculator;
   EditText price;
   EditText shipping;
   EditText soldPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         price = findViewById(R.id.itemPrice);
         shipping = findViewById(R.id.shippingFee);
         soldPrice = findViewById(R.id.soldPrice);

         price.setFilters(new InputFilter[] { new DecimalDigitsInputFilter() });
         shipping.setFilters(new InputFilter[] { new DecimalDigitsInputFilter() });
         soldPrice.setFilters(new InputFilter[] { new DecimalDigitsInputFilter() });

    }

    public void calculateProfit(View v){

        TextView profitValue = findViewById(R.id.profit);
        Spinner mySpinner = (Spinner) findViewById(R.id.appSelect);
        String priceText = price.getText().toString();
        String shippingText = shipping.getText().toString();
        String soldPriceText = soldPrice.getText().toString();
        String message;

        if(priceText.isEmpty()){
            missingText("Item Cost");
            return;
        }
        else if(soldPriceText.isEmpty()){
            missingText("Sold Price");
            return;
        }

        double price = Double.parseDouble(priceText);
        double soldPrice = Double.parseDouble(soldPriceText);
        double shippingFee = shippingText.isEmpty() ? 0.0 : Double.parseDouble(shippingText);

        String text = mySpinner.getSelectedItem().toString();

        if(text.equals("Ebay")) {
            profitCalculator = new EbayProfitCalculator(price, soldPrice, shippingFee);
        }
        else{
            profitCalculator = new ProfitCalculator(price, soldPrice, shippingFee);
        }

        profitValue.setText(profitCalculator.calculateProfit());

    }
    private void missingText(String name){
        String message = name + " is Missing!";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

