package com.example.user.sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lstvw;
    DBhelper dhelp;
    ArrayList<String> nameP;
    ArrayList<String> ContactP;

    Adapterrr adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstvw = findViewById(R.id.lst);
        dhelp = new DBhelper(this);
        try {

            nameP = new ArrayList<>();
            nameP = dhelp.getAllNames();

            ContactP = new ArrayList<>();
            ContactP = dhelp.getAllNumber();

            adapt = new Adapterrr();
            lstvw.setAdapter(adapt);
          lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Intent in=new Intent(getApplicationContext(),Viewdetails.class);
                  in.putExtra("k1",nameP.get(position));
                  startActivity(in);
              }
          });



        } catch (Exception e) {
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sqll, menu);

        return true;

        //return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.insertdata) {
            Intent in = new Intent(getApplicationContext(), insertdata.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }

class Adapterrr extends BaseAdapter
{
    @Override
    public int getCount() {
        return nameP.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.list_single,null);
        TextView namee=convertView.findViewById(R.id.textView);
        TextView numberr=convertView.findViewById(R.id.textView2);
        namee.setText(nameP.get(position));
        numberr.setText(ContactP.get(position));
        return convertView;
    }
}
}