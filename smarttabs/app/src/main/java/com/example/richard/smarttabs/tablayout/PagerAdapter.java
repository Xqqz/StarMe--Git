package com.example.richard.smarttabs.tablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.richard.smarttabs.audioplayer.Audio;
import com.example.richard.smarttabs.R;

import java.util.ArrayList;

/**
 * Created by richard on 28.03.2018.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    String tabTitles[] = new String[] { "Recommended", "Popular", "Rock", "Pop", "Blues", "Chill" };
    Context context;
    private ArrayList<Audio> audioList;

    public PagerAdapter(FragmentManager fm, Context context, ArrayList<Audio> audioList) {
        super(fm);
        this.context = context;
        this.audioList = audioList;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
            return BlankFragment.newInstance(tabTitles[position], audioList);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }


    public View getTabView(int position) {
        View tab = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) tab.findViewById(R.id.custom_text);
        tv.setText(tabTitles[position]);
        return tab;
    }

}

