package com.nitt.karaens.npsc18;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ScheduleActivity extends AppCompatActivity {

    ViewPager mViewPager;
    ViewPageAdapter vpAdapter=new ViewPageAdapter(getSupportFragmentManager());
    TabLayout mTabLayout;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        mViewPager = findViewById(R.id.viewpager);
        mTabLayout=findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
        mToolbar=findViewById(R.id.toolbar);
        mToolbar.setTitle("SCHEDULE");
        setSupportActionBar(mToolbar);

        mViewPager.setOffscreenPageLimit(2);
        addFrags();

    }





    void addFrags() {
        if (vpAdapter.getCount() == 0) {
            vpAdapter.addFragment(new Day1Frag());
            vpAdapter.notifyDataSetChanged();
            vpAdapter.addFragment(new Day2Frag());
            vpAdapter.notifyDataSetChanged();
            vpAdapter.addFragment(new Day3Frag());
            vpAdapter.notifyDataSetChanged();
            mViewPager.setAdapter(vpAdapter);
        }
    }

}
