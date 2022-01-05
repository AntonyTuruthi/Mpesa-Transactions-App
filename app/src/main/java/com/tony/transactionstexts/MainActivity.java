package com.tony.transactionstexts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tony.transactionstexts.logic.Transaction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PagerViewAdapter pagerViewAdapter;
    TextView textView_withdrawals, textView_received, textView_payments, textView_sents;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView_withdrawals = findViewById(R.id.withdrawals_fragment_label);
        textView_received = findViewById(R.id.received_fragment_label);
        textView_payments = findViewById(R.id.payments_fragment_label);
        textView_sents = findViewById(R.id.sents_fragment_label);

        viewPager = findViewById(R.id.fragmentContainer);

        textView_withdrawals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

        textView_received.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

        textView_payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        textView_sents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
            }
        });

        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerViewAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onChangeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void onChangeTab(int position) {


        if (position == 0){
            textView_withdrawals.setTextSize(25);
            textView_withdrawals.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.green));
            textView_received.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));
            textView_received.setTextSize(15);
            textView_payments.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));
            textView_payments.setTextSize(15);
            textView_sents.setTextSize(15);
            textView_sents.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));
        }

        if (position == 1){
            textView_withdrawals.setTextSize(15);
            textView_withdrawals.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));
            textView_received.setTextSize(25);
            textView_received.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.green));
            textView_payments.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));
            textView_payments.setTextSize(15);
            textView_sents.setTextSize(15);
            textView_sents.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));


        }

        if (position == 2){
            textView_withdrawals.setTextSize(15);
            textView_withdrawals.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));
            textView_received.setTextSize(15);
            textView_received.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));
            textView_payments.setTextSize(25);
            textView_payments.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.green));
            textView_sents.setTextSize(15);
            textView_sents.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));

        }

        if (position == 3){
            textView_withdrawals.setTextSize(15);
            textView_withdrawals.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));
            textView_received.setTextSize(15);
            textView_received.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));
            textView_payments.setTextSize(15);
            textView_payments.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.white));
            textView_sents.setTextSize(25);
            textView_sents.setBackgroundColor(ContextCompat.getColor(textView_received.getContext(), R.color.green));

        }


    }


}