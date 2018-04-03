package com.example.liligang.nba.net;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public enum SingletonNetServer {
    INSTANCE;

    private GameServerApi mGameServerApi;

    SingletonNetServer(){
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .baseUrl("http://data.nba.com")
                .build();

        mGameServerApi = retrofit.create(GameServerApi.class);
    }

    public GameServerApi getGameServer() {
        return mGameServerApi;
    }
}
