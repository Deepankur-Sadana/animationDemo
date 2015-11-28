package com.example.deepankur.animation;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by deepankur on 25-11-2015.
 */
public class Animate3 extends Fragment {
    ImageView planet;
    ImageView rocket,yellow;

    public Animate3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animat3, container, false);

        planet = (ImageView) view.findViewById(R.id.planet);
        rocket = (ImageView) view.findViewById(R.id.rocketsmall);
        yellow = (ImageView) view.findViewById(R.id.yellow);

        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        planet.startAnimation(fadeIn);
        fadeIn.setDuration(5000);
        fadeIn.setFillAfter(true);

        /** set splash time out */
        final int splashTimer = 3000;

        /** create a thread to show splash up to splash time */
        final Thread welcomeThread = new Thread() {
            int wait;

            //   * Thread for Splash

            @Override
            public void run() {
                try {
                    /**
                     * use while to get the splash time. Use sleep() to increase
                     * the wait variable for every 100L.
                     */
                    while (wait < splashTimer) {
                        sleep(100);
                        wait += 100;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
            }
        };
        welcomeThread.start();

        Animation leftanimation = new TranslateAnimation(0.0f, 0.0f,
                0.0f, -1750.0f);
        leftanimation.setDuration(5000); // repeat animation (left to right, right to left )
        leftanimation.setFillAfter(true);
        rocket.startAnimation(leftanimation);
        rocket.startAnimation(leftanimation);




        return view;
    }


}
