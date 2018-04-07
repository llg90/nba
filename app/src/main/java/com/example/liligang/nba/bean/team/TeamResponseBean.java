package com.example.liligang.nba.bean.team;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class TeamResponseBean {
    @JSONField(name="resultSets")
    private List<TeamResultSetsBean> resultSets;
}
