package com.example.liligang.nba.view.game.details;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_game_details_member_data, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(R.id.tag_view_holder, holder);
        } else {
            holder = (ViewHolder) convertView.getTag(R.id.tag_view_holder);
        }

        GameDetailsPlayerBean data = getItem(position);
        String startingPosition = data.getStartingPosition();
        if (startingPosition == null || startingPosition.isEmpty()) {
            startingPosition = "-";
        }
        holder.mStartingPosition.setText(startingPosition);

        String points = data.getPoints();
        holder.mPoints.setText(points!=null?points:"");

        String assists = data.getAssists();
        holder.mAssists.setText(assists!=null?assists:"");

        int defensiveOffensive = 0;
        String defensive = data.getReboundsDefensive();
        String offensive = data.getReboundsOffensive();
        if (defensive != null) {
            defensiveOffensive = Integer.parseInt(defensive, 10);
        }

        if (offensive != null) {
            defensiveOffensive =+ Integer.parseInt(offensive, 10);
        }

        holder.mDefensiveOffensive.setText(String.valueOf(defensiveOffensive));

        String goalsMadeAttempted = null;
        String goalsMade      = data.getFieldGoalsMade();
        String goalsAttempted = data.getFieldGoalsAttempted();
        if (goalsMade != null) {
            goalsMadeAttempted = goalsMade;
        }

        if (goalsAttempted != null) {
            goalsMadeAttempted =
                    goalsMadeAttempted==null?
                    goalsAttempted:
                    goalsMadeAttempted + "-" + goalsAttempted;
        }
        holder.mGoalsMadeAttempted.setText(goalsMadeAttempted);

        String blocks = data.getBlocks();
        holder.mBlocks.setText(blocks==null?"":blocks);

        String steals = data.getSteals();
        holder.mSteals.setText(steals==null?"":steals);

        String pointersMadeAttempted = null;
        String pointersMade      = data.getThreePointersMade();
        String pointersAttempted = data.getThreePointersAttempted();
        if (pointersMade != null) {
            pointersMadeAttempted = pointersMade;
        }

        if (pointersAttempted != null) {
            pointersMadeAttempted =
                    pointersMadeAttempted==null?
                            pointersAttempted:
                            pointersMadeAttempted + "-" + pointersAttempted;
        }
        holder.mPointersMadeAttempted.setText(pointersMadeAttempted);

        String throwsMadeAttempted = null;
        String throwsMade      = data.getFreeThrowsMade();
        String throwsAttempted = data.getFreeThrowsAttempted();
        if (throwsMade != null) {
            throwsMadeAttempted = throwsMade;
        }

        if (throwsAttempted != null) {
            throwsMadeAttempted =
                    throwsMadeAttempted==null?
                    throwsAttempted:
                    throwsMadeAttempted + "-" + throwsAttempted;
        }
        holder.mThrowsMadeAttempted.setText(throwsMadeAttempted);

        String turnovers = data.getTurnovers();
        holder.mTurnovers.setText(turnovers==null?"":turnovers);

        String fouls = data.getFouls();
        holder.mFouls.setText(fouls==null?"":fouls);

        String plusMinus = data.getPlusMinus();
        holder.mPlusMinus.setText(plusMinus==null?"":plusMinus);

        String minutes = data.getMinutes();
        holder.mMinutes.setText(minutes==null?"":minutes);

        return convertView;
    }

    static class ViewHolder {
        TextView mStartingPosition;
        TextView mPoints;
        TextView mAssists;
        TextView mDefensiveOffensive;
        TextView mGoalsMadeAttempted;
        TextView mBlocks;
        TextView mSteals;
        TextView mPointersMadeAttempted;
        TextView mThrowsMadeAttempted;
        TextView mTurnovers;
        TextView mFouls;
        TextView mPlusMinus;
        TextView mMinutes;

        ViewHolder(View v) {
            mStartingPosition = v.findViewById(R.id.starting_position_view);
            mPoints  = v.findViewById(R.id.points_view);
            mAssists = v.findViewById(R.id.assists_view);
            mDefensiveOffensive = v.findViewById(R.id.defensive_offensive_view);
            mGoalsMadeAttempted = v.findViewById(R.id.goals_made_attempted_view);
            mBlocks = v.findViewById(R.id.blocks_view);
            mSteals = v.findViewById(R.id.steals_view);
            mPointersMadeAttempted = v.findViewById(R.id.pointers_made_attempted_view);
            mThrowsMadeAttempted   = v.findViewById(R.id.throws_made_attempted_view);
            mTurnovers = v.findViewById(R.id.turnovers_view);
            mFouls     = v.findViewById(R.id.fouls_view);
            mPlusMinus = v.findViewById(R.id.plus_minus_view);
            mMinutes   = v.findViewById(R.id.minutes_view);
        }
    }
}
