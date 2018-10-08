package com.xgs.androiddemo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by W.J on 2018/10/8.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter{
    List<String> tabList;
    List<Fragment> fragmentList;
    public FragmentAdapter(FragmentManager fm, List<String> tabList,List<Fragment> fragmentList) {
        super(fm);
        this.tabList = tabList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }
}
