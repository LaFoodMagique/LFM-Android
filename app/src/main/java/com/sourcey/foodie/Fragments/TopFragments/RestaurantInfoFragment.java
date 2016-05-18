package com.sourcey.foodie.Fragments.TopFragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sourcey.foodie.Fragments.BottomFragments.RestoInfoComments;
import com.sourcey.foodie.Fragments.BottomFragments.RestoInfoDishlist;
import com.sourcey.foodie.Fragments.BottomFragments.RestoInfoInfoblock;
import com.sourcey.foodie.R;

import java.util.ArrayList;
import java.util.List;


public class RestaurantInfoFragment extends Fragment {

    private View myFragmentView;
    protected TabLayout tabLayout;
    protected ViewPager viewPager;

    protected class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

    public RestaurantInfoFragment() {
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
        adapter.addFrag(new RestoInfoComments(),    getString(R.string.tab_restaurant_string_first));
        adapter.addFrag(new RestoInfoInfoblock(),   getString(R.string.tab_restaurant_string_second));
        adapter.addFrag(new RestoInfoDishlist(),    getString(R.string.tab_restaurant_string_third));
        viewPager.setAdapter(adapter);
    }
}
