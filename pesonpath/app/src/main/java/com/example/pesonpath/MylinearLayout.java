package com.example.pesonpath;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 张翔宇 on 2018/5/24.
 */

public class MylinearLayout extends ViewGroup {
    public MylinearLayout(Context context) {
        super(context);
    }

    public MylinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MylinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int widthmode=MeasureSpec.getMode(widthMeasureSpec);
        int widthsize=MeasureSpec.getSize(widthMeasureSpec);
        int heightmode=MeasureSpec.getMode(heightMeasureSpec);
        int heigtsize=MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        if (widthmode==MeasureSpec.AT_MOST&&heightmode==MeasureSpec.AT_MOST){
            widthsize=getMaxwidth();
            heigtsize=getMaxHeight();
        }else if(widthmode==MeasureSpec.AT_MOST){
            widthsize=getMaxwidth();
        }else if (heightmode==MeasureSpec.AT_MOST){
            heigtsize=getMaxHeight();
        }
        setMeasuredDimension(widthsize,heigtsize);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int layoutleft=l;
        for (int i=0;i<getChildCount();i++){
            int height=getChildAt(i).getMeasuredHeight();
            int width=getChildAt(i).getMeasuredWidth();
            getChildAt(i).layout(layoutleft,t,layoutleft+width,t+height);
            layoutleft=layoutleft+width;
        }
    }
    public int getMaxwidth(){
        int Maxwidth=0;
        for (int i=0;i<getChildCount();i++){
                Maxwidth+=getChildAt(i).getMeasuredWidth();
            }
        return Maxwidth;
    }
    public int getMaxHeight(){

        int Maxheight=0;
        for (int i=0;i<getChildCount();i++){
            if(Maxheight<getChildAt(i).getMeasuredHeight()){
                Maxheight=getChildAt(i).getMeasuredHeight();
            }
        }
        return Maxheight;
    }
}
