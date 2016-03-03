package net.neiquan.pagersliding;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * 作者:  hjb
 * 时间: 2016/3/3.
 */
public class TabFragment extends BaseViewPagerFragment {

    @Override
    public ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        return fragments;
    }

    @Override
    public String[] getTitle() {
        String[] stringArray = getActivity().getResources().getStringArray(R.array.tabs_arrays);
        return stringArray;
    }
}
