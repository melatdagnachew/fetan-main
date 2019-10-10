package com.gebeya.fetan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.gebeya.fetan.data.AppDatabase;
import com.gebeya.fetan.data.model.Run;
import com.gebeya.fetan.framework.base.BaseActivity;
import com.gebeya.fetan.framework.util.Const;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    private FloatingActionButton fab;

    @BindView(R.id.homeNoRunsLabel)
    TextView noRunsLabel;

    @BindView(R.id.summaryContainer)
    LinearLayout container;

    @BindView(R.id.homeRecyclerview)
    RecyclerView mRecyclerView;

    ArrayList<Run> runs;
    RunAdapter mAdapter;
    AppDatabase db;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {
            final Intent intent = new Intent(getApplicationContext(), AddRunActivity.class);
            startActivity(intent);
        });

        Run run = new Run();

        db = Room.databaseBuilder(
                this,
                AppDatabase.class,
                Const.DATABASE_NAME
        ).allowMainThreadQueries()
                .build();

        runs = new ArrayList<>();

        runs.addAll(db.runDao().getAll());

        mAdapter = new RunAdapter(runs,this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));




    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homeMenuSettings:
                return true;
            case R.id.homeMenuAbout:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
