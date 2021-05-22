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
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up extends AppCompatActivity {
  EditText username,phone,street,pin,cty,email,pass,com;
  Button submit;
   FirebaseAuth fAuth;

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username=(EditText) findViewById(R.id.logusername);
        phone=(EditText)findViewById(R.id.phoneno);
        street=(EditText)findViewById(R.id.streetname);
        pin=(EditText)findViewById(R.id.pincode);
        cty=(EditText)findViewById(R.id.city);
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);
   submit=findViewById(R.id.submitbtn);

   fAuth=FirebaseAuth.getInstance();

   com=(EditText)findViewById(R.id.conpassword);



/*   if(fAuth.getCurrentUser()!=null)
   {
       Toast.makeText(Sign_up.this, "ALREADY CREATED", Toast.LENGTH_SHORT).show();
       startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
   }
*/
   submit.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

           final String name=username.getText().toString();
           final String pas=pass.getText().toString();
           final String ph=phone.getText().toString();
           final String str=street.getText().toString();
           final String city=cty.getText().toString();
           final String Email=email.getText().toString();
           final String Pin=pin.getText().toString();
           if(TextUtils.isEmpty(pas))
           {
               pass.setError("Enter Password");
           }

           String p=pass.getText().toString();
           String c=com.getText().toString();
           if(!p.equals(c))
           {
               Toast.makeText(Sign_up.this, "PASSWORD AND CONFIRM PASSWORD DOESN'T MATCH ENTER AGAIN", Toast.LENGTH_SHORT).show();
               pass.setError("Enter Correctly");
               com.setError("Enter correctly");
           }
           if(TextUtils.isEmpty(name))
           {
               username.setError("Enter name");
           }
           if(TextUtils.isEmpty(pas))
           {
               pass.setError("Enter Password");
           }
           if(TextUtils.isEmpty(ph))
           {
               phone.setError("Enter Phone number");
           }
           if(TextUtils.isEmpty(city))
           {
               cty.setError("Enter city");
           }
           if(TextUtils.isEmpty(Email))
           {
               email.setError("Enter Email");
           }

           spinner = (ProgressBar)findViewById(R.id.progressBar1);
           spinner.setVisibility(View.VISIBLE);

           fAuth.createUserWithEmailAndPassword(Email,pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {



                   if(task.isSuccessful())
                   {
                       User u=new User(name,ph,str,city,Pin,Email,pas);

                       FirebaseDatabase.getInstance().getReference("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(u).addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if(task.isSuccessful())
                               {
                                   Toast.makeText(Sign_up.this, "REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });

                         Toast.makeText(Sign_up.this, "USER CREATED", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(getApplicationContext(),MainActivity.class));

                   }
                   else
                   {
                       Toast.makeText(Sign_up.this, "ERROR !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                   }
               }
           });

       }
   });


    }
}