package com.example.liligang.nba.view.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.liligang.nba.R;
import com.example.liligang.nba.base.BaseLazyLoadFragment;
import com.example.liligang.nba.bean.game.GameBean;
import com.example.liligang.nba.bean.game.GameResponseBean;
import com.example.liligang.nba.bean.game.GameHomeBean;
import com.example.liligang.nba.bean.game.GameVisitorBean;
import com.example.liligang.nba.constant.ConstantValue;
import com.example.liligang.nba.net.NetObserver;
import com.example.liligang.nba.net.SingletonNetServer;
import com.example.liligang.nba.view.game.details.GameDetailsActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wang.avi.AVLoadingIndicatorView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liligang on 2018/3/27.
 */

public class GameFragment extends BaseLazyLoadFragment {
    private AVLoadingIndicatorView mAVLoadingIndicatorView;
    private SmartRefreshLayout mSmartRefreshLayout;
    private ListView mGameListView;

    private String mUsaDateString;
    private GameHead mGameHead;
    private GameListAdapter mGameListAdapter;
    private List<GameBean> mGameListData = new ArrayList<>();

    @Override
    public void getData() {
        Activity fatherActivity = getActivity();
        if (fatherActivity instanceof GameHead) {
            mGameHead = (GameHead) fatherActivity;
        }

        Calendar currentDataCalendar = Calendar.getInstance();
        mGameHead.setGameHeadDate(currentDataCalendar.getTime()); //显示当前的时间
        currentDataCalendar.add(Calendar.DATE, -1);//美国时间
        Date usaDate= currentDataCalendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        mUsaDateString = sdf.format(usaDate);
        SingletonNetServer.INSTANCE.getGameServer().gameGeneral(mUsaDateString)
                .compose(this.<GameResponseBean>bindToLifecycle())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NetObserver<GameResponseBean>(mAVLoadingIndicatorView, mSmartRefreshLayout) {
                    @Override
                    public void onNext(GameResponseBean gameDataBean) {
                        List<GameBean> data = gameDataBean.getGameSportsContentBean().getGames().getGame();
                        if (data != null && !data.isEmpty()) {
                            mGameHead.setGameHeadNumber(data.size());
                            mGameListData.addAll(data);
                            mGameListAdapter.notifyDataSetChanged();
                        } else {
                            mGameHead.setGameHeadNumber(0);
                        }
                    }
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_game;
    }

    @Override
    protected void initView(View convertView) {
        mAVLoadingIndicatorView = convertView.findViewById(R.id.av_loading_indicator_view);
        mSmartRefreshLayout     = convertView.findViewById(R.id.refreshLayout);
        mGameListView           = convertView.findViewById(R.id.game_list_view);

        mGameListAdapter = new GameListAdapter(mGameListData);
        mGameListView.setAdapter(mGameListAdapter);
        mGameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GameBean data = mGameListData.get(position);
                Bundle bundle = new Bundle();
                bundle.putString(ConstantValue.INTENT_KEY.GAME_DATE, mUsaDateString);
                bundle.putString(ConstantValue.INTENT_KEY.GAME_ID, data.getId());
                bundle.putString(ConstantValue.INTENT_KEY.GAME_STATE, data.getGamePeriodTime().getPeriodStatus());
                GameHomeBean gameHomeBean = data.getGameHome();
                if (gameHomeBean != null) {
                    bundle.putSerializable(ConstantValue.INTENT_KEY.HOME_TEAM,
                            ConstantValue.TEAM_MAP.get(gameHomeBean.getTeamKey()));
                    bundle.putString(ConstantValue.INTENT_KEY.HOME_SCORE, gameHomeBean.getScore());
                }
                GameVisitorBean gameVisitorBean = data.getGameVisitor();
                if (gameVisitorBean != null) {
                    bundle.putSerializable(ConstantValue.INTENT_KEY.VISITOR_TEAM,
                            ConstantValue.TEAM_MAP.get(gameVisitorBean.getTeamKey()));
                    bundle.putString(ConstantValue.INTENT_KEY.VISITOR_SCORE, gameVisitorBean.getScore());
                }

                Intent intent = new Intent(getActivity(), GameDetailsActivity.class);
                intent.putExtras(bundle);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    GameListAdapter.ViewHolder holder = (GameListAdapter.ViewHolder) view.getTag(R.id.tag_view_holder);
                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                            Pair.create((View) holder.mHomeIcon,            "homeIconView"),
                            Pair.create((View) holder.mHomeTeamCityName,    "homeTeamCityView"),
                            Pair.create((View) holder.mHomeTeamName,        "homeTeamNameView"),
                            Pair.create((View) holder.mHomeScore,           "homeScoreView"),
                            Pair.create((View) holder.mGameState,           "gameStateView"),
                            Pair.create((View) holder.mVisitorIcon,         "visitorIconView"),
                            Pair.create((View) holder.mVisitorTeamCityName, "visitorTeamCityNameView"),
                            Pair.create((View) holder.mVisitorTeamName,     "visitorTeamNameView"),
                            Pair.create((View) holder.mVisitorScore,        "visitorScoreView"));
                    startActivity(intent, activityOptionsCompat.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });

        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mGameListData.clear();
                getData();
            }
        });
    }
}
