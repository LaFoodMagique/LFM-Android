package com.sourcey.foodie.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.DimType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;
import com.sourcey.foodie.Fragments.TopFragments.FriendFragment;
import com.sourcey.foodie.Fragments.TopFragments.HomeFragment;
import com.sourcey.foodie.Fragments.TopFragments.RestaurantFragment;
import com.sourcey.foodie.Fragments.TopFragments.ReservationFragment;
import com.sourcey.foodie.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
    implements
    BoomMenuButton.OnSubButtonClickListener,
    BoomMenuButton.AnimatorListener,
    View.OnClickListener {

    private TabLayout       tabLayout;
    private ViewPager       viewPager;
    private View            mCustomView;
    private BoomMenuButton  boomMenuButtonInActionBar;
    private boolean         isInit = false;
    private Context         mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText(R.string.app_name);

        boomMenuButtonInActionBar = (BoomMenuButton) mCustomView.findViewById(R.id.boom);
        boomMenuButtonInActionBar.setOnSubButtonClickListener(this);
        boomMenuButtonInActionBar.setAnimatorListener(this);

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        ((Toolbar) mCustomView.getParent()).setContentInsetsAbsolute(0,0);


        HomeFragment frag = new HomeFragment();
        frag.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_fragment, frag).commit();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (!isInit) {
            initBoom();
        }
        isInit = true;
    }

    private String[] Colors = {
            "#F44336",
            "#E91E63",
            "#9C27B0",
            "#2196F3",
            "#03A9F4",
            "#00BCD4",
            "#009688",
            "#4CAF50",
            "#8BC34A",
            "#CDDC39",
            "#FFEB3B",
            "#FFC107",
            "#FF9800",
            "#FF5722",
            "#795548",
            "#9E9E9E",
            "#607D8B"
    };

    @Override
    public void onBackPressed() {
        // Disable going back to the LoginActivity
        moveTaskToBack(true);
    }

    public int GetRandomColor() {
        Random random = new Random();
        int p = random.nextInt(Colors.length);
        return Color.parseColor(Colors[p]);
    }

    private void initBoom() {
        int number = getResources().getInteger(R.integer.ab_boom_number);

        Drawable[] drawables = new Drawable[number];
        int[] drawablesResource = new int[]{
                R.drawable.like,
                R.drawable.ic_restaurant,
                R.drawable.copy,
                R.drawable.settings,
                R.drawable.ic_restaurant,
                R.drawable.ic_restaurant
        };
        for (int i = 0; i < number; i++)
            drawables[i] = ContextCompat.getDrawable(mContext, drawablesResource[i]);

        String[] STRINGS = new String[]{
                getString(R.string.bm_string_friends),
                getString(R.string.bm_string_restaurants),
                getString(R.string.bm_string_profile),
                getString(R.string.bm_string_settings),
                getString(R.string.bm_string_scan),
                getString(R.string.bm_string_reservation)
        };

        String[] strings = new String[number];
        for (int i = 0; i < number; i++)
            strings[i] = STRINGS[i];

        int[][] colors = new int[number][2];
        for (int i = 0; i < number; i++) {
            colors[i][1] = GetRandomColor();
            colors[i][0] = Util.getInstance().getPressedColor(colors[i][1]);
        }

        new BoomMenuButton.Builder()
                .subButtons(drawables, colors, strings)
                .button(ButtonType.CIRCLE)
                .boom(BoomType.PARABOLA)
                .place(PlaceType.CIRCLE_6_1)
                .subButtonsShadow(Util.getInstance().dp2px(2), Util.getInstance().dp2px(2))
                .onSubButtonClick(this)
                .animator(this)
                .dim(DimType.DIM_0)
                .init(boomMenuButtonInActionBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private  boolean onScanQrClicked() {
        try {

            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes

            startActivityForResult(intent, 0);
            return true;

        } catch (Exception e) {

            Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
            Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
            startActivity(marketIntent);
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
            }
            if(resultCode == RESULT_CANCELED){
                //handle cancel
            }
        }
    }

    @Override
    public void toShow() { }

    @Override
    public void showing(float fraction) {}

    @Override
    public void showed() {}

    @Override
    public void toHide() {}

    @Override
    public void hiding(float fraction) {}

    @Override
    public void hided() {}

    @Override
    public void onClick(View v) {}

    @Override
    public void onClick(int buttonIndex) {
        if (buttonIndex == this.getResources().getInteger(R.integer.bm_scan_menu_value)) {
            onScanQrClicked();
        }
        else if (buttonIndex == this.getResources().getInteger(R.integer.bm_profile_value)) {
            onProfileClicked();
        }
        else if (buttonIndex == this.getResources().getInteger(R.integer.bm_restaurant_value)) {
            onRestaurantClicked();
        }
        else if (buttonIndex == this.getResources().getInteger(R.integer.bm_reservation_value)) {
            onReservationClicked();
        }
        else if (buttonIndex == this.getResources().getInteger(R.integer.bm_friends_value)) {
            onFriendsClicked();
        }
    }

    private void onRestaurantClicked() {
        RestaurantFragment frag = new RestaurantFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frame_fragment, frag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void onReservationClicked() {
        ReservationFragment frag = new ReservationFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frame_fragment, frag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void onFriendsClicked() {
        FriendFragment frag = new FriendFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frame_fragment, frag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void onProfileClicked(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

}
