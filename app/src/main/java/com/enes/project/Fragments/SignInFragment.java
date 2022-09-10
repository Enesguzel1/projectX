package com.enes.project.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.enes.project.R;


public class SignInFragment extends Fragment {
    TextView signUpText,forgotPasswordText;
    Button signInButton;

    public SignInFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signUpText=view.findViewById(R.id.signUpText);
        forgotPasswordText=view.findViewById(R.id.forgotPasswordText);
        signInButton=view.findViewById(R.id.signInButton);


        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSignUp(view);
            }
        });

        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToForgotPasswordFragment(view);
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHomePage(view);
            }
        });

    }


    public void goToForgotPasswordFragment(View view){
        NavDirections action=SignInFragmentDirections.actionSignInFragmentToForgotPasswordFragment();
        Navigation.findNavController(view).navigate(action);

    }
    public void goToSignUp(View view){
        NavDirections action = SignInFragmentDirections.actionSignInFragmentToSignUpFragment();
        Navigation.findNavController(view).navigate(action);
    }

    public void goToHomePage(View view){
        NavDirections action = SignInFragmentDirections.actionSignInFragmentToHomePageActivity();
        Navigation.findNavController(view).navigate(action);
    }

}