package com.example.language3605;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder>{
    private static final String TAG = "LanguageAdapter";

    public static ArrayList<String> languageList = new ArrayList<>();
    private ArrayList<String> locationList = new ArrayList<>();
    private Context mContext;

    public static String languagePosition;

    public LanguageAdapter(Context context, ArrayList<String> language, ArrayList<String> location) {
        languageList = language;
        locationList = location;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.language_item,parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.language.setText(languageList.get(position));
        holder.location.setText(locationList.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + languageList.get(position));
                languagePosition = languageList.get(position);

                Toast.makeText(mContext, languageList.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, CategoryActivity.class);
                intent.putExtra("language_type", languageList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        TextView language;
        TextView location;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            language = itemView.findViewById(R.id.language_tv);
            location = itemView.findViewById(R.id.location_tv);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }

//    Context context;
//    List<Language> languageData;
//    LanguageUserClickListener langaugeUserClickListener;
//
//    private ArrayList<String> LanguageList = new ArrayList<>();
//
//    public LanguageAdapter(ArrayList<String> languageList, Context mContext) {
//        LanguageList = languageList;
//        this.mContext = mContext;
//    }
//
//
//    //inflating the view
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_languagelistitem, parent,false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
//    }
//
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Log.d(TAG, "onBindViewHolder: called.");
//        holder.languageType.setText(LanguageList.get(position));
//
//        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//
//                Log.d(TAG, "onClick: clicked on: " + LanguageList.get(position));
//                Toast.makeText(mContext, LanguageList.get(position), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return LanguageList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        TextView languageType;
//        RelativeLayout parentLayout;
//
//        public ViewHolder(View itemView){
//            super(itemView);
//            languageType = itemView.findViewById(R.id.language_type);
//            parentLayout = itemView.findViewById(R.id.parent_layout);
//
//        }
//    }
}
