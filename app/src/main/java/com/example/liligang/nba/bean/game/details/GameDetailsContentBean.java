package com.example.liligang.nba.bean.game.details;

import com.google.gson.annotations.SerializedName;

public class GameDetailsContentBean {
    @SerializedName("game")
    private GameDetailsGameBean mGame;

    public GameDetailsGameBean getGame() {
        return mGame;
    }

    public void setGame(GameDetailsGameBean game) {
        mGame = game;
    }
}
