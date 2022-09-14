package com.enes.project.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enes.project.Adapters.AlSatAdvertiseAdapter;
import com.enes.project.Models.AlSatAdvertiseModel;
import com.enes.project.R;

import java.util.ArrayList;


public class AlSatHomePageFragment extends Fragment {
    private RecyclerView recyclerView;
    private AlSatAdvertiseAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_al_sat_home_page, container, false);

        recyclerView = view.findViewById(R.id.recyclerAlSatHomePage);

        // test array
        ArrayList<AlSatAdvertiseModel> alSatAdvertiseModels = new ArrayList<>();
        alSatAdvertiseModels.add(new AlSatAdvertiseModel("Title-1"));
        alSatAdvertiseModels.add(new AlSatAdvertiseModel("Title-2"));
        alSatAdvertiseModels.add(new AlSatAdvertiseModel("Title-3"));
        alSatAdvertiseModels.add(new AlSatAdvertiseModel("Title-4"));

        adapter = new AlSatAdvertiseAdapter(alSatAdvertiseModels, getContext());
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}