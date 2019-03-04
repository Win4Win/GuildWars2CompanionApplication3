package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class testPage extends AppCompatActivity {





    static TextView testView;
    static ImageView ItemIcon;
    static ImageView infusion1_;
    static ImageView infusion2_;
    static ImageView upgrade1_;
    static ImageView upgrade2_;

ImageView im;

Drawable test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);






       testView = (TextView) findViewById(R.id.testView);
        ItemIcon = (ImageView) findViewById(R.id.theicon);
        infusion1_=(ImageView) findViewById(R.id.infusion1);
        infusion2_ = (ImageView) findViewById(R.id.infusion2);
        upgrade1_ = (ImageView) findViewById(R.id.upgrade1);
        upgrade2_ = (ImageView) findViewById(R.id.upgrade2);


        /////////////////////////////////////////////////////////////
        //////////// character names ////////////////////////////////
        /////////////////////////////////////////////////////////////














    }




}



