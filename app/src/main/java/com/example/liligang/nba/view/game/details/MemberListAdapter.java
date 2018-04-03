package com.example.liligang.nba.view.game.details;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liligang.nba.R;
import com.example.liligang.nba.base.BaseMAdapter;

import java.util.List;

public class MemberListAdapter extends BaseMAdapter<String> {


    public MemberListAdapter(@NonNull List<String> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_game_details_member, parent, false);
        }
        ((TextView) convertView).setText(getItem(position));
        return convertView;
    }
}
