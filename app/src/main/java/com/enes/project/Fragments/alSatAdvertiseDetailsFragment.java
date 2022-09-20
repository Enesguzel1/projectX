package com.enes.project.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enes.project.Adapters.AlSatAdvertiseDetailsProductImgAdapter;
import com.enes.project.R;

public class alSatAdvertiseDetailsFragment extends Fragment {
    private ViewPager2 viewPager;
    private AlSatAdvertiseDetailsProductImgAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_al_sat_advertise_details, container, false);

        viewPager = view.findViewById(R.id.alSatAdvertiseDetailsViewPager);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        adapter = new AlSatAdvertiseDetailsProductImgAdapter(getContext());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);


        return view;
    }
}