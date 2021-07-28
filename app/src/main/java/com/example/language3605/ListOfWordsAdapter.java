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

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListOfWordsAdapter extends RecyclerView.Adapter<ListOfWordsAdapter.WordListViewHolder> {
    private static final String TAG = "ListOfWordsAdapter";

    private final List<Dictionary> mDictionary;
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

    public ListOfWordsAdapter(List<Dictionary> mDictionary, List<Dictionary> mCategoryDictionary, Listener mListener) {
        this.mDictionary = mDictionary;
        this.mCategoryDictionary = mCategoryDictionary;
        this.mListener = mListener;
    }

    public ListOfWordsAdapter(List<Dictionary> dictionary) {
        mDictionary = dictionary;

    }

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
        Dictionary entry = mCategoryDictionary.get(position);
        holder.englishWord.setText(entry.getEnglishWord());
        holder.indigWord.setText(entry.getWord());
        holder.itemView.setTag(entry.getId());
        Picasso.get().load(entry.getImage()).into(holder.wordImage);

    }

    @Override
    public int getItemCount() {
        return mCategoryDictionary.size();
    }

    public static class WordListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView englishWord, indigWord;
        public ImageView wordImage;
        private final Listener listener;

        public WordListViewHolder(@NonNull View itemView, Listener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);

            englishWord = itemView.findViewById(R.id.tv_english_word);
            indigWord = itemView.findViewById(R.id.indig_tv);
            wordImage = itemView.findViewById(R.id.ivWordIcon);
        }

        @Override
        public void onClick(View v) {
            Bundle bundle = new Bundle();
            bundle.putString("id", (String) v.getTag());

            DictionaryFragment dictionaryFragment = new DictionaryFragment();

            dictionaryFragment.setArguments(bundle);

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, dictionaryFragment).addToBackStack(null).commit();

        }
    }

//    public void filterList(ArrayList<Words> filteredList) {
//        mExampleList = filteredList;
//        notifyDataSetChanged();
//    }
}
