package com.example.pat.taxcounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class Opener extends AppCompatActivity {
   
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opener);
        Handler handler = new Handler();


       handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.opener);
            }
        }, 10000);

        EditText login = (EditText) findViewById(R.id.login);
        EditText haslo = (EditText) findViewById(R.id.haslo);
        TextView tit = (TextView) findViewById(R.id.title);
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);
        DBHandler dbHandler = new DBHandler(this);
        dbHandler.dodajLogo(login.getText().toString(), haslo.getText().toString());
        Cursor cursor = dbHandler.dajWszystkie();
        while(cursor.moveToNext()) {
            int nr = cursor.getInt(0);
            String loginn = cursor.getString(1);
            String hasloo = cursor.getString(2);
            tit.setText(tit.getText() + "\n" + loginn + " " + hasloo);
        }
    }
}
