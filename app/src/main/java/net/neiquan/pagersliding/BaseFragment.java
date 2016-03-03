package net.neiquan.pagersliding;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * 這個基類可以是Fragment,但是要返回的界面是LoadingPager返回来的界面,因为LoadingPager封装了五种状态返回的不同界面
 * 在Fragment或者Activity中都可以调用LoadingPager
 * 作者:  hjb
 * 时间: 2016/2/17.
 */
public abstract class BaseFragment extends Fragment {

    public View view;

    /**
     * 解决fragment嵌套问题:No activity
     */
    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = initView();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setViews();
        initData();
    }

    /**
     * 初始化View,加载布局
     *
     * @return 布局
     */
    public abstract View initView();

    /**
     * 初始化数据
     */
    public abstract void setViews();

    /**
     * 加载网络数据
     */
    public abstract void initData();
}

