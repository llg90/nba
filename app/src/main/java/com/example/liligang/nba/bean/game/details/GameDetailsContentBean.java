package com.example.liligang.nba.bean.game.details;

import com.alibaba.fastjson.annotation.JSONField;

public class GameDetailsContentBean {
    @JSONField(name="game")
    private GameDetailsGameBean mGame;

    public GameDetailsGameBean getGame() {
        return mGame;
    }

    public void setGame(GameDetailsGameBean game) {
        mGame = game;
    }
}
