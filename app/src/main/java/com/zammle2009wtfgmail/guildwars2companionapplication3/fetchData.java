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

public class fetchData extends AsyncTask<Void, Void, Void> {




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

            JSONObject JO =  new JSONObject(testPage.urls2);

            /**
            for(int i = 0; i < JA.length(); ++i)
            {
                JSONObject JO = (JSONObject) JA.get(i);


                DataParsed = DataParsed + SingleParsed;
            }
            **/

            int i = 0;




            SingleParsed = "Id:" + JO.get("id")  ;


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

        testPage.testpage.setText(SingleParsed);
    }
}
