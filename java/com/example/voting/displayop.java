package com.example.voting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.voting.Blockchain;
import com.example.voting.block;
import androidx.appcompat.app.AppCompatActivity;

public class displayop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayop);

        Intent intent1 = getIntent();
        String result1 = intent1.getStringExtra("VOTER");


//       Blockchain ch1 = new Blockchain();

  //      ch1.addBlock(new block("0x204", "1", "Ragul", result1, "02/07/2020"));

        TextView stringTextView = (TextView) findViewById(R.id.list);

    //    String s = ch1.getUser("1");

        stringTextView.setText("here    :" + result1);


    }
}