package com.gebeya.fetan;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RunViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.runItemTimeLabel)
    public TextView timeLabel;

    @BindView(R.id.runItemDistanceLabel)
    public TextView distancelabel;

    @BindView(R.id.runItemCreatedAtLabel)
    public TextView createdAtLabel;

    public RunViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
