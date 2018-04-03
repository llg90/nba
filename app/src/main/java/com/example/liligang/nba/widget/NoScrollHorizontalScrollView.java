package com.example.liligang.nba.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class NoScrollHorizontalScrollView extends HorizontalScrollView {
    public NoScrollHorizontalScrollView(Context context) {
        super(context);
    }

    public NoScrollHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NoScrollHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
//        return super.onInterceptHoverEvent(event);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        return super.onTouchEvent(ev);
        return false;
    }
}
