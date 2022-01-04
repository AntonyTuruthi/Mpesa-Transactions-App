package com.tony.transactionstexts.logic;

public class ReceivableDetails {
    String receiveText;

    public ReceivableDetails(String receiveText) {

        this.receiveText = receiveText;

    }

    //Derive the sender
    public String senderName(String receiveText) {
        int startEntityIndex = receiveText.indexOf("from")+5;
        int endEntityIndex = receiveText.indexOf(" on ");

        String senderName = receiveText.substring(startEntityIndex, endEntityIndex);
        return senderName;
    }

    //Derive the amount received
    public String receivedAmount(String receiveText){
        int start = receiveText.indexOf("Ksh");
        int end = receiveText.indexOf("from")-1;
        String amount = receiveText.substring(start, end);
        return amount;
    }

    //Derive the date
    public String receivedDate(String withdrawalText){
        int start = withdrawalText.indexOf(" on ")+4;
        int end = withdrawalText.indexOf(" at ");

        String dateString = withdrawalText.substring(start, end);
        return dateString;
    }

    //Extract the time
//    public String receivedTime(String withdrawalText){
//        int start = withdrawalText.indexOf("at")+3;
//        int end = withdrawalText.indexOf(" New ");
//
//        String dateString = withdrawalText.substring(start, end);
//
//        return dateString;
//    }
}
