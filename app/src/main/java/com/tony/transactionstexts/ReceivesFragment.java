package com.tony.transactionstexts;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tony.transactionstexts.logic.TextList;
import com.tony.transactionstexts.logic.TextTypeDeterminor;
import com.tony.transactionstexts.logic.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReceivesFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private List<Transaction> receivedArrayList;
    private RecyclerView recyclerView;
    private List<TextList> textList;
    private final static int REQUEST_CODE_PERMISSION_READ_SMS = 456;

    public ReceivesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReceivesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReceivesFragment newInstance(String param1, String param2) {
        ReceivesFragment fragment = new ReceivesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //Initialize the array
        receivedArrayList = new ArrayList<>();
        textList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_receives, null);

        recyclerView = v.findViewById(R.id.received_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), receivedArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);

        if (checkPermission(Manifest.permission.READ_SMS)){
            refreshList();

        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    (Manifest.permission.READ_SMS)}, REQUEST_CODE_PERMISSION_READ_SMS);

        }

        getTextType();

        return v;
    }

    private boolean checkPermission(String permission) {
        int checkPermission = ContextCompat.checkSelfPermission(getContext(), permission);
        return checkPermission == PackageManager.PERMISSION_GRANTED;
    }

    //Gets the text type and it's details which include Entity, Amount, Date and Time the adds them on an array
    private void getTextType() {

        //Call the class TextTypeDeterminor's check text method to get the text details
        TextTypeDeterminor typeDeterminor = new TextTypeDeterminor();

        refreshList();

        for (int i = 0; i < textList.size(); i++){

            String mpesaText = textList.get(i).getTransactionText();

            if (mpesaText.contains("received")) {
                typeDeterminor.checkTransaction(mpesaText);

                //Get the text details
                String senderName = typeDeterminor.entity;
                String amount = typeDeterminor.amount;
                String date = typeDeterminor.date;
//                String time = typeDeterminor.time;

                receivedArrayList.add(new Transaction(senderName, amount, date));

            }

        }

    }

    public void refreshList() {
        ContentResolver cResolver = getActivity().getContentResolver();
        Cursor smsInboxCursor = cResolver.query(Uri.parse("content://sms/inbox"),
                null, null, null, null);

        int indexBody = smsInboxCursor.getColumnIndex("body");
        int indexAddress = smsInboxCursor.getColumnIndex("address");

        if (indexBody < 0 || !smsInboxCursor.moveToFirst()) return;

        do {
            String smsAddress = smsInboxCursor.getString(indexAddress);
            if (smsAddress.equals("MPESA")) {
                String text = smsInboxCursor.getString(indexBody);
                textList.add(new TextList(text));

            }
        } while (smsInboxCursor.moveToNext());

    }
}
