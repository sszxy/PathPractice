package com.example.pesonpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 张翔宇 on 2018/5/24.
 */

public class canvasview extends View {
    public canvasview(Context context) {
        super(context);
    }

    public canvasview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }



    public canvasview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width=getSize(widthMeasureSpec);
        int height=getSize(heightMeasureSpec);
        if(width<=height){
            height=width;
        }else {
            width=height;
        }
        setMeasuredDimension(width,height);
    }
    public int getSize(int measureSpec){
        int defaultsize=100;
        int measuresize=defaultsize;
        int size=MeasureSpec.getSize(measureSpec);
        int sizemode=MeasureSpec.getMode(measureSpec);
        if(sizemode==MeasureSpec.UNSPECIFIED){
            return defaultsize;
        }else if(sizemode==MeasureSpec.AT_MOST){
            measuresize=200;
        }else if (sizemode==MeasureSpec.EXACTLY){
            measuresize=size;
        }
        return measuresize;
    }


}
