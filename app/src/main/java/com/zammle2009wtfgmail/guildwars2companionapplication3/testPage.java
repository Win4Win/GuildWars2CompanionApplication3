package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class testPage extends AppCompatActivity {



    static String urls2="";

        public static TextView testpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        testpage = (TextView) findViewById(R.id.info1);
        fetchData process = new fetchData();
        process.execute();


    }

}