package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VoteMain extends AppCompatActivity {
     String V_name,V_id;

    private Button cand1;
    private Button cand2;
    private Button cand3;
    private Button cand4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_main);

        cand1=findViewById(R.id.cand_1);

        cand2=findViewById(R.id.cand_2);
        cand3=findViewById(R.id.cand_3);
        cand4=findViewById(R.id.cand_4);

        V_name=getIntent().getExtras().getString("Vname");
        V_id= getIntent().getExtras().getString("Vid");


        cand1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity6();
            }
        });

        cand2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity61();
            }
        });

        cand3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity62();
            }
        });

        cand4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity63();
            }
        });


    }

    public void openactivity6()
    {
        V_name=getIntent().getExtras().getString("Vname");
        V_id= getIntent().getExtras().getString("Vid");


        Intent intent =new Intent(this,confirm_page.class);
        intent.putExtra("VOTE_ID",V_id);
        intent.putExtra("VOTE_NAME",V_name);
        intent.putExtra("VOTE","A");
        startActivity(intent);
    }

public void openactivity61()
{
    V_name=getIntent().getExtras().getString("Vname");
    V_id= getIntent().getExtras().getString("Vid");

    Intent intent =new Intent(this,confirm_page.class);
    intent.putExtra("VOTE_ID",V_id);
    intent.putExtra("VOTE_NAME",V_name);
    intent.putExtra("VOTE","B");
    startActivity(intent);
}

    public void openactivity62()
    {
        V_name=getIntent().getExtras().getString("Vname");
        V_id= getIntent().getExtras().getString("Vid");

        Intent intent =new Intent(this,confirm_page.class);
        intent.putExtra("VOTE_ID",V_id);
        intent.putExtra("VOTE_NAME",V_name);
        intent.putExtra("VOTE","C");
        startActivity(intent);
    }

    public void openactivity63()
    {
        V_name=getIntent().getExtras().getString("Vname");
        V_id= getIntent().getExtras().getString("Vid");

        Intent intent =new Intent(this,confirm_page.class);
        intent.putExtra("VOTE_ID",V_id);
        intent.putExtra("VOTE_NAME",V_name);
        intent.putExtra("VOTE","D");
        startActivity(intent);
    }

}