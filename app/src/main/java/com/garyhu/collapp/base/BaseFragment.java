package com.garyhu.collapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 作者： garyhu.
 * 时间： 2016/12/22.
 */

public abstract class BaseFragment extends SupportFragment {

    protected Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutRes(),null);
        unbinder = ButterKnife.bind(this,view);
        initData();
        setListener();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public abstract int getLayoutRes();

    protected abstract void initData();

    protected abstract void setListener();

    @Override
    public void onDestroy() {
        if(unbinder!=null)
            unbinder.unbind();
        super.onDestroy();
    }
}
