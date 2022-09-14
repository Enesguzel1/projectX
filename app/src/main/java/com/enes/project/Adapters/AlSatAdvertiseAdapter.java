package com.enes.project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enes.project.Models.AlSatAdvertiseModel;
import com.enes.project.R;

import java.util.ArrayList;

public class AlSatAdvertiseAdapter extends RecyclerView.Adapter<AlSatAdvertiseAdapter.AlSatHomeAdapterHolder> {
    private ArrayList<AlSatAdvertiseModel> alSatAdvertiseModels;
    private Context context;

    public AlSatAdvertiseAdapter(ArrayList<AlSatAdvertiseModel> alSatAdvertiseModels, Context context) {
        this.alSatAdvertiseModels = alSatAdvertiseModels;
        this.context = context;
    }

    @NonNull
    @Override
    public AlSatHomeAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.al_sat_home_page_card_view, parent, false);
        return new AlSatHomeAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlSatHomeAdapterHolder holder, int position) {
        holder.alSatAdvertiseTitle.setText(alSatAdvertiseModels.get(position).getAdvertiseTitle());
    }


    @Override
    public int getItemCount() {
        return alSatAdvertiseModels.size();
    }

    class AlSatHomeAdapterHolder extends RecyclerView.ViewHolder{
        TextView alSatAdvertiseTitle;

        public AlSatHomeAdapterHolder(@NonNull View itemView) {
            super(itemView);
            alSatAdvertiseTitle = itemView.findViewById(R.id.alSatAdvertiseTitle);
        }
    }

}
