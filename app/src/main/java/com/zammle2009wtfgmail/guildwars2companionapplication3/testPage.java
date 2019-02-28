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

                                            String delimterName = names.get(selectedCharacter).replace(" ", "%20");

                                            String linkAPI = ApiResources.charactersAPI + "/" + delimterName + ApiResources.token + ApiResources.accountAPI;

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

                                                try {
                                                     currentCharacter.name_ = "" + characterInfo.get("name");
                                                     currentCharacter.race = "" + characterInfo.get("race");
                                                     currentCharacter.gender = "" + characterInfo.get("gender");
                                                     currentCharacter.profession = "" + characterInfo.get("profession");
                                                     currentCharacter.guild = "" + characterInfo.get("guild");
                                                     currentCharacter.age = "" + characterInfo.get("age");
                                                     currentCharacter.created = "" + characterInfo.get("created");
                                                     currentCharacter.deaths = "" + characterInfo.get("deaths");
                                                     currentCharacter.level = "" + characterInfo.get("level");


                                                    JSONArray crafting = characterInfo.getJSONArray("crafting");
                                                    for (int i = 0; i < crafting.length(); ++i)
                                                    {
                                                        JSONObject source = (JSONObject) crafting.get(i);

                                                        Crafting temp = new Crafting();
                                                        temp.active = "" + source.get("active");
                                                        temp.discipline = "" + source.get("discipline");
                                                        temp.rating = "" + source.get("rating");

                                                        currentCharacter.crafting.add(temp);

                                                    }


                                                    JSONObject specialization = characterInfo.getJSONObject("specializations");
                                                    JSONArray PVE = specialization.getJSONArray("pve");
                                                    for (int i = 0; i < PVE.length(); ++i)
                                                    {
                                                        JSONObject source = (JSONObject) PVE.get(i);

                                                      Traits temp = new Traits();
                                                      temp.id_ = "" + source.get("id");

                                                            JSONArray traitLine = source.getJSONArray("traits");

                                                            for (int x = 0; x < traitLine.length(); ++x)
                                                            {
                                                                temp.traits_[x] = "" + traitLine.get(x).toString();
                                                            }

                                                      currentCharacter.specialization.pve_.add(temp);

                                                    }


                                                    JSONArray PVP = specialization.getJSONArray("pvp");
                                                    for (int i = 0; i < PVP.length(); ++i)
                                                    {
                                                        JSONObject source = (JSONObject) PVP.get(i);

                                                        Traits temp = new Traits();
                                                        temp.id_ = "" + source.get("id");

                                                        JSONArray traitLine = source.getJSONArray("traits");

                                                        for (int x = 0; x < traitLine.length(); ++x)
                                                        {
                                                            temp.traits_[x] = "" + traitLine.get(x).toString();
                                                        }

                                                        currentCharacter.specialization.pvp_.add(temp);

                                                    }

                                                    JSONArray WVW = specialization.getJSONArray("wvw");
                                                    for (int i = 0; i < WVW.length(); ++i)
                                                    {
                                                        JSONObject source = (JSONObject) WVW.get(i);

                                                        Traits temp = new Traits();
                                                        temp.id_ = "" + source.get("id");

                                                        JSONArray traitLine = source.getJSONArray("traits");

                                                        for (int x = 0; x < traitLine.length(); ++x)
                                                        {
                                                            temp.traits_[x] = "" + traitLine.get(x).toString();
                                                        }

                                                        currentCharacter.specialization.wvw_.add(temp);

                                                    }



                                                    // start of complicated items


                                                    //////////////////////////////
                                                    //// complicated items!!! ////
                                                    //////////////////////////////

                                                    JSONArray equipment = characterInfo.getJSONArray("equipment");
                                                    for (int i = 0; i < equipment.length(); ++i)
                                                    {
                                                        JSONObject source = (JSONObject) equipment.get(i);

                                                        final itemInfo tempItem = new itemInfo();




                                                        new Thread(new itemRunnable(i,source){}).start();












                                                    }

                                                    // end of complicated items


                                                    //  String delimterName = names.get(selectedCharacter).replace(" ", "%20");
                                                 //   testView.setText(currentCharacter.specialization.wvw_.get(0).traits_[1]);




















                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }


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

    public class itemRunnable implements Runnable
    {



        public int position;
        public JSONObject JSON;
        public JSONObject Linker;


        public itemRunnable(int _pos, JSONObject js)
        {

            this.position = _pos;
            this.JSON = js;



        }

        @Override
        public void run(){



            //TextView t; //to show the result, please declare and find it inside onCreate()


            itemInfo tempItem = new itemInfo();
                try
                {
                    tempItem.id_ = "" + JSON.get("id");
                    tempItem.type_ = "" + JSON.get("slot");
                    try {
                        tempItem.skin = "" + JSON.get("skin");
                    }
                    catch (Exception e)
                    {

                    }


                    try {
                        JSONArray infusion = JSON.getJSONArray("infusions");
                        for (int i = 0; i < infusion.length(); ++i) {

                            String temp = "" + infusion.get(i);

                            tempItem.infusions.add(temp);

                        }
                    }
                    catch (Exception e)
                    {}

                    try {
                        JSONArray upgrades = JSON.getJSONArray("upgrades");
                        for (int i = 0; i < upgrades.length(); ++i) {
                            String temp = "" + upgrades.get(i);

                            tempItem.upgrades.add(temp);

                        }
                    }
                    catch (Exception e)
                    {}




                    currentCharacter.equipment.add(tempItem);




                }catch (Exception e)
                {

                }



            try {
                // Create a URL for the desired page




                URL url = new URL(ApiResources.itemAPI + tempItem.id_); //My text file location
                //First open the connection
                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(60000); // timing out in a minute

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()


                String tempURL = "";

                String str;
                while ((str = in.readLine()) != null) {
                    tempURL = tempURL + str;
                }

                Linker =  new JSONObject(tempURL);

                in.close();
            } catch (Exception e) {
                Log.d("MyTag",e.toString());
            }



            //since we are in background thread, to post results we have to go back to ui thread. do the following for that

            testPage.this.runOnUiThread(new Runnable(){
                public void run()
                {

                    testPage.testView.setText(currentCharacter.equipment.get(0).id_);
                    try {
                        currentCharacter.name_ ="" + Linker.get("name");

                        String itemPNG = "" + Linker.get("icon");

                        Picasso.with(testPage.this)
                                .load(itemPNG)
                                .into(ItemIcon, new com.squareup.picasso.Callback() {
                                    @Override
                                    public void onSuccess() {




                                    }

                                    @Override
                                    public void onError() {
                                        ItemIcon.setImageDrawable(getResources().getDrawable(R.drawable.xerror));

                                    }
                                });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }




            });


        }






    }





}



