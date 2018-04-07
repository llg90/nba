package com.example.liligang.nba.view.game.details;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.AbsListView;
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
import com.example.liligang.nba.utils.Utils;
import com.example.liligang.nba.widget.LinkedHorizontalScrollView;
import com.example.liligang.nba.widget.NoScrollHorizontalScrollView;
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
    private NoScrollHorizontalScrollView mNoScrollHorizontalScrollView;
    private LinkedHorizontalScrollView   mLinkedHorizontalScrollView;
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

        mNoScrollHorizontalScrollView = findViewById(R.id.no_scroll_horizontal_scroll_view);
        mLinkedHorizontalScrollView   = findViewById(R.id.linked_horizontal_scroll_view);
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
                                        Utils.setListFromItemMax(mMemberListView);
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


    private boolean isLeftListEnabled = false;
    private boolean isRightListEnabled = false;

    private void initViewListener() {
        mDetailsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        mCurrentMemberDataList.clear();
                        mCurrentMemberDataList.addAll(mHomeMemberListData);
                        Utils.setListFromItemMax(mMemberListView);
                        mMemberListAdapter.notifyDataSetChanged();

                        mCurrentMemberDataListData.clear();
                        mCurrentMemberDataListData.addAll(mHomeMemberDataListData);
                        mMemberDataListAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        mCurrentMemberDataList.clear();
                        mCurrentMemberDataList.addAll(mVisitorMemberListData);
                        Utils.setListFromItemMax(mMemberListView);
                        mMemberListAdapter.notifyDataSetChanged();

                        mCurrentMemberDataListData.clear();
                        mCurrentMemberDataListData.addAll(mVisitorMemberDataListData);
                        mMemberDataListAdapter.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mLinkedHorizontalScrollView.setLinkScrollChangeListener(new LinkedHorizontalScrollView.LinkScrollChangeListener() {
            @Override
            public void onScroll(LinkedHorizontalScrollView view, int l, int t, int oldl, int oldt) {
                mNoScrollHorizontalScrollView.scrollTo(l, t);
            }
        });

        mMemberListView.setOverScrollMode(ListView.OVER_SCROLL_NEVER);//禁止快速滑动
        mMemberDataListView.setOverScrollMode(ListView.OVER_SCROLL_NEVER);

        /*右List跟随左List联动*/
        mMemberListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_TOUCH_SCROLL:
                        isLeftListEnabled  = true;
                        isRightListEnabled = false;
                        break;
                    case SCROLL_STATE_IDLE:
                        isRightListEnabled = true;
                        break;
                    default:
                        isLeftListEnabled  = false;
                        isRightListEnabled = false;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                View child = view.getChildAt(0);
                if (child != null && isLeftListEnabled) {
                    mMemberDataListView.setSelectionFromTop(firstVisibleItem, child.getTop());
                }
            }
        });

        /*左List跟随右List联动*/
        mMemberDataListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_TOUCH_SCROLL:
                        isLeftListEnabled  = false;
                        isRightListEnabled = true;
                        break;
                    case SCROLL_STATE_IDLE:
                        isLeftListEnabled = true;
                        break;
                    default:
                        isLeftListEnabled  = false;
                        isRightListEnabled = false;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                View child = view.getChildAt(0);
                if (child != null && isRightListEnabled) {
                    mMemberListView.setSelectionFromTop(firstVisibleItem, child.getTop());
                }
            }
        });

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
