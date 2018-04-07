package com.example.liligang.nba.bean.player;

import com.alibaba.fastjson.annotation.JSONField;

public class PlayerParametersBean {
    @JSONField(name="LeagueID")
    private String LeagueID;

    @JSONField(name = "Season")
    private String Season;

    @JSONField(name = "IsOnlyCurrentSeason")
    private String IsOnlyCurrentSeason;

    public String getLeagueID() {
        return LeagueID;
    }

    public void setLeagueID(String leagueID) {
        LeagueID = leagueID;
    }

    public String getSeason() {
        return Season;
    }

    public void setSeason(String season) {
        Season = season;
    }

    public String getIsOnlyCurrentSeason() {
        return IsOnlyCurrentSeason;
    }

    public void setIsOnlyCurrentSeason(String isOnlyCurrentSeason) {
        IsOnlyCurrentSeason = isOnlyCurrentSeason;
    }
}
