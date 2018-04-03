package com.example.liligang.nba.net;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.liligang.nba.NbaApplication;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wang.avi.AVLoadingIndicatorView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class NetObserver<T> implements Observer<T> {
    private AVLoadingIndicatorView mAVLoadingIndicatorView;
    private SmartRefreshLayout mSmartRefreshLayout;

    public NetObserver() {
        super();
    }

    protected NetObserver(AVLoadingIndicatorView loadingIndicatorView) {
        super();
        mAVLoadingIndicatorView = loadingIndicatorView;
        if (mAVLoadingIndicatorView != null) {
            mAVLoadingIndicatorView.show();
        }
    }

    protected NetObserver(SmartRefreshLayout smartRefreshLayout) {
        super();
        mSmartRefreshLayout = smartRefreshLayout;
        if (mAVLoadingIndicatorView != null) {
            mAVLoadingIndicatorView.show();
        }
    }

    protected NetObserver(AVLoadingIndicatorView loadingIndicatorView, SmartRefreshLayout smartRefreshLayout) {
        super();
        mAVLoadingIndicatorView = loadingIndicatorView;
        mSmartRefreshLayout     = smartRefreshLayout;
        if (mAVLoadingIndicatorView != null) {
            mAVLoadingIndicatorView.show();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onError(Throwable e) {
        Context context = NbaApplication.getContext();
        if (context != null) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
        Log.e("okhttp", e.toString());
        if (mAVLoadingIndicatorView != null) {
            mAVLoadingIndicatorView.hide();
        }

        if (mSmartRefreshLayout != null && mSmartRefreshLayout.isEnableRefresh()) {
            mSmartRefreshLayout.finishRefresh();
        }
    }

    @Override
    public void onComplete() {
        if (mAVLoadingIndicatorView != null) {
            mAVLoadingIndicatorView.hide();
        }

        if (mSmartRefreshLayout != null && mSmartRefreshLayout.isEnableRefresh()) {
            mSmartRefreshLayout.finishRefresh();
        }
    }
}
