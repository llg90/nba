package com.example.liligang.nba.bean.player;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class PlayerResponseBean {
    @JSONField(name="resource")
    private String resource;

    @JSONField(name = "parameters")
    private PlayerParametersBean parameters;

    @JSONField(name="resultSets")
    private List<PlayerResultSetsBean> resultSets;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public PlayerParametersBean getParameters() {
        return parameters;
    }

    public void setParameters(PlayerParametersBean parameters) {
        this.parameters = parameters;
    }

    public List<PlayerResultSetsBean> getResultSets() {
        return resultSets;
    }

    public void setResultSets(List<PlayerResultSetsBean> resultSets) {
        this.resultSets = resultSets;
    }
}
