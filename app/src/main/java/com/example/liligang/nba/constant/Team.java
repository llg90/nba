package com.example.liligang.nba.constant;

import com.example.liligang.nba.R;

/**
 * Created by liligang on 2018/3/26.
 */

public enum  Team {
    ATL(1610612737, "Atlanta",       "Hawks",        R.color.atl, "eastern", R.mipmap.atl),
    BKN(1610612751, "Brooklyn",      "Nets",         R.color.bkn, "eastern", R.mipmap.bkn),
    BOS(1610612738, "Boston",        "Celtics",      R.color.bos, "eastern", R.mipmap.bos),
    CHA(1610612766, "Charlotte",     "Hornets",      R.color.cha, "eastern", R.mipmap.cha),
    CHI(1610612741, "Chicago",       "Bulls",        R.color.chi, "eastern", R.mipmap.chi),
    CLE(1610612739, "Cleveland",     "Cavaliers",    R.color.cle, "eastern", R.mipmap.cle),
    DAL(1610612742, "Dallas",        "Mavericks",    R.color.dal, "western", R.mipmap.dal),
    DEN(1610612743, "Denver",        "Nuggets",      R.color.den, "western", R.mipmap.den),
    DET(1610612765, "Detroit",       "Pistons",      R.color.det, "eastern", R.mipmap.det),
    GSW(1610612744, "Golden State",  "Warriors",     R.color.gsw, "western", R.mipmap.gsw),
    HOU(1610612745, "Houston",       "Rockets",      R.color.hou, "western", R.mipmap.hou),
    IND(1610612754, "Indiana",       "Pacers",       R.color.ind, "eastern", R.mipmap.ind),
    LAC(1610612746, "Los Angeles",   "Clippers",     R.color.lac, "western", R.mipmap.lac),
    LAL(1610612747, "Los Angeles",   "Lakers",       R.color.lal, "western", R.mipmap.lal),
    MEM(1610612763, "Memphis",       "Grizzlies",    R.color.mem, "western", R.mipmap.mem),
    MIA(1610612748, "Miami",         "Heat",         R.color.mia, "eastern", R.mipmap.mia),
    MIL(1610612749, "Milwaukee",     "Bucks",        R.color.mil, "eastern", R.mipmap.mil),
    MIN(1610612750, "Minnesota",     "Timberwolves", R.color.min, "western", R.mipmap.min),
    NOP(1610612740, "New Orleans",   "Pelicans",     R.color.nop, "western", R.mipmap.nop),
    NYK(1610612752, "New York",      "Knicks",       R.color.nyk, "eastern", R.mipmap.nyk),
    OKC(1610612760, "Oklahoma City", "Thunder",      R.color.okc, "western", R.mipmap.okc),
    ORL(1610612753, "Orlando",       "Magic",        R.color.orl, "eastern", R.mipmap.orl),
    PHI(1610612755, "Philadelphia", "76ers",         R.color.phi, "eastern", R.mipmap.phi),
    PHX(1610612756, "Phoenix",      "Suns",          R.color.phx, "western", R.mipmap.phx),
    POR(1610612757, "Portland",     "Trail Blazers", R.color.por, "western", R.mipmap.por),
    SAC(1610612758, "Sacramento",   "Kings",         R.color.sac, "western", R.mipmap.sac),
    SAS(1610612759, "San Antonio",  "Spurs",         R.color.sas, "western", R.mipmap.sas),
    TOR(1610612761, "Toronto",      "Raptors",       R.color.tor, "eastern", R.mipmap.tor),
    UTA(1610612762, "Utah",         "Jazz",          R.color.uta, "western", R.mipmap.uta),
    WAS(1610612764, "Washington",   "Wizards",       R.color.was, "eastern", R.mipmap.was);

    public long id;
    public String city;
    public String team;
    public int color;
    public String conf;
    public int logo;

    private Team(long id, String city, String team, int color, String conf, int logo){
        this.id    = id;
        this.city  = city;
        this.team  = team;
        this.color = color;
        this.conf  = conf;
        this.logo  = logo;
    }
}
