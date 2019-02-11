package com.example.user.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insertdata extends AppCompatActivity {
EditText nameinsert,Contactinsert;
Button submitbuttn;
DBhelper dhelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertdata);
        dhelp=new DBhelper(this);

        nameinsert=(EditText) findViewById(R.id.nameedt);
        Contactinsert=findViewById(R.id.edtcontact);
        submitbuttn=findViewById(R.id.button1);
        submitbuttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(dhelp.insertdata(nameinsert.getText().toString(),Contactinsert.getText().toString()))
            {
                Toast.makeText(insertdata.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
                Intent in=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
            else {
                Toast.makeText(insertdata.this, "failed to inserted", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }
}
