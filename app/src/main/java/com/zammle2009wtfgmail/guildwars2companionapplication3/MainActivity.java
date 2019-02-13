package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    static String urls="";

    static String[] id_ = new String[2];
    static String[] name_ = new String[2];
    static String[] age_ = new String[2];
    static String[] world = new String[2];
    static String[] guilds_ = new String[6];
    static String[] guildLeader_= new String[6];
    static String[] created_ = new String[2];
    static String[] access_ = new String[6];
    static String[] commander_ = new String[2];
    static String[] fractalLevel_ = new String[2];
    static String[] dailyAp_ = new String[2];
    static String[] monthlyAp_ = new String[2];
    static String[] wvwRank_= new String[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button milestone = (Button) findViewById(R.id.Milestone);
        final Button achievements = (Button) findViewById(R.id.Achievements);
        final Button blogs = (Button) findViewById(R.id.Blogs);
        final Button temp1 = (Button) findViewById(R.id.TempHolder1);
        final Button temp2 = (Button) findViewById(R.id.TempHolder2);

        final TextView t = (TextView) findViewById(R.id.YourName);

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

                MainActivity.this.runOnUiThread(new Runnable(){
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


                        int i = 1;


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



                        if (newText3[i].equals("guild_leader"))
                        {
                            int i2 = i;
                            guildLeader_[0] = newText3[i2];
                            i2 += 1;


                            boolean NoMoreGuilds = false;

                            /** checking first guild L**/
                            if (NoMoreGuilds == false)
                            {

                                if (newText3[i2].equals("created")  || newText3[i2].equals("access"))
                                {
                                    NoMoreGuilds = true;
                                }
                                else
                                {
                                    guildLeader_[i2-i] = newText3[i2];
                                    i2 += 1;
                                }
                            }

                            /** checking second guild L**/
                            if (NoMoreGuilds == false)
                            {

                                if (newText3[i2].equals("created")  || newText3[i2].equals("access"))
                                {
                                    NoMoreGuilds = true;
                                }
                                else
                                {
                                    guildLeader_[i2-i] = newText3[i2];
                                    i2 += 1;
                                }
                            }

                            /** checking third guild L**/
                            if (NoMoreGuilds == false)
                            {

                                if (newText3[i2].equals("created")  || newText3[i2].equals("access"))
                                {
                                    NoMoreGuilds = true;
                                }
                                else
                                {
                                    guildLeader_[i2-i] = newText3[i2];
                                    i2 += 1;
                                }
                            }

                            /** checking 4th guild L**/
                            if (NoMoreGuilds == false)
                            {

                                if (newText3[i2].equals("created")  || newText3[i2].equals("access"))
                                {
                                    NoMoreGuilds = true;
                                }
                                else
                                {
                                    guildLeader_[i2-i] = newText3[i2];
                                    i2 += 1;
                                }
                            }

                            /** checking fifth guild L**/
                            if (NoMoreGuilds == false)
                            {

                                if (newText3[i2].equals("created")  || newText3[i2].equals("access"))
                                {
                                    NoMoreGuilds = true;
                                }
                                else
                                {
                                    guildLeader_[i2-i] = newText3[i2];
                                    i2 += 1;
                                }
                            }




                            i = i2;
                        }

                        if (newText3[i].equals("created"))
                        {
                            created_[0] = newText3[i];
                            i += 1;
                            created_[1] = newText3[i];
                            i += 1;
                        }

                        if (newText3[i].equals("access"))
                        {
                            int i2 = i;
                            access_[0] = newText3[i2];
                            i2 += 1;

                            boolean NoMoreExpansions = false;



                            /** checking 1st expansion **/
                            if (NoMoreExpansions == false)
                            {
                                if (newText3[i2].equals("commander") || newText3[i2].equals("fractal_level"))
                                {
                                    NoMoreExpansions = true;
                                }
                                else
                                {
                                    access_[i2 - i] = newText3[i2];
                                    i2 += 1;
                                }
                            }

                            /** checking 2nd expansion **/
                            if (NoMoreExpansions == false)
                            {
                                if (newText3[i2].equals("commander") || newText3[i2].equals("fractal_level"))
                                {
                                    NoMoreExpansions = true;
                                }
                                else
                                {
                                    access_[i2 - i] = newText3[i2];
                                    i2 += 1;
                                }
                            }

                            /** checking 3rd expansion **/
                            if (NoMoreExpansions == false)
                            {
                                if (newText3[i2].equals("commander") || newText3[i2].equals("fractal_level"))
                                {
                                    NoMoreExpansions = true;
                                }
                                else
                                {
                                    access_[i2 - i] = newText3[i2];
                                    i2 += 1;
                                }
                            }

                            /** checking 4th expansion **/
                            if (NoMoreExpansions == false)
                            {
                                if (newText3[i2].equals("commander") || newText3[i2].equals("fractal_level"))
                                {
                                    NoMoreExpansions = true;
                                }
                                else
                                {
                                    access_[i2 - i] = newText3[i2];
                                    i2 += 1;
                                }
                            }

                            /** checking 5th expansion **/
                            if (NoMoreExpansions == false)
                            {
                                if (newText3[i2].equals("commander") || newText3[i2].equals("fractal_level"))
                                {
                                    NoMoreExpansions = true;
                                }
                                else
                                {
                                    access_[i2 - i] = newText3[i2];
                                    i2 += 1;
                                }
                            }

                            i = i2;
                        }


                        boolean OutOfBounds = false;

                        if (OutOfBounds == false)
                        {
                            try
                            {
                                if (newText3[i].equals("commander"))
                                {
                                    commander_[0] = newText3[i];
                                    i += 1;
                                    commander_[1] = newText3[i];
                                    i += 1;
                                }


                            } catch (IndexOutOfBoundsException e)
                            {
                                OutOfBounds = true;
                            }
                        }




                        if (OutOfBounds == false)
                        {
                            try
                            {
                                if (newText3[i].equals("fractal_level"))
                                {
                                    fractalLevel_[0] = newText3[i];
                                    i += 1;
                                    fractalLevel_[1] = newText3[i];
                                    i += 1;
                                }


                            } catch (IndexOutOfBoundsException e)
                            {
                                OutOfBounds = true;
                            }
                        }

                        if (OutOfBounds == false)
                        {
                            try
                            {
                                if (newText3[i].equals("daily_ap"))
                                {
                                    dailyAp_[0] = newText3[i];
                                    i += 1;
                                    dailyAp_[1] = newText3[i];
                                    i += 1;
                                }


                            } catch (IndexOutOfBoundsException e)
                            {
                                OutOfBounds = true;
                            }
                        }

                        if (OutOfBounds == false)
                        {
                            try
                            {
                                if (newText3[i].equals("monthly_ap"))
                                {
                                    monthlyAp_[0] = newText3[i];
                                    i += 1;
                                    monthlyAp_[1] = newText3[i];
                                    i += 1;
                                }


                            } catch (IndexOutOfBoundsException e)
                            {
                                OutOfBounds = true;
                            }
                        }

                        if (OutOfBounds == false)
                        {
                            try
                            {
                                if (newText3[i].equals("wvw_rank"))
                                {
                                    wvwRank_[0] = newText3[i];
                                    i += 1;
                                    wvwRank_[1] = newText3[i];
                                    i += 1;
                                }


                            } catch (IndexOutOfBoundsException e)
                            {
                                OutOfBounds = true;
                            }
                        }

                        t.setText(name_[1]); // My TextFile has 3 lines
                    }
                });

            }
        }).start();

        milestone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milestone.setBackgroundResource(R.drawable.selected2);
                achievements.setBackgroundResource(R.drawable.lighterbackground);
                blogs.setBackgroundResource(R.drawable.lighterbackground);
                temp1.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.lighterbackground);


                milestone.setTextColor(Color.parseColor("#FFFFFF"));
                achievements.setTextColor(Color.parseColor("#A0A0A0"));
                blogs.setTextColor(Color.parseColor("#A0A0A0"));
                temp1.setTextColor(Color.parseColor("#A0A0A0"));
                temp2.setTextColor(Color.parseColor("#A0A0A0"));
            }


        });

        achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milestone.setBackgroundResource(R.drawable.lighterbackground);
                achievements.setBackgroundResource(R.drawable.selected2);
                blogs.setBackgroundResource(R.drawable.lighterbackground);
                temp1.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.lighterbackground);

                milestone.setTextColor(Color.parseColor("#A0A0A0"));
                achievements.setTextColor(Color.parseColor("#FFFFFF"));
                blogs.setTextColor(Color.parseColor("#A0A0A0"));
                temp1.setTextColor(Color.parseColor("#A0A0A0"));
                temp2.setTextColor(Color.parseColor("#A0A0A0"));
            }


        });

        blogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milestone.setBackgroundResource(R.drawable.lighterbackground);
                achievements.setBackgroundResource(R.drawable.lighterbackground);
                blogs.setBackgroundResource(R.drawable.selected2);
                temp1.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.lighterbackground);

                milestone.setTextColor(Color.parseColor("#A0A0A0"));
                achievements.setTextColor(Color.parseColor("#A0A0A0"));
                blogs.setTextColor(Color.parseColor("#FFFFFF"));
                temp1.setTextColor(Color.parseColor("#A0A0A0"));
                temp2.setTextColor(Color.parseColor("#A0A0A0"));
            }


        });


        temp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milestone.setBackgroundResource(R.drawable.lighterbackground);
                achievements.setBackgroundResource(R.drawable.lighterbackground);
                blogs.setBackgroundResource(R.drawable.lighterbackground);
                temp1.setBackgroundResource(R.drawable.selected2);
                temp2.setBackgroundResource(R.drawable.lighterbackground);

                milestone.setTextColor(Color.parseColor("#A0A0A0"));
                achievements.setTextColor(Color.parseColor("#A0A0A0"));
                blogs.setTextColor(Color.parseColor("#A0A0A0"));
                temp1.setTextColor(Color.parseColor("#FFFFFF"));
                temp2.setTextColor(Color.parseColor("#A0A0A0"));
            }


        });

        temp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milestone.setBackgroundResource(R.drawable.lighterbackground);
                achievements.setBackgroundResource(R.drawable.lighterbackground);
                blogs.setBackgroundResource(R.drawable.lighterbackground);
                temp1.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.selected2);


                milestone.setTextColor(Color.parseColor("#A0A0A0"));
                achievements.setTextColor(Color.parseColor("#A0A0A0"));
                blogs.setTextColor(Color.parseColor("#A0A0A0"));
                temp1.setTextColor(Color.parseColor("#A0A0A0"));
                temp2.setTextColor(Color.parseColor("#FFFFFF"));
            }


        });



        final Button companion = (Button) findViewById(R.id.companion);
        companion.setOnClickListener(new View.OnClickListener()
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


        final Button hero = (Button) findViewById(R.id.heroPanel);
        hero.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                 Intent history = new Intent (MainActivity.this, heroPanels.class );
                 startActivity(history);

            }

        });

        final Button forums = (Button) findViewById(R.id.forums);
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

        final Button WvW = (Button) findViewById(R.id.wvw);
        WvW.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                 Intent history = new Intent (MainActivity.this, worldVsWorld.class );
                 startActivity(history);

            }

        });

        final Button more = (Button) findViewById(R.id.more);
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


        final ImageButton news1 = (ImageButton) findViewById(R.id.news1);
        news1.setOnClickListener(new View.OnClickListener()
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

        final ImageButton news2 = (ImageButton) findViewById(R.id.news2);
        news2.setOnClickListener(new View.OnClickListener()
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

        final ImageButton news3 = (ImageButton) findViewById(R.id.news3);
        news3.setOnClickListener(new View.OnClickListener()
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

        final ImageButton news4 = (ImageButton) findViewById(R.id.news4);
        news4.setOnClickListener(new View.OnClickListener()
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

        final ImageButton news5 = (ImageButton) findViewById(R.id.news5);
        news1.setOnClickListener(new View.OnClickListener()
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

        /** comments  more***/

    }}