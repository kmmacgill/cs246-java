package com.example.kmmac.multithread;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MultiThread extends AppCompatActivity {

    String fileName = "numbers.txt";
    private ProgressBar progress;
    private int progStatus = 0;
    private Handler handle = new Handler();
    StringBuilder builder = new StringBuilder();
    FileOutputStream outputs;
    ListView list;
    ArrayList<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setProgress(0);
    }

    public void create_file(View v) {
        progStatus = 0;

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i < 11; i++) {
                    builder.append(i).append("\n");

                    progStatus += 10;
                    handle.post(new Runnable(){
                        public void run() {
                            progress.setProgress(progStatus);
                        }
                    });

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    File Newfile = new File(getFilesDir(), fileName);
                    outputs = new FileOutputStream(Newfile);
                    outputs.write(builder.toString().getBytes());
                    outputs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    public void load_file(View v) {
        list = (ListView) findViewById(R.id.listView);

        array = new ArrayList<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fin = new FileInputStream(new File(getFilesDir(), "numbers.txt"));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(fin, "UTF-8"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        array.add(line);
                    }
                    fin.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        list.setAdapter(adapter);
    }

    public void clear_file(View v) {
        ListView list = (ListView) findViewById(R.id.listView);
        progress.setProgress(0);
        list.setAdapter(null);
    }
}
