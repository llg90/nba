package com.example.liligang.nba.constant;

import java.util.HashMap;
import java.util.Map;

public class ConstantValue {
    public static final Map<String, Team> TEAM_MAP = new HashMap<>();

    static {
        TEAM_MAP.put("ATL", Team.ATL);
        TEAM_MAP.put("BKN", Team.BKN);
        TEAM_MAP.put("BOS", Team.BOS);
        TEAM_MAP.put("CHA", Team.CHA);
        TEAM_MAP.put("CHI", Team.CHI);
        TEAM_MAP.put("CLE", Team.CLE);
        TEAM_MAP.put("DAL", Team.DAL);
        TEAM_MAP.put("DEN", Team.DEN);
        TEAM_MAP.put("DET", Team.DET);
        TEAM_MAP.put("GSW", Team.GSW);
        TEAM_MAP.put("HOU", Team.HOU);
        TEAM_MAP.put("IND", Team.IND);
        TEAM_MAP.put("LAC", Team.LAC);
        TEAM_MAP.put("LAL", Team.LAL);
        TEAM_MAP.put("MEM", Team.MEM);
        TEAM_MAP.put("MIA", Team.MIA);
        TEAM_MAP.put("MIL", Team.MIL);
        TEAM_MAP.put("MIN", Team.MIN);
        TEAM_MAP.put("NOP", Team.NOP);
        TEAM_MAP.put("NYK", Team.NYK);
        TEAM_MAP.put("OKC", Team.OKC);
        TEAM_MAP.put("ORL", Team.ORL);
        TEAM_MAP.put("PHI", Team.PHI);
        TEAM_MAP.put("PHX", Team.PHX);
        TEAM_MAP.put("POR", Team.POR);
        TEAM_MAP.put("SAC", Team.SAC);
        TEAM_MAP.put("SAS", Team.SAS);
        TEAM_MAP.put("TOR", Team.TOR);
        TEAM_MAP.put("UTA", Team.UTA);
        TEAM_MAP.put("WAS", Team.WAS);
    }


    public static class INTENT_KEY {
        public static final String GAME_STATE = "game_state";
        public static final String HOME_TEAM     = "home_team";
        public static final String VISITOR_TEAM  = "visitor_team";
        public static final String HOME_SCORE    = "home_score";
        public static final String VISITOR_SCORE = "visitor_score";
        public static final String GAME_ID = "game_id";
        public static final String GAME_DATE = "game_date";
    }
}
