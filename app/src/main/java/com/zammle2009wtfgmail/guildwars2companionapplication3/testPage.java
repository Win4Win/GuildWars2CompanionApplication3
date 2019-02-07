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



    static String urls="";

    static String[] id_ = new String[2];
    static String[] name_ = new String[2];
    static String[] age_ = new String[2];
    static String[] world = new String[2];
    static String[] guilds_ = new String[6];
    static String[] guildLeader_= new String[6];
    static String[] created_ = new String[2];
    static String[] access_ = new String[4];
    static String[] commander_ = new String[2];
    static String[] fractalLevel_ = new String[2];
    static String[] dailyAp_ = new String[2];
    static String[] monthlyAp_ = new String[2];
    static String[] wvwRank_= new String[2];




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
                        urls = urls.replace(":", "");
                        urls = urls.replace("  ", " ");
                        urls = urls.replace("  ", " ");
                        urls = urls.replace("  ", " ");

                        String[] newText = urls.split(" ");
                        String newText2 = new String();

                        for (int i = 0; i < newText.length; ++i)
                        {
                            newText2 += newText[i]  + (System.getProperty("line.separator"));
                        }
                        String[] newText3 = newText2.split(System.getProperty("line.separator"));


                        for (int i = 1; i < newText3.length; ++i)
                        {
                            if (i == 1)
                            {
                                id_[0] = newText3[1];
                                id_[1] = newText3[2];
                                i += 2;

                            }
                            if (i == 3)
                            {
                                name_[0] = newText3[3];
                                name_[1] = newText3[4];
                                i += 2;
                            }
                            if (i == 5)
                            {
                                age_[0] = newText3[5];
                                age_[1] = newText3[6];
                                i += 2;
                            }
                            if (i == 7)
                            {
                                world[0] = newText3[7];
                                world[1] = newText3[8];
                                i += 2;
                            }

                            if (i == 9)
                            {
                                guilds_[0] = newText3[9];
                                int i2 = 1;


                                boolean NoMoreGuilds = false;


                                /** checking first guild **/
                                if (NoMoreGuilds == false)
                                {

                                    if (newText3[10].equals("created") || newText3[10].equals("guild_leader") || newText3[10].equals("access"))
                                    {
                                        NoMoreGuilds = true;
                                    }
                                    else
                                    {
                                        guilds_[i2] = newText3[10];
                                        i2 += 1;
                                    }
                                }

                                /** checking second guild **/
                                if (NoMoreGuilds == false)
                                {

                                    if (newText3[11].equals("created") || newText3[11].equals("guild_leader") || newText3[11].equals("access"))
                                    {
                                        NoMoreGuilds = true;
                                    }
                                    else
                                    {
                                        guilds_[i2] = newText3[11];
                                        i2 += 1;
                                    }
                                }

                                /** checking third guild **/
                                if (NoMoreGuilds == false)
                                {

                                    if (newText3[12].equals("created") || newText3[12].equals("guild_leader") || newText3[12].equals("access"))
                                    {
                                        NoMoreGuilds = true;
                                    }
                                    else
                                    {
                                        guilds_[i2] = newText3[12];
                                        i2 += 1;
                                    }
                                }

                                /** checking fourth guild **/
                                if (NoMoreGuilds == false)
                                {

                                    if (newText3[13].equals("created") || newText3[13].equals("guild_leader") || newText3[13].equals("access"))
                                    {
                                        NoMoreGuilds = true;
                                    }
                                    else
                                    {
                                        guilds_[i2] = newText3[13];
                                        i2 += 1;
                                    }
                                }

                                /** checking fifth guild **/
                                if (NoMoreGuilds == false)
                                {

                                    if (newText3[14].equals("created") || newText3[14].equals("guild_leader") || newText3[14].equals("access"))
                                    {
                                        NoMoreGuilds = true;
                                    }
                                    else
                                    {
                                        guilds_[i2] = newText3[14];
                                        i2 += 1;
                                    }
                                }


                                i += i2;
                            }


                        }

                        t.setText(guilds_[5]); // My TextFile has 3 lines
                    }
                });

            }
        }).start();

    }

}