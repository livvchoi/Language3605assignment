package com.example.language3605;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListOfWordsAdapter extends RecyclerView.Adapter<ListOfWordsAdapter.WordListViewHolder> {
    private static final String TAG = "ListOfWordsAdapter";

    private List<Dictionary> mDictionary;
    //TODO: Add filtered list functionality

    //public static ArrayList<String> englishList;
    //public static ArrayList<String> indigList;
    public static Context mContext;

    public static String englishPosition;
    public static String indigPosition;


    //ListofWordsAdapter Constructor
    public ListOfWordsAdapter(Context context, List<Dictionary> dictionary) {
        mContext = context;
        mDictionary = dictionary;
    }

    public interface Listener{
        void onClick(View view, String id);
    }
    @NonNull
    @Override
    public WordListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wordlist_item, parent, false);
        WordListViewHolder holder = new WordListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(WordListViewHolder holder, int position) {
        Dictionary entry = mDictionary.get(position);
        holder.englishWord.setText(entry.getEnglishWord());
        holder.indigWord.setText(entry.getWord());


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "onClick: clicked on: " +englishList.get(position));

                englishPosition = englishList.get(position);
                indigPosition = indigList.get(position);



                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                DictionaryFragment myFragment = new DictionaryFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return mDictionary.size();
    }

    public static class WordListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView englishWord, indigWord;
        public static RelativeLayout parentLayout;
        private Listener listener;

        public WordListViewHolder(@NonNull View itemView, Listener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);

            englishWord = itemView.findViewById(R.id.tv_english_word);
            indigWord = itemView.findViewById(R.id.indig_tv);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }
    }

//    public void filterList(ArrayList<Words> filteredList) {
//        mExampleList = filteredList;
//        notifyDataSetChanged();
//    }
}
