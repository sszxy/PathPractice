package com.example.pesonpath;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 张翔宇 on 2018/5/26.
 */

public class wangyuanjing extends View {
    Paint paint;
    Bitmap bitmap;
    Bitmap bitmapRG;
    float downx=-1,downy=-1;
    public wangyuanjing(Context context) {
        super(context);
        init();
    }

    public wangyuanjing(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public wangyuanjing(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.background2);
        paint=new Paint();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                 downx=event.getX();
                 downy=event.getY();
                 invalidate();
                 return true;
            case MotionEvent.ACTION_MOVE:
                downx=event.getX();
                downy=event.getY();
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                downx=-1;
                downy=-1;
                 invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
     /*   if(bitmapRG==null){
            bitmapRG=Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_8888);
            Canvas c=new Canvas(bitmapRG);
            c.drawBitmap(bitmap,null,new Rect(0,0,getWidth(),getHeight()),paint);
        }*/
        if(downx!=-1&&downy!=-1) {
            paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            canvas.drawCircle(downx,downy,150,paint);
        }
    }
}
