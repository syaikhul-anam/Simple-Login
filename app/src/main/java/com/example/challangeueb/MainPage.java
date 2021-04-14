package com.example.challangeueb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        text1=(TextView) findViewById(R.id.Text_mail);

        String dataText = getIntent().getStringExtra("username");

        text1.setText(dataText);




    }
}
