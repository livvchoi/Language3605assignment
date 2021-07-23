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

        import java.lang.reflect.Array;
        import java.util.ArrayList;

public class ListOfWordsAdapter extends RecyclerView.Adapter<ListOfWordsAdapter.ViewHolder> {
    private static final String TAG = "ListOfWordsAdapter";

    public static ArrayList<String> englishList;
    public static ArrayList<String> indigList;
    public static Context mContext;

    public static String englishPosition;
    public static String indigPosition;

//    private ArrayList<Dictionary> mExampleList;
//
//    public ListOfWordsAdapter(ArrayList<Dictionary> exampleList){
//        mExampleList = exampleList;
//    }


    public ListOfWordsAdapter(Context context, ArrayList<String> english, ArrayList<String> indig) {
        mContext = context;
        englishList = english;
        indigList = indig;
    }

    @NonNull
    @Override
    public ListOfWordsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wordlist_item, parent, false);
        ListOfWordsAdapter.ViewHolder holder = new ListOfWordsAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Dictionary currentItem = mExampleList.get(position);
        holder.englishWord.setText(englishList.get(position));
        holder.indigWord.setText(indigList.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " +englishList.get(position));

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
        return englishList.size();
    }

//    @Override
//    public int getItemCount() {
//        return mExampleList.size();
//    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static TextView englishWord;
        public static TextView indigWord;

        public static RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            englishWord = itemView.findViewById(R.id.tv_english_word);
            indigWord = itemView.findViewById(R.id.indig_tv);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

//    public void filterList(ArrayList<Dictionary>filteredList){
//        mExampleList = filteredList;
//        notifyDataSetChanged();
//    }

}
