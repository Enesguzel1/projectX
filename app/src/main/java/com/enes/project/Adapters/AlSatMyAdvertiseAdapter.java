package com.enes.project.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class AlSatMyAdvertiseAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> fragments;
    ArrayList<String> pageTitles;

    public AlSatMyAdvertiseAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        fragments = new ArrayList<>();
        pageTitles = new ArrayList<>();
    }

    public void addFragment(Fragment fragment, String title){
        fragments.add(fragment);
        pageTitles.add(title);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public CharSequence getPageTitle(int position){
        return pageTitles.get(position);
    }

}
