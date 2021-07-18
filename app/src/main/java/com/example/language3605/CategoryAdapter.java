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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private static final String TAG = "CategoryAdapter";

    public static ArrayList<String> categoriesList;
    public static Context mContext;

    public static String categoryPosition;


    public CategoryAdapter(Context context, ArrayList<String> category) {
        mContext = context;
        categoriesList = category;
    }


//    public CategoryAdapter(Context context, ArrayList<String> category, CategoryClickListener clickListener) {
//        mContext = context;
//        categoriesList = category;
//        this.clickListener = clickListener;
//    }

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



//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                // transaction.replace(R.id.frame_container, fragment, "detail_fragment");
//
//                transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("main_fragment"));
//                transaction.add(R.id.frame_container, fragment);
//                transaction.addToBackStack(null);
//                transaction.commit();


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
            categoryType = itemView.findViewById(R.id.category_tv);
            parentLayout = itemView.findViewById(R.id.parent_layout);

//            itemView.setOnClickListener((v -> {
//                Intent intent = new intent.
//            }));
        }
    }
}