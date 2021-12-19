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

    public void onClickButton(View v){ //버튼에 onclick 설정 넣어야함
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("str","Hello world");
        intent.putExtra("number",123);
        startActivity(intent);
    }
}