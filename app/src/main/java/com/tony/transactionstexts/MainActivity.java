package com.tony.transactionstexts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.tony.transactionstexts.logic.Transaction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tabItem1, tabItem2, tabItem3, tabItem4;

    //selected tab number. We have 3 tabs so value must lie between 1 -3
    //we are setting default value 1 because by default first tab will be selected.
    private int selectedTabNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabItem1 = findViewById(R.id.tabItem_withdrawals);
        tabItem2 = findViewById(R.id.tabItem_receives);
        tabItem3 = findViewById(R.id.tabItem_payments);
        tabItem4 = findViewById(R.id.tabItem_sents);

        //selecting first fragment by default
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, WithdrawalsFragment.class, null)
                .commit();

        tabItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTab(1);
            }
        });

        tabItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTab(2);
            }
        });

        tabItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTab(3);
            }
        });

        tabItem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTab(4);
            }
        });
    }

    private void selectTab(int tabNumber){
        TextView selectedTextView;

        TextView nonSelectedTextView1;
        TextView nonSelectedTextView2;
        TextView nonSelectedTextView3;

        //if you have more than 3 tabs then create nonSelectedTextView3....n

        if (tabNumber == 1){
            //user has selected first tab so 1st TextView is selected.
            selectedTextView = tabItem1;

            //other 2 TextViews are non selected
            nonSelectedTextView1 = tabItem2;
            nonSelectedTextView2 = tabItem3;
            nonSelectedTextView3 = tabItem4;

            //setting fragment to the fragment container view
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, WithdrawalsFragment.class, null)
                    .commit();
        }

        else if (tabNumber == 2){
            //user has selected second tab so 2nd TextView is selected.
            selectedTextView = tabItem2;

            //other 2 TextViews are non selected. 1st and 3rd tabs are non selected
            nonSelectedTextView1 = tabItem1;
            nonSelectedTextView2 = tabItem3;
            nonSelectedTextView3 = tabItem4;

            //setting fragment to the fragment container view
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, ReceivesFragment.class, null)
                    .commit();
        }

        else if (tabNumber == 3){
            //user has selected third tab so 3rd TextView is selected.
            selectedTextView = tabItem3;

            //other 2 TextViews are non selected. 1st and 2nd tabs are non selected
            nonSelectedTextView1 = tabItem1;
            nonSelectedTextView2 = tabItem2;
            nonSelectedTextView3 = tabItem4;

            //setting fragment to the fragment container view
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, PaymentsFragment.class, null)
                    .commit();

        }

        else{
            //user has selected first tab so 1st TextView is selected.
            selectedTextView = tabItem4;

            //other 2 TextViews are non selected
            nonSelectedTextView1 = tabItem1;
            nonSelectedTextView2 = tabItem2;
            nonSelectedTextView3 = tabItem3;

            //setting fragment to the fragment container view
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, SentFragment.class, null)
                    .commit();
        }

        float slideTo = (tabNumber - selectedTabNumber) * selectedTextView.getWidth();

        //creating translate animation
        TranslateAnimation translateAnimation = new TranslateAnimation(0, slideTo, 0, 0);
        translateAnimation.setDuration(100);

        //checking for previously selected tab
        if (selectedTabNumber == 1){
            tabItem1.startAnimation(translateAnimation);
        }
        else if (selectedTabNumber == 2){
            tabItem2.startAnimation(translateAnimation);
        }
        else if (selectedTabNumber == 3){
            tabItem3.startAnimation(translateAnimation);
        }
        else {
            tabItem4.startAnimation(translateAnimation);
        }

        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                // change design of selected tab's TextView
                selectedTextView.setBackgroundResource(R.drawable.round_back_white_100);
                selectedTextView.setTypeface(null, Typeface.BOLD);
                selectedTextView.setTextColor(Color.BLACK);

                // change design of the selected tab's TextViews
                nonSelectedTextView1.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                nonSelectedTextView1.setTextColor(Color.parseColor("#80FFFFFF"));
                nonSelectedTextView1.setTypeface(null, Typeface.NORMAL);

                nonSelectedTextView2.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                nonSelectedTextView2.setTextColor(Color.parseColor("#80FFFFFF"));
                nonSelectedTextView2.setTypeface(null, Typeface.NORMAL);

                nonSelectedTextView3.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                nonSelectedTextView3.setTextColor(Color.parseColor("#80FFFFFF"));
                nonSelectedTextView3.setTypeface(null, Typeface.NORMAL);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        selectedTabNumber = tabNumber;


    }
    }
