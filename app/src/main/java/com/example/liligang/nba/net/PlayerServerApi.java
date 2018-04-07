package com.example.liligang.nba.net;

import com.example.liligang.nba.bean.player.PlayerResponseBean;
import com.example.liligang.nba.bean.player.detail.PlayerInfoResponseBean;
import com.example.liligang.nba.bean.player.detail.PlayerLogResponseBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface PlayerServerApi {
    String PLAYER_ICON_URL_FORMAT = "http://stats.nba.com/media/players/230x185/%d.png";

    @Headers({
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
            "Accept-Language: zh-CN,zh;q=0.9,en;q=0.8",
            "Connection: keep-alive",
            "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36"
    })
    @GET("http://stats.nba.com/stats/commonallplayers?IsOnlyCurrentSeason=0&LeagueID=00")
    Observable<PlayerResponseBean> playerList(@Query("Season") String Season);

    @Headers({
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
            "Accept-Language: zh-CN,zh;q=0.9,en;q=0.8",
            "Connection: keep-alive",
            "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36"
    })
    @GET("http://stats.nba.com/stats/commonplayerinfo?LeagueID=00&SeasonType=Regular+Season")
    Observable<PlayerInfoResponseBean> getPlayerInfo(@Query("PlayerID") int playerID);


    @Headers({
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
            "Accept-Language: zh-CN,zh;q=0.9,en;q=0.8",
            "Connection: keep-alive",
            "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36"
    })
    @GET("http://stats.nba.com/stats/playergamelog?LeagueID=00&PerMode=PerGame&SeasonType=Regular+Season")
    Observable<PlayerLogResponseBean> getPlayerLog(@Query("PlayerID") String PlayerID, @Query("Season") String Season);

}
