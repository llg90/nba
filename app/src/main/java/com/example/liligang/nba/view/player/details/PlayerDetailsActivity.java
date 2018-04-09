package com.example.liligang.nba.view.player.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.liligang.nba.R;
import com.example.liligang.nba.base.BaseActivity;
import com.example.liligang.nba.bean.player.detail.PlayerDetailResultSetsBean;
import com.example.liligang.nba.bean.player.detail.PlayerInfoResponseBean;
import com.example.liligang.nba.bean.player.detail.PlayerLogResponseBean;
import com.example.liligang.nba.constant.ConstantValue;
import com.example.liligang.nba.constant.Team;
import com.example.liligang.nba.net.NetObserver;
import com.example.liligang.nba.net.PlayerServerApi;
import com.example.liligang.nba.net.SingletonNetServer;

import java.util.List;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PlayerDetailsActivity extends BaseActivity {
    private ImageView mIconView;
    private TextView  mNameView;
    private TextView  mIdentifierView;

    private TextView mPointsTextView;
    private TextView mAsistantTextView;
    private TextView mReboundsTextView;

    private View mPointsBarView;
    private TextView mPointsValue;
    private View mAsistantBarView;
    private TextView mAsistantValue;
    private View mReboundsBarView;
    private TextView mReboundsValue;
    private View mStealsBarView;
    private TextView mStealsValue;
    private View mBlocksBarView;
    private TextView mBlocksValue;
    private View mTurnoversBarView;
    private TextView mTurnoversValue;
    private View mMinutesBarView;
    private TextView mMinutesValue;

    private int mPlayerId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        mPlayerId = getIntent().getIntExtra(ConstantValue.INTENT_KEY.ID, 0);
        initView();
        getNetworkData();
    }

    private void initView() {
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        int teamId = getIntent().getIntExtra(ConstantValue.INTENT_KEY.TEAM_ID, 0);
        Team team = Team.getFormId(teamId);
        findViewById(R.id.icon_layout).setBackgroundResource(team==null?Team.ATL.color:team.color);

        mIconView = findViewById(R.id.icon_view);
        mNameView = findViewById(R.id.name_view);
        mIdentifierView = findViewById(R.id.identifier_view);
        String url = String.format(Locale.getDefault(), PlayerServerApi.PLAYER_ICON_URL_FORMAT, mPlayerId);
        Glide.with(this)
                .applyDefaultRequestOptions(new RequestOptions().circleCrop())
                .load(url).into(mIconView);

        mPointsTextView   = findViewById(R.id.points_text_view);
        mAsistantTextView = findViewById(R.id.asistant_text_view);
        mReboundsTextView = findViewById(R.id.rebounds_text_view);

        mPointsBarView    = findViewById(R.id.points_bar);
        mPointsValue      = findViewById(R.id.points_value);
        mAsistantBarView  = findViewById(R.id.asistant_bar);
        mAsistantValue    = findViewById(R.id.asistant_value);
        mReboundsBarView  = findViewById(R.id.rebounds_bar);
        mReboundsValue    = findViewById(R.id.rebounds_value);
        mStealsBarView    = findViewById(R.id.steals_bar);
        mStealsValue      = findViewById(R.id.steals_value);
        mBlocksBarView    = findViewById(R.id.blocks_bar);
        mBlocksValue      = findViewById(R.id.blocks_value);
        mTurnoversBarView = findViewById(R.id.turnovers_bar);
        mTurnoversValue   = findViewById(R.id.turnovers_value);
        mMinutesBarView   = findViewById(R.id.minutes_bar);
        mMinutesValue     = findViewById(R.id.minutes_value);


        Animation animation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1.0f);
        animation.setDuration(2000);
        mPointsBarView.setAnimation(animation);
        animation.start();
    }

    private void getNetworkData() {
        SingletonNetServer.INSTANCE.getPlayerServerApi().getPlayerInfo(mPlayerId)
                .compose(this.<PlayerInfoResponseBean>bindToLifecycle())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NetObserver<PlayerInfoResponseBean>() {
                    @Override
                    public void onNext(PlayerInfoResponseBean playerDetailResponseBean) {
                        initInfoViewData(playerDetailResponseBean.getResultSets());
                    }
                });

        SingletonNetServer.INSTANCE.getPlayerServerApi().getPlayerLog(String.valueOf(mPlayerId), "2017-18")
                .compose(this.<PlayerLogResponseBean>bindToLifecycle())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NetObserver<PlayerLogResponseBean>() {
                    @Override
                    public void onNext(PlayerLogResponseBean playerLogResponseBean) {

                    }
                });
    }

    private void initInfoViewData(List<PlayerDetailResultSetsBean> data) {
        if (data == null) return;

        Object[] playerInfo = data.get(0).getRowSet().get(0);
        Object[] playerHeadlineStats = data.get(1).getRowSet().get(0);

        mNameView.setText((String) playerInfo[3]);
        mIdentifierView.setText((playerInfo[28]).toString());

        mPointsTextView.setText(  String.format(Locale.getDefault(), "%.2f", playerHeadlineStats[3]));
        mAsistantTextView.setText(String.format(Locale.getDefault(), "%.2f", playerHeadlineStats[4]));
        mReboundsTextView.setText(String.format(Locale.getDefault(), "%.2f", playerHeadlineStats[5]));
    }
}
