package com.example.liligang.nba.bean.game;

import com.alibaba.fastjson.annotation.JSONField;

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

    @JSONField(name="period_value")
    private String mPeriodValue; //节数

    @JSONField(name="period_name")
    private String mPeriodName; //节数名称Q1 Q2 Q3 Q4

    @JSONField(name="score")
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
