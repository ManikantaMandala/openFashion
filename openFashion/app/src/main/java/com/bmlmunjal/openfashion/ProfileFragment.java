package com.bmlmunjal.openfashion;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragment extends Fragment implements View.OnClickListener {

    FirebaseAuth mAuth;
    Button logoutButton;
    ImageView imageViewArrowReturn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mAuth= FirebaseAuth.getInstance();
        View myView=inflater.inflate(R.layout.fragment_profile, container, false);
        logoutButton=(Button) myView.findViewById(R.id.logoutButtonProfileFragment);
        imageViewArrowReturn = (ImageView) myView.findViewById(R.id.arrow_return);

        logoutButton.setOnClickListener(this);
        return myView;
    }
    private void closeFragment(){
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.logoutButtonProfileFragment):
                mAuth.signOut();
                startActivity(new Intent(getActivity(),MainActivity.class));
                closeFragment();
                break;
        }
    }
}