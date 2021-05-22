package com.example.voting;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class confirm_page extends AppCompatActivity {

    private TextView baack;
    private Button vote_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_page);


        Intent intent = getIntent();
        String result = intent.getStringExtra("VOTE");
        TextView txtView = (TextView) findViewById(R.id.button7);
        txtView.setText(result);


        baack=findViewById(R.id.back);
        vote_btn=findViewById(R.id.vote);

        baack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity7();
            }
        });

        vote_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity8();
            }
        });
    }

    public void openactivity7()
    {
        Intent intent =new Intent(this,VoteMain.class);
        startActivity(intent);
    }

    public void openactivity8() {
        Intent intent = getIntent();
        String result = intent.getStringExtra("VOTE");
        String ID=intent.getStringExtra("VOTE_ID");
        String NAME=intent.getStringExtra("VOTE_NAME");


String s="";
//s = ID+" "+NAME+" "+result;
  //      Intent intent1 =new Intent(this,displayop.class);
    //     intent1.putExtra("VOTER",s);
      //  startActivity(intent1);

    ObjectInputStream input;
    String filename = "testFilemost.srl";

    try {
        input = new ObjectInputStream(new FileInputStream(new File(new File(getFilesDir(), "") + File.separator + filename)));
        Blockchain myBlk = (Blockchain) input.readObject();

        myBlk.addBlock(new block("0x209",ID,NAME,result, "02/07/2020"));


        input.close();

        ObjectOutput out = null;
        out = new ObjectOutputStream(new FileOutputStream(new File(getFilesDir(), "") + File.separator + filename));
        out.writeObject(myBlk);
        out.close();

        Toast.makeText(getApplicationContext(), "Voted Successfully", Toast.LENGTH_LONG).show();

        s = myBlk.getUser("11") + " " + myBlk.getUser("5");

     //   Intent intent1 = new Intent(this, displayop.class);
      //  intent1.putExtra("VOTER", s);
       // startActivity(intent1);

       Intent inte =new Intent(this,MainActivity.class);
        startActivity(inte);



    } catch (StreamCorruptedException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
            e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
}
