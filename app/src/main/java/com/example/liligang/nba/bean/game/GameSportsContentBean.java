package com.example.liligang.nba.bean.game;

import com.example.liligang.nba.bean.sports.SeasonMetaBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by liligang on 2018/3/25.
 */

public class GameSportsContentBean {

    @SerializedName("sports_meta")
    private SeasonMetaBean mSportsMeta;

    @SerializedName("games")
    private GamesBean mGames;

    public SeasonMetaBean getSportsMeta() {
        return mSportsMeta;
    }

    public void setSportsMeta(SeasonMetaBean sportsMeta) {
        mSportsMeta = sportsMeta;
    }

    public GamesBean getGames() {
        return mGames;
    }

    public void setGames(GamesBean games) {
        mGames = games;
    }
}
