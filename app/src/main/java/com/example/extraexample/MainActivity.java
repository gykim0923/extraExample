package com.example.extraexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View v){
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("str","Hello world");
        intent.putExtra("num","123");
        startActivity(intent);
    }
}