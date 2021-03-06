package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.os.Handler;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class worldVsWorld extends AppCompatActivity {



    static borderlands Center = new borderlands();
    static borderlands redBorderlands = new borderlands();
    static borderlands blueBorderlands = new borderlands();
    static borderlands greenBorderlands = new borderlands();


    public static TextView server;

    private Handler handler = new Handler();
    static String wvwURL = "";

    JSONObject WvW;

    static int Borderland = 0;

    static int count = 0;

  static int completed = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.world_vs_world);
        {

            server = (TextView) findViewById(R.id.serverName);

            count = 0;


           final Button view2 = (Button) findViewById(R.id.wvw2);

           final LinearLayout mapselector = (LinearLayout) findViewById(R.id.mapselector);
           final Button maps = (Button) findViewById(R.id.button);
           final Button ebgs = (Button) findViewById(R.id.ebgbutton);
           final Button rbls = (Button) findViewById(R.id.rblbutton);
           final Button bbls = (Button) findViewById(R.id.bblbutton);
           final Button gbls = (Button) findViewById(R.id.gblbutton);
           final RelativeLayout Eborder = (RelativeLayout) findViewById(R.id.ebg);
           final RelativeLayout Rborder = (RelativeLayout) findViewById(R.id.rbl);
           final RelativeLayout Bborder = (RelativeLayout) findViewById(R.id.bbl);
           final RelativeLayout Gborder = (RelativeLayout) findViewById(R.id.gbl);
           final Button close = (Button) findViewById(R.id.close);
           final Button closeout = (Button) findViewById(R.id.background4);

           maps.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v)
               {
                   if (count == 0) {
                       mapselector.setVisibility(view2.VISIBLE);
                       closeout.setVisibility(view2.VISIBLE);

                       count = 1;
                   }
                   else if (count == 1)
                   {
                       mapselector.setVisibility(view2.INVISIBLE);
                       closeout.setVisibility(view2.INVISIBLE);

                       count = 0;
                   }
               }
           });

           close.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (count == 0) {
                       mapselector.setVisibility(view2.VISIBLE);
                       closeout.setVisibility(view2.VISIBLE);

                       count = 1;
                   }
                   else if (count == 1)
                   {
                       mapselector.setVisibility(view2.INVISIBLE);
                       closeout.setVisibility(view2.INVISIBLE);


                       count = 0;
                   }
               }
           });

           closeout.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v)
               {
                   if (count == 0) {
                       mapselector.setVisibility(view2.VISIBLE);
                       closeout.setVisibility(view2.VISIBLE);

                       count = 1;
                   }
                   else if (count == 1)
                   {
                       mapselector.setVisibility(view2.INVISIBLE);
                       closeout.setVisibility(view2.INVISIBLE);


                       count = 0;
                   }
               }
           });

           ebgs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Eborder.setVisibility(view2.VISIBLE);
                Rborder.setVisibility(view2.INVISIBLE);
                Bborder.setVisibility(view2.INVISIBLE);
                Gborder.setVisibility(View.INVISIBLE);
            }
        });

            rbls.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Eborder.setVisibility(view2.INVISIBLE);
                    Rborder.setVisibility(view2.VISIBLE);
                    Bborder.setVisibility(view2.INVISIBLE);
                    Gborder.setVisibility(View.INVISIBLE);
                }
            });

            bbls.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Eborder.setVisibility(view2.INVISIBLE);
                    Rborder.setVisibility(view2.INVISIBLE);
                    Bborder.setVisibility(view2.VISIBLE);
                    Gborder.setVisibility(View.INVISIBLE);
                }
            });

            gbls.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Eborder.setVisibility(view2.INVISIBLE);
                    Rborder.setVisibility(view2.INVISIBLE);
                    Bborder.setVisibility(view2.INVISIBLE);
                    Gborder.setVisibility(View.VISIBLE);
                }
            });


            MainActivity.selectedLayout = 3;


            new Thread(new Runnable(){

                public void run(){



                    //TextView t; //to show the result, please declare and find it inside onCreate()




                    try {
                        // Create a URL for the desired page
                        URL url = new URL("https://api.guildwars2.com/v2/wvw/matches/1-1"); //My text file location
                        //First open the connection
                        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                        conn.setConnectTimeout(60000); // timing out in a minute

                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                        //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()


                        wvwURL = "";

                        String str;
                        while ((str = in.readLine()) != null) {
                            wvwURL = wvwURL + str;
                        }

                        WvW =  new JSONObject(wvwURL);

                        in.close();
                    } catch (Exception e) {
                        Log.d("MyTag",e.toString());
                    }



                    //since we are in background thread, to post results we have to go back to ui thread. do the following for that

                    worldVsWorld.this.runOnUiThread(new Runnable(){
                            public void run()
                            {

                                try {

                                    JSONArray maps = WvW.getJSONArray("maps");

                                    //////////////////////////////////////////////////////////////////////////////////
                                    /////////////////////////////////////  EBG  //////////////////////////////////////
                                    //////////////////////////////////////////////////////////////////////////////////
                                    JSONObject EBG = (JSONObject) maps.get(0);
                                    JSONArray EBGobjectives = EBG.getJSONArray("objectives");

                                    for (int i = 0; i < EBGobjectives.length(); ++i)
                                    {
                                        JSONObject source = (JSONObject) EBGobjectives.get(i);
                                        structures temp = new structures();

                                        try
                                        {
                                            temp.yaks_delivered = "" + source.get("yak_delivered");
                                            temp.claimed_by = "" + source.get("claimed_by");
                                        }
                                        catch(Exception e)
                                        {
                                            temp.notSpawn = false;
                                        }
                                        temp.points_capture = "" + source.get("points_capture");
                                        temp.points_tick = "" + source.get("points_tick");
                                        temp.type = "" + source.get("type");
                                        temp.id = "" + source.get("id");
                                        temp.last_flipped = "" + source.get("last_flipped");
                                        temp.owner = "" + source.get("owner");





                                      try
                                      {



                                            if (temp.id.equals("38-20")) {
                                                temp.color = (ImageView) findViewById(R.id.veloka_slope);

                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-10"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.rogues_quarry);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-9"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.stonemist_castle);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-4"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.golanta_clearing);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-6"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.speldan_clearcut);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-11"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.aldons_ledge);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-12"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.wildcreek_run);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-5"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.pangloss_rise);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-16"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.quentin_lake);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-8"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.umberglade_woods);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-1"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.red_keep);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-22"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.bravost_escarpment);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-17"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.mendons_gap);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-14"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.klovan_gully);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-19"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.ogrewatch_cut);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-3"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.green_keep);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-21"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.durious_gulch);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-18"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.anzalias_pass);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-2"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.blue_keep);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-7"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.danelon_passge);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-13"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.jerrifers_slough);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("38-15"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.langor_gulch);
                                                if (temp.owner.equals("Red"))
                                                {
                                                    temp.color.setImageResource(R.drawable.red);



                                                }
                                                else if (temp.owner.equals("Blue"))
                                                {
                                                    temp.color.setImageResource(R.drawable.blueicon);



                                                }
                                                else if (temp.owner.equals("Green"))
                                                {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }

                                        }
                                        catch (Exception e)
                                        {

                                        }


                                        worldVsWorld.Center.buildings.add(temp);

                                    }


                                    //////////////////////////////////////////////////////////////////////////////////
                                    /////////////////////////////////////  GREEN BL  /////////////////////////////////
                                    //////////////////////////////////////////////////////////////////////////////////
                                    JSONObject Green = (JSONObject) maps.get(3);
                                    JSONArray Greenobjectives = Green.getJSONArray("objectives");

                                    for (int i = 0; i < Greenobjectives.length(); ++i)
                                    {
                                        JSONObject source = (JSONObject) Greenobjectives.get(i);
                                        structures temp = new structures();

                                        try {
                                            temp.yaks_delivered = "" + source.get("yak_delivered");
                                            temp.claimed_by = "" + source.get("claimed_by");
                                        }
                                        catch (Exception e)
                                        {
                                            temp.notSpawn = false;
                                        }


                                        temp.points_capture = "" + source.get("points_capture");
                                        temp.points_tick = "" + source.get("points_tick");
                                        temp.type = "" + source.get("type");
                                        temp.id = "" + source.get("id");
                                        temp.last_flipped = "" + source.get("last_flipped");
                                        temp.owner = "" + source.get("owner");


                                        try
                                        {


                                            if (temp.id.equals("95-53")) {
                                                temp.color = (ImageView) findViewById(R.id.bluevale_refuge);

                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                           else if (temp.id.equals("95-40")) {
                                                temp.color = (ImageView) findViewById(R.id.cragtop);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-35")) {
                                                temp.color = (ImageView) findViewById(R.id.bluebriar);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-36")) {
                                                temp.color = (ImageView) findViewById(R.id.redlake);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-33")) {
                                                temp.color = (ImageView) findViewById(R.id.dreadfall_bay);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-39")) {
                                                temp.color = (ImageView) findViewById(R.id.the_titanpaw);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-52")) {
                                                temp.color = (ImageView) findViewById(R.id.faithleap);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-34")) {
                                                temp.color = (ImageView) findViewById(R.id.heros_lodge);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-32")) {
                                                temp.color = (ImageView) findViewById(R.id.shadaran_hills);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-51")) {
                                                temp.color = (ImageView) findViewById(R.id.foghaven);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-37")) {
                                                temp.color = (ImageView) findViewById(R.id.green_garrison);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-38")) {
                                                temp.color = (ImageView) findViewById(R.id.sunnyhill);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("95-50")) {
                                                temp.color = (ImageView) findViewById(R.id.redwater_lowlands);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }

                                        } catch (Exception e)
                                        {

                                        }


                                        worldVsWorld.greenBorderlands.buildings.add(temp);

                                    }


                                    //////////////////////////////////////////////////////////////////////////////////
                                    /////////////////////////////////////  BLUE BL  //////////////////////////////////
                                    //////////////////////////////////////////////////////////////////////////////////
                                    JSONObject Blue = (JSONObject) maps.get(1);
                                    JSONArray Blueobjectives = Blue.getJSONArray("objectives");

                                    for (int i = 0; i < Blueobjectives.length(); ++i)
                                    {
                                        JSONObject source = (JSONObject) Blueobjectives.get(i);
                                        structures temp = new structures();

                                        try
                                        {
                                            temp.yaks_delivered = "" + source.get("yak_delivered");
                                            temp.claimed_by = "" + source.get("claimed_by");
                                        }
                                        catch (Exception e)
                                        {
                                            temp.notSpawn = false;
                                        }

                                        temp.points_capture = "" + source.get("points_capture");
                                        temp.points_tick = "" + source.get("points_tick");
                                        temp.type = "" + source.get("type");
                                        temp.id = "" + source.get("id");
                                        temp.last_flipped = "" + source.get("last_flipped");
                                        temp.owner = "" + source.get("owner");



                                        try
                                        {


                                            if (temp.id.equals("96-53")) {
                                                temp.color = (ImageView) findViewById(R.id.redvale_refuge);

                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-40")) {
                                                temp.color = (ImageView) findViewById(R.id.dawns_eyrie);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-35")) {
                                                temp.color = (ImageView) findViewById(R.id.redbriar);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-36")) {
                                                temp.color = (ImageView) findViewById(R.id.greenlake);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-33")) {
                                                temp.color = (ImageView) findViewById(R.id.ascension_bay);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-39")) {
                                                temp.color = (ImageView) findViewById(R.id.the_spiritholme);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-52")) {
                                                temp.color = (ImageView) findViewById(R.id.godslore);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-34")) {
                                                temp.color = (ImageView) findViewById(R.id.champions_demesne);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-32")) {
                                                temp.color = (ImageView) findViewById(R.id.askalion_hills);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-51")) {
                                                temp.color = (ImageView) findViewById(R.id.stargrove);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-37")) {
                                                temp.color = (ImageView) findViewById(R.id.blue_garrison);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-38")) {
                                                temp.color = (ImageView) findViewById(R.id.woodhaven);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("96-50")) {
                                                temp.color = (ImageView) findViewById(R.id.greenwater_lowlands);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }

                                        } catch (Exception e)
                                        {

                                        }


                                        worldVsWorld.blueBorderlands.buildings.add(temp);

                                    }

                                    //////////////////////////////////////////////////////////////////////////////////
                                    /////////////////////////////////////  RED BL  ///////////////////////////////////
                                    //////////////////////////////////////////////////////////////////////////////////
                                    JSONObject Red = (JSONObject) maps.get(2);
                                    JSONArray Redobjectives = Red.getJSONArray("objectives");


                                    for (int i = 0; i < Redobjectives.length(); ++i)
                                    {
                                        JSONObject source = (JSONObject) Redobjectives.get(i);
                                        structures temp = new structures();

                                        try
                                        {
                                            temp.yaks_delivered = "" + source.get("yak_delivered");
                                            temp.claimed_by = "" + source.get("claimed_by");
                                        }
                                        catch (Exception e)
                                        {
                                            temp.notSpawn = false;
                                        }

                                        temp.points_capture = "" + source.get("points_capture");
                                        temp.points_tick = "" + source.get("points_tick");
                                        temp.type = "" + source.get("type");
                                        temp.id = "" + source.get("id");
                                        temp.last_flipped = "" + source.get("last_flipped");
                                        temp.owner = "" + source.get("owner");


                                        try
                                        {


                                            if (temp.id.equals("1099-116"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.dustwhisper_well);

                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-114"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.ospreys_palace);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-99"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.hamms_labb);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-113"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.stoic_rampart);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-115"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.boettigers_hideway);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-110"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.parched_outpost);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-106"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.blistering_undercroft);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-105"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.crankshaft_depot);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-102"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.odel_academy);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-109"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.roys_refuge);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-101"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.mclains_encampment);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-104"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.eternal_necropolis);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }
                                            else if (temp.id.equals("1099-100"))
                                            {
                                                temp.color = (ImageView) findViewById(R.id.bauer_farmstead);
                                                if (temp.owner.equals("Red")) {
                                                    temp.color.setImageResource(R.drawable.red);


                                                } else if (temp.owner.equals("Blue")) {
                                                    temp.color.setImageResource(R.drawable.blueicon);


                                                } else if (temp.owner.equals("Green")) {
                                                    temp.color.setImageResource(R.drawable.green);

                                                }
                                            }

                                        } catch (Exception e)
                                        {

                                        }


                                        worldVsWorld.redBorderlands.buildings.add(temp);

                                    }








                                }
                               catch (JSONException e)
                                {
                                    e.printStackTrace();
                                }


                                worldVsWorld.completed = 1;


                            }




                        });
                    handler.postDelayed(new MyRunnables(3),7 * 1000);


                }


            }).start();









            final Button companion = (Button) findViewById(R.id.companion2);
            companion.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                    Intent history = new Intent (worldVsWorld.this, MainActivity.class );
                    startActivity(history);

                }

            });


            final Button hero = (Button) findViewById(R.id.heroPanel2);
            hero.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                     Intent history = new Intent (worldVsWorld.this, heroPanels.class );
                     startActivity(history);

                }

            });

            final Button forums = (Button) findViewById(R.id.forums2);
            forums.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    /**
                     Intent history = new Intent (MainActivity.this, History.class );
                     startActivity(history);
                     **/
                }

            });

            final Button WvW = (Button) findViewById(R.id.wvw2);
            WvW.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                    /**
                    Intent history = new Intent (heroPanels.this, worldVsWorld.class );
                    startActivity(history);
                     **/

                }

            });

            final Button more = (Button) findViewById(R.id.more2);
            more.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    /**
                     Intent history = new Intent (MainActivity.this, History.class );
                     startActivity(history);
                     **/
                }

            });
        }


    }



    public class MyRunnables implements Runnable
    {



        private int Time;

        public MyRunnables(int _Time)
        {

            this.Time = _Time;



        }







        @Override
        public void run()
        {

                if (MainActivity.selectedLayout == 3)
                {

                    new Thread(new Runnable() {

                        public void run() {





                            if (worldVsWorld.completed == 1) {
                                worldVsWorld.completed = 0;


                                try {
                                    // Create a URL for the desired page
                                    URL url = new URL("https://api.guildwars2.com/v2/wvw/matches/1-1"); //My text file location
                                    //First open the connection
                                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                    conn.setConnectTimeout(60000); // timing out in a minute

                                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                                    //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()


                                    wvwURL = "";

                                    String str;
                                    while ((str = in.readLine()) != null) {
                                        wvwURL = wvwURL + str;
                                    }

                                    WvW = new JSONObject(wvwURL);

                                    in.close();
                                } catch (Exception e) {
                                    Log.d("MyTag", e.toString());
                                }


                                //since we are in background thread, to post results we have to go back to ui thread. do the following for that

                                worldVsWorld.this.runOnUiThread(new Runnable() {
                                    public void run() {

                                        try {


                                            JSONObject WvW = new JSONObject(wvwURL);

                                            JSONArray maps = WvW.getJSONArray("maps");

                                            //////////////////////////////////////////////////////////////////////////////////
                                            /////////////////////////////////////  EBG  //////////////////////////////////////
                                            //////////////////////////////////////////////////////////////////////////////////
                                            JSONObject EBG = (JSONObject) maps.get(0);
                                            JSONArray EBGobjectives = EBG.getJSONArray("objectives");


                                            for (int i = 0; i < EBGobjectives.length(); ++i) {
                                                JSONObject source = (JSONObject) EBGobjectives.get(i);
                                                String temp = "" + source.get("owner");

                                                try {
                                                    if (!worldVsWorld.Center.buildings.get(i).owner.equals(temp)) {
                                                        if (temp.equals("Red")) {
                                                            worldVsWorld.Center.buildings.get(i).color.setImageResource(R.drawable.red);
                                                            worldVsWorld.Center.buildings.get(i).owner = "Red";
                                                        } else if (temp.equals("Blue")) {
                                                            worldVsWorld.Center.buildings.get(i).color.setImageResource(R.drawable.blueicon);
                                                            worldVsWorld.Center.buildings.get(i).owner = "Blue";
                                                        } else if (temp.equals("Green")) {
                                                            worldVsWorld.Center.buildings.get(i).color.setImageResource(R.drawable.green);
                                                            worldVsWorld.Center.buildings.get(i).owner = "Green";
                                                        }

                                                    }
                                                } catch (Exception e) {

                                                }
                                            }


                                            //////////////////////////////////////////////////////////////////////////////////
                                            /////////////////////////////////////  GREEN BL  /////////////////////////////////
                                            //////////////////////////////////////////////////////////////////////////////////
                                            JSONObject Green = (JSONObject) maps.get(3);
                                            JSONArray Greenobjectives = Green.getJSONArray("objectives");



                                            for (int i = 0; i < Greenobjectives.length(); ++i) {
                                                JSONObject source = (JSONObject) Greenobjectives.get(i);
                                                String temp = "" + source.get("owner");

                                                try {
                                                    if (!worldVsWorld.greenBorderlands.buildings.get(i).owner.equals(temp)) {
                                                        if (temp.equals("Red")) {
                                                            worldVsWorld.greenBorderlands.buildings.get(i).color.setImageResource(R.drawable.red);
                                                            worldVsWorld.greenBorderlands.buildings.get(i).owner = "Red";
                                                        } else if (temp.equals("Blue")) {
                                                            worldVsWorld.greenBorderlands.buildings.get(i).color.setImageResource(R.drawable.blueicon);
                                                            worldVsWorld.greenBorderlands.buildings.get(i).owner = "Blue";
                                                        } else if (temp.equals("Green")) {
                                                            worldVsWorld.greenBorderlands.buildings.get(i).color.setImageResource(R.drawable.green);
                                                            worldVsWorld.greenBorderlands.buildings.get(i).owner = "Green";
                                                        }

                                                    }
                                                } catch (Exception e) {

                                                }
                                            }


                                            //////////////////////////////////////////////////////////////////////////////////
                                            /////////////////////////////////////  BLUE BL  //////////////////////////////////
                                            //////////////////////////////////////////////////////////////////////////////////
                                            JSONObject Blue = (JSONObject) maps.get(1);
                                            JSONArray Blueobjectives = Blue.getJSONArray("objectives");


                                            for (int i = 0; i < Blueobjectives.length(); ++i) {
                                                JSONObject source = (JSONObject) Blueobjectives.get(i);
                                                String temp = "" + source.get("owner");

                                                try {
                                                    if (!worldVsWorld.blueBorderlands.buildings.get(i).owner.equals(temp)) {
                                                        if (temp.equals("Red")) {
                                                            worldVsWorld.blueBorderlands.buildings.get(i).color.setImageResource(R.drawable.red);
                                                            worldVsWorld.blueBorderlands.buildings.get(i).owner = "Red";
                                                        } else if (temp.equals("Blue")) {
                                                            worldVsWorld.blueBorderlands.buildings.get(i).color.setImageResource(R.drawable.blueicon);
                                                            worldVsWorld.blueBorderlands.buildings.get(i).owner = "Blue";
                                                        } else if (temp.equals("Green")) {
                                                            worldVsWorld.blueBorderlands.buildings.get(i).color.setImageResource(R.drawable.green);
                                                            worldVsWorld.blueBorderlands.buildings.get(i).owner = "Green";
                                                        }

                                                    }
                                                } catch (Exception e) {

                                                }
                                            }




                                            //////////////////////////////////////////////////////////////////////////////////
                                            ////////////////////////////////////////  RED BL  ///////////////////////////////////
                                            //////////////////////////////////////////////////////////////////////////////////
                                            JSONObject Red = (JSONObject) maps.get(2);
                                            JSONArray Redobjectives = Red.getJSONArray("objectives");


                                            for (int i = 0; i < Redobjectives.length(); ++i) {
                                                JSONObject source = (JSONObject) Redobjectives.get(i);
                                                String temp = "" + source.get("owner");

                                                try {
                                                    if (!worldVsWorld.redBorderlands.buildings.get(i).owner.equals(temp)) {
                                                        if (temp.equals("Red")) {
                                                            worldVsWorld.redBorderlands.buildings.get(i).color.setImageResource(R.drawable.red);
                                                            worldVsWorld.redBorderlands.buildings.get(i).owner = "Red";
                                                        } else if (temp.equals("Blue")) {
                                                            worldVsWorld.redBorderlands.buildings.get(i).color.setImageResource(R.drawable.blueicon);
                                                            worldVsWorld.redBorderlands.buildings.get(i).owner = "Blue";
                                                        } else if (temp.equals("Green")) {
                                                            worldVsWorld.redBorderlands.buildings.get(i).color.setImageResource(R.drawable.green);
                                                            worldVsWorld.redBorderlands.buildings.get(i).owner = "Green";
                                                        }

                                                    }
                                                } catch (Exception e) {

                                                }
                                            }


                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }


                                        worldVsWorld.completed = 1;


                                    }


                                });


                            }
                        }


                    }).start();
                }




            if (MainActivity.selectedLayout == 3 )
            {

                handler.postDelayed(this, Time  * 1000);
            }







        }





    }





  }








