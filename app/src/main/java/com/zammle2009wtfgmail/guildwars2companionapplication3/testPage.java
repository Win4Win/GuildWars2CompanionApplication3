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



    static    String urls=new String();

    static String[] id_;
    static String[] name_;
    static String[] age_;
    static String[] world;
    static String[] guilds_;
    static String[] guildLeader_;
    static String[] created_;
    static String[] access_;
    static String[] commander_;
    static String[] fractalLevel_;
    static String[] dailyAp_;
    static String[] monthlyAp_;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);


        final TextView t = (TextView) findViewById(R.id.info1);



        new Thread(new Runnable(){

            public void run(){



                //TextView t; //to show the result, please declare and find it inside onCreate()



                try {
                    // Create a URL for the desired page
                    URL url = new URL("https://api.guildwars2.com/v2/account?access_token=4D1E4855-C111-0148-97BA-7E3AC22F7150405B70E3-B469-4EE5-95CA-5BE5928B7FA7"); //My text file location
                    //First open the connection
                    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(60000); // timing out in a minute

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()
                    String str;
                    while ((str = in.readLine()) != null) {
                        urls = urls + str;
                    }
                    in.close();
                } catch (Exception e) {
                    Log.d("MyTag",e.toString());
                }

                //since we are in background thread, to post results we have to go back to ui thread. do the following for that

                testPage.this.runOnUiThread(new Runnable(){
                    public void run(){




                        urls = urls.replace("{", "");
                        urls = urls.replace("}", "");
                        urls = urls.replace("\"", "");
                        urls = urls.replace(",", "");
                        urls = urls.replace("[", "");
                        urls = urls.replace("]", "");

                        String[] newText = urls.split(System.getProperty("line.separator"));

                        for (int i = 0; i < newText.length; ++i )
                        {




                        }

                        t.setText(urls); // My TextFile has 3 lines
                    }
                });

            }
        }).start();

    }

}