package com.example.pesonpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 张翔宇 on 2018/5/22.
 */

public class Myview extends View {

    public void setRadius(int radius) {
        this.radius = radius;
        invalidate();
    }

    int radius=100;
    public Myview(Context context) {
        super(context);
    }

    public Myview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Myview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        canvas.translate(getWidth()/2,getHeight()/2);
        canvas.drawCircle(0,0,radius,paint);
    }

}
