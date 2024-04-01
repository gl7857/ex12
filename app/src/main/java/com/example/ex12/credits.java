package com.example.ex12;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class credits extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        Intent ti = getIntent();

        TextView tv;
        tv = findViewById(R.id.tv1);
        String result = ti.getStringExtra("result");
        tv.setText(result);

    }

    public void backToMain(View view) {
        finish();
    }
}