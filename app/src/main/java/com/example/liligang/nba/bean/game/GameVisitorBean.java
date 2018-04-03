package com.example.liligang.nba.bean.game;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liligang on 2018/3/25.
 * 客队情况bean
 */

public class GameVisitorBean {

    /**
     * id : 1610612739
     * team_key : CLE
     * city : Cleveland
     * abbreviation : CLE
     * nickname : Cavaliers
     * url_name : cavaliers
     * team_code : cavaliers
     * score :
     */

    @SerializedName("id")
    private String mId;

    @SerializedName("team_key")
    private String mTeamKey;

    @SerializedName("city")
    private String mCity;

    @SerializedName("abbreviation")
    private String mAbbreviation;

    @SerializedName("nickname")
    private String mNickname;

    @SerializedName("url_name")
    private String mUrlName;

    @SerializedName("team_code")
    private String mTeamCode;

    @SerializedName("score")
    private String mScore; //本场总得分

//    @SerializedName("linescores")
//    private GameLinescoresBean mLinescores; //各节得分

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

    public String getUrlName() {
        return mUrlName;
    }

    public void setUrlName(String urlName) {
        mUrlName = urlName;
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

//    public GameLinescoresBean getLinescores() {
//        return mLinescores;
//    }
//
//    public void setLinescores(GameLinescoresBean linescores) {
//        mLinescores = linescores;
//    }
}
