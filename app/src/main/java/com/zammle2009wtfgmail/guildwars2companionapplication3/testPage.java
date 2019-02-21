package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class testPage extends AppCompatActivity {



    static String urls2="";









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);










        new DownloadImageTask((ImageView) findViewById(R.id.testview))
                .execute("https://render.guildwars2.com/file/D5A5A4083E97C4EF0226315226E610C01DEE2248/1423739.png");
















    }

}