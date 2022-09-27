package com.bmlmunjal.openfashion;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class HomeFragment extends Fragment implements View.OnClickListener{

    private TextView logoutTextView;
    private FirebaseAuth mAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_home,container,false);
        mAuth = FirebaseAuth.getInstance();
        logoutTextView=(TextView) myView.findViewById(R.id.logoutTextView);
        logoutTextView.setOnClickListener(this);
        return myView;
    }
    private void closeFragment(){
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.logoutTextView):
                mAuth.signOut();
                startActivity(new Intent(getActivity(),MainActivity.class));
                closeFragment();
                break;
        }
    }
}