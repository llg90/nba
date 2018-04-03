package com.example.liligang.nba.view.game.details;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liligang.nba.R;
import com.example.liligang.nba.base.BaseActivity;
import com.example.liligang.nba.bean.game.details.GameDetailsContentBean;
import com.example.liligang.nba.bean.game.details.GameDetailsGameBean;
import com.example.liligang.nba.bean.game.details.GameDetailsPlayerBean;
import com.example.liligang.nba.bean.game.details.GameDetailsResponseBean;
import com.example.liligang.nba.constant.ConstantValue;
import com.example.liligang.nba.constant.Team;
import com.example.liligang.nba.net.NetObserver;
import com.example.liligang.nba.net.SingletonNetServer;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GameDetailsActivity extends BaseActivity {

    private ImageView mHomeIconView;
    private TextView  mHomeTeamCityView;
    private TextView  mHomeTeamNameView;
    private TextView  mHomeDefeatRatioView;
    private TextView  mHomeScoreView;

    private ImageView mVisitorIconView;
    private TextView  mVisitorTeamCityView;
    private TextView  mVisitorTeamNameView;
    private TextView  mVisitorDefeatRatioView;
    private TextView  mVisitorScoreView;

    private TabLayout mDetailsTabLayout;
    private ListView  mMemberListView;
    private ListView  mMemberDataListView;
    private AVLoadingIndicatorView mAVLoadingIndicatorView;

    private List<String> mHomeMemberListData = new ArrayList<>();
    private List<GameDetailsPlayerBean> mHomeMemberDataListData = new ArrayList<>();

    private List<String> mVisitorMemberListData = new ArrayList<>();
    private List<GameDetailsPlayerBean> mVisitorMemberDataListData = new ArrayList<>();

    private List<String> mCurrentMemberDataList = new ArrayList<>();
    private MemberListAdapter mMemberListAdapter;
    private List<GameDetailsPlayerBean> mCurrentMemberDataListData = new ArrayList<>();
    private MemberDataListAdapter mMemberDataListAdapter;

    private String mGameId;
    private String mGameDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);
        initView();
        initHeadViewData();
        initDetailsTableData();
        initViewListener();
    }

    private void initView() {
        mHomeIconView        = findViewById(R.id.home_icon_view);
        mHomeTeamCityView    = findViewById(R.id.home_team_city_view);
        mHomeTeamNameView    = findViewById(R.id.home_team_name_view);
        mHomeDefeatRatioView = findViewById(R.id.home_defeat_ratio_view);
        mHomeScoreView       = findViewById(R.id.home_score_view);

        mVisitorIconView        = findViewById(R.id.visitor_icon_view);
        mVisitorTeamCityView    = findViewById(R.id.visitor_team_city_view);
        mVisitorTeamNameView    = findViewById(R.id.visitor_team_name_view);
        mVisitorDefeatRatioView = findViewById(R.id.visitor_defeat_ratio_view);
        mVisitorScoreView       = findViewById(R.id.visitor_score_view);

        mDetailsTabLayout       = findViewById(R.id.tab_layout);
        mMemberListView         = findViewById(R.id.member_list_view);
        mMemberDataListView     = findViewById(R.id.member_data_list_view);
        mAVLoadingIndicatorView = findViewById(R.id.av_loading_indicator_view);

        mAVLoadingIndicatorView.show();
    }

    private void initHeadViewData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mGameId   = bundle.getString(ConstantValue.INTENT_KEY.GAME_ID);
            mGameDate = bundle.getString(ConstantValue.INTENT_KEY.GAME_DATE);
            Team homeTeam = (Team) bundle.getSerializable(ConstantValue.INTENT_KEY.HOME_TEAM);
            if (homeTeam != null) {
                mHomeIconView.setImageResource(homeTeam.logo);
                mHomeTeamCityView.setText(homeTeam.city);
                mHomeTeamNameView.setText(homeTeam.team);
                findViewById(R.id.root_view).setBackgroundResource(homeTeam.color);
                int color;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    color = getColor(homeTeam.color);
                } else {
                    color = getResources().getColor(homeTeam.color);
                }
                mAVLoadingIndicatorView.setIndicatorColor(color);
                String tabText = String.format(Locale.getDefault(), "%s %s", homeTeam.city, homeTeam.team);
                mDetailsTabLayout.addTab(mDetailsTabLayout.newTab().setText(tabText));
            }

            Team visitorTeam = (Team) bundle.getSerializable(ConstantValue.INTENT_KEY.VISITOR_TEAM);
            if (visitorTeam != null) {
                mVisitorIconView.setImageResource(visitorTeam.logo);
                mVisitorTeamCityView.setText(visitorTeam.city);
                mVisitorTeamNameView.setText(visitorTeam.team);

                String tabText = String.format(Locale.getDefault(), "%s %s", visitorTeam.city, visitorTeam.team);
                mDetailsTabLayout.addTab(mDetailsTabLayout.newTab().setText(tabText));
            }

            String homeScore = bundle.getString(ConstantValue.INTENT_KEY.HOME_SCORE);
            if (homeScore != null) {
                mHomeScoreView.setText(homeScore);
            }

            String visitorScore = bundle.getString(ConstantValue.INTENT_KEY.VISITOR_SCORE);
            if (visitorScore != null) {
                mVisitorScoreView.setText(visitorScore);
            }

        }
    }

    private void initDetailsTableData() {
        mMemberListAdapter     = new MemberListAdapter(mCurrentMemberDataList);
        mMemberDataListAdapter = new MemberDataListAdapter(mCurrentMemberDataListData);

        mMemberListView.setAdapter(mMemberListAdapter);
        mMemberDataListView.setAdapter(mMemberDataListAdapter);

        if (mGameId != null && mGameDate != null) {
            SingletonNetServer.INSTANCE.getGameServer().gameDetail(mGameDate, mGameId)
                    .compose(this.<GameDetailsResponseBean>bindToLifecycle())
                    .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new NetObserver<GameDetailsResponseBean>(mAVLoadingIndicatorView) {
                        @Override
                        public void onNext(GameDetailsResponseBean gameDetailsResponseBean) {
                            GameDetailsContentBean content = gameDetailsResponseBean.getGameDetailsContent();
                            if (content != null) {
                                GameDetailsGameBean game = content.getGame();
                                if (game != null) {
                                    List<GameDetailsPlayerBean> homeData    = game.getHome().getPlayers().getPlayer();
                                    List<GameDetailsPlayerBean> visitorData = game.getVisitor().getPlayers().getPlayer();
                                    if (homeData != null) {
                                        mHomeMemberListData.clear();
                                        for (GameDetailsPlayerBean item : homeData) {
                                            String text = item.getFirstName().substring(0, 1).toUpperCase()+'.'+item.getLastName();
                                            mHomeMemberListData.add(text);
                                        }
                                        mHomeMemberDataListData.clear();
                                        mHomeMemberDataListData.addAll(homeData);

                                        mVisitorMemberListData.clear();
                                        for (GameDetailsPlayerBean item : visitorData) {
                                            String text = item.getFirstName().substring(0, 1).toUpperCase()+'.'+item.getLastName();
                                            mVisitorMemberListData.add(text);
                                        }
                                        mVisitorMemberDataListData.clear();
                                        mVisitorMemberDataListData.addAll(visitorData);

                                        mCurrentMemberDataList.clear();
                                        mCurrentMemberDataList.addAll(mHomeMemberListData);
                                        mMemberListAdapter.notifyDataSetChanged();

                                        mCurrentMemberDataListData.clear();
                                        mCurrentMemberDataListData.addAll(mHomeMemberDataListData);
                                        mMemberDataListAdapter.notifyDataSetChanged();
                                    }
                                }
                            }
                        }
                    });
        }
    }

    private void initViewListener() {

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });
    }
}
