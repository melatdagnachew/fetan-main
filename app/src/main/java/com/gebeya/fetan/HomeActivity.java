package com.gebeya.fetan;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        AnimatorSet fabAnimation = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.fab_animation
        );
        fabAnimation.setTarget(fab);
        fabAnimation.start();

        ObjectAnimator animator = ObjectAnimator.ofFloat(
                noRunsLabel, "alpha", 0f, 1f
        );
        animator.setDuration(1000);
        animator.setStartDelay(400);
        animator.start();
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
