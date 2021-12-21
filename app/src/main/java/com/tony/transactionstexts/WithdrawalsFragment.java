package com.tony.transactionstexts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.tony.transactionstexts.logic.TextTypeDeterminor;
import com.tony.transactionstexts.logic.Transaction;

import java.util.ArrayList;
import java.util.List;

public class WithdrawalsFragment extends Fragment {
    private List<Transaction> withdrawalArrayList;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.withdrawals_fragment, null);

        recyclerView = v.findViewById(R.id.withdrawals_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), withdrawalArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);

        getTextType();

        return v;

    }

    //Gets the text type and it's details which include Entity, Amount, Date and Time the adds them on an array
    private void getTextType() {
        //Call the class TextTypeDeterminor's check text method to get the text details
        TextTypeDeterminor typeDeterminor = new TextTypeDeterminor();


        String[] withdrawalTextList = new String[] {
                "PL79R03ILP Confirmed.on 7/12/21 at 1:08 PMWithdraw Ksh1,000.00 from 406849 - Kathmo Investments Claycity Supermarket clayworks off Thikaroad agg New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL40M1SX4C Confirmed.on 4/12/21 at 4:03 PMWithdraw Ksh700.00 from 244605 - Sikinya Transporters Old Nation Centre Building New M-PESA balance is Ksh82.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 298,160.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 7/12/21 at 1:08 PMWithdraw Ksh1,000.00 from 406849 - Kathmo Investments Claycity Supermarket clayworks off Thikaroad agg New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 7/12/21 at 1:08 PMWithdraw Ksh45,000.00 from 406849 - Texan Investments New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 13/11/21 at 1:08 PMWithdraw Ksh114,000.00 from 406849 - Muthokinju Comms Claycity New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 6/12/21 at 1:08 PMWithdraw Ksh13,000.00 from 406849 - Clay City Investment New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 3/09/21 at 1:08 PMWithdraw Ksh20,000.00 from 406849 - Elison Investments New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 8/10/21 at 1:08 PMWithdraw Ksh8,000.00 from 406849 - Comms Comm New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 7/11/21 at 1:08 PMWithdraw Ksh1,000.00 from 406849 - Kathmo Investments Claycity Supermarket clayworks off Thikaroad agg New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 1/12/21 at 1:08 PMWithdraw Ksh111,000.00 from 406849 - Ent Cuddles New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 12/12/21 at 1:08 PMWithdraw Ksh1,000.00 from 406849 - Kathmo Investments Claycity Supermarket clayworks off Thikaroad agg New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 13/12/21 at 1:08 PMWithdraw Ksh2,000.00 from 406849 - Bell Comms New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm",
                "PL79R03ILP Confirmed.on 16/12/21 at 1:08 PMWithdraw Ksh1,000.00 from 406849 - Taxan Investment New M-PESA balance is Ksh2,824.76. Transaction cost, Ksh28.00. Amount you can transact within the day is 299,000.00.Get your M-PESA statement on M-PESA App http://bit.ly/mpesappsm"
        };


        for (int i = 0; i < withdrawalTextList.length; i++){

            String mpesaText = withdrawalTextList[i];

            typeDeterminor.checkTransaction(mpesaText);

            //Get the text details
            String entity = typeDeterminor.senderName;
            String amount = typeDeterminor.amount;
            String date = typeDeterminor.date;
            String time = typeDeterminor.time;

            withdrawalArrayList.add(new Transaction(entity, amount, date, time));

        }


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize the array
        withdrawalArrayList = new ArrayList<>();

    }
}
