package com.example.liligang.nba.net;

import com.example.liligang.nba.net.converter.fast.FastJsonConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public enum SingletonNetServer {
    INSTANCE;

    private GameServerApi   mGameServerApi;
    private PlayerServerApi mPlayerServerApi;
    private TeamServerApi   mTeamServerApi;

    SingletonNetServer(){
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .baseUrl("http://data.nba.com")
                .build();

        mGameServerApi   = retrofit.create(GameServerApi.class);
        mPlayerServerApi = retrofit.create(PlayerServerApi.class);
        mTeamServerApi   = retrofit.create(TeamServerApi.class);
    }

    public GameServerApi getGameServer() {
        return mGameServerApi;
    }

    public PlayerServerApi getPlayerServerApi() {
        return mPlayerServerApi;
    }

    public TeamServerApi getTeamServerApi() {
        return mTeamServerApi;
    }
}
