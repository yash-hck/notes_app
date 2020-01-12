package com.example.notes_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_3 extends AppCompatActivity {
    TextView tvTitle,tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        tvDescription=findViewById(R.id.tvDescription);
        tvTitle=findViewById(R.id.tvTitle);

        Intent intent=getIntent();
        String T=intent.getStringExtra("aTitle");
        String D=intent.getStringExtra("aDescription");

        tvTitle.setText(T);
        tvDescription.setText(D);


    }
}
