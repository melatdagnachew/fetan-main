package com.gebeya.fetan.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "runs")
public class Run {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public double distance;

    @ColumnInfo
    public int time;

    @ColumnInfo(name = "created_at")
    public String createdAt;


}
