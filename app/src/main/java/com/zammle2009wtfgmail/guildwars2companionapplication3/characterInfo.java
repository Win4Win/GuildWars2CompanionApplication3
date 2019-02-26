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




























}

class Crafting
{
    public String discipline = "";
    public String rating = "";
    public String active = "";

}

class Specialization
{

    public ArrayList<Traits> pve_ = new ArrayList <>();
    public ArrayList<Traits> pvp_ = new ArrayList <>();
    public ArrayList<Traits> wvw_ = new ArrayList <>();







}

class Traits
{
    public String id_ = "";
    public String[] traits_ = new String[3];
}