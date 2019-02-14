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


            String str;
            while ((str = in.readLine()) != null) {
                testPage.urls2 = testPage.urls2 + str;
            }

            JSONObject WvW =  new JSONObject(testPage.urls2);

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
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        testPage.testpage.setText(worldVsWorld.redBorderlands.buildings.get(1).getId());
    }
}
