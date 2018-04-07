package com.example.liligang.nba.bean.game;

import com.alibaba.fastjson.annotation.JSONField;

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

    @JSONField(name="period_value")
    private String mPeriodValue;

    @JSONField(name="period_status")
    private String mPeriodStatus;

    @JSONField(name="game_status")
    private String mGameStatus;

    @JSONField(name="game_clock")
    private String mGameClock;

    @JSONField(name="total_periods")
    private String mTotalPeriods;

    @JSONField(name="period_name")
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
