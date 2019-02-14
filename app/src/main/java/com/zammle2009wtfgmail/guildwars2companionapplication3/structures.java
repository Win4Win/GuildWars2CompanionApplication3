package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.widget.ImageView;

import java.util.ArrayList;

public class structures
{
        String id = "";
        String type = "";
        String owner = "";
        String last_flipped = "";
        String points_tick = "";
        String points_capture = "";
        String claimed_by = "";
        String yaks_delivered = "";
        boolean notSpawn = true;
        public ImageView color;

        public ArrayList<String> guild_upgrades = new ArrayList <>();


        void setId (String id_)
        {
            id = id_;
        }
        void setType (String type_)
        {
            type = type_;
        }


        String getId ()
        {
            return id;
        }
        String getType()
        {
            return type;
        }



///////// future functions ////////////
        boolean setTime (String time)
        {
            return false;
        }








}
