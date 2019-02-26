package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class itemInfo
{
    public String id_ = "";
    public String type_ = "";
    public ArrayList<String> upgrades = new ArrayList <>();
    public ArrayList<String> infusions = new ArrayList <>();
    public Stats stats = new Stats();
    public String binding = "";
    public Drawable itemImage = new ColorDrawable(Color.TRANSPARENT);





    private class Stats {

        public String id_ = "";
        public String power = "0";
        public String precision = "0";
        public String toughness = "0";
        public String vitality = "0";
        public String concentration = "0";
        public String condition_damage = "0";
        public String expertise = "0";
        public String ferocity = "0";
        public String healing_power = "0";

    }

}
