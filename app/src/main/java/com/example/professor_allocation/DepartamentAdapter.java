package com.example.professor_allocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professor_allocation.model.Departament;

import java.util.List;

public class DepartamentAdapter extends RecyclerView.Adapter<DepartamentAdapter.DepartamentHolder> {

    private List<Departament> departaments;
    private final LayoutInflater mInflater;


    public DepartamentAdapter(Context context, List<Departament> departaments) {

        this.mInflater = LayoutInflater.from(context);
        this.departaments = departaments;

    }

    @NonNull
    @Override
    public DepartamentAdapter.DepartamentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.item_view, parent,false);

        return new DepartamentAdapter.DepartamentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartamentAdapter.DepartamentHolder holder, int position) {

        holder.textView.setText(departaments.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return departaments.size();
    }

    public class DepartamentHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public DepartamentHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_professor);
            textView = itemView.findViewById(R.id.name_professor);

        }
    }
}