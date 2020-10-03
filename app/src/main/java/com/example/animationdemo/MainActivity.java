package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    AnimationDrawable animDrawable;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);
        imageView.setBackgroundResource(R.drawable.frameanimation);
        animDrawable = (AnimationDrawable) imageView.getBackground();
        AnimationUtils.loadAnimation(this, R.anim.anim);
    }

    public void frameAnimation(View view) {
        switch (view.getId()) {
            case R.id.b11:
                if (!animDrawable.isRunning())
                    animDrawable.start();
                break;
            case R.id.b12:
                if (animDrawable.isRunning())
                    animDrawable.stop();
                break;

        }
    }


    public void mytweenanimation(View view) {
        switch (view.getId()) {
            case R.id.b13:
                AlphaAnimation aNnim = new AlphaAnimation(1.0f, 0.0f);
                aNnim.setDuration(3000);
                aNnim.setRepeatCount(1);
                aNnim.setFillAfter(true);
                imageView.startAnimation(aNnim);
                break;

            case R.id.b14:
                //imageView.startAnimation(anim);
                ScaleAnimation sAnim = new ScaleAnimation(1.0f, 4.0f, 1.0f, 3.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                sAnim.setDuration(3000);
                imageView.startAnimation(sAnim);
                break;
            //   case R.id.b15:
            // imageView.startAnimation(anim);
            //    TranslateAnimation tanim=new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,0.0f,
            //           Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,1.0f);
            // tanim.setDuration(5000);
            //imageView.startAnimation(tanim);
            //}
            //imageView.setAnimation(anim);
            case R.id.b16:
                //imageView.startAnimation(a
                RotateAnimation ranim= new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                ranim.setDuration(5000);
                imageView.startAnimation(ranim);
                break;
            case R.id.b17:
                AnimationSet animationSet=new AnimationSet(true);

                   TranslateAnimation tanim=new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
                           0.0f,Animation.RELATIVE_TO_PARENT,0.0f,
                         Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,1.0f);
                 tanim.setDuration(5000);
                RotateAnimation ranim1= new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,
                        0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                ranim1.setStartOffset(6000);
                ranim1.setDuration(5000);
                animationSet.addAnimation(tanim);
                animationSet.addAnimation(ranim1);
                imageView.startAnimation(animationSet);

        }
    }
}