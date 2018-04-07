package com.example.liligang.nba.bean.game.details;

import com.alibaba.fastjson.annotation.JSONField;

public class GameDetailsResponseBean {
    @JSONField(name="sports_content")
    private GameDetailsContentBean mGameDetailsContent;

    public GameDetailsContentBean getGameDetailsContent() {
        return mGameDetailsContent;
    }

    public void setGameDetailsContent(GameDetailsContentBean gameDetailsContentBean) {
        mGameDetailsContent = gameDetailsContentBean;
    }
}
