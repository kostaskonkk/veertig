package com.example.veertig;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.os.CountDownTimer;
import android.content.res.AssetManager;
import android.widget.TextView;

import com.example.veertig.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Random;
import java.util.ArrayList;

import static java.lang.String.valueOf;


public class wordlist extends AppCompatActivity {
    TextView word1, word2, word3, word4, word5;
    public int counter;
    TextView textViewCounter;
    public ArrayList<String> myDict = new ArrayList<String>();
    public ArrayList<String> easy = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_wordlist);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        word1= (TextView) findViewById(R.id.word1);
        word2= (TextView) findViewById(R.id.word2);
        word3= (TextView) findViewById(R.id.word3);
        word4= (TextView) findViewById(R.id.word4);
        word5= (TextView) findViewById(R.id.word5);
        textViewCounter= (TextView) findViewById(R.id.TextViewCounter);
        try {
            //Initialize assetmanager object
            AssetManager am = this.getAssets();
            //open file using asset manager
            InputStream is = am.open("worden.txt");
            InputStream is_wm = am.open("worden_easy.txt");

            //read buffer manager
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            BufferedReader reader_wm = new BufferedReader(new InputStreamReader(is_wm));

            //Tries to read the word file
            try {
                while (reader.readLine() != null) {
                    myDict.add(reader.readLine());
                }
                while (reader_wm.readLine() != null) {
                    easy.add(reader_wm.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Random r = new Random();
            int n = r.nextInt(easy.size())+1;
            String word = easy.get(n);
            word1.setText(valueOf(word));
            n = r.nextInt(easy.size())+1;
            word = easy.get(n);
            word2.setText(valueOf(word));
            n = r.nextInt(myDict.size())+1;
            word = myDict.get(n);
            word3.setText(valueOf(word));
            n = r.nextInt(myDict.size())+1;
            word = myDict.get(n);
            word4.setText(valueOf(word));
            n = r.nextInt(easy.size());
            word = easy.get(n);
            word5.setText(valueOf(word));


            new CountDownTimer(40000, 1000) {
                public void onTick(long millisUntilFinished) {
                    textViewCounter.setText(String.valueOf(40 - counter));
                    counter++;
                }

                public void onFinish() {
                    textViewCounter.setText("FINISH!!");
                }

            }.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
