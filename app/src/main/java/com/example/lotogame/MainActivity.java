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
    TextView txtNumRao, txtNumRaoPre;
    Button btnReset, btnPlay;
    ArrayList<Integer> arrayListSoRao = new ArrayList<Integer>();
    Random random = new Random();
    String arraylistNum = "";
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        txtNumRao = findViewById(R.id.textViewSoRao);
        txtNumRaoPre = findViewById(R.id.textViewHienThiSoDaRao);
        btnPlay = findViewById(R.id.buttonRao);
        btnReset = findViewById(R.id.buttonReset);

        // tao mang so
        createArrayListNum();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayListSoRao.size() == 0){
                    Toast.makeText(MainActivity.this,"Da het so",Toast.LENGTH_LONG).show();
                    return;
                }
                index = random.nextInt(arrayListSoRao.size()+1);
                txtNumRao.setText(arrayListSoRao.get(index).toString());
                arraylistNum += arrayListSoRao.get(index).toString() +" - ";
                txtNumRaoPre.setText(arraylistNum);
                arrayListSoRao.remove(index);
                // cuon scroll xuong vi tri cuoi
                scrollView.fullScroll(View.FOCUS_DOWN);
            }

        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createArrayListNum();
                txtNumRao.setText("");
                arraylistNum = "";
                txtNumRaoPre.setText(arraylistNum);
            }

        });

    }
    private void createArrayListNum(){
        if(arrayListSoRao.size() != 0){
            arrayListSoRao.clear();
        }
        for (int i = 1; i <= 100; i++) {
            arrayListSoRao.add(i);
        }

    }
}