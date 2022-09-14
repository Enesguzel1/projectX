package com.enes.project.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enes.project.Adapters.BecayisAdapter;
import com.enes.project.Models.BecayisRowModel;
import com.enes.project.R;

import java.util.ArrayList;


public class BecayisHomePageFragment extends Fragment {
    ArrayList<BecayisRowModel> becayisRowModels= new ArrayList<>();


    public BecayisHomePageFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_becayis_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView=view.findViewById(R.id.mRecycleView);

        setUpBecayisModels();

        BecayisAdapter adapter= new BecayisAdapter(getContext(),becayisRowModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    public void setUpBecayisModels(){
        String[] username=getResources().getStringArray(R.array.username);
        String[] bulunulanYurt=getResources().getStringArray(R.array.bulunulanyurt);
        String[] gidilecekYurt=getResources().getStringArray(R.array.gidilecekyurt);
        String[] aciklama=getResources().getStringArray(R.array.aciklama);

        for (int i=0;i<5;i++){
            becayisRowModels.add(new BecayisRowModel(username[i],
                    bulunulanYurt[i],
                    gidilecekYurt[i],
                    aciklama[i]));
        }
    }
}