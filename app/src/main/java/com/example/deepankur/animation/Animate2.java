package com.example.deepankur.animation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by deepankur on 25-11-2015.
 */
public class Animate2 extends Fragment {
    RelativeLayout relativeLayout;
    ImageView rocket, orange, left, right;
    LinearLayout linearLayout;

    public Animate2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animat2, container, false);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.relative);
        rocket = (ImageView) view.findViewById(R.id.rocket);
        orange = (ImageView) view.findViewById(R.id.orange);
        left = (ImageView) view.findViewById(R.id.left);
        right = (ImageView) view.findViewById(R.id.right);
        linearLayout=(LinearLayout)view.findViewById(R.id.linear);

        Animation animation = new TranslateAnimation(0.0f, 0.0f,
                0.0f, -450.0f);
        animation.setDuration(5000); // repeat animation (left to right, right to left )
        animation.setFillAfter(true);
        animateleft();
        animateright();
        animatecenter();
        createThread();
        rocket.startAnimation(animation);

        return view;
    }
    private void createThread() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rocket.setImageResource(R.mipmap.rocketwithfire);
                postfirstanimation();
                createfinalThread();

            }
        }, 5000);
    }

    private void createfinalThread() {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Fragment fragment;
                fragment = new Animate3();
          /*      FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

*/

                FragmentTransaction fragmentTransaction =
                        getActivity().getFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(
                        R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);

                fragmentTransaction.replace(R.id.content_frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        }, 5000);

    }

    private void postfirstanimation() {
        Animation leftanimation = new TranslateAnimation(.0f, -450.0f,
                -250.0f, 450.0f);
        leftanimation.setDuration(5000); // repeat animation (left to right, right to left )
        leftanimation.setFillAfter(true);
        left.startAnimation(leftanimation);


        Animation rightanimation = new TranslateAnimation(.0f, 450.0f,
                -250.0f, 450.0f);
        rightanimation.setDuration(5000); // repeat animation (left to right, right to left )
        rightanimation.setFillAfter(true);
        right.startAnimation(rightanimation);


        Animation centeranimation = new TranslateAnimation(0.0f, 0.0f,
                 -450.0f,500.0f);
        centeranimation.setDuration(8000); // repeat animation (left to right, right to left )
        centeranimation.setFillAfter(true);
        orange.startAnimation(centeranimation);

        Animation animation = new TranslateAnimation(0.0f, 0.0f,
                -450.0f, -1750.0f);
        animation.setDuration(25000);
        finalThread();
         // repeat animation (left to right, right to left )
        animation.setFillAfter(true);
        rocket.startAnimation(animation);


    }
    private void animateleft(){
        Animation leftanimation = new TranslateAnimation(0.0f, 0.0f,
                0.0f, -250.0f);
        leftanimation.setDuration(5000);
        leftanimation.setFillAfter(true);
        left.startAnimation(leftanimation);

    }

    private void animatecenter(){
        Animation centeranimation = new TranslateAnimation(0.0f, 0.0f,
                0.0f, -450.0f);
        centeranimation.setDuration(5000); // repeat animation (left to right, right to left )
        centeranimation.setFillAfter(true);
        orange.startAnimation(centeranimation);

    }

    private void animateright(){
        Animation rightanimation = new TranslateAnimation(0.0f, 0.0f,
                0.0f, -250.0f);
        rightanimation.setDuration(5000); // repeat animation (left to right, right to left )
        rightanimation.setFillAfter(true);
        right.startAnimation(rightanimation);

    }


    private void finalThread(){
        final float growTo = 1.2f;
        final long duration = 1200;

        ScaleAnimation grow = new ScaleAnimation(1, growTo, 1, growTo,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        grow.setDuration(duration / 2);
        ScaleAnimation shrink = new ScaleAnimation(growTo, 1, growTo, 1,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        shrink.setDuration(duration / 2);
        shrink.setStartOffset(duration / 2);
        AnimationSet growAndShrink = new AnimationSet(true);
        growAndShrink.setInterpolator(new LinearInterpolator());
        growAndShrink.addAnimation(grow);
        growAndShrink.addAnimation(shrink);
        rocket.startAnimation(growAndShrink);
    }
}
