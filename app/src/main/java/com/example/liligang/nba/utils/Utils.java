package com.example.liligang.nba.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * @author: 李利刚
 * @E-mail: lgzc_work@163.com
 * @date: 2018-04-03 11:29
 * @describe:
 */
public class Utils {

    public static void setListFromItemMax(ListView listView) {
        if (listView == null || listView.getAdapter() == null) {
            return;
        }

        View view;
        ListAdapter adapter = listView.getAdapter();
        int maxWidth = 0;
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            view = adapter.getView(i, null, listView);
            view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            if (view.getMeasuredWidth() > maxWidth) {
                maxWidth = view.getMeasuredWidth();
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.width = maxWidth;
        listView.setLayoutParams(params);
    }
}
