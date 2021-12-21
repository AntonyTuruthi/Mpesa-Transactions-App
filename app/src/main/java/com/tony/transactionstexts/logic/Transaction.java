package com.tony.transactionstexts.logic;

public class Transaction {
    String entity;
    String amount;
    String date;
    String time;

    public Transaction(String entity, String amount, String date, String time) {
        this.entity = entity;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    public String getEntity() {
        return entity;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }


}
