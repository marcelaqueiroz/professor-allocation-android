package com.example.professor_allocation.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professor_allocation.R;
import com.example.professor_allocation.model.Course;

import java.util.List;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseHolder> {

    private List<Course> courses;
    private final LayoutInflater mInflater;


    public CourseAdapter(Context context, List<Course> courses) {

        this.mInflater = LayoutInflater.from(context);
        this.courses = courses;

    }

    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.item_view, parent,false);

        return new CourseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {

        holder.textView.setText(courses.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class CourseHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public CourseHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_professor);
            textView = itemView.findViewById(R.id.name_professor);

        }
    }
}