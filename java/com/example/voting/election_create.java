package com.example.voting;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class election_create extends AppCompatActivity {

    private Button ele_cr_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_election_create);
        ele_cr_btn=findViewById(R.id.cr_elec);

        ele_cr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity14();
            }
        });
    }

    public void openactivity14()
    {
        //intilize
        Blockchain ch = new Blockchain();
        ch.addBlock(new block("0x207", "111111", "ragul@gmail.com", "A", "02/07/2020"));
        ch.addBlock(new block("0x208", "222222", "bhuvi@gmail.com", "B", "02/07/2020"));
        ch.addBlock(new block("0x209", "333333", "ragu@gmail.com", "B", "02/07/2020"));
        ch.addBlock(new block("0x2010", "444444", "sabari@gmail.com", "A", "02/07/2020"));
        ch.addBlock(new block("0x2011", "555555", "balaji@gmail.com", "A", "02/07/2020"));
        ch.addBlock(new block("0x2012", "666666", "rajan@gmail.com", "A", "02/07/2020"));
        ch.addBlock(new block("0x2013", "777777", "rohit@gmail.com", "B", "02/07/2020"));
        ch.addBlock(new block("0x2014", "888888", "shyam@gmail.com", "C", "02/07/2020"));
        ch.addBlock(new block("0x2015", "999999", "viji@gmail.com", "C", "02/07/2020"));
        ch.addBlock(new block("0x2016", "101010101010", "prashanth@gmail.com", "C", "02/07/2020"));
        ch.addBlock(new block("0x2016", "111111111111", "prashanthragul@gmail.com", "D", "02/07/2020"));



        String filename = "testFilemost.srl";
        ObjectOutput out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(new File(getFilesDir(), "") + File.separator + filename));
            out.writeObject(ch);
            out.close();

            Toast.makeText(getApplicationContext(), "Election Created", Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Intent intent =new Intent(this,org_home.class);
        startActivity(intent);
    }
}
