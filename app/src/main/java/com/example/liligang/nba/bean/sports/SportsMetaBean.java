package com.example.liligang.nba.bean.sports;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liligang on 2018/3/25.
 */

public class SportsMetaBean {
    @JSONField(name="date_time")
    private String mDateTime;

    @JSONField(name="season_meta")
    private SeasonMetaBean mSeasonMeta;

    @JSONField(name="next")
    private NextBean mNext;

    public String getDateTime() {
        return mDateTime;
    }

    public void setDateTime(String dateTime) {
        mDateTime = dateTime;
    }

    public SeasonMetaBean getSeasonMeta() {
        return mSeasonMeta;
    }

    public void setSeasonMeta(SeasonMetaBean seasonMeta) {
        mSeasonMeta = seasonMeta;
    }

    public NextBean getNext() {
        return mNext;
    }

    public void setNext(NextBean next) {
        mNext = next;
    }
}
