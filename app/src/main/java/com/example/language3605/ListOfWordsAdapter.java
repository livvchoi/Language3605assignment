package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListOfWordsAdapter extends RecyclerView.Adapter<ListOfWordsAdapter.WordListViewHolder> {
    private static final String TAG = "ListOfWordsAdapter";

    private List<Dictionary> mDictionary;
    private List<Dictionary> mCategoryDictionary;
    private Listener mListener;
    //public static Context mContext;
    public static String wordPosition;
    // public static String indigPosition;

    public ListOfWordsAdapter(List<Dictionary> dictionary, Listener listener) {
        //mContext = context;
        mDictionary = dictionary;
        mListener = listener;
    }
    public ListOfWordsAdapter(List<Dictionary> dictionary) {
        mDictionary = dictionary;

    }

    //ListofWordsAdapter constructor
    /*public ListOfWordsAdapter(Context context, List<Dictionary> dictionary) {
        mContext = context;
        mDictionary = dictionary;
    }*/

    //TODO: Add filtered list functionality

    public interface Listener{
        void onClick(View view, String id);
    }
    @NonNull
    @Override
    public WordListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wordlist_item, parent, false);
       WordListViewHolder holder = new WordListViewHolder(view, mListener);
//        WordListViewHolder holder = new WordListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(WordListViewHolder holder, int position) {
        Dictionary entry = mDictionary.get(position);
        holder.englishWord.setText(entry.getEnglishWord());
        holder.indigWord.setText(entry.getWord());
        holder.itemView.setTag(entry.getId());
        /*holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "onClick: clicked on: " +englishList.get(position));

                wordPosition = englishList.get(position);
                indigPosition = indigList.get(position);



                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                DictionaryFragment myFragment = new DictionaryFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return mCategoryDictionary.size();
    }

    public static class WordListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView englishWord, indigWord;
        public ImageView wordImage;
       // public static RelativeLayout parentLayout;
        private Listener listener;

        public WordListViewHolder(@NonNull View itemView, Listener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);

            englishWord = itemView.findViewById(R.id.tv_english_word);
            indigWord = itemView.findViewById(R.id.indig_tv);
            wordImage = itemView.findViewById(R.id.ivWordIcon);
            //parentLayout = itemView.findViewById(R.id.parent_layout);
        }

        @Override
        public void onClick(View v) {
            Bundle bundle = new Bundle();
            bundle.putString("id", (String) v.getTag());

            DictionaryFragment dictionaryFragment = new DictionaryFragment();

            dictionaryFragment.setArguments(bundle);

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, dictionaryFragment).addToBackStack(null).commit();
            //listener.onClick(v, (String) v.getTag());

        }
    }

//    public void filterList(ArrayList<Words> filteredList) {
//        mExampleList = filteredList;
//        notifyDataSetChanged();
//    }
}
