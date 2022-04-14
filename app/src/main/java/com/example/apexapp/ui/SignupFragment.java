package com.example.apexapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.apexapp.Database;
import com.example.apexapp.R;

public class SignupFragment extends Fragment{

    View view;
    //
    TextView loginTextView;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText confirmPasswordEditText;
    Button signUpButton;
    Database db = new Database();

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_signup, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeView();
    }

    private void initializeView(){
        loginTextView = view.findViewById(R.id.loginTextView);
        usernameEditText = view.findViewById(R.id.usernameEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        confirmPasswordEditText = view.findViewById(R.id.confirmPasswordEditText);
        signUpButton = view.findViewById(R.id.signUpButton);
        //
        loginSetOnClickListener(view);
        signUpButtonOnClickListener(view);
    }

    // Listeners

    private void loginSetOnClickListener(View view){
        loginTextView = view.findViewById(R.id.loginTextView);
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController;
                //
                navController = NavHostFragment.findNavController(SignupFragment.this);
                navController.navigate(R.id.action_signup_to_login);

            }
        });
    }

    private void signUpButtonOnClickListener(View view){
        signUpButton = view.findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                if(password.equals(confirmPassword)){
                    db.registerUser(username, password);
                }

            }
        });
    }

    /*
    private void createNewUser(View view) {

    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
