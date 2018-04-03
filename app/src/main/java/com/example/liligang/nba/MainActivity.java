package com.example.liligang.nba;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liligang.nba.base.BaseFragment;
import com.example.liligang.nba.base.BaseFragmentActivity;
import com.example.liligang.nba.view.game.GameFragment;
import com.example.liligang.nba.view.game.GameHead;
import com.example.liligang.nba.view.player.PlayerFragment;
import com.example.liligang.nba.view.player.PlayerHead;
import com.example.liligang.nba.view.team.TeamFragment;
import com.example.liligang.nba.view.team.TeamHead;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends BaseFragmentActivity implements GameHead, PlayerHead, TeamHead{
    private LinearLayout mGameHeadLayout;
    private TextView mGameDataTextView;
    private TextView mGameNumberTextView;

    private LinearLayout mPlayerHeadLayout;
    private EditText mPlayerSearchView;

    private LinearLayout mTeamHeadLayout;
    private TextView mTeamConfTextView;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private String[] mTabNames = new String[]{"Game", "Player", "Team"};
    private BaseFragment[] mFragments = new BaseFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mGameHeadLayout     = findViewById(R.id.game_head);
        mGameDataTextView   = findViewById(R.id.date_text_view);
        mGameNumberTextView = findViewById(R.id.count_text_vie);

        mPlayerHeadLayout = findViewById(R.id.player_head);
        mPlayerSearchView = findViewById(R.id.search_edit_text);

        mTeamHeadLayout   = findViewById(R.id.team_head);
        mTeamConfTextView = findViewById(R.id.conf_text_view);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        showTabTextAdapteIndicator(mTabLayout);
        for (String item : mTabNames) {
            mTabLayout.addTab(mTabLayout.newTab().setText(item));
        }

        mFragments[0] = new GameFragment();
        mFragments[1] = new PlayerFragment();
        mFragments[2] = new TeamFragment();

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

            @Override
            public int getCount() {
                return mFragments.length;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTabNames[position];
            }

        });

        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mGameHeadLayout.setVisibility(View.VISIBLE);
                    mPlayerHeadLayout.setVisibility(View.GONE);
                    mTeamHeadLayout.setVisibility(View.GONE);
                } else if (position == 1) {
                    mGameHeadLayout.setVisibility(View.GONE);
                    mPlayerHeadLayout.setVisibility(View.VISIBLE);
                    mTeamHeadLayout.setVisibility(View.GONE);
                } else {
                    mGameHeadLayout.setVisibility(View.GONE);
                    mPlayerHeadLayout.setVisibility(View.GONE);
                    mTeamHeadLayout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void showTabTextAdapteIndicator(final TabLayout tab) {
        tab.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                tab.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Class<?> tabLayout = tab.getClass();
                Field tabStrip = null;
                try {
                    tabStrip = tabLayout.getDeclaredField("mTabStrip");
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                tabStrip.setAccessible(true);
                LinearLayout ll_tab = null;
                try {
                    ll_tab = (LinearLayout) tabStrip.get(tab);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                int maxLen = 0;
                int maxTextSize = 0;
                int tabCount = ll_tab.getChildCount();
                for (int i = 0; i < tabCount; i++) {
                    View child = ll_tab.getChildAt(i);
                    child.setPadding(0, 0, 0, 0);
                    if (child instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) child;
                        for (int j = 0; j < ll_tab.getChildCount(); j++) {
                            if (viewGroup.getChildAt(j) instanceof TextView) {
                                TextView tabTextView = (TextView) viewGroup.getChildAt(j);
                                int length = tabTextView.getText().length();
                                maxTextSize = (int) tabTextView.getTextSize() > maxTextSize ? (int) tabTextView.getTextSize() : maxTextSize;
                                maxLen = length > maxLen ? length : maxLen;
                            }
                        }

                    }

                    int dp2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, Resources.getSystem().getDisplayMetrics());
                    int margin = (tab.getWidth() / tabCount - (maxTextSize + dp2) * maxLen) / 2 - dp2;
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                    params.leftMargin = margin;
                    params.rightMargin = margin;
                    child.setLayoutParams(params);
                    child.invalidate();
                }


            }
        });

    }

    @Override
    public void setGameHeadDate(Date date) {
        if (date == null) return;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        mGameDataTextView.setText(sdf.format(date));
    }

    @Override
    public void setGameHeadNumber(int number) {
        String text = String.format(Locale.getDefault(), "%d Games", number);
        mGameNumberTextView.setText(text);
    }

    @Override
    public EditText getSearchView() {
        return mPlayerSearchView;
    }

    @Override
    public void setConfViewText(String text) {
        mTeamConfTextView.setText(text);
    }
}
