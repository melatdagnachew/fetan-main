package com.gebeya.fetan;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.gebeya.fetan.framework.base.BaseActivity;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity {

    @BindView(R.id.aboutLogoIon)
    ImageView logo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        rotate();
    }

    @OnClick(R.id.aboutLogoIon)
    public void rotate() {
        Random rand = new Random();
        int factor = rand.nextInt(5);
        int direction = rand.nextInt(2);

        float size = rand.nextInt(360) + 360;

        float degree = size * factor;
        degree = degree * (direction == 0 ? 1 : -1);
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                logo, "rotation", degree
        );
        animator.setDuration(2000);
        animator.start();
    }
}
