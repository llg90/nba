package com.example.liligang.nba.bean.game;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liligang on 2018/3/26.
 * 单节得分bean
 */

public class GameLinescoresPeriodBean {

    /**
     * period_value : 1
     * period_name : Q1
     * score : 28
     */

    @SerializedName("period_value")
    private String mPeriodValue; //节数

    @SerializedName("period_name")
    private String mPeriodName; //节数名称Q1 Q2 Q3 Q4

    @SerializedName("score")
    private String score; //得分

    public String getPeriodValue() {
        return mPeriodValue;
    }

    public void setPeriodValue(String periodValue) {
        mPeriodValue = periodValue;
    }

    public String getPeriodName() {
        return mPeriodName;
    }

    public void setPeriodName(String periodName) {
        mPeriodName = periodName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
