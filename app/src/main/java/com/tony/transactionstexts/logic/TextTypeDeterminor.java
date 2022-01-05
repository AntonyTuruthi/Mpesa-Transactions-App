package com.tony.transactionstexts.logic;

public class TextTypeDeterminor {

    public String entity;
    public String amount;
    public String date;
    public String time;

    //Determines which type of transaction the text represents
    public void checkTransaction(String mpesaText) {

        //check if the transaction is a withdrawal and get the entity, amount, date and time
        if (mpesaText.contains("Withdraw")){

            WithdrawalDetails withDrawals = new WithdrawalDetails(mpesaText);
            entity = withDrawals.withdrawalEntity(withDrawals.withdrawalText);
            amount = withDrawals.withdrawalAmount(withDrawals.withdrawalText);
            date = withDrawals.withdrawalDate(withDrawals.withdrawalText);
            time = withDrawals.withdrawalTime(withDrawals.withdrawalText);

        }
        else if (mpesaText.contains("received")){
            //check if the transaction message is a receivable and print the entity and amount

                ReceivableDetails receivables = new ReceivableDetails(mpesaText);
                entity = receivables.senderName(receivables.receiveText);
                amount = receivables.receivedAmount(receivables.receiveText);
                date = receivables.receivedDate(receivables.receiveText);
//                time = receivables.receivedTime(receivables.receiveText);
        }
        else if (mpesaText.contains("paid to")){
            //check if the transaction message is a payment and print the entity and amount

            PaymentDetails paymentDetails = new PaymentDetails(mpesaText);
            entity = paymentDetails.paymentEntity(paymentDetails.paidToText);
            amount = paymentDetails.paidAmount(paymentDetails.paidToText);
            date = paymentDetails.paidDate(paymentDetails.paidToText);
        } else {
            //check if the transaction message is a sent and print the entity and amount

            SentDetails sentDetails = new SentDetails(mpesaText);
            entity = sentDetails.sentEntity(sentDetails.sentText);
            amount = sentDetails.sentAmount(sentDetails.sentText);
            date = sentDetails.sentDate(sentDetails.sentText);
        }
    }
}
