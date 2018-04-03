package com.example.liligang.nba.bean.game;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liligang on 2018/3/25.
 */

public class GameTicketBean {
    @SerializedName("ticket_link")
    private String mTicketLink;

    public String getTicketLink() {
        return mTicketLink;
    }

    public void setTicketLink(String ticketLink) {
        mTicketLink = ticketLink;
    }
}
