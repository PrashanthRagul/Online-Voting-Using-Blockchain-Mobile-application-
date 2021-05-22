package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class orglogin extends AppCompatActivity {

   private Button org_pass_btn;
   private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orglogin);

        org_pass_btn=findViewById(R.id.org_pass);


        org_pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity10();
            }
        });


    }

    public void openactivity10()
    {

        password=findViewById(R.id.orgPassword);
        String s=password.getText().toString();

        if(s.equals("12345")) {
            Intent intent = new Intent(this, org_home.class);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(getApplicationContext(), "INCORRECT PASSWORD", Toast.LENGTH_LONG).show();
        }

    }
}