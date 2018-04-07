package com.example.liligang.nba.bean.player.detail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class PlayerDetailResultSetsBean {
    @JSONField(name = "rowSet")
    private List<Object[]> rowSet;

    public List<Object[]> getRowSet() {
        return rowSet;
    }

    public void setRowSet(List<Object[]> rowSet) {
        this.rowSet = rowSet;
    }
}
