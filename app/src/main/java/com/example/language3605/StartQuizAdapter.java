package com.example.language3605;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class StartQuizAdapter extends RecyclerView.Adapter<StartQuizAdapter.ViewHolder> {

    private static final String TAG = "SelectQuizAdapter";


    @NonNull
    @NotNull
    @Override
    public StartQuizAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_start_quiz, parent, false);
        StartQuizAdapter.ViewHolder holder = new StartQuizAdapter.ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StartQuizAdapter.ViewHolder holder, int position) {

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                StartQuizFragment goFragment = new StartQuizFragment(categoryName, questionCount);
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, goFragment).addToBackStack(null).commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView questionCounting, categoryName;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            questionCounting = itemView.findViewById(R.id.tv_startQuiz_num_question);
            categoryName = itemView.findViewById(R.id.tv_category_name);
            parentLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }

}
