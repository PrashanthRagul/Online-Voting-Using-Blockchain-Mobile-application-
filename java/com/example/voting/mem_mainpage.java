package com.example.voting;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class mem_mainpage extends AppCompatActivity {
 private DatabaseReference reference;
    private Button poll_btn;
    //private Button res_btn;
    private FirebaseUser user;
private String userID;

    String name;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_mainpage);

        poll_btn=findViewById(R.id.pollbtn);
      //  res_btn=findViewById(R.id.resbtn);

        name=getIntent().getExtras().getString("NAME");
        id= getIntent().getExtras().getString("ID");


        user= FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users");

        final TextView username=(TextView)findViewById(R.id.textView6);
        final TextView phone=(TextView)findViewById(R.id.textView7);
        final TextView street=(TextView)findViewById(R.id.textView9);
        final TextView city=(TextView)findViewById(R.id.textView10);
        final TextView pin=(TextView)findViewById(R.id.textView11);
         userID = user.getUid();

reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        User userprof=snapshot.getValue(User.class);
        if(userprof!=null)
        {
            String us=userprof.name;
            String ph=userprof.phone;
            String str=userprof.street;
            String cty=userprof.city;
            String pn=userprof.pin;
            username.setText(us);
            phone.setText(ph);
            street.setText(str);
            city.setText(cty);
            pin.setText(pn);

        }

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {
        Toast.makeText(mem_mainpage.this, "TRY AGAIN", Toast.LENGTH_SHORT).show();
    }
});

        poll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity4();
            }
        });


    }

    public void openactivity4()
    {

        name=getIntent().getExtras().getString("NAME");
        id= getIntent().getExtras().getString("ID");


        ObjectInputStream input;
        String filename = "testFilemost.srl";

        try {
            input = new ObjectInputStream(new FileInputStream(new File(new File(getFilesDir(), "") + File.separator + filename)));
            Blockchain myBlk = (Blockchain) input.readObject();
            if(myBlk.Voted(name)==true) {
                Toast.makeText(mem_mainpage.this, "ALREADY VOTED", Toast.LENGTH_SHORT).show();
                Intent inte =new Intent(this,MainActivity.class);
                startActivity(inte);

            }
            else
            {

                Intent intent =new Intent(this,VoteMain.class);

                intent.putExtra("Vname",name);
                intent.putExtra("Vid",id);
                Toast.makeText(getApplicationContext(),
                        name+" "+id,
                        Toast.LENGTH_LONG)
                        .show();
                startActivity(intent);


            }
        }
        catch (StreamCorruptedException e) {
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
