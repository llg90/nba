package com.example.liligang.nba.bean.game;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liligang on 2018/3/25.
 */

public class GameBean {


    /**
     * id : 0021701094
     * game_url : 20180325/CLEBKN
     * season_id : 22017
     * date : 20180325
     * time : 1300
     * arena : Barclays Center
     * city : Brooklyn
     * state : NY
     * country : USA
     * home_start_date : 20180325
     * home_start_time : 1300
     * visitor_start_date : 20180325
     * visitor_start_time : 1300
     * previewAvailable : 1
     * recapAvailable : 0
     * notebookAvailable : 0
     * tnt_ot : 0
     * buzzerBeater : 0
     */

    @JSONField(name="id")
    private String mId;

    @JSONField(name="game_url")
    private String mGameUrl;

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

    @JSONField(name="home_start_date")
    private String mHomeStartDate;

    @JSONField(name="home_start_time")
    private String mHomeStartTime;

    @JSONField(name="visitor_start_date")
    private String mVisitorStartDate;

    @JSONField(name="visitor_start_time")
    private String mVisitorStartTime;

    @JSONField(name="previewAvailable")
    private String mPreviewAvailable;

    @JSONField(name="recapAvailable")
    private String mRecapAvailable;

    @JSONField(name="notebookAvailable")
    private String mNotebookAvailable;

    @JSONField(name="tnt_ot")
    private String mTntOt;

    @JSONField(name="buzzerBeater")
    private String mBuzzerBeater;

    @JSONField(name="ticket")
    private GameTicketBean mGameTicket;

    @JSONField(name="period_time")
    private GamePeriodTimeBean mGamePeriodTime;

    @JSONField(name="visitor")
    private GameVisitorBean mGameVisitor;

    @JSONField(name="home")
    private GameHomeBean mGameHome;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getGameUrl() {
        return mGameUrl;
    }

    public void setGameUrl(String gameUrl) {
        mGameUrl = gameUrl;
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

    public String getHomeStartDate() {
        return mHomeStartDate;
    }

    public void setHomeStartDate(String homeStartDate) {
        mHomeStartDate = homeStartDate;
    }

    public String getHomeStartTime() {
        return mHomeStartTime;
    }

    public void setHomeStartTime(String homeStartTime) {
        mHomeStartTime = homeStartTime;
    }

    public String getVisitorStartDate() {
        return mVisitorStartDate;
    }

    public void setVisitorStartDate(String visitorStartDate) {
        mVisitorStartDate = visitorStartDate;
    }

    public String getVisitorStartTime() {
        return mVisitorStartTime;
    }

    public void setVisitorStartTime(String visitorStartTime) {
        mVisitorStartTime = visitorStartTime;
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

    public String getBuzzerBeater() {
        return mBuzzerBeater;
    }

    public void setBuzzerBeater(String buzzerBeater) {
        mBuzzerBeater = buzzerBeater;
    }

    public GameTicketBean getGameTicket() {
        return mGameTicket;
    }

    public void setGameTicket(GameTicketBean gameTicket) {
        mGameTicket = gameTicket;
    }

    public GamePeriodTimeBean getGamePeriodTime() {
        return mGamePeriodTime;
    }

    public void setGamePeriodTime(GamePeriodTimeBean gamePeriodTime) {
        mGamePeriodTime = gamePeriodTime;
    }

    public GameVisitorBean getGameVisitor() {
        return mGameVisitor;
    }

    public void setGameVisitor(GameVisitorBean gameVisitor) {
        mGameVisitor = gameVisitor;
    }

    public GameHomeBean getGameHome() {
        return mGameHome;
    }

    public void setGameHome(GameHomeBean gameHome) {
        mGameHome = gameHome;
    }
}
