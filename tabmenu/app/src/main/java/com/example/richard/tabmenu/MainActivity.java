package com.example.richard.tabmenu;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItem;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItems;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class MainActivity extends Activity {

    private final ViewPager.OnPageChangeListener mPageChangeListener =
            new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    View page = mAdapter.getPage(position);
                    if (page == null) {
                        showToast("page is null");
                        return;
                    }

                    RecyclerView cardList = (RecyclerView) page.findViewById(R.id.cardList);
                    if (cardList == null) {
                        showToast("cardList is null");
                    }

                    showToast("cardList is not null");
                }
            };

    private ViewPagerItemAdapter mAdapter;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);

        mAdapter = new ViewPagerItemAdapter(ViewPagerItems.with(this)
                .add(new ViewPagerSampleItem("A", R.layout.page))
                .add(new ViewPagerSampleItem("B", R.layout.page))
                .add(new ViewPagerSampleItem("C", R.layout.page))
                .add(new ViewPagerSampleItem("D", R.layout.page))
                .create());

        viewPager.setAdapter(mAdapter);
        viewPagerTab.setViewPager(viewPager);
        viewPagerTab.setOnPageChangeListener(mPageChangeListener);

    }

    private void showToast(String text) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, text, Toast.LENGTH_LONG);
        mToast.show();
    }

    private static class ViewPagerSampleItem extends ViewPagerItem {

        private ViewPagerSampleItem(CharSequence title, int resource) {
            super(title, DEFAULT_WIDTH, resource);
        }

        @Override
        public View initiate(LayoutInflater inflater, ViewGroup container) {
            View page = super.initiate(inflater, container);

            RecyclerView cardList = (RecyclerView) page.findViewById(R.id.cardList);
            cardList.setHasFixedSize(true);
            GridLayoutManager llm = new GridLayoutManager(page.getContext(), 3);
            cardList.setLayoutManager(llm);

            return page;
        }

    }

}