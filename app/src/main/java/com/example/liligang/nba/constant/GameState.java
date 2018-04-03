package com.example.liligang.nba.constant;

public enum  GameState {
    UNDEFINED,UNSTART,LIVE,OVER;

    public static GameState getFormValue(int value) {
        GameState gameState = UNDEFINED;
        for (GameState item : GameState.values()) {
            if (item.ordinal() == value) {
                gameState = item;
            }
        }
        return gameState;
    }
}
