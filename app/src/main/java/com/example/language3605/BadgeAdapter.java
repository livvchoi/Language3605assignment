package com.example.language3605;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BadgeAdapter extends RecyclerView.Adapter<BadgeAdapter.BadgeViewHolder> {
    private final List<Badge> mBadgeList;

    public BadgeAdapter(List<Badge> mBadgeList) {
        this.mBadgeList = mBadgeList;
    }

    @NonNull
    @NotNull
    @Override
    public BadgeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.badge_item, parent, false);
        BadgeAdapter.BadgeViewHolder holder = new BadgeAdapter.BadgeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BadgeAdapter.BadgeViewHolder holder, int position) {
        Badge mBadge = mBadgeList.get(position);
        holder.mBadgeName.setText(mBadge.getName());
        Picasso.get().load(mBadge.getImage()).into(holder.mBadgeImage);
        Log.d("mBadge Name", mBadge.getName());
        Log.d("Achieved", String.valueOf(mBadge.isAchieved()));
        if(mBadge.isAchieved() == false){
            holder.mBadgeImage.setColorFilter(Color.GRAY);
            holder.mBadgeName.setTextColor(Color.DKGRAY);
        }
    }

    @Override
    public int getItemCount() {
        return mBadgeList.size();
    }

    public static class BadgeViewHolder extends RecyclerView.ViewHolder{
        TextView mBadgeName;
        ImageView mBadgeImage;

        public BadgeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mBadgeImage = itemView.findViewById(R.id.ivBadge);
            mBadgeName = itemView.findViewById(R.id.tvBadgeName);



        }
    }
}
