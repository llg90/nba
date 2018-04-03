package com.example.liligang.nba.bean.game;

import java.util.List;

/**
 * Created by liligang on 2018/3/26.
 * 每节得分列表bean
 */

public class GameLinescoresBean {
    private List<GameLinescoresPeriodBean> period;

    public List<GameLinescoresPeriodBean> getPeriod() {
        return period;
    }

    public void setPeriod(List<GameLinescoresPeriodBean> period) {
        this.period = period;
    }
}
