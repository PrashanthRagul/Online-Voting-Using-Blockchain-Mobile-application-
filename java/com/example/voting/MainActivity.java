package com.example.voting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button log_btn;
    EditText txtname, userid;
    TextView reg;
    FirebaseAuth fAuth;
    String name, id;
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth=FirebaseAuth.getInstance();

        log_btn = findViewById(R.id.logbtn);

        reg = findViewById(R.id.register);

        userid = findViewById(R.id.editTextTextPassword);

        txtname = findViewById(R.id.editTextTextPersonName);


        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                          openactivity3();

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, Sign_up.class);
                startActivity(in);
            }
        });
    }

    public void openactivity3() {
        txtname = findViewById(R.id.editTextTextPersonName);
        name = txtname.getText().toString();
        userid = findViewById(R.id.editTextTextPassword);
        id = userid.getText().toString();

        spinner = (ProgressBar)findViewById(R.id.progressBar1);

        //final String name = txtname.getText().toString();

        //String pas = userid.getText().toString();


        if (TextUtils.isEmpty(name)||name==null) {
            txtname.setError("Enter Email");
            return;
        }
        if (TextUtils.isEmpty(id)||id==null) {
            txtname.setError("Enter Password");
            return;
        }

        spinner.setVisibility(View.VISIBLE);

        fAuth.signInWithEmailAndPassword(name,id).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(!task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "ERROR !", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, mem_mainpage.class);
                    Toast.makeText(getApplicationContext(),
                            name + " " + id,
                            Toast.LENGTH_LONG)
                            .show();
                    intent.putExtra("NAME", name);
                    intent.putExtra("ID", id);
                    startActivity(intent);
                }

            }
        });



    }
}