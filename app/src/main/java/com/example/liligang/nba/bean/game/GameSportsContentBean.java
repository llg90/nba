package com.example.liligang.nba.bean.game;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.liligang.nba.bean.sports.SeasonMetaBean;

/**
 * Created by liligang on 2018/3/25.
 */

public class GameSportsContentBean {

    @JSONField(name="sports_meta")
    private SeasonMetaBean mSportsMeta;

    @JSONField(name="games")
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
