package com.sourcey.foodie.Fragments.BottomFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sourcey.foodie.R;

/**
 * Created by Perith on 18/05/2016.
 */
public class ReservDetailResto extends Fragment {
    public ReservDetailResto() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation_detail_resto, container, false);
    }
}
