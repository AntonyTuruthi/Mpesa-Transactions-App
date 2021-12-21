package com.tony.transactionstexts.logic;

public class WithdrawalDetails {
    String withdrawalText;


    public WithdrawalDetails (String withdrawalText) {

        this.withdrawalText = withdrawalText;

    }

    // Extract Entity
    public String withdrawalEntity (String withdrawalText){
        int startEntityIndex = withdrawalText.indexOf("-")+2;
        int endEntityIndex = withdrawalText.indexOf("New")-1;

        String entity = withdrawalText.substring(startEntityIndex, endEntityIndex);
        return entity;
    }

    //Extract the amount
    public String withdrawalAmount(String withdrawalText){
        int start = withdrawalText.indexOf("Ksh");
        int end = withdrawalText.indexOf("from")-1;
        String amount = withdrawalText.substring(start, end);
        return amount;
    }

    //Extract the date
    public String withdrawalDate(String withdrawalText){
        int start = withdrawalText.indexOf(".on ")+4;
        int end = withdrawalText.indexOf(" at ");

        String dateString1 = withdrawalText.substring(start, end);
        return dateString1;
    }

    //Extract the time
    public String withdrawalTime(String withdrawalText){
        int start = withdrawalText.indexOf("at")+3;
        int end = withdrawalText.indexOf("Withdraw ");

        String timeString = withdrawalText.substring(start, end);
        return timeString;
    }
}
