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


    private Handler handler = new Handler();
    static String wvwURL = "";

    JSONObject WvW;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.world_vs_world);
        {





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



                                        worldVsWorld.Center.buildings.add(temp);

                                    }


                                    //////////////////////////////////////////////////////////////////////////////////
                                    /////////////////////////////////////  GREEN BL  /////////////////////////////////
                                    //////////////////////////////////////////////////////////////////////////////////
                                    JSONObject Green = (JSONObject) maps.get(1);
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



                                        worldVsWorld.greenBorderlands.buildings.add(temp);

                                    }


                                    //////////////////////////////////////////////////////////////////////////////////
                                    /////////////////////////////////////  BLUE BL  //////////////////////////////////
                                    //////////////////////////////////////////////////////////////////////////////////
                                    JSONObject Blue = (JSONObject) maps.get(2);
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

                                        /**
                                        if (temp.notSpawn == true) {

                                            if (temp.id == "38-20") {
                                                temp.color = (ImageView) findViewById(R.id.veloka_slope);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }
                                            else if (temp.id == "11-2")
                                            {
                                                temp.color = (ImageView) findViewById(R.id.);
                                            }

                                        }
                                         **/

                                        worldVsWorld.blueBorderlands.buildings.add(temp);

                                    }

                                    //////////////////////////////////////////////////////////////////////////////////
                                    /////////////////////////////////////  RED BL  ///////////////////////////////////
                                    //////////////////////////////////////////////////////////////////////////////////
                                    JSONObject Red = (JSONObject) maps.get(3);
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



                                        worldVsWorld.redBorderlands.buildings.add(temp);

                                    }







                                }
                               catch (JSONException e)
                                {
                                    e.printStackTrace();
                                }





                            }
                        });

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
        public int GetTimer()
        {return Time;}
        public void SetTime(int time)
        {Time = time;}
        public MyRunnables(int _Time)
        {

            this.Time = _Time;



        }







        @Override
        public void run()
        {

            if (MainActivity.selectedLayout == 3)
            {


                handler.postDelayed(this, Time  * 1000);


            }

        }
    }






}

