package net.neiquan.pagersliding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * 作者:  hjb
 * 时间: 2016/3/3.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragments;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
