package com.example.liligang.nba.bean.team;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class TeamRowSetBean {
    @JSONField(name="rowSet")
    private List<List<Object>> rowSet;
}
