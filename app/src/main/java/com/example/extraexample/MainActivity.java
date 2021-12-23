package com.example.extraexample;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int count =0;
    ActivityResultLauncher<Intent> activityResultLauncher; // 런처 시작
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityResultLauncher = registerForActivityResult(//런처 생성
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent intent = result.getData();
                        String s= intent.getStringExtra("result");
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                        //안에서는 this가 아닌 applicationContext로 받음
                    }
                }
        );
    }

    public void onClickButton(View v){ //버튼에 onclick 설정 넣어야함
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("str","Hello world");
        intent.putExtra("number",123);
//        startActivity(intent);
        activityResultLauncher.launch(intent);
    }
    public void onClickButton2(View v){
//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/119"));//dialog에 연결
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("http://www.google.com"),"text/html"); //웹페이지 띄우기
        intent.addCategory(Intent.CATEGORY_DEFAULT );
        startActivity(intent);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//    }
    public void onClickButton3(View v){ //버튼에 onclick 설정 넣어야함
       count++;
        TextView textView = (TextView) findViewById(R.id.num);
        textView.setText(String.valueOf(count));

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { //화면 돌려도 저장
        super.onSaveInstanceState(outState);
        outState.putInt("count",count);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
        TextView textView = (TextView) findViewById(R.id.num);
        textView.setText(String.valueOf(count));
    }
}