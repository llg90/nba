package com.example.liligang.nba.net;

import com.example.liligang.nba.bean.game.GameResponseBean;
import com.example.liligang.nba.bean.game.details.GameDetailsResponseBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GameServerApi {

    @GET("/data/5s/json/cms/noseason/scoreboard/{gameDate}/games.json")
    Observable<GameResponseBean> gameGeneral(@Path("gameDate") String gameDate);

    @GET("/data/10s/json/cms/noseason/game/{gameDate}/{gameId}/boxscore.json")
    Observable<GameDetailsResponseBean> gameDetail(@Path("gameDate") String gameDate, @Path("gameId") String gameId);
}
