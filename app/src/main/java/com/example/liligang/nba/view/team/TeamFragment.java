package com.example.liligang.nba.view.team;

import android.view.View;

import com.example.liligang.nba.R;
import com.example.liligang.nba.base.BaseLazyLoadFragment;
import com.example.liligang.nba.bean.team.TeamResponseBean;
import com.example.liligang.nba.net.NetObserver;
import com.example.liligang.nba.net.SingletonNetServer;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liligang on 2018/3/27.
 */

public class TeamFragment extends BaseLazyLoadFragment {


    @Override
    protected void getData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_team;
    }

    @Override
    protected void initView(View convertView) {

    }
}
