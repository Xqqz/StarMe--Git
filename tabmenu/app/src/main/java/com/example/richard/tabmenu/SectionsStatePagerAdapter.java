package com.example.richard.tabmenu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richard on 28.03.2018.
 */

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragmentList =  new ArrayList<>();
    private final List<String> fragmentTitle =  new ArrayList<>();

    public SectionsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentTitle.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
