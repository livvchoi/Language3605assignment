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
    //List<SelectQuizData> list;
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

//    public SelectQuizAdapter(Context context, ArrayList<String> category) {
//        mContext = context;
//        categoryQuizList = category;
//    }

    @NonNull
    @Override
    public SelectQuizAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item, parent, false);
        //return new MyViewHolder(view);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item, parent, false);
        SelectQuizAdapter.ViewHolder holder = new SelectQuizAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.quizName.setText(list.get(position).getmQuizName());
//        holder.numQuestion.setText(list.get(position).getmNumQuestion());
//        holder.quizIcon.setImageResource(list.get(position).getmQuizIcon());

        //String selectQuizData = QuizList.get(position);
//        holder.ID.setText(selectQuizData.getID());
//        holder.CategoryName.setText(selectQuizData.getName());


        //Click listener
        holder.questionCounting.setText(String.valueOf(questionCounter.get(position)));
        holder.categoryName.setText(categoryQuizList.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + categoryQuizList.get(position));
                //clickListener.onItemClick(QuizList.get((position)));
                quizPosition = categoryQuizList.get(position);
                Log.d(TAG, "quizPosition: " + quizPosition);

                countPosition = questionCounter.get(position);
                Log.d(TAG, "countPosition: " + countPosition);

                String categoryName = quizPosition;
                Integer questionCount = countPosition;

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                StartQuizFragment goFragment = new StartQuizFragment(categoryName, questionCount);
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

//            quizName = view.findViewById(R.id.tv_quiz_name);
//            numQuestion = view.findViewById(R.id.tv_num_question);
//            quizIcon = view.findViewById(R.id.iv_quiz_icon);

            //ID = view.findViewById(R.id.);
            questionCounting = itemView.findViewById(R.id.tv_static_questions);
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
