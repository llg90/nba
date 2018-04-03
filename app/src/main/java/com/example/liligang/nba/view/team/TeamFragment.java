package com.example.liligang.nba.view.team;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liligang.nba.R;
import com.example.liligang.nba.base.BaseFragment;

/**
 * Created by liligang on 2018/3/27.
 */

public class TeamFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_team, container, false);
        return contentView;
    }
}
