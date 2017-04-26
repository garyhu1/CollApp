package com.garyhu.collapp.activity;

import android.support.v4.app.Fragment;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.garyhu.collapp.R;
import com.garyhu.collapp.base.BaseActivity;
import com.garyhu.collapp.fragment.ForthFragment;
import com.garyhu.collapp.fragment.MainFragment;
import com.garyhu.collapp.fragment.SecondFragment;
import com.garyhu.collapp.fragment.ThirdFragment;
import com.garyhu.collapp.model.TabEntity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 作者： garyhu.
 * 时间： 2016/12/22.
 */

public class FlycoActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.tl)
    CommonTabLayout mTabLayout;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"首页", "快速报价", "我的装修", "我的"};
    private int[] mIconUnselectIds = {
            R.drawable.buttona2,R.drawable.buttonb2,
            R.drawable.buttone1,R.drawable.buttond2};
    private int[] mIconSelectIds = {
            R.drawable.buttona1,R.drawable.buttonb1,
            R.drawable.buttone2,R.drawable.buttond1};
    //tab的标题、选中图标、未选中图标
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_flyco;
    }

    @Override
    protected void init() {
        initData();
        //给tab设置数据和关联的fragment
        mTabLayout.setTabData(mTabEntities, this, R.id.fl_change, mFragments);
    }

    private void initData() {
        mFragments.add(new MainFragment());
        mFragments.add(new SecondFragment());
        mFragments.add(new ThirdFragment());
        mFragments.add(new ForthFragment());
        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
    }

}
