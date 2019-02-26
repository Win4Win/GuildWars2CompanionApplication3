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



    static String urls2="";
    static String urls3="";

    static int selectedCharacter = 0;

    JSONArray characters;
    JSONObject characterInfo;
    static ArrayList <String> names = new ArrayList <>();
    static characterInfo currentCharacter = new characterInfo();



ImageView im;

Drawable test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);






        final TextView testView = (TextView) findViewById(R.id.testView);



        /////////////////////////////////////////////////////////////
        //////////// character names ////////////////////////////////
        /////////////////////////////////////////////////////////////



                new Thread(new Runnable(){

                    public void run(){



                        //TextView t; //to show the result, please declare and find it inside onCreate()




                        try {
                            // Create a URL for the desired page

                            String linkAPI =ApiResources.charactersAPI + ApiResources.token + ApiResources.accountAPI;

                            URL url = new URL(linkAPI); //My text file location
                            //First open the connection
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setConnectTimeout(60000); // timing out in a minute

                            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                            //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()


                            urls2 = "";

                            String str;
                            while ((str = in.readLine()) != null) {
                                urls2 = urls2 + str;
                            }

                            characters = new JSONArray(urls2);

                            in.close();
                        } catch (Exception e) {
                            Log.d("MyTag", e.toString());
                        }


                        //since we are in background thread, to post results we have to go back to ui thread. do the following for that

                        testPage.this.runOnUiThread(new Runnable(){
                            public void run()
                            {



                                for (int i = 0; i < characters.length(); ++i) {
                                    try {
                                        names.add(characters.get(i).toString());
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }






                                // part 2


                                ////////////////////////////////////////////////////
                                ///////////// selected character info //////////////
                                ////////////////////////////////////////////////////




                                new Thread(new Runnable(){

                                    public void run(){



                                        //TextView t; //to show the result, please declare and find it inside onCreate()




                                        try {
                                            // Create a URL for the desired page

                                            String delimterName = names.get(selectedCharacter).replace(" ", "%20");;

                                            String linkAPI = ApiResources.charactersAPI + delimterName + ApiResources.token + ApiResources.accountAPI;

                                            URL url = new URL(linkAPI); //My text file location
                                            //First open the connection
                                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                            conn.setConnectTimeout(60000); // timing out in a minute

                                            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                                            //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()


                                            urls3 = "";

                                            String str;
                                            while ((str = in.readLine()) != null) {
                                                urls3 = urls3 + str;
                                            }

                                            characterInfo = new JSONObject(urls3);

                                            in.close();
                                        } catch (Exception e) {
                                            Log.d("MyTag", e.toString());
                                        }


                                        //since we are in background thread, to post results we have to go back to ui thread. do the following for that

                                        testPage.this.runOnUiThread(new Runnable(){
                                            public void run()
                                            {






                                            }




                                        });



                                    }


                                }).start();

                                // end of part 2




                            }




                        });



                    }


                }).start();











    }
}