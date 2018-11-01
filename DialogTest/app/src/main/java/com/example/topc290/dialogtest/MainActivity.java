package com.example.topc290.dialogtest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    TextView textView;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        // setContentView로 처리된 객체만  findViewById해서 찾아올수 있다.

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog1(v);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog2(v);
            }
        });

    }

    private void showDialog1(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // builder.setIcon(R.mipmap.ic_launcher); // 타이틀 왼쪽에 뜨는 아이콘
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("상단 타이틀");
        builder.setMessage("중단 메세지");
        // 하단 버튼들
        builder.setPositiveButton("YES",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("YES");
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("Cancel");
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("NO");
            }
        });

        builder.show();
    }

    private void showDialog2(View v) {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("하나를 고르세요");

        View view = View.inflate(this, R.layout.dialog, null);
        Log.d("view is LinearLayout",""+ (view instanceof LinearLayout));
        builder.setView(view);

        // #1
        //final AlertDialog alertDialog = builder.show();
        // #2 위에 선언 AlertDialog alertDialog;
        alertDialog = builder.show();

        // 이미지를 클릭하게 하는 버튼
        ImageView imageView = view.findViewById(R.id.imageView);
        ImageView imageView2 = view.findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("PineApple");
                alertDialog.dismiss();
            }
        });

        // alertDialog 이 변수를 조작하게 되면
        // 콜백함수 안에서 사용하는 참조와 다들게 되어 버그가 발생할수 있게
        // 되므로 자바는 원천적으로 이번 변수앞에 fina키워드를 붙여서 변수의 조작을 한다

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Kiwi");
                alertDialog.dismiss();
            }
        });


        // 하단 버튼들
//        builder.setPositiveButton("Kiwi",new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                textView.setText("Kiwi");
//            }
//        });
//
//        builder.setNeutralButton("PineApple", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                textView.setText("PineApple");
//            }
//        });
//
//        builder.show();
    }
}
