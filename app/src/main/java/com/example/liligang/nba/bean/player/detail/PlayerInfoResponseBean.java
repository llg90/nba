package com.example.liligang.nba.bean.player.detail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class PlayerInfoResponseBean {
    @JSONField(name = "resultSets")
    private List<PlayerDetailResultSetsBean> resultSets;

    public List<PlayerDetailResultSetsBean> getResultSets() {
        return resultSets;
    }

    public void setResultSets(List<PlayerDetailResultSetsBean> resultSets) {
        this.resultSets = resultSets;
    }
}
