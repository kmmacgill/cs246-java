package com.example.kmmac.scanr_test;

import android.sax.EndTextElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.nio.charset.Charset;
import java.util.List;

public class Scanr_test_case extends AppCompatActivity {

    TextWatcher watchmen = new TextWatcher() {

        int sizeOfBarCode = 1;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() > 0 ) {
                TextView output = (TextView) findViewById(R.id.result);
                output.setText(s + "\n");
    }
}

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() >= 13) {
                EditText Texting = (EditText)findViewById(R.id.ScanrThing);
                Texting.setText("");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanr_test_case_layout);
        EditText Texthing = (EditText)findViewById(R.id.ScanrThing);
        Texthing.addTextChangedListener(watchmen);
    }
}