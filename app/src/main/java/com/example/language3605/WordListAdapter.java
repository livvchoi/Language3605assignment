//package com.example.language3605;
//
//import android.content.Context;
//import android.content.Intent;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder>{
//    private static final String TAG = "LanguageAdapter";
//
//    private ArrayList<String> indigList = new ArrayList<>();
//    private ArrayList<String> englishList = new ArrayList<>();
//    private Context mContext;
//
//    public static String wordPosition;
//
//    public WordListAdapter(Context context, ArrayList<String> indig, ArrayList<String> english) {
//        indigList = indig;
//        englishList = english;
//        mContext = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wordlist_item, parent, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position){
//        Log.d(TAG, "onBindViewHolder:called");
//
//        holder.indig.setText(indigList.get(position));
//        holder.english.setText(englishList.get(position));
//
//        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Log.d(TAG, "onClick: clicked on: " + englishList.get(position));
//
//                Toast.makeText(mContext, englishList.get(position), Toast.LENGTH_SHORT).show();
//
//                wordPosition = englishList.get(position);
//
//                Intent intent = new Intent(mContext, PictureActivity.class);
//                intent.putExtra("word_type", englishList.get(position));
//                mContext.startActivity(intent);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount(){
//        return englishList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        TextView indig;
//        TextView english;
//        RelativeLayout parentLayout;
//
//        public ViewHolder(View itemView){
//            super(itemView);
//            indig = itemView.findViewById(R.id.indig_tv);
//            english = itemView.findViewById(R.id.english_tv);
//            parentLayout = itemView.findViewById(R.id.parent_layout);
//        }
//    }
//
//
//
//}
//
