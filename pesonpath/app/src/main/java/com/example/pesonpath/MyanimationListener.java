package com.example.pesonpath;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;

/**
 * Created by 张翔宇 on 2018/5/23.
 */

public class MyanimationListener implements ValueAnimator.AnimatorUpdateListener {
    private View view;
    public MyanimationListener(View v){
        view=v;
    }
    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        PointF pointF= (PointF) animation.getAnimatedValue();
        view.setX(pointF.x);
        view.setY(pointF.y);
        view.setAlpha(1-animation.getAnimatedFraction());
    }
}
