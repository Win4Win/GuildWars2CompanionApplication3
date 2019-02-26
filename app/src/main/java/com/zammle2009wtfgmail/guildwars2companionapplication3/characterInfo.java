package com.zammle2009wtfgmail.guildwars2companionapplication3;

import java.util.ArrayList;

public class characterInfo
{
    public String name_ = "";
    public String race = "";
    public String gender = "";
    public String profession = "";
    public String level = "";
    public String guild = "";
    public String age = "";
    public String created = "";
    public String deaths = "";
    public ArrayList<Crafting> crafting = new ArrayList <>();
    public Specialization specialization = new Specialization();
    public ArrayList<itemInfo> equipment = new ArrayList <>();






















    private class Crafting
    {
        public String discipline = "";
        public String rating = "";
        public String active = "";

    }

    private class Specialization
    {

        public Traits pve_ = new Traits();
        public Traits pvp_ = new Traits();
        public Traits wvw_ = new Traits();





        private class Traits
        {
            public String id_ = "";
            public String[] traits_ = new String[3];
        }
    }





}
