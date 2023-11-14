package com.example.feetracker;

public class EbayProfitCalculator extends ProfitCalculator {

    /*final double europeFee = 0.0126;
    final double usaFee = 0.0216;
    final double otherCountriesFee = 0.024;
    promoted lisitng fee
     */


    double ebayFinalFee;

    final double ebayFee = 0.106667;
    public EbayProfitCalculator(double boughtPrice, double soldPrice, double shippingCost){
    super( boughtPrice,  soldPrice,  shippingCost);
    }


    protected double getDeductions(){
        return super.getDeductions() + getEbayFinalFee();
    }
    protected double getEbayFinalFee(){
        ebayFinalFee = (0.25 + soldPrice * ebayFee) * 1.2;
        return ebayFinalFee;
    }
    protected double getEarnings(){
        return getRevenue() - getEbayFinalFee() - shippingCost;
    }


    protected String calculateProfit(){
        String profitText = "Ebay Fee: £" + df.format(getEbayFinalFee()) + "\n" +  super.calculateProfit();
        return profitText;

    }


}
