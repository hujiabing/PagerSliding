package net.neiquan.pagersliding;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import net.neiquan.pagerslidingtabstrip.PagerSlidingTabStrip;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者:  hjb
 * 时间: 2016/3/3.
 */
public abstract class BaseViewPagerFragment extends BaseFragment {


    @InjectView(R.id.pager_tabstrip)
    PagerSlidingTabStrip mPagerTabstrip;
    @InjectView(R.id.pager)
    ViewPager mPager;
    private ArrayList<Fragment> fragments;
    private MyPagerAdapter adapter;

    @Override
    public View initView() {
        view = View.inflate(getActivity(), R.layout.base_viewpage_fragment, null);
        ButterKnife.inject(this, view);
        return view;
    }


    public abstract ArrayList<Fragment> getFragments();

    public abstract String[] getTitle();

    public void addTitle(String[] title) {
        for (int i = 0; i < title.length; i++) {
            View titleView = View.inflate(getActivity(), R.layout.base_viewpage_fragment_tab_item, null);
            TextView tv = (TextView) titleView.findViewById(R.id.tab_title_tv);
            tv.setText(title[i]);
            mPagerTabstrip.addTab(titleView);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setViews() {
        fragments = getFragments();
        adapter = new MyPagerAdapter(getChildFragmentManager(), fragments);
        String[] title = getTitle();
        addTitle(title);
        mPager.setAdapter(adapter);
        mPagerTabstrip.setViewPager(mPager);

    }

    @Override
    public void initData() {

    }
}
