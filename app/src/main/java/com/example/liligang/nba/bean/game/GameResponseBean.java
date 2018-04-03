package com.example.liligang.nba.bean.game;

import com.google.gson.annotations.SerializedName;

public class GameResponseBean {
    @SerializedName("sports_content")
    private GameSportsContentBean mGameSportsContentBean;

    public GameSportsContentBean getGameSportsContentBean() {
        return mGameSportsContentBean;
    }

    public void setGameSportsContentBean(GameSportsContentBean gameSportsContentBean) {
        mGameSportsContentBean = gameSportsContentBean;
    }
}
