package com.example.language3605;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class BadgeAdapter extends RecyclerView.Adapter<BadgeAdapter.BadgeViewHolder> {


    @NonNull
    @NotNull
    @Override
    public BadgeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BadgeAdapter.BadgeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class BadgeViewHolder extends RecyclerView.ViewHolder{
        TextView mBadgeName;
        ImageView mBadge;

        public BadgeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mBadge = itemView.findViewById(R.id.ivBadge);
            mBadgeName = itemView.findViewById(R.id.ivBadge);



        }
    }
}
