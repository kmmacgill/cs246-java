package com.example.kmmac.scripturereferenceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class first_Activity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    public final static String MESSAGE_KEY = "com.example.kmmac.scripturereferenceapp.message_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
    }

    public void shareScripture (View view) {
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        String message = "Your favorite scripture is: " + editText.getText().toString() + " Chapter " + editText2.getText().toString() + " Verse " + editText3.getText().toString();
        Intent intent = new Intent(this, secondActivity.class);
        intent.putExtra(MESSAGE_KEY, message);
        startActivity(intent);
    }
}
