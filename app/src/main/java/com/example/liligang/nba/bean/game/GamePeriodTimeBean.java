package com.example.liligang.nba.bean.game;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liligang on 2018/3/25.
 */

public class GamePeriodTimeBean {

    /**
     * period_value :
     * period_status : 1:00 pm ET
     * game_status : 1
     * game_clock :
     * total_periods : 4
     * period_name : Qtr
     */

    @SerializedName("period_value")
    private String mPeriodValue;

    @SerializedName("period_status")
    private String mPeriodStatus;

    @SerializedName("game_status")
    private String mGameStatus;

    @SerializedName("game_clock")
    private String mGameClock;

    @SerializedName("total_periods")
    private String mTotalPeriods;

    @SerializedName("period_name")
    private String mPeriodName;


    public String getPeriodValue() {
        return mPeriodValue;
    }

    public void setPeriodValue(String periodValue) {
        mPeriodValue = periodValue;
    }

    public String getPeriodStatus() {
        return mPeriodStatus;
    }

    public void setPeriodStatus(String periodStatus) {
        mPeriodStatus = periodStatus;
    }

    public String getGameStatus() {
        return mGameStatus;
    }

    public void setGameStatus(String gameStatus) {
        mGameStatus = gameStatus;
    }

    public String getGameClock() {
        return mGameClock;
    }

    public void setGameClock(String gameClock) {
        mGameClock = gameClock;
    }

    public String getTotalPeriods() {
        return mTotalPeriods;
    }

    public void setTotalPeriods(String totalPeriods) {
        mTotalPeriods = totalPeriods;
    }

    public String getPeriodName() {
        return mPeriodName;
    }

    public void setPeriodName(String periodName) {
        mPeriodName = periodName;
    }
}
