package com.example.user.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyData.db";
    public static final String TABLE_NAME= "Data";
    public static final String NAME= "Name";
    public static final String NUMBER= "Contacts";
    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Data " + "(Name text primary key,Contacts text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists Data");
        onCreate(db);
        Log.e("car","Table exist");
    }


    public boolean insertdata(String name,String numb) {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Contacts",numb);

        db.insert(TABLE_NAME,null,contentValues);
       return true;
    }
//it is local so use sqlitedb obj name as dbnme
    public ArrayList<String> getAllNames() {
        ArrayList<String> strgname = new ArrayList<>();

        SQLiteDatabase dbnme = this.getReadableDatabase();
        Cursor res = dbnme.rawQuery("select * from data", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {


            strgname.add(res.getString(res.getColumnIndex("Name")));
            res.moveToNext();

        }
        return strgname;

}
public ArrayList<String> getAllNumber()
{
    ArrayList<String> arraynum=new ArrayList<String>();
    SQLiteDatabase dbb=this.getReadableDatabase();
    Cursor res = dbb.rawQuery("select * from data", null);
    res.moveToFirst();

    while (res.isAfterLast() == false) {


        arraynum.add(res.getString(res.getColumnIndex("Contacts")));
        res.moveToNext();

    }
    return arraynum;

}
    public boolean updatedata(String name,String numb,String r) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Contacts", numb);
        db.update("Data", contentValues, "Name=?", new String[]{r});
        return true;
    }
public Integer DeleteContact(String name)
{
    SQLiteDatabase db=this.getWritableDatabase();
    return db.delete("Data","Name=?",new  String[]{name});
}
public Cursor getData(String s)
{
    SQLiteDatabase db=this.getReadableDatabase();
    Cursor r=db.rawQuery("select * from data where Name='"+s+"'",null);
    return r;
}

}


