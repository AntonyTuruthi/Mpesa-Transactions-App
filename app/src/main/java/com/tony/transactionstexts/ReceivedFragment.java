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

public class ReceivedFragment extends Fragment {
    private List<Transaction> receivedArrayList;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.received_fragment, null);

        recyclerView = v.findViewById(R.id.received_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), receivedArrayList);
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
                "PL75QZRWMN Confirmed.You have received Ksh3,000.00 from Equity Bulk Account 300600 on 7/12/21 at 1:03 PM New M-PESA balance is Ksh3,852.76.  Separate personal and business funds through Pochi la Biashara on *334#.",
                "PL47L378CL Confirmed.You have received Ksh227.00 from PETER  WANGUGI 0708551251 on 4/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB.",
                "PL22IT823C Confirmed.You have received Ksh1,000.00 from Equity Bulk Account 300600 on 2/12/21 at 7:01 PM New M-PESA balance is Ksh1,453.76.  Separate personal and business funds through Pochi la Biashara on *334#.",
                "PJR3SBYNZ7 Confirmed.You have received Ksh14,000.00 from Equity Bulk Account 300600 on 27/10/21 at 10:38 AM New M-PESA balance is Ksh14,032.07.  Separate personal and business funds through Pochi la Biashara on *334#.",
                "PJU5XP43WN Confirmed.You have received Ksh1,000.00 from Equity Bulk Account 300600 on 30/10/21 at 2:37 PM New M-PESA balance is Ksh1,017.70.  Separate personal and business funds through Pochi la Biashara on *334#.",
                "PJV4Z8OK20 Confirmed.You have received Ksh1,000.00 from Equity Bulk Account 300600 on 31/10/21 at 1:34 PM New M-PESA balance is Ksh1,109.70.  Separate personal and business funds through Pochi la Biashara on *334#.",
                "PL47L378CL Confirmed.You have received Ksh22700.00 from PETER  Maingi 0708551251 on 5/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB.",
                "PL47L378CL Confirmed.You have received Ksh1000.00 from Amos  Karanja 0708551251 on 16/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB.",
                "PL47L378CL Confirmed.You have received Ksh227.00 from Priscila  Mwangi 0708551251 on 26/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB.",
                "PL47L378CL Confirmed.You have received Ksh2000.00 from Kamau  Ngengi 0708551251 on 30/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB.",
                "PL47L378CL Confirmed.You have received Ksh10000.00 from Odipo  Osolo 0708551251 on 15/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB.",
                "PL47L378CL Confirmed.You have received Ksh50000.00 from Franklin  Chepet 0708551251 on 22/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB.",
                "PL47L378CL Confirmed.You have received Ksh1400.00 from Star  Chebet 0708551251 on 3/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB.",
                "PL47L378CL Confirmed.You have received Ksh13000.00 from Mercy  Muthoni 0708551251 on 7/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB.",
                "PL47L378CL Confirmed.You have received Ksh15000.00 from Mwangi  Karanja 0708551251 on 6/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB.",
                "PL47L378CL Confirmed.You have received Ksh459.00 from PETER  Thuku 0708551251 on 8/12/21 at 12:49 AM  New M-PESA balance is Ksh1,962.76.Download M-PESA app on http://bit.ly/mpesappsm & get 500MB."
        };

        for (int i = 0; i < withdrawalTextList.length; i++){

            String mpesaText = withdrawalTextList[i];

            typeDeterminor.checkTransaction(mpesaText);

            //Get the text details
            String senderName = typeDeterminor.senderName;
            String amount = typeDeterminor.amount;
            String date = typeDeterminor.date;
            String time = typeDeterminor.time;

            receivedArrayList.add(new Transaction(senderName, amount, date, time));

        }


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize the array
        receivedArrayList = new ArrayList<>();

    }
}
