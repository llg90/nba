package com.example.liligang.nba.view.game;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.liligang.nba.R;
import com.example.liligang.nba.base.BaseMAdapter;
import com.example.liligang.nba.bean.game.GameBean;
import com.example.liligang.nba.bean.game.GameHomeBean;
import com.example.liligang.nba.bean.game.GamePeriodTimeBean;
import com.example.liligang.nba.bean.game.GameVisitorBean;
import com.example.liligang.nba.constant.ConstantValue;
import com.example.liligang.nba.constant.GameState;
import com.example.liligang.nba.constant.Team;

import java.util.List;
import java.util.Locale;

/**
 * Created by liligang on 2018/3/28.
 */

public class GameListAdapter extends BaseMAdapter<GameBean> {

    public GameListAdapter(@NonNull List<GameBean> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_game, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(R.id.tag_view_holder, holder);
        } else {
            holder = (ViewHolder) convertView.getTag(R.id.tag_view_holder);
        }

        GameBean data = getItem(position);
        Team homeTeam    = ConstantValue.TEAM_MAP.get(data.getGameHome().getTeamKey());
        Team visitorTeam = ConstantValue.TEAM_MAP.get(data.getGameVisitor().getTeamKey());

        int backgroundColor=android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M?
                parent.getResources().getColor(homeTeam.color, parent.getResources().newTheme())
                :parent.getResources().getColor(homeTeam.color);

        holder.mCardView.setCardBackgroundColor(backgroundColor);
        Glide.with(parent.getContext()).load(homeTeam.logo).into(holder.mHomeIcon);
        Glide.with(parent.getContext()).load(visitorTeam.logo).into(holder.mVisitorIcon);
        holder.mHomeTeamName.setText(homeTeam.team);
        holder.mHomeTeamCityName.setText(homeTeam.city);
        holder.mVisitorTeamName.setText(visitorTeam.team);
        holder.mVisitorTeamCityName.setText(visitorTeam.city);

        String state = "";
        String homeScore = "";
        String visitorScore = "";
        GameHomeBean    gameHome    = data.getGameHome();
        GameVisitorBean gameVisitor = data.getGameVisitor();
        GamePeriodTimeBean periodTime = data.getGamePeriodTime();
        if (periodTime != null) {
            switch (GameState.getFormValue(Integer.parseInt(periodTime.getGameStatus()))) {
                case UNSTART:
                    state = periodTime.getPeriodStatus().toUpperCase();
                    break;
                case LIVE:
                    int periodValue = Integer.parseInt(periodTime.getPeriodValue()) - 1;
                    state = String.format(Locale.getDefault(), "Q%d", periodValue);
                    homeScore = gameHome.getScore();
                    visitorScore = gameVisitor.getScore();
                    break;
                case OVER:
                    state = periodTime.getPeriodStatus();
                    homeScore = gameHome.getScore();
                    visitorScore = gameVisitor.getScore();
                    break;
                default:
                    break;
            }
        }

        holder.mGameState.setText(state);
        holder.mHomeScore.setText(homeScore);
        holder.mVisitorScore.setText(visitorScore);

        return convertView;
    }

    static class ViewHolder {
        CardView mCardView;
        TextView mGameState;

        ImageView mHomeIcon;
        TextView  mHomeTeamCityName;
        TextView  mHomeTeamName;
        TextView  mHomeScore;

        ImageView mVisitorIcon;
        TextView  mVisitorTeamCityName;
        TextView  mVisitorTeamName;
        TextView  mVisitorScore;

        ViewHolder(View v) {
            mCardView  = v.findViewById(R.id.card_view);
            mGameState = v.findViewById(R.id.game_state_view);

            mHomeIcon         = v.findViewById(R.id.home_icon_view);
            mHomeTeamCityName = v.findViewById(R.id.home_team_city_view);
            mHomeTeamName     = v.findViewById(R.id.home_team_name_view);
            mHomeScore        = v.findViewById(R.id.home_score_view);

            mVisitorIcon         = v.findViewById(R.id.visitor_icon_view);
            mVisitorTeamCityName = v.findViewById(R.id.visitor_team_city_view);
            mVisitorTeamName     = v.findViewById(R.id.visitor_team_name_view);
            mVisitorScore        = v.findViewById(R.id.visitor_score_view);


        }
    }
}
