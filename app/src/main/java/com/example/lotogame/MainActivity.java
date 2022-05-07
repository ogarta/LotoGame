package com.example.lotogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    TextView txtNumRao, txtNumRao_pre;
    Button btnReset, btnRao;
    ArrayList<Integer> num = new ArrayList<Integer>();
    Random random = new Random();
    String arraylistNum = "";
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        txtNumRao = findViewById(R.id.textViewSoRao);
        txtNumRao_pre = findViewById(R.id.textViewHienThiSoDaRao);
        btnRao = findViewById(R.id.buttonRao);
        btnReset = findViewById(R.id.buttonReset);

        create_ArrayListNum();

        btnRao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num.size() == 0){
                    Toast.makeText(MainActivity.this,"Da het so",Toast.LENGTH_LONG).show();
                    return;
                }
                number = random.nextInt(num.size()+1);
                txtNumRao.setText(num.get(number).toString());

                arraylistNum += num.get(number).toString() +" - ";
                txtNumRao_pre.setText(arraylistNum);
                num.remove(number);
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_ArrayListNum();
                txtNumRao.setText("");
                arraylistNum = "";
                txtNumRao_pre.setText(arraylistNum);
            }
        });

    }
    public void create_ArrayListNum(){
        num.clear();
        for (int i = 1; i <= 100; i++) {
            num.add(i);
        }
    }
}