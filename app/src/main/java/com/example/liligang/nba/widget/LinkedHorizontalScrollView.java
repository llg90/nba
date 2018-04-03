package com.example.liligang.nba.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class LinkedHorizontalScrollView extends HorizontalScrollView {
    private LinkScrollChangeListener mListener;

    public interface LinkScrollChangeListener {
        void onScroll(LinkedHorizontalScrollView view, int l, int t, int oldl, int oldt);
    }

    public void LinkScrollChangeListener(LinkScrollChangeListener listener) {
        mListener = listener;
    }

    public LinkedHorizontalScrollView(Context context) {
        super(context);
    }

    public LinkedHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinkedHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LinkedHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void fling(int velocityX) {
        super.fling(velocityX/2); //控制滑动速度
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
//        super.onScrollChanged(l, t, oldl, oldt);
        if (mListener != null) {
            mListener.onScroll(this, l, t, oldl, oldt);
        }
    }
}
