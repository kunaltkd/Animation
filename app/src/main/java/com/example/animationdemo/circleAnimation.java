package com.example.animationdemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

public class circleAnimation extends View {
Float x,y,radius;
Paint mypaint;
AnimationSet myset;


    public circleAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mypaint = new Paint();
        myset= new AnimationSet();
    }
    public void setRadius(float radius){
     this.radius=radius;
     mypaint.setColor(Color.CYAN ) ;
     invalidate();
    }
    protected void onSizeChanged(int w,int h,int oldw,int oldh){
        ObjectAnimator growAnimator = ObjectAnimator.ofFloat(this,"radius",0,getWidth());
        growAnimator.setDuration(5000);
        growAnimator.setInterpolator(new LinearInterpolator());

        ObjectAnimator shinAnimator = ObjectAnimator.ofFloat(this,"radius",0,getWidth());
        shinAnimator.setDuration(5000);
        shinAnimator.setInterpolator(new DecelerateInterpolator());

    }
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(x,y,radius,mypaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case  MotionEvent.ACTION_DOWN:
                x=event.getX();
                y=event.getY();
                myset.start();
                break;

        }
        return true;
    }
}
