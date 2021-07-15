package com.example.language3605;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SelectQuizAdapter extends RecyclerView.Adapter<SelectQuizAdapter.MyViewHolder> {

    private List<SelectQuizData> list;
    private ItemClickListener clickListener;


    public SelectQuizAdapter(List<SelectQuizData> list, ItemClickListener clickListener){
        this.list = list;
        this.clickListener = clickListener;

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public SelectQuizAdapter.MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull SelectQuizAdapter.MyViewHolder holder, int position) {
        holder.quizName.setText(list.get(position).getmQuizName());
        holder.numQuestion.setText(list.get(position).getmNumQuestion());
        holder.quizIcon.setImageResource(list.get(position).getmQuizIcon());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(list.get((position)));

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView quizName;
        TextView numQuestion;
        ImageView quizIcon;

        public MyViewHolder(View view){
            super(view);

            quizName = view.findViewById(R.id.tv_quiz_name);
            numQuestion = view.findViewById(R.id.tv_num_question);
            quizIcon = view.findViewById(R.id.iv_quiz_icon);
        }
    }

    public interface ItemClickListener{
        public void onItemClick (SelectQuizData selectQuizData);
    }
}
