package com.example.whatsapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewpagerFragmentAdapter extends FragmentPagerAdapter {

    public ViewpagerFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

            if(position==0)
                return new chats();
            else if(position==1)
                return new status();
            else
                return new calls();


    }

    @Override
    public int getCount() {
        return 3; // No of Tabs
    }
    public CharSequence getPageTitle(int position)
    {
        if (position == 0)
            return "Chats";
        else if (position == 1)
            return "Status";
        else
            return "Calls";

    }
}
