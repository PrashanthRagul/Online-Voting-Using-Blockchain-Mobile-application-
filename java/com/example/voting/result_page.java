package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class result_page extends AppCompatActivity {
    private TextView baaack;
private TextView results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        results=findViewById(R.id.resultView);

        ObjectInputStream input;
        String filename = "testFilemost.srl";

        try {
            input = new ObjectInputStream(new FileInputStream(new File(new File(getFilesDir(), "") + File.separator + filename)));
            Blockchain myBlk = (Blockchain) input.readObject();

            String s=myBlk.result();
            results.setText("WINNER :"+s);
        input.close();
    } catch (StreamCorruptedException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }




    baaack=findViewById(R.id.button9);



        baaack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity9();
            }
        });
    }

    public void openactivity9(){
        Intent intent =new Intent(this,ch_member.class);
        startActivity(intent);

    }
}