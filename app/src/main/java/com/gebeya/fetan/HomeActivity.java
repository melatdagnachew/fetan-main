package com.gebeya.fetan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gebeya.fetan.framework.base.BaseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    private FloatingActionButton fab;

    @BindView(R.id.homeNoRunsLabel)
    TextView noRunsLabel;

    @BindView(R.id.summaryContainer)
    LinearLayout container;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {
            final Intent intent = new Intent(getApplicationContext(), AddRunActivity.class);
            startActivity(intent);


            LayoutInflater Inflater = getLayoutInflater();
         View root=  Inflater.inflate(R.layout.runs_summary_layout,container,true);

         TextView timeLabel = findViewById(R.id.homeSummaryTimeLabel);
         timeLabel.setText("0 mins");

        });

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
