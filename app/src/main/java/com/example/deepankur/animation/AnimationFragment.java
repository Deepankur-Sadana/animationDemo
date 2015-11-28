package com.example.deepankur.animation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by deepankur on 25-11-2015.
 */
public class AnimationFragment extends Fragment {
    ImageView img_animation, smoke;

    public AnimationFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animation, container, false);


        img_animation = (ImageView) view.findViewById(R.id.rocketfull);

        /*TranslateAnimation animation = new TranslateAnimation(0.0f, 400.0f,
                0.0f, 0.0f); */

        Animation animation = new TranslateAnimation(0.0f, 0.0f,
                0.0f, -900.0f);
        animation.setDuration(5000);  // animation duration
        animation.setRepeatCount(0);  // animation repeat count
        animation.setRepeatMode(0);   // repeat animation (left to right, right to left )
        //animation.setFillAfter(true);
        try {

            nextFrag();
        } catch (Exception e) {
            Log.d("Exception", e.toString());
        }


        img_animation.startAnimation(animation);
        smoke = (ImageView) view.findViewById(R.id.smoke);
        smoke.setVisibility(View.VISIBLE);
        return view;
    }

    private void nextFrag() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Fragment fragment;
                fragment = new Animate2();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            }
        }, 4500);//// TODO: 25-11-2015  4500
    }

}
