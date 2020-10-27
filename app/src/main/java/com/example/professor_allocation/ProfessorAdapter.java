package com.example.professor_allocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professor_allocation.model.Professor;

import java.util.List;

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.ProfessorHolder> {

    private List<Professor> professors;
    private final LayoutInflater mInflater;


    public ProfessorAdapter(Context context, List<Professor> professors) {

        this.mInflater = LayoutInflater.from(context);
        this.professors = professors;

    }

    @NonNull
    @Override
    public ProfessorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.item_view, parent,false);

        return new ProfessorHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessorHolder holder, int position) {

        holder.textView.setText(professors.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return professors.size();
    }

    public class ProfessorHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public ProfessorHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_professor);
            textView = itemView.findViewById(R.id.name_professor);

        }
    }


}
