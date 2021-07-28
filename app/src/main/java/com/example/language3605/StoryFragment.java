package com.example.language3605;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoryFragment extends Fragment {


    private TextView mStoryTitle, mStoryBody, mStoryCountry;
    private ImageView mStorySource;
    private RecyclerView storyRecyclerView;
    private String storyId;


     List<Story>storyList = HomeFragment.storyList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_story, container, false);

        //get bundle
        Bundle bundle = this.getArguments();
        if (bundle != null){
            storyId = bundle.get("id").toString();
        }

        //instantiate view objects
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        storyRecyclerView = contentView.findViewById(R.id.rvStories);
        storyRecyclerView.setHasFixedSize(true);
        storyRecyclerView.setLayoutManager(layoutManager);

        mStoryTitle = contentView.findViewById(R.id.tvStoryTitle);
        mStorySource = contentView.findViewById(R.id.ivSearch);
        mStoryBody = contentView.findViewById(R.id.tvStoryBody);
        mStoryCountry = contentView.findViewById(R.id.tvStoryCountry);

        mStoryBody.setMovementMethod(new ScrollingMovementMethod());
        mStorySource.setVisibility(View.GONE);

        //get story specified
        Story storyPicked = Story.getStoryEntry(storyList, storyId);

        //show story details
        mStoryTitle.setText(storyPicked.getTitle());
        mStoryCountry.setText("This story is from "+ storyPicked.getCountry());
        mStoryBody.setText(storyPicked.getStories());

        //Make recyclerView
        StoryAdapter storyAdapter = new StoryAdapter(storyList);
        storyRecyclerView.setAdapter(storyAdapter);

        return contentView;
    }
    /*private void openStorySource(Story storyPicked){
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(storyPicked.getSource()));
        MainActivity.startActivity(webIntent);
    }*/
}
