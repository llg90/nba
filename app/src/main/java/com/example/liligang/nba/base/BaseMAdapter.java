package com.example.liligang.nba.base;

import android.support.annotation.NonNull;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by liligang on 2018/3/28.
 */

public abstract class BaseMAdapter<T> extends BaseAdapter {
    private List<T> mDataList;

    public BaseMAdapter(@NonNull List<T> data) {
        this.mDataList = data;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public T getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
