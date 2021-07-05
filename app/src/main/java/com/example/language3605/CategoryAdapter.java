package com.example.language3605;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private static final String TAG = "CategoryAdapter";

    public static ArrayList<String> categoryList = new ArrayList<>();
    private Context mContext;

    public static String categoryPosition;


    public CategoryAdapter(Context context, ArrayList<String> category) {
        categoryList = category;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.category.setText(categoryList.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + categoryList.get(position));
                categoryPosition = categoryList.get(position);

                Toast.makeText(mContext, categoryList.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, WordListActivity.class);
                intent.putExtra("category_type", categoryList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView category;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.category_tv);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
}


