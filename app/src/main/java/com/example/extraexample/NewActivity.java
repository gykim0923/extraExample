package com.example.extraexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2); // 자기꺼 이름
        Intent intent = getIntent();
        String a = intent.getStringExtra("str");// default값 자동으로 null
        int b = intent.getIntExtra("number",-4);// putExtra와 다르게 get 타입 으로 해야함
        //default값이 있을 수 있음
        Toast.makeText(this, a+b, Toast.LENGTH_SHORT).show();


    }
    public void onClickButton(View v){
        Intent intent = new Intent();
        intent.putExtra("result","Hello");
        setResult(RESULT_OK,intent);

        finish();// finish를 해야 종료 됐을 때 전달됨

    }

}