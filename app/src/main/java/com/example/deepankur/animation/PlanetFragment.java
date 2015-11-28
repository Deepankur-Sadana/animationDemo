package com.example.deepankur.animation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by deepankur on 25-11-2015.
 */
public class PlanetFragment extends Fragment {
    public PlanetFragment() {
    }

    EditText email, pass;
    Button signIn, forgot;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planet, container, false);


        email = (EditText) view.findViewById(R.id.ETEmail);
        email.requestFocus();
        pass = (EditText) view.findViewById(R.id.ETPass);
        signIn = (Button) view.findViewById(R.id.signin);
        signIn.setOnClickListener(timeclick);
        forgot = (Button) view.findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Please enter Email", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private View.OnClickListener timeclick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Fragment fragment;
            fragment = new AnimationFragment();
            if (email.getText().toString().contains("123") && pass.getText().toString().contains("123")) {


                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            } else {}

            FragmentTransaction fragmentTransaction =
                    getActivity().getFragmentManager().beginTransaction();

            fragmentTransaction.setCustomAnimations(
                    R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);

            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    };
}
