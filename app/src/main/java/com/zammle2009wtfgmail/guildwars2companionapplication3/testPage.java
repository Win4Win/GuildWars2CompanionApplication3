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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class testPage extends AppCompatActivity {



    static String urls2="";




ImageView im;

Drawable test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);




        im = (ImageView) findViewById(R.id.testview);
        test = getResources().getDrawable(R.drawable.testinfusion);
        ImageView image = new ImageView(getApplicationContext());


        String img_url = "https://render.guildwars2.com/file/D5A5A4083E97C4EF0226315226E610C01DEE2248/1423739.png";
        if (!img_url.equalsIgnoreCase(""))
            Picasso.with(getApplicationContext()).load(img_url).placeholder(R.drawable.oload)// Place holder image from drawable folder
                    .error(R.drawable.xerror).resize(110, 110).centerCrop()
                    .into(image);


        test = image.getDrawable();
        im.setImageDrawable(test);
        /**
        new DownloadImageTask(im)
                .execute("https://render.guildwars2.com/file/D5A5A4083E97C4EF0226315226E610C01DEE2248/1423739.png");
         **/



    }


}