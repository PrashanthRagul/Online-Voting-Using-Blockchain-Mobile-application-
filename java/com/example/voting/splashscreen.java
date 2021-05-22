package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {
    Animation anim1,anim2;
    ImageView img;
    TextView txt,reg;
    Button btn;
    private static int splash=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        img=findViewById(R.id.imageView);
        txt =findViewById(R.id.textView);

        anim1= AnimationUtils.loadAnimation(splashscreen.this,R.anim.bounce);
        anim2= AnimationUtils.loadAnimation(splashscreen.this,R.anim.lefttoright);
        img.setAnimation(anim1);
        txt.setAnimation(anim2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splashscreen.this,ch_member.class);
                startActivity(intent);
                finish();
            }
        },splash);
    }
}