package com.example.language3605;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private static final String TAG = "CategoryAdapter";

    private List<Dictionary> mDictionary;
    private List<Dictionary>
    public static ArrayList<String> categoriesList;
    public static Context mContext;

    public static String categoryPosition;


    public CategoryAdapter(Context context, ArrayList<String> category) {
        mContext = context;
        categoriesList = category;
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


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + categoriesList.get(position));
                Toast.makeText(mContext, categoriesList.get(position), Toast.LENGTH_SHORT).show();

                categoryPosition = categoriesList.get(position);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                ListOfWordsFragment myFragment = new ListOfWordsFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();

            }
        });
    }


    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static TextView categoryType;
        public static RelativeLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            categoryType = itemView.findViewById(R.id.tvCategory);
//            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}