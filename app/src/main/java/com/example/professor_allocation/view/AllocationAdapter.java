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
import com.example.professor_allocation.model.Allocation;

import java.util.List;

public class AllocationAdapter extends RecyclerView.Adapter<AllocationAdapter.AllocationHolder> {

    private List<Allocation> allocations;
    private final LayoutInflater mInflater;

    public AllocationAdapter(Context context, List<Allocation> allocations){

        this. mInflater = LayoutInflater.from(context);
        this.allocations = allocations;
    }


    @NonNull
    @Override
    public AllocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.item_view2, parent,false);

        return new AllocationAdapter.AllocationHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AllocationAdapter.AllocationHolder holder, int position) {

        holder.textView1.setText(allocations.get(position).getCourse().getName());
        holder.textView2.setText(allocations.get(position).getProfessor().getName());

    }

    @Override
    public int getItemCount() {
        return allocations.size();
    }

    public class AllocationHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView1, textView2;

        public AllocationHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_professor);
            textView1 = itemView.findViewById(R.id.name_course);
            textView2 = itemView.findViewById(R.id.name_professor);

        }
    }
}
