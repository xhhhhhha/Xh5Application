package com.example.xh5application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class Main4Activity extends AppCompatActivity implements android.view.GestureDetector.OnGestureListener  {
private int[] images={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5};
private GestureDetector gestureDetector=null;
private ViewFlipper viewFlipper=null;
private static final int FLING_MIN_DISTANCE=100;
private static final int FLING_MIN_VELOCITY=200;
private Activity mactivity=null;
private Animation rInAnim,rOutAnim,lInAnim,lOutAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mactivity=this;
        viewFlipper=findViewById(R.id.ViewFlipper01);
        gestureDetector =new GestureDetector(this, (GestureDetector.OnGestureListener) this);
        rInAnim= AnimationUtils.loadAnimation(mactivity,R.anim.push_right_in);
        rOutAnim=AnimationUtils.loadAnimation(mactivity,R.anim.push_right_out);
        lInAnim=AnimationUtils.loadAnimation(mactivity,R.anim.push_left_in);
        lOutAnim=AnimationUtils.loadAnimation(mactivity,R.anim.push_left_out);
        for(int i=0;i<images.length;i++){
            ImageView iv=new ImageView(this);
            iv.setImageResource(images[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);

            viewFlipper.addView(iv, i, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        }
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        viewFlipper.stopFlipping();
        viewFlipper.setAutoStart(false);
        return gestureDetector.onTouchEvent(event);
    }
    @Override
    public boolean onDown(MotionEvent e){
        return  false;
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        // 从左向右滑动（左进右出）,X轴的坐标位移大于FLING_MIN_DISTANCE，且移动速度大于FLING_MIN_VELOCITY个像素/秒
        if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {

            viewFlipper.setInAnimation(rInAnim);
            viewFlipper.setOutAnimation(rOutAnim);
            viewFlipper.showPrevious();
            setTitle("相片编号：" + viewFlipper.getDisplayedChild());
            return true;
        } else if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {         // 从右向左滑动（右进左出）
            viewFlipper.setInAnimation(lInAnim);
            viewFlipper.setOutAnimation(lOutAnim);
            viewFlipper.showNext();
            setTitle("相片编号：" + viewFlipper.getDisplayedChild());
            return true;
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
}

