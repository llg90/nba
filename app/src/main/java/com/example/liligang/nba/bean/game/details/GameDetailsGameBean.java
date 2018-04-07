package com.example.liligang.nba.bean.game.details;

import com.alibaba.fastjson.annotation.JSONField;

public class GameDetailsGameBean {

    /**
     * id : 0021500239
     * game_url : 20151128/TORWAS
     * season_id : 22015
     * date : 20151128
     * time : 1900
     * arena : Verizon Center
     * city : Washington
     * state : DC
     * country :
     * home_start_date : 20151128
     * home_start_time : 1900
     * visitor_start_date : 20151128
     * visitor_start_time : 1900
     * previewAvailable : 1
     * recapAvailable : 1
     * notebookAvailable : 0
     * tnt_ot : 0
     * attendance : 16841
     */

    @JSONField(name="id")
    private String mId;

    @JSONField(name="season_id")
    private String mSeasonId;

    @JSONField(name="date")
    private String mDate;

    @JSONField(name="time")
    private String mTime;

    @JSONField(name="arena")
    private String mArena;

    @JSONField(name="city")
    private String mCity;

    @JSONField(name="state")
    private String mState;

    @JSONField(name="country")
    private String mCountry;

    @JSONField(name="previewAvailable")
    private String mPreviewAvailable;

    @JSONField(name="recapAvailable")
    private String mRecapAvailable;

    @JSONField(name="notebookAvailable")
    private String mNotebookAvailable;

    @JSONField(name="tnt_ot")
    private String mTntOt;

    @JSONField(name="attendance")
    private String mAttendance;

    @JSONField(name="visitor")
    private GameDetailsMemberBean mVisitor;

    @JSONField(name="home")
    private GameDetailsMemberBean mHome;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getSeasonId() {
        return mSeasonId;
    }

    public void setSeasonId(String seasonId) {
        mSeasonId = seasonId;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getArena() {
        return mArena;
    }

    public void setArena(String arena) {
        mArena = arena;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getPreviewAvailable() {
        return mPreviewAvailable;
    }

    public void setPreviewAvailable(String previewAvailable) {
        mPreviewAvailable = previewAvailable;
    }

    public String getRecapAvailable() {
        return mRecapAvailable;
    }

    public void setRecapAvailable(String recapAvailable) {
        mRecapAvailable = recapAvailable;
    }

    public String getNotebookAvailable() {
        return mNotebookAvailable;
    }

    public void setNotebookAvailable(String notebookAvailable) {
        mNotebookAvailable = notebookAvailable;
    }

    public String getTntOt() {
        return mTntOt;
    }

    public void setTntOt(String tntOt) {
        mTntOt = tntOt;
    }

    public String getAttendance() {
        return mAttendance;
    }

    public void setAttendance(String attendance) {
        mAttendance = attendance;
    }

    public GameDetailsMemberBean getVisitor() {
        return mVisitor;
    }

    public void setVisitor(GameDetailsMemberBean visitor) {
        mVisitor = visitor;
    }

    public GameDetailsMemberBean getHome() {
        return mHome;
    }

    public void setHome(GameDetailsMemberBean home) {
        mHome = home;
    }
}
