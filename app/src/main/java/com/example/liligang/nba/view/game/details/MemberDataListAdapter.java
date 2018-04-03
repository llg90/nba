package com.example.liligang.nba.view.game.details;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liligang.nba.R;
import com.example.liligang.nba.base.BaseMAdapter;
import com.example.liligang.nba.bean.game.details.GameDetailsPlayerBean;

import java.util.List;

public class MemberDataListAdapter extends BaseMAdapter<GameDetailsPlayerBean> {

    public MemberDataListAdapter(@NonNull List<GameDetailsPlayerBean> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_game_details_member, parent, false);
        }
//        ((TextView) convertView).setText(getItem(position));
        return convertView;
    }
}
