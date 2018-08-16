package com.example.pesonpath;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 张翔宇 on 2018/5/23.
 */

public class searchview extends View{
    Paint paint=new Paint();
    float length;
    float start=0;
    float end;
    float linex=0;
    float fraction;
    public searchview(Context context) {
        super(context);
    }

    public searchview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        final ValueAnimator animator=ValueAnimator.ofFloat(0f,1f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                fraction=animation.getAnimatedFraction();
                if(fraction<=0.8){
                    start=end*fraction/0.8f;
                    linex=0;
                }else if (fraction<1){
                    start=end;
                    linex=500*(fraction-0.8f);
                }
                invalidate();
            }
        });

        animator.setDuration(5000);
        animator.setRepeatCount(Integer.MAX_VALUE);
        animator.start();
    }

    public searchview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path=new Path();
        canvas.translate(getWidth()/2,getHeight()/2);
        canvas.rotate(45);
        path.addCircle(0,0,200, Path.Direction.CW);
        PathMeasure measure=new PathMeasure();
        measure.setPath(path,false);
        end=measure.getLength();
        Path path1=new Path();
        measure.getSegment(start,end,path1,true);
        canvas.drawPath(path1,paint);
        canvas.drawLine(200+linex,0,300,0,paint);

    }
}
