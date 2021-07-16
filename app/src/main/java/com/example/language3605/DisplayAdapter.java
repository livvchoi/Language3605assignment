package com.example.language3605;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder>{

    private static final String TAG = "DisplayAdapter";

    public static ArrayList<String> engList;
    public static ArrayList<String> indList;
    public static ArrayList<ImageView> img;
    public static Context mContext;

    public static String engPosition;
    public static String indPosition;
    public static String imgPosition;

    private WordClickListener clickListener;

    public DisplayAdapter(Context context, ArrayList<String> english,ArrayList<String> indig, ArrayList<ImageView> image) {
        mContext = context;
        engList = english;
        indList = indig;
        img = image;
    }

    @NonNull
    @Override
    public DisplayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_item, parent, false);
        DisplayAdapter.ViewHolder holder = new DisplayAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.englishWord.setText(engList.get(position));
        holder.indigWord.setText(indList.get(position));
//        holder.showImage.setImageResource(img.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engPosition = engList.get(position);
                indPosition = indList.get(position);
//                imgPosition = img.get(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static TextView englishWord;
        public static TextView indigWord;
        public static ImageView showImage;

        public static RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            englishWord = itemView.findViewById(R.id.english_tv);
            indigWord = itemView.findViewById(R.id.indig_tv);
            showImage = itemView.findViewById(R.id.wordImageView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
