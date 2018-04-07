package com.example.liligang.nba.bean.game;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class GamesBean {
    @JSONField(name="game")
    private List<GameBean> mGame;

    public List<GameBean> getGame() {
        return mGame;
    }

    public void setGame(List<GameBean> games) {
        mGame = games;
    }
}
