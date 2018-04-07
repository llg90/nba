package com.example.liligang.nba.bean.game;

import com.alibaba.fastjson.annotation.JSONField;

public class GameResponseBean {
    @JSONField(name="sports_content")
    private GameSportsContentBean mGameSportsContentBean;

    public GameSportsContentBean getGameSportsContentBean() {
        return mGameSportsContentBean;
    }

    public void setGameSportsContentBean(GameSportsContentBean gameSportsContentBean) {
        mGameSportsContentBean = gameSportsContentBean;
    }
}
