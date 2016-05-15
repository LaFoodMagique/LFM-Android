package com.sourcey.foodie.Fragments.TopFragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sourcey.foodie.Fragments.BasicFragment;
import com.sourcey.foodie.Fragments.BottomFragments.BlankFragment;
import com.sourcey.foodie.R;


public class RestaurantFragment extends BasicFragment {

    private View myFragmentView;

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.fragment_top_home, container, false);
        viewPager = (ViewPager) myFragmentView.findViewById(R.id.bottom_viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) myFragmentView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return myFragmentView;
    }

    /**
     * Adding fragments to ViewPager
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new BlankFragment(), getString(R.string.tab_restaurant_string_first));
        adapter.addFrag(new BlankFragment(), getString(R.string.tab_restaurant_string_second));
        adapter.addFrag(new BlankFragment(), getString(R.string.tab_restaurant_string_third));
        viewPager.setAdapter(adapter);
    }
}
