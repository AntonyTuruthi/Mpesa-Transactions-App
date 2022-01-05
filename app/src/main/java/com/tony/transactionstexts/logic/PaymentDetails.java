package com.tony.transactionstexts.logic;

public class PaymentDetails {
    public String paidToText;

    private String transactionType;
    private String entity;


    public PaymentDetails (String paidToText) {

        this.paidToText = paidToText;


    }

    // Extract Entity
    public String paymentEntity (String paymentText){
        int startEntityIndex = this.paidToText.indexOf(" to ")+3;
        int endEntityIndex = this.paidToText.indexOf(" on")-1;

        transactionType = "Payments";
        entity = this.paidToText.substring(startEntityIndex, endEntityIndex);

        return entity;
    }

    //Extract the amount
    public String paidAmount(String paymentText){
        int start = paymentText.indexOf("Ksh");
        int end = paymentText.indexOf("paid")-1;
        String amount = paymentText.substring(start, end);

        return amount;
    }

    //Extract the date
    public String paidDate(String paymentText){
        int start = paymentText.indexOf(" on ")+3;
        int end = paymentText.indexOf(" at ");

        String dateString = paymentText.substring(start, end);
        return dateString;
    }

    //Extract the time
    public String paidTime(String paymentText){
        int start = paymentText.indexOf("at")+3;
        int end = paymentText.indexOf("New");

        String timeString = paymentText.substring(start, end);
        return timeString;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getEntity() {
        return entity;
    }

}
