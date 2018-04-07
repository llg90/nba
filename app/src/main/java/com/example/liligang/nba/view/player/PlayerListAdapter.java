package com.example.liligang.nba.view.player;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liligang.nba.R;
import com.example.liligang.nba.base.BaseMAdapter;

import java.util.List;
import java.util.Locale;

public class PlayerListAdapter extends BaseMAdapter<Object[]> {

    public PlayerListAdapter(@NonNull List<Object[]> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_player, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(R.id.tag_view_holder, holder);
        } else {
            holder = (ViewHolder) convertView.getTag(R.id.tag_view_holder);
        }

        Object[] data = getItem(position);
        holder.mNameView.setText((String) data[2]);
        holder.mTeamNameView.setText(String.format(Locale.getDefault(), "%s %s", data[8], data[9]));
        return convertView;
    }

    static class ViewHolder {
        TextView mNameView;
        TextView mTeamNameView;

        public ViewHolder(View v) {
            mNameView     = v.findViewById(R.id.name_view);
            mTeamNameView = v.findViewById(R.id.team_name_view);
        }
    }
}
