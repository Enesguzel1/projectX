package com.enes.project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enes.project.Models.BecayisRowModel;
import com.enes.project.R;

import java.util.ArrayList;

public class BecayisAdapter extends RecyclerView.Adapter<BecayisAdapter.MyViewHolder> {
    ArrayList<BecayisRowModel> becayisRowModels;
    Context context;

    public BecayisAdapter(Context context,ArrayList<BecayisRowModel> becayisRowModels) {
        this.becayisRowModels=becayisRowModels;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.becayis_recycle_view_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.username.setText(becayisRowModels.get(position).getUsername());
        holder.bulunulanYurt.setText(becayisRowModels.get(position).getBulunulanYurt());
        holder.gidilecekYurt.setText(becayisRowModels.get(position).getGidilecekYurt());
        holder.aciklama.setText(becayisRowModels.get(position).getAciklama());
    }

    @Override
    public int getItemCount() {
        return becayisRowModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView username,bulunulanYurt,gidilecekYurt,aciklama;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.usernameTextCardView);
            bulunulanYurt=itemView.findViewById(R.id.bulunulanYurtTextCardView);
            gidilecekYurt=itemView.findViewById(R.id.gidilecekYurtTextCardView);
            aciklama=itemView.findViewById(R.id.aciklamaTextCardView);

        }
    }
}
