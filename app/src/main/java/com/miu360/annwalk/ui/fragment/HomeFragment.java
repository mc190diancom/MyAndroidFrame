package com.miu360.annwalk.ui.fragment;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miu360.annwalk.R;
import com.miu360.annwalk.base.BaseFragment;
import com.miu360.annwalk.base.contract.HomeContract;
import com.miu360.annwalk.databinding.FragmentHomeBinding;
import com.miu360.annwalk.presenter.HomePresenter;

/**
 * Created by Murphy on 2018/4/19.
 * 界面——首页
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View{

    private FragmentHomeBinding mBinding;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected View getLayout(LayoutInflater inflater,ViewGroup container) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        return mBinding.getRoot();
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getShowData();
    }

    @Override
    public void showView(String content) {
        mBinding.tvContent.setText(content);
    }
}
