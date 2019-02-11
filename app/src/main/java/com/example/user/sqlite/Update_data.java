package com.example.user.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_data extends AppCompatActivity {
 EditText upname,upContact;
 Button upbtnnn;
 DBhelper dhelp;
 String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        upname=findViewById(R.id.updtenmnme);
        upContact=findViewById(R.id.updtecntct);
        upbtnnn=findViewById(R.id.btnupdte);
        dhelp=new DBhelper(this);
        Bundle bun=getIntent().getExtras();
        final String bunname=bun.getString("name");
       final String bunContact=bun.getString("num");
       st=bun.getString("name");
        upname.setText(""+bun.getString("name"));
        upContact.setText(bunContact);
        upbtnnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        String   bunname=upname.getText().toString();
         String bunContact=upContact.getText().toString();



                if(dhelp.updatedata(bunname,bunContact,st))
               {

                   Toast.makeText(Update_data.this, "updated", Toast.LENGTH_SHORT).show();

                   finish();
               }
            }
        });
    }
}
