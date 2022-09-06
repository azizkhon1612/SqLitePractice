package com.example.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
try {
    SQLiteDatabase myEvents=this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

    myEvents.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");


    /*myEvents.execSQL("INSERT INTO users (name,age) VALUES ('Aziz',22)");
    myEvents.execSQL("INSERT INTO users (name,age) VALUES ('Akbarshox',18)");
    myEvents.execSQL("INSERT INTO users (name,age) VALUES ('Lolo',35)");
    myEvents.execSQL("INSERT INTO users (name,age) VALUES ('Lolo',16)");
     myEvents.execSQL("DELETE FROM users WHERE name='Lolo' AND age=35");
    */


    Cursor c = myEvents.rawQuery("SELECT * FROM users", null);

        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");

        c.moveToFirst();

        while (!c.isAfterLast()) {
            Log.i("Name", c.getString(nameIndex));

            Log.i("Age", Integer.toString(c.getInt(ageIndex)));
            c.moveToNext();

        }

}
catch (Exception e){
    e.printStackTrace();
}



    }
}