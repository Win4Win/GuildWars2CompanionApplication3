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
        void setOwner (String owner_)
        {
            owner = owner_;
        }
        void setLast_flipped (String last_flipped_)
        {
            last_flipped = last_flipped_;
        }
        void setPoints_tick (String points_tick_)
        {
            points_tick = points_tick_;
        }
        void setPoints_capture (String points_capture_)
        {
            points_capture = points_capture;
        }
        void setClaimed_by(String claimed_by_)
        {
            claimed_by = claimed_by_;
        }
        void setYaks_delivered(String yaks_delivered_)
        {
            yaks_delivered = yaks_delivered_;
        }


        String getId ()
        {
            return id;
        }
        String getType()
        {
            return type;
        }
        String getOwner()
        {
            return owner;
        }
        String getLast_flipped()
        {
            return last_flipped;
        }
        String getPoints_tick()
        {
            return points_tick;
        }
        String getPoints_capture()
        {
            return points_capture;
        }
        String getClaimed_by()
        {
            return claimed_by;
        }
        String getYaks_delivered()
        {
            return yaks_delivered;
        }



        boolean setTime (String time)
        {
            return false;
        }








}
