package com.gebeya.fetan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gebeya.fetan.data.model.Run;

import java.util.ArrayList;

public class RunAdapter extends RecyclerView.Adapter<RunViewHolder> {

    private ArrayList<Run> runs;
    private LayoutInflater inflater;

    public RunAdapter(ArrayList<Run> runs, Context context) {
        this.runs = runs;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RunViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView  = inflater.inflate(R.layout.run_item_layout,parent,false);

        return new RunViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RunViewHolder holder, int position) {

        Run run = runs.get(position);

        holder.createdAtLabel.setText(String.valueOf(run.createdAt));
        holder.distancelabel.setText(String.valueOf(run.distance));
        holder.timeLabel.setText(String.valueOf(run.time));
    }


    @Override
    public int getItemCount() {
        return runs.size();
    }
}
