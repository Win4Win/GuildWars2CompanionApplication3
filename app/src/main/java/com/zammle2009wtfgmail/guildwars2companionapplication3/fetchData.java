package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void, Void, Void>  {




    String DataParsed = "";
    String SingleParsed = "";
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://api.guildwars2.com/v2/wvw/matches/1-1");
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(60000); // timing out in a minute

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            heroPanels.urls2 = "";

            String str;
            while ((str = in.readLine()) != null) {
                heroPanels.urls2 = heroPanels.urls2 + str;
            }
            in.close();

            JSONObject WvW =  new JSONObject(heroPanels.urls2);

            JSONArray maps = WvW.getJSONArray("maps");

            //////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////  EBG  //////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////
            JSONObject EBG = (JSONObject) maps.get(0);
            JSONArray EBGobjectives = EBG.getJSONArray("objectives");

            if (worldVsWorld.Borderland == 0)
            {
                for (int i = 0; i < EBGobjectives.length(); ++i)
                {
                    JSONObject source = (JSONObject) EBGobjectives.get(i);
                    String temp = "" + source.get("owner");

                    try
                    {
                        if (!worldVsWorld.Center.buildings.get(i).owner.equals(temp))
                        {
                            if (temp.equals("Red"))
                            {
                                worldVsWorld.Center.buildings.get(i).color.setImageResource(R.drawable.red);
                            }
                            else if (temp.equals("Blue"))
                            {
                                worldVsWorld.Center.buildings.get(i).color.setImageResource(R.drawable.blueicon);
                            }
                            else if (temp.equals("Green"))
                            {
                                worldVsWorld.Center.buildings.get(i).color.setImageResource(R.drawable.green);
                            }

                        }
                    }
                    catch(Exception e)
                    {

                    }
                }
            }



            //////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////  GREEN BL  /////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////
            JSONObject Green = (JSONObject) maps.get(1);
            JSONArray Greenobjectives = Green.getJSONArray("objectives");

            if (worldVsWorld.Borderland == 1)
            {

            }



            //////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////  BLUE BL  //////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////
            JSONObject Blue = (JSONObject) maps.get(2);
            JSONArray Blueobjectives = Blue.getJSONArray("objectives");


            if (worldVsWorld.Borderland == 2)
            {

            }

            //////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////  RED BL  ///////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////
            JSONObject Red = (JSONObject) maps.get(3);
            JSONArray Redobjectives = Red.getJSONArray("objectives");

            if (worldVsWorld.Borderland == 3)
            {

            }






            in.close();
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {

            e.printStackTrace();
        } catch (JSONException e)
        {
            e.printStackTrace();
        }





        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);

        try {

            int i = Integer.parseInt(worldVsWorld.server.toString()) + 1;
            worldVsWorld.server.setText((Integer.toString(i)));
        }
        catch (Exception e)
        {

        }
    }
}
