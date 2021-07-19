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

public class SelectQuizAdapter extends RecyclerView.Adapter<SelectQuizAdapter.MyViewHolder> {

    private static final String TAG = "SelectQuizAdapter";

    Context context;
    //List<SelectQuizData> list;
    ArrayList<String> categoryQuizList;
    //private ItemClickListener clickListener;
    public static String QuizPosition;


//    public SelectQuizAdapter(Context context, ArrayList<String> list, ItemClickListener clickListener){
//        this.context = context;
//        this.QuizList = list;
//        this.clickListener = clickListener;
//    }

    public SelectQuizAdapter(Context context, ArrayList<String> category){
        this.context = context;
        this.categoryQuizList = category;
    }

    @NonNull
    @Override
    public SelectQuizAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item, parent, false);
        //return new MyViewHolder(view);

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item,parent,false);
        SelectQuizAdapter.MyViewHolder holder = new SelectQuizAdapter.MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
//        holder.quizName.setText(list.get(position).getmQuizName());
//        holder.numQuestion.setText(list.get(position).getmNumQuestion());
//        holder.quizIcon.setImageResource(list.get(position).getmQuizIcon());

        //String selectQuizData = QuizList.get(position);
        holder.CategoryName.setText(categoryQuizList.get(position));
//        holder.ID.setText(selectQuizData.getID());
//        holder.CategoryName.setText(selectQuizData.getName());


        //Click listener
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + categoryQuizList.get(position));
                //clickListener.onItemClick(QuizList.get((position)));
                QuizPosition = categoryQuizList.get(position);

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                StartQuizFragment goFragment = new StartQuizFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,goFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryQuizList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ID, CategoryName;
        RelativeLayout parentLayout;

        public MyViewHolder(View itemView){
            super(itemView);

//            quizName = view.findViewById(R.id.tv_quiz_name);
//            numQuestion = view.findViewById(R.id.tv_num_question);
//            quizIcon = view.findViewById(R.id.iv_quiz_icon);

            //ID = view.findViewById(R.id.);
            CategoryName = itemView.findViewById(R.id.tv_quiz_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            //numQuestion = view.findViewById(R.id.tv_num_question);
            //quizIcon = view.findViewById(R.id.iv_quiz_icon);
        }
    }

//    public interface ItemClickListener{
//        public void onItemClick (SelectQuizData selectQuizData);
//    }
}
