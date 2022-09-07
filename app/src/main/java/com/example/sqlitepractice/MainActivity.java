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

    myEvents.execSQL("CREATE TABLE IF NOT EXISTS newUsers(name VARCHAR, age INT(3),id INTEGER PRIMARY KEY)");


   /* myEvents.execSQL("INSERT INTO newUsers (name,age) VALUES ('Aziz',22)");
    myEvents.execSQL("INSERT INTO newUsers (name,age) VALUES ('Akbarshox',18)");
    myEvents.execSQL("INSERT INTO newUsers (name,age) VALUES ('Lolo',35)");
    myEvents.execSQL("INSERT INTO newUsers (name,age) VALUES ('Lolo',16)");*/

      //  myEvents.execSQL("DELETE FROM newUsers WHERE id=5");






    Cursor c = myEvents.rawQuery("SELECT * FROM newUsers", null);

        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");
        int idIndex=c.getColumnIndex("id");

        c.moveToFirst();

        while (!c.isAfterLast()) {
            Log.i("Name", c.getString(nameIndex));
            Log.i("Age", Integer.toString(c.getInt(ageIndex)));
            Log.i("Id",Integer.toString(c.getInt(idIndex)));

            c.moveToNext();

        }

}
catch (Exception e){
    e.printStackTrace();
}



    }
}