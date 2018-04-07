package com.example.liligang.nba.bean.game;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liligang on 2018/3/25.
 */

public class GameTicketBean {
    @JSONField(name="ticket_link")
    private String mTicketLink;

    public String getTicketLink() {
        return mTicketLink;
    }

    public void setTicketLink(String ticketLink) {
        mTicketLink = ticketLink;
    }
}
