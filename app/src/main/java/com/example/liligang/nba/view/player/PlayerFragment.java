package com.example.liligang.nba.view.player;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.liligang.nba.R;
import com.example.liligang.nba.base.BaseLazyLoadFragment;
import com.example.liligang.nba.bean.player.PlayerResponseBean;
import com.example.liligang.nba.constant.ConstantValue;
import com.example.liligang.nba.net.NetObserver;
import com.example.liligang.nba.net.SingletonNetServer;
import com.example.liligang.nba.view.player.details.PlayerDetailsActivity;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liligang on 2018/3/27.
 */

public class PlayerFragment extends BaseLazyLoadFragment {
    private EditText mSearchEditText;
    private AVLoadingIndicatorView mAVLoadingIndicatorView;
    private List<Object[]> mPlayerData;
    private List<Object[]> mSearchPlayerData = new ArrayList<>();
    private PlayerListAdapter mPlayerListAdapter;

    @Override
    protected void getData() {
        Calendar currentDataCalendar = Calendar.getInstance();
        int year  = currentDataCalendar.get(Calendar.YEAR);
        int month = currentDataCalendar.get(Calendar.MONTH)+1;
        String season = month>9?
                String.format(Locale.getDefault(),"%d-%d",year, (year+1)%100):
                String.format(Locale.getDefault(),"%d-%d",year-1, year%100);
        SingletonNetServer.INSTANCE.getPlayerServerApi().playerList(season)
                .compose(this.<PlayerResponseBean>bindToLifecycle())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NetObserver<PlayerResponseBean>(mAVLoadingIndicatorView) {
                    @Override
                    public void onNext(PlayerResponseBean playerResponseBean) {
                        mPlayerData = playerResponseBean.getResultSets().get(0).getRowSet();
                    }
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_player;
    }

    @Override
    protected void initView(View convertView) {
        if (getActivity() instanceof PlayerHead) {
            mSearchEditText = ((PlayerHead) getActivity()).getSearchView();
        }

        ListView playerListView = convertView.findViewById(R.id.player_list_view);
        mAVLoadingIndicatorView = convertView.findViewById(R.id.av_loading_indicator_view);
        mPlayerListAdapter = new PlayerListAdapter(mSearchPlayerData);
        playerListView.setAdapter(mPlayerListAdapter);
        playerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlayerDetailsActivity.class);
                int playerId = ((Integer) mSearchPlayerData.get(position)[0]);
                int teamId = ((Integer) mSearchPlayerData.get(position)[7]);
                Log.e("okhttp", "----------"+playerId);
                Log.e("okhttp", "----------"+teamId);
                intent.putExtra(ConstantValue.INTENT_KEY.ID, playerId);
                intent.putExtra(ConstantValue.INTENT_KEY.TEAM_ID, teamId);
                startActivity(intent);
            }
        });

        RxTextView.textChanges(mSearchEditText).debounce(500, TimeUnit.MILLISECONDS)
                .compose(this.<CharSequence>bindToLifecycle())
                .filter(new Predicate<CharSequence>() {
                    @Override
                    public boolean test(CharSequence charSequence) throws Exception {
                        return !mAVLoadingIndicatorView.isShown();
                    }
                }).switchMap(new Function<CharSequence, ObservableSource<List<Object[]>>>() {
            @Override
            public ObservableSource<List<Object[]>> apply(CharSequence charSequence) throws Exception {
                final String key = charSequence.toString();
                return Observable.fromIterable(mPlayerData).filter(new Predicate<Object[]>() {
                    @Override
                    public boolean test(Object[] objects) throws Exception {
                        String name = (String) objects[2];
                        String city = (String) objects[8];
                        String team = (String) objects[9];
                        return !name.isEmpty() && !city.isEmpty() && !team.isEmpty() && name.contains(key);
                    }
                }).toList().toObservable();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NetObserver<List<Object[]>>() {
                    @Override
                    public void onNext(List<Object[]> objects) {
                        mSearchPlayerData.clear();
                        mSearchPlayerData.addAll(objects);
                        mPlayerListAdapter.notifyDataSetChanged();
                    }
                });
        mAVLoadingIndicatorView.show();
    }

}
