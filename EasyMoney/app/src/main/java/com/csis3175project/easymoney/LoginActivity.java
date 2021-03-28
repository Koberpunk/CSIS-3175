package com.csis3175project.easymoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class LoginActivity extends AppCompatActivity {
    EMDatabase myhelper;
    private String inputUserName;
    private String inputUserPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myhelper = new EMDatabase(this);

        TextInputEditText password = findViewById(R.id.inputPassword);
        TextInputEditText userName = findViewById(R.id.inputUserName);

        ImageView btnBack = findViewById(R.id.btnBack);
        Button btnLogin = findViewById(R.id.btnSignUp);

        TextView btnSignUp = findViewById(R.id.btnGoSignUpWelcome);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputUserName = userName.getText().toString();
                inputUserPassword = password.getText().toString();

                System.out.println(inputUserName + " : " + inputUserPassword);


                boolean ischecked =
                        myhelper.checkLogin(inputUserName, inputUserPassword);

                if(ischecked) {
                    Toast.makeText(LoginActivity.this, "Welcome," + inputUserName, Toast.LENGTH_LONG).show();
//                    startActivity(new Intent(LoginActivity,this. --put the name of screen--.class)

                } else {
                    Toast.makeText(LoginActivity.this, "Please check username or password again", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}