package com.xgs.androiddemo.design;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.xgs.androiddemo.R;
import com.xgs.androiddemo.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabActivity extends AppCompatActivity {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);

        List<String> tabList = new ArrayList<String>();
        tabList.add("火箭");
        tabList.add("湖人");
        tabList.add("马刺");
        tabList.add("雷霆");
        tabList.add("凯尔特人");
        tabList.add("开拓者");
        tabList.add("骑士");
        tabList.add("森林狼");
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        for (int i = 0; i < tabList.size(); i++) {
            fragmentList.add(new ListFragment());
            tabLayout.addTab(tabLayout.newTab().setText(tabList.get(i)));
        }
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), tabList, fragmentList);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(fragmentAdapter);
    }
}
