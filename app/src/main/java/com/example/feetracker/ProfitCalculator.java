package com.example.feetracker;


import java.text.DecimalFormat;

public class ProfitCalculator{
    double boughtPrice;
    double soldPrice;
    double shippingCost;
    double profit;
    DecimalFormat df = new DecimalFormat("####0.00");

    public ProfitCalculator(double boughtPrice, double soldPrice, double shippingCost) {
        this.soldPrice = soldPrice;
        this.boughtPrice = boughtPrice;
        this.shippingCost = shippingCost;
    }



    protected String calculateProfit(){
        profit = getRevenue() - getDeductions();
        return "Profit: £" + df.format(profit) +"\nEarnings: £" + df.format(getEarnings());
    }

    protected double getEarnings(){
        return getRevenue() - shippingCost;
    }

    protected double getRevenue(){
        return soldPrice;
    }

    protected double getDeductions(){
        return shippingCost + boughtPrice;
    }
}
