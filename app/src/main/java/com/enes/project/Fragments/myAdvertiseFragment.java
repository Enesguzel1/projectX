package com.enes.project.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enes.project.Adapters.alSatAdapter;
import com.enes.project.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class myAdvertiseFragment extends Fragment {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private alSatAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_advertise, container, false);

        viewPager = view.findViewById(R.id.alSatViewPager);

        adapter = new alSatAdapter(getParentFragmentManager(), getLifecycle());
        adapter.addFragment(new alSatMyAdvertiseForSaleFragment(), "İlandakiler");
        adapter.addFragment(new alSatMyAdvertiseSoldFragment(), "Satılanlar");
        viewPager.setAdapter(adapter);

        tabLayout = view.findViewById(R.id.alSatTabLayout);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(adapter.getPageTitle(position));
            }
        }).attach();



        return view;
    }
}