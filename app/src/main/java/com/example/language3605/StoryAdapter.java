package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryListHolder> {
    private final List<Story> mStoryList;

    public StoryAdapter(List<Story> mStoryList) {
        this.mStoryList = mStoryList;
    }

    @NonNull
    @NotNull
    @Override
    public StoryListHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false);
        StoryListHolder holder = new StoryListHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StoryAdapter.StoryListHolder holder, int position) {
        Story storyEntry = mStoryList.get(position);
        holder.showStoryTitle.setText(storyEntry.getTitle());
        holder.itemView.setTag(storyEntry.getID());
    }

    @Override
    public int getItemCount() {
        return mStoryList.size();
    }

    public class StoryListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView showStoryTitle;

        public StoryListHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            showStoryTitle = itemView.findViewById(R.id.tvStoryTitleList);
        }

        @Override
        public void onClick(View v) {
            Bundle bundle = new Bundle();
            bundle.putString("id", (String) v.getTag());

           StoryFragment storyFragment = new StoryFragment();

            storyFragment.setArguments(bundle);

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, storyFragment).addToBackStack(null).commit();

        }
    }
}
