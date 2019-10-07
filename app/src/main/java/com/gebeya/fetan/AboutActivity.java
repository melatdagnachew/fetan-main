package com.gebeya.fetan;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.gebeya.fetan.framework.base.BaseActivity;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends BaseActivity {

    @BindView(R.id.aboutLogoIon)
    ImageView shoeLogo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        animation();
    }
    public void animation(){

        AnimatorSet fabAnimation = (AnimatorSet)
                AnimatorInflater.loadAnimator(this,R.animator.fab_animation);

        fabAnimation.setTarget(shoeLogo);
        fabAnimation.start();

        ObjectAnimator animator = ObjectAnimator.ofFloat(shoeLogo,"rotation",0,-90);
        animator.setDuration(1500);
        animator.setStartDelay(400);
        animator.start();

    }

}
