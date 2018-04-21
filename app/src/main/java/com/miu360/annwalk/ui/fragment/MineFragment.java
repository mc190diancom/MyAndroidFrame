package com.miu360.annwalk.ui.fragment;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miu360.annwalk.R;
import com.miu360.annwalk.base.contract.BaseFragment;
import com.miu360.annwalk.base.contract.MineContract;
import com.miu360.annwalk.databinding.FragmentMineBinding;
import com.miu360.annwalk.presenter.MinePresenter;

/**
 * Created by Murphy on 2018/4/19.
 * 界面——我的
 */

public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.View{

    private FragmentMineBinding mBinding;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine,container,false);
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
