package com.example.kmmac.advancepractice;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Count_Main extends AppCompatActivity {

    TextView textElement;
    int num;
    public static final String fileName = "greatGreenGlobs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_main_layout);
        textElement = (TextView) findViewById(R.id.numbers);
        sqlThingy Db = new sqlThingy();
        SharedPreferences data = getPreferences(MODE_PRIVATE);
        int retrieved = data.getInt("numberToAdd", 0);
        num = retrieved;
        setText();
    }

    public void advanceNumber(View v) {
        num++;
        setText();
    }
    public void setText() {
        String number = Integer.toString(num);
        textElement.setText(number);
    }

    public void savePref(View v) {
        SharedPreferences numby = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = numby.edit();
        editor.putInt("numberToAdd", num);
        editor.commit();
    }

    public void resetPref(View v) {
        num = 0;
        setText();
    }
}

    class Sqlite extends SQLiteOpenHelper {

        private static final String DICTIONARY_TABLE_CREATE =
                "CREATE TABLE numbers (numb TEXT);";

        public Sqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DICTIONARY_TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }