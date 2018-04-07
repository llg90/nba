package com.example.liligang.nba.bean.game.details;

import com.alibaba.fastjson.annotation.JSONField;

public class GameDetailsMemberBean {

    /**
     * id : 1610612761
     * team_key : TOR
     * city : Toronto
     * abbreviation : TOR
     * nickname : Raptors
     * url_name : raptors
     * team_code : raptors
     * score : 84
     */

    @JSONField(name="id")
    private String mId;

    @JSONField(name="team_key")
    private String mTeamKey;

    @JSONField(name="city")
    private String mCity;

    @JSONField(name="abbreviation")
    private String mAbbreviation;

    @JSONField(name="nickname")
    private String mNickname;

    @JSONField(name="team_code")
    private String mTeamCode;

    @JSONField(name="score")
    private String mScore;

    @JSONField(name="players")
    private GameDetailsPlayersBean mPlayers;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTeamKey() {
        return mTeamKey;
    }

    public void setTeamKey(String teamKey) {
        mTeamKey = teamKey;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getAbbreviation() {
        return mAbbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        mAbbreviation = abbreviation;
    }

    public String getNickname() {
        return mNickname;
    }

    public void setNickname(String nickname) {
        mNickname = nickname;
    }

    public String getTeamCode() {
        return mTeamCode;
    }

    public void setTeamCode(String teamCode) {
        mTeamCode = teamCode;
    }

    public String getScore() {
        return mScore;
    }

    public void setScore(String score) {
        mScore = score;
    }

    public GameDetailsPlayersBean getPlayers() {
        return mPlayers;
    }

    public void setPlayers(GameDetailsPlayersBean players) {
        mPlayers = players;
    }
}
