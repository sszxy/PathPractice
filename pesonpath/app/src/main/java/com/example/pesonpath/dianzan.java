package com.example.pesonpath;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Random;

/**
 * Created by 张翔宇 on 2018/5/23.
 */

public class dianzan extends RelativeLayout {
    Random random=new Random();
    ImageView imageView;
    public dianzan(Context context) {
        super(context);
    }

    public dianzan(Context context, AttributeSet attrs) {
        super(context, attrs);
        imageView=new ImageView(context);
    }

    public dianzan(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public AnimatorSet startanimator(){
        imageView=new ImageView(getContext());
        Drawable drawable=getResources().getDrawable(R.drawable.heart_red);
       // Drawable drawable1= ContextCompat.getDrawable(getContext(),R.drawable.heart_red);
        imageView.setImageDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(ALIGN_PARENT_BOTTOM,TRUE);
        layoutParams.addRule(CENTER_HORIZONTAL,TRUE);
        addView(imageView,layoutParams);
        ObjectAnimator animator=ObjectAnimator.ofFloat(imageView,View.ALPHA,0.2f,1.0f);
        ObjectAnimator animator1=ObjectAnimator.ofFloat(imageView,View.SCALE_X,0.2f,1.0f);
        ObjectAnimator animator2=ObjectAnimator.ofFloat(imageView,View.SCALE_Y,0.2f,1.0f);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(animator,animator1,animator2);
        animatorSet.setInterpolator(new LinearInterpolator());
        return animatorSet;
    }
    public void setanimatior(){
        MyEvaluator evaluator=new MyEvaluator(getPointF(2),getPointF(1));
        ValueAnimator animator=ValueAnimator.ofObject(evaluator,new PointF((getWidth()-imageView.getWidth())/2,getHeight()-imageView.getHeight()),
                new PointF(random.nextInt(getWidth()),0));
        animator.setTarget(imageView);
        animator.addUpdateListener(new MyanimationListener(imageView));
        animator.setDuration(1000);
        AnimatorSet animatorSet1=new AnimatorSet();
        animatorSet1.playSequentially(startanimator(),animator);
        animatorSet1.start();
    }
    public PointF getPointF(int scale){
        PointF pointF=new PointF();
        pointF.x=random.nextInt(getWidth()-100);
        pointF.y=random.nextInt(getHeight()-100)/scale;
        return pointF;
    }
}
