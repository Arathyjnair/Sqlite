package com.example.user.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Viewdetails extends AppCompatActivity {
         TextView vwdelnme,vwdelContct;
         DBhelper dhelp;

    String viewww,na,nu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetails);
        vwdelnme=findViewById(R.id.deletnme);
        vwdelContct=findViewById(R.id.delcontct);
        dhelp=new DBhelper(this);
        Bundle object=getIntent().getExtras();
         viewww=object.getString("k1");
        if(object!=null)
        {

            if(viewww!=null)
            {
                Cursor c=dhelp.getData(viewww);
                c.moveToFirst();
                na=c.getString(c.getColumnIndex(dhelp.NAME));
                 nu=c.getString(c.getColumnIndex(dhelp.NUMBER));
                vwdelnme.setText("Name : "+na);
                vwdelContct.setText("Contacts : "+nu);
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.deletee,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.deletedata)
        {
        dhelp.DeleteContact(viewww);
        Intent in=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(in);
        }
        if(id==R.id.updatee)
        {
            Intent ok=new Intent(getApplicationContext(),Update_data.class);
            ok.putExtra("name",na);
            ok.putExtra("num",nu);
            startActivity(ok);
            Toast.makeText(this, "you selected edit option", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
