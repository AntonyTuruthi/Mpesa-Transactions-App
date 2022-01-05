package com.tony.transactionstexts;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerViewAdapter extends FragmentPagerAdapter {

    public PagerViewAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new WithdrawalsFragment();
                break;

            case 1:
                fragment = new ReceivedFragment();
                break;

            case 2:
                fragment = new PaymentsFragment();
                break;
            case 3:
                fragment = new SentsFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
