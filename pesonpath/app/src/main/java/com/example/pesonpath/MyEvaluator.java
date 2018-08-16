package com.example.pesonpath;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;

/**
 * Created by 张翔宇 on 2018/5/23.
 */

public class MyEvaluator implements TypeEvaluator<PointF> {
    PointF point1=new PointF();
    PointF point2=new PointF();
    public MyEvaluator(PointF point1,PointF point2){
        this.point1=point1;
        this.point2=point2;
    }

    @Override
    public PointF evaluate(float time, PointF startValue, PointF endValue) {
         float timeleft=1.0f-time;
         PointF pointf=new PointF();
         PointF point0=startValue;
         PointF point3=endValue;
         pointf.x=timeleft*timeleft*timeleft*point0.x+3*timeleft*timeleft*time*point1.x
                +3*timeleft*time*time*point2.x+time*time*time*point3.x;
         pointf.y=timeleft*timeleft*timeleft*point0.y+3*timeleft*timeleft*time*point1.y
                +3*timeleft*time*time*point2.y+time*time*time*point3.y;
         return pointf;
    }
}
