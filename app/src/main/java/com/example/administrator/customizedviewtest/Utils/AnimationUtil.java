package com.example.administrator.customizedviewtest.Utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/10/3.
 */
public class AnimationUtil  {
    public static void rotateOutAnim(RelativeLayout relativeLayout,long delay){
        int childCount=relativeLayout.getChildCount();
        for (int i=0;i<childCount;i++){
            relativeLayout.getChildAt(i).setEnabled(false);
        }
        RotateAnimation ra =new RotateAnimation(0f,-180f,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,1.0f);
        ra.setDuration(500);
        ra.setFillAfter(true);
        ra.setStartOffset(delay);
        relativeLayout.startAnimation(ra);
    }
    public static void rotateInAnim(RelativeLayout relativeLayout){
        int childCount=relativeLayout.getChildCount();
        for (int i=0;i<childCount;i++){
            relativeLayout.getChildAt(i).setEnabled(true);
        }
        RotateAnimation ra =new RotateAnimation(-180f,0f,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,1.0f);
        ra.setDuration(500);
        ra.setFillAfter(true);
        relativeLayout.startAnimation(ra);
    }
}
