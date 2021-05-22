package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ch_member extends AppCompatActivity {
    private Button mem_but;
    private Button org_but;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch_member);

        mem_but=findViewById(R.id.member);
        org_but=findViewById(R.id.org);

        mem_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity1();
            }
        });

        org_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity2();
            }
        });
    }
    public void openactivity1(){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    public void openactivity2(){
        Intent intent= new Intent(this,orglogin.class);
        startActivity(intent);

    }

}


