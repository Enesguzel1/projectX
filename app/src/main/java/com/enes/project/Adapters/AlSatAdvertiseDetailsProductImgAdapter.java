package com.enes.project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enes.project.R;

import java.util.zip.Inflater;

public class AlSatAdvertiseDetailsProductImgAdapter extends RecyclerView.Adapter<AlSatAdvertiseDetailsProductImgAdapter.productDetailsHolder> {
    private Context context;

    public AlSatAdvertiseDetailsProductImgAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public productDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.al_sat_product_img, parent, false);
        return new productDetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull productDetailsHolder holder, int position) {
        int [] images = {R.drawable.ic_add, R.drawable.ic_add, R.drawable.ic_add, R.drawable.ic_add};
        holder.cardViewProductImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class productDetailsHolder extends RecyclerView.ViewHolder{
        ImageView cardViewProductImg;
        public productDetailsHolder(@NonNull View itemView) {
            super(itemView);
            cardViewProductImg = itemView.findViewById(R.id.cardViewProductImg);
        }
    }

}
