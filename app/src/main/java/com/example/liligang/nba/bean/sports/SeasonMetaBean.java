package com.example.liligang.nba.bean.sports;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liligang on 2018/3/25.
 */

public class SeasonMetaBean {

    /**
     * calendar_date : 20180324
     * season_year : 2017
     * stats_season_year : 2017
     * stats_season_id : 22017
     * stats_season_stage : 2
     * roster_season_year : 2017
     * schedule_season_year : 2017
     * standings_season_year : 2017
     * season_id : 22017
     * display_year : 2017-18
     * display_season : Regular Season
     * season_stage : 2
     * league_id : 00
     */

    @JSONField(name="calendar_date")
    private String mCalendarDate; //日历日期

    @JSONField(name="season_year")
    private String mSeasonYear;   //季度

    @JSONField(name="stats_season_year")
    private String mStatsSeasonYear; //统计季度年

    @JSONField(name="stats_season_id")
    private String mStatsSeasonId; //统计季度id

    @JSONField(name="stats_season_stage")
    private String mStatsSeasonStage; //

    @JSONField(name="roster_season_year")
    private String mRosterSeasonYear; //

    @JSONField(name="schedule_season_year")
    private String mScheduleSeasonYear; //

    @JSONField(name="standings_season_year")
    private String mStandingsSeasonYear; //

    @JSONField(name="season_id")
    private String mSeasonId; //

    @JSONField(name="display_year")
    private String mDisplayYear; //

    @JSONField(name="display_season")
    private String mDisplaySeason; //

    @JSONField(name="season_stage")
    private String mSeasonStage; //

    @JSONField(name="league_id")
    private String mLeagueId; //

    public String getCalendarDate() {
        return mCalendarDate;
    }

    public void setCalendarDate(String calendarDate) {
        mCalendarDate = calendarDate;
    }

    public String getSeasonYear() {
        return mSeasonYear;
    }

    public void setSeasonYear(String seasonYear) {
        mSeasonYear = seasonYear;
    }

    public String getStatsSeasonYear() {
        return mStatsSeasonYear;
    }

    public void setStatsSeasonYear(String statsSeasonYear) {
        mStatsSeasonYear = statsSeasonYear;
    }

    public String getStatsSeasonId() {
        return mStatsSeasonId;
    }

    public void setStatsSeasonId(String statsSeasonId) {
        mStatsSeasonId = statsSeasonId;
    }

    public String getStatsSeasonStage() {
        return mStatsSeasonStage;
    }

    public void setStatsSeasonStage(String statsSeasonStage) {
        mStatsSeasonStage = statsSeasonStage;
    }

    public String getRosterSeasonYear() {
        return mRosterSeasonYear;
    }

    public void setRosterSeasonYear(String rosterSeasonYear) {
        mRosterSeasonYear = rosterSeasonYear;
    }

    public String getScheduleSeasonYear() {
        return mScheduleSeasonYear;
    }

    public void setScheduleSeasonYear(String scheduleSeasonYear) {
        mScheduleSeasonYear = scheduleSeasonYear;
    }

    public String getStandingsSeasonYear() {
        return mStandingsSeasonYear;
    }

    public void setStandingsSeasonYear(String standingsSeasonYear) {
        mStandingsSeasonYear = standingsSeasonYear;
    }

    public String getSeasonId() {
        return mSeasonId;
    }

    public void setSeasonId(String seasonId) {
        mSeasonId = seasonId;
    }

    public String getDisplayYear() {
        return mDisplayYear;
    }

    public void setDisplayYear(String displayYear) {
        mDisplayYear = displayYear;
    }

    public String getDisplaySeason() {
        return mDisplaySeason;
    }

    public void setDisplaySeason(String displaySeason) {
        mDisplaySeason = displaySeason;
    }

    public String getSeasonStage() {
        return mSeasonStage;
    }

    public void setSeasonStage(String seasonStage) {
        mSeasonStage = seasonStage;
    }

    public String getLeagueId() {
        return mLeagueId;
    }

    public void setLeagueId(String leagueId) {
        mLeagueId = leagueId;
    }
}
