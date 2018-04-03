package com.example.liligang.nba.bean.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GamesBean {
    @SerializedName("game")
    private List<GameBean> mGame;

    public List<GameBean> getGame() {
        return mGame;
    }

    public void setGame(List<GameBean> games) {
        mGame = games;
    }
}
