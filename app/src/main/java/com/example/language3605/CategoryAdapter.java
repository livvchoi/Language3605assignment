package com.example.language3605;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private static final String TAG = "CategoryAdapter";

    public static ArrayList<String> categoriesList;
    public static ArrayList<String> categoryImageList;
    public static Context mContext;

    public static String categoryPosition;


    public CategoryAdapter(Context context, ArrayList<String> category, ArrayList<String> images) {
        mContext = context;
        categoriesList = category;
        categoryImageList = images;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        CategoryAdapter.ViewHolder holder = new CategoryAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.categoryType.setText(categoriesList.get(position));
        Picasso.get().load(categoryImageList.get(position)).into(holder.categoryImage);
        holder.itemView.setTag(categoriesList.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category", (String) v.getTag());
                Log.d("ViewHolderTag", (String) v.getTag());

                ListOfWordsFragment listofWordsFragment = new ListOfWordsFragment();

                listofWordsFragment.setArguments(bundle);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, listofWordsFragment).addToBackStack(null).commit();
            }
        });
    }


    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static TextView categoryType;
        public ImageView categoryImage;
        public static RelativeLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            categoryType = itemView.findViewById(R.id.category_tv);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            categoryImage = itemView.findViewById(R.id.ivCategoryIcon);

        }


    }
}