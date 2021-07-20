package com.example.language3605;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SelectQuizAdapter extends RecyclerView.Adapter<SelectQuizAdapter.ViewHolder> {

    private static final String TAG = "SelectQuizAdapter";

    Context mContext;
    ArrayList<String> categoryQuizList;
    ArrayList<Integer> questionCounter;

    //private ItemClickListener clickListener;
    public static String quizPosition;
    public static Integer countPosition;

    public SelectQuizAdapter(Context context, ArrayList<String> category, ArrayList<Integer> counting) {
        mContext = context;
        categoryQuizList = category;
        questionCounter = counting;
    }



    @NonNull
    @Override
    public SelectQuizAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item, parent, false);
        SelectQuizAdapter.ViewHolder holder = new SelectQuizAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //Click listener
        holder.questionCounting.setText(questionCounter.get(position).toString());
        holder.categoryName.setText(categoryQuizList.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + categoryQuizList.get(position));
                //clickListener.onItemClick(QuizList.get((position)));
                quizPosition = categoryQuizList.get(position);
                countPosition = questionCounter.get(position);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                StartQuizFragment goFragment = new StartQuizFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, goFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryQuizList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView questionCounting, categoryName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            questionCounting = itemView.findViewById(R.id.tv_num_question);
            categoryName = itemView.findViewById(R.id.tv_quiz_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            //numQuestion = view.findViewById(R.id.tv_num_question);
            //quizIcon = view.findViewById(R.id.iv_quiz_icon);
        }
    }
}

//    public interface ItemClickListener{
//        public void onItemClick (SelectQuizData selectQuizData);
//    }
//}
