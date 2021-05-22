package com.example.voting;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class Analysis_apge extends AppCompatActivity {
    private TextView results1;
    private TextView results2;
    private TextView results3;
    private TextView results4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_apge);


        results1=findViewById(R.id.textview11);
        results2=findViewById(R.id.textview22);
        results3=findViewById(R.id.textview33);
        results4=findViewById(R.id.textview44);

        ObjectInputStream input;
        String filename = "testFilemost.srl";

        try {
            input = new ObjectInputStream(new FileInputStream(new File(new File(getFilesDir(), "") + File.separator + filename)));
            Blockchain myBlk = (Blockchain) input.readObject();
            String s=myBlk.findpercent();
           String a="",b="",c="",d="";
          int i=0;
           while(i<s.length()&&s.charAt(i)!=',')
           {  a=a+s.charAt(i);
               i++;

           }
           i++;
            while(i<s.length()&&s.charAt(i)!=',')
            {  b=b+s.charAt(i);
                i++;

            }
            i++;
            while(i<s.length()&&s.charAt(i)!=',')
            {  c=c+s.charAt(i);
                i++;

            }
            i++;
            while(i<s.length()&&s.charAt(i)!=',')
            {  d=d+s.charAt(i);
                i++;

            }


            results1.setText("PARTY A:"+a);
            results2.setText("PARTY B :"+b);
            results3.setText("PARTY C :"+c);
            results4.setText("PARTY D :"+d);



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






    }
}