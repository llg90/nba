package com.example.liligang.nba.bean.game.details;

import com.google.gson.annotations.SerializedName;

public class GameDetailsPlayerBean {

    /**
     * first_name : DeMarre
     * last_name : Carroll
     * jersey_number : 5
     * person_id : 201960
     * position_short : F
     * position_full : Forward
     * minutes : 27
     * seconds : 37
     * points : 4
     * field_goals_made : 1
     * field_goals_attempted : 8
     * player_code : demarre_carroll
     * free_throws_made : 2
     * free_throws_attempted : 2
     * three_pointers_made : 0
     * three_pointers_attempted : 3
     * rebounds_offensive : 1
     * rebounds_defensive : 3
     * assists : 1
     * fouls : 4
     * steals : 1
     * turnovers : 2
     * team_turnovers :
     * blocks : 0
     * plus_minus : 3
     * on_court : 1
     * starting_position : F
     */

    @SerializedName("first_name")
    private String mFirstName;

    @SerializedName("last_name")
    private String mLastName;

    @SerializedName("jersey_number")
    private String mJerseyNumber;

    @SerializedName("person_id")
    private String mPersonId;

    @SerializedName("position_short")
    private String mPositionShort;

    @SerializedName("position_full")
    private String mPositionFull;

    @SerializedName("minutes")
    private String mMinutes;

    @SerializedName("seconds")
    private String mSeconds;

    @SerializedName("points")
    private String mPoints;

    @SerializedName("field_goals_made")
    private String mFieldGoalsMade;

    @SerializedName("field_goals_attempted")
    private String mFieldGoalsAttempted;

    @SerializedName("player_code")
    private String mPlayerCode;

    @SerializedName("free_throws_made")
    private String mFreeThrowsMade;

    @SerializedName("free_throws_attempted")
    private String mFreeThrowsAttempted;

    @SerializedName("three_pointers_made")
    private String mThreePointersMade;

    @SerializedName("three_pointers_attempted")
    private String mThreePointersAttempted;

    @SerializedName("rebounds_offensive")
    private String mReboundsOffensive;

    @SerializedName("rebounds_defensive")
    private String mReboundsDefensive;

    @SerializedName("assists")
    private String mAssists;

    @SerializedName("fouls")
    private String mFouls;

    @SerializedName("steals")
    private String mSteals;

    @SerializedName("turnovers")
    private String mTurnovers;

    @SerializedName("team_turnovers")
    private String mTeamTurnovers;

    @SerializedName("blocks")
    private String mBlocks;

    @SerializedName("plus_minus")
    private String mPlusMinus;

    @SerializedName("on_court")
    private String mOnCourt;

    @SerializedName("starting_position")
    private String mStartingPosition;

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getJerseyNumber() {
        return mJerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        mJerseyNumber = jerseyNumber;
    }

    public String getPersonId() {
        return mPersonId;
    }

    public void setPersonId(String personId) {
        mPersonId = personId;
    }

    public String getPositionShort() {
        return mPositionShort;
    }

    public void setPositionShort(String positionShort) {
        mPositionShort = positionShort;
    }

    public String getPositionFull() {
        return mPositionFull;
    }

    public void setPositionFull(String positionFull) {
        mPositionFull = positionFull;
    }

    public String getMinutes() {
        return mMinutes;
    }

    public void setMinutes(String minutes) {
        mMinutes = minutes;
    }

    public String getSeconds() {
        return mSeconds;
    }

    public void setSeconds(String seconds) {
        mSeconds = seconds;
    }

    public String getPoints() {
        return mPoints;
    }

    public void setPoints(String points) {
        mPoints = points;
    }

    public String getFieldGoalsMade() {
        return mFieldGoalsMade;
    }

    public void setFieldGoalsMade(String fieldGoalsMade) {
        mFieldGoalsMade = fieldGoalsMade;
    }

    public String getFieldGoalsAttempted() {
        return mFieldGoalsAttempted;
    }

    public void setFieldGoalsAttempted(String fieldGoalsAttempted) {
        mFieldGoalsAttempted = fieldGoalsAttempted;
    }

    public String getPlayerCode() {
        return mPlayerCode;
    }

    public void setPlayerCode(String playerCode) {
        mPlayerCode = playerCode;
    }

    public String getFreeThrowsMade() {
        return mFreeThrowsMade;
    }

    public void setFreeThrowsMade(String freeThrowsMade) {
        mFreeThrowsMade = freeThrowsMade;
    }

    public String getFreeThrowsAttempted() {
        return mFreeThrowsAttempted;
    }

    public void setFreeThrowsAttempted(String freeThrowsAttempted) {
        mFreeThrowsAttempted = freeThrowsAttempted;
    }

    public String getThreePointersMade() {
        return mThreePointersMade;
    }

    public void setThreePointersMade(String threePointersMade) {
        mThreePointersMade = threePointersMade;
    }

    public String getThreePointersAttempted() {
        return mThreePointersAttempted;
    }

    public void setThreePointersAttempted(String threePointersAttempted) {
        mThreePointersAttempted = threePointersAttempted;
    }

    public String getReboundsOffensive() {
        return mReboundsOffensive;
    }

    public void setReboundsOffensive(String reboundsOffensive) {
        mReboundsOffensive = reboundsOffensive;
    }

    public String getReboundsDefensive() {
        return mReboundsDefensive;
    }

    public void setReboundsDefensive(String reboundsDefensive) {
        mReboundsDefensive = reboundsDefensive;
    }

    public String getAssists() {
        return mAssists;
    }

    public void setAssists(String assists) {
        mAssists = assists;
    }

    public String getFouls() {
        return mFouls;
    }

    public void setFouls(String fouls) {
        mFouls = fouls;
    }

    public String getSteals() {
        return mSteals;
    }

    public void setSteals(String steals) {
        mSteals = steals;
    }

    public String getTurnovers() {
        return mTurnovers;
    }

    public void setTurnovers(String turnovers) {
        mTurnovers = turnovers;
    }

    public String getTeamTurnovers() {
        return mTeamTurnovers;
    }

    public void setTeamTurnovers(String teamTurnovers) {
        mTeamTurnovers = teamTurnovers;
    }

    public String getBlocks() {
        return mBlocks;
    }

    public void setBlocks(String blocks) {
        mBlocks = blocks;
    }

    public String getPlusMinus() {
        return mPlusMinus;
    }

    public void setPlusMinus(String plusMinus) {
        mPlusMinus = plusMinus;
    }

    public String getOnCourt() {
        return mOnCourt;
    }

    public void setOnCourt(String onCourt) {
        mOnCourt = onCourt;
    }

    public String getStartingPosition() {
        return mStartingPosition;
    }

    public void setStartingPosition(String startingPosition) {
        mStartingPosition = startingPosition;
    }
}
