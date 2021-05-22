package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class org_home extends AppCompatActivity {

    private Button create_btn;
    private Button anal_btn;
    private Button res_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_home);

        create_btn = findViewById(R.id.create);
        anal_btn = findViewById(R.id.analysis);
        res_btn = findViewById(R.id.view_res);

        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity11();
            }
        });

        anal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity12();
            }
        });

        res_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity13();
            }
        });
    }


    public void openactivity11(){

        Intent intent =new Intent(this,election_create.class);
        startActivity(intent);
    }

    public void openactivity12(){

        Intent intent =new Intent(this,Analysis_apge.class);
        startActivity(intent);
    }

    public void openactivity13(){

        Intent intent =new Intent(this,result_page.class);
        startActivity(intent);
    }

}