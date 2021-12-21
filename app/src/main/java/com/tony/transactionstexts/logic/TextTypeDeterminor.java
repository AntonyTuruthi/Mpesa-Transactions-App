package com.tony.transactionstexts.logic;

public class TextTypeDeterminor {

    public String senderName;
    public String amount;
    public String date;
    public String time;

    //Determines which type of transaction the text represents
    public void checkTransaction(String mpesaText) {

        //check if the transaction is a withdrawal and get the entity, amount, date and time
        if (mpesaText.contains("Withdraw")){

            WithdrawalDetails withDrawals = new WithdrawalDetails(mpesaText);
            senderName = withDrawals.withdrawalEntity(withDrawals.withdrawalText);
            amount = withDrawals.withdrawalAmount(withDrawals.withdrawalText);
            date = withDrawals.withdrawalDate(withDrawals.withdrawalText);
            time = withDrawals.withdrawalTime(withDrawals.withdrawalText);

        }
        else {
            //check if the transaction message is a receivable and print the entity and amount
            if (mpesaText.contains("received")){

                ReceivableDetails receivables = new ReceivableDetails(mpesaText);
                senderName = receivables.senderName(receivables.receiveText);
                amount = receivables.receivedAmount(receivables.receiveText);
                date = receivables.receivedDate(receivables.receiveText);
                time = receivables.receivedTime(receivables.receiveText);

            }
        }
    }
}
