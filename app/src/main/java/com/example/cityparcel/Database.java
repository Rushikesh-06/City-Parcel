package com.example.cityparcel;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public static String name = "DB_CityParcel";
    public static int version = 1;
    private String TAG= getClass().getSimpleName();

    public Database(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE `Users` (`userid` INTEGER PRIMARY KEY AUTOINCREMENT, `username` TEXT(255) , `phoneno` TEXT(255) , `birthdate` TEXT(255), `anniversarydate` TEXT(255) )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertValue(ContentValues values) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long status = sqLiteDatabase.insert("Users", null, values);
        sqLiteDatabase.close();
    }

    @SuppressLint("Range")
    public List<DBuserdetails> getAllValue() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor userdata = db.rawQuery("select * from `Users`", null);
        userdata.moveToFirst();
        List<DBuserdetails> list = new ArrayList<>();
        while (userdata.isAfterLast() == false) {
            DBuserdetails dBuserdetails = new DBuserdetails();
            dBuserdetails.setId(userdata.getString(userdata.getColumnIndex("userid")));
            dBuserdetails.setUsername(userdata.getString(userdata.getColumnIndex("username")));
            dBuserdetails.setPhoneno(userdata.getString(userdata.getColumnIndex("phoneno")));
            dBuserdetails.setBirthdate(userdata.getString(userdata.getColumnIndex("birthdate")));
            dBuserdetails.setAnniversarydate(userdata.getString(userdata.getColumnIndex("anniversarydate")));
            list.add(dBuserdetails);
            userdata.moveToNext();
            Log.e(TAG, "getAllValue: "+dBuserdetails.getId() );
        }
        db.close();
        return list;
    }
}
