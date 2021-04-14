package com.example.challangeueb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btnLogin;

    //set pass
    private final String password = "admin";

    boolean isValid = false;
    private  int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPass);
        btnLogin=(Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUsername = etUsername.getText().toString();
                String inputPass = etPassword.getText().toString();

                if(inputUsername.isEmpty() || inputPass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all the details correctly",Toast.LENGTH_SHORT).show();
                } else {
                    isValid = validate(inputPass);

                    if (!isValid){
                        counter--;
                        Toast.makeText(MainActivity.this,"Incorrect Your Password",Toast.LENGTH_SHORT).show();

                        if (counter == 0){
                            btnLogin.setEnabled(false);
                        }
                    }else {
                        Toast.makeText(MainActivity.this,"Login Successful!",Toast.LENGTH_SHORT).show();

                        //Add the code to move activity
                        Intent i = new Intent(MainActivity.this, MainPage.class);
                        i.putExtra("username",inputUsername);
                        startActivity(i);

                    }

                }

                
            }
        });

    }

   private boolean validate(String pass){

        if(pass.equals(password)){
            return true;
        }
        return false;
   }
}
