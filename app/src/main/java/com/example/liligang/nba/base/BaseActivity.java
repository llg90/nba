package com.example.liligang.nba.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.RxActivity;

/**
 * Created by liligang on 2018/3/24.
 */

public class BaseActivity extends RxActivity {

    private long firstTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

/*    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(BaseActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }

        return super.onKeyUp(keyCode, event);
    }*/
}
