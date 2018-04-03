package com.example.liligang.nba.bean.game.details;

import com.google.gson.annotations.SerializedName;

public class GameDetailsResponseBean {
    @SerializedName("sports_content")
    private GameDetailsContentBean mGameDetailsContent;

    public GameDetailsContentBean getGameDetailsContent() {
        return mGameDetailsContent;
    }

    public void setGameDetailsContent(GameDetailsContentBean gameDetailsContentBean) {
        mGameDetailsContent = gameDetailsContentBean;
    }
}
