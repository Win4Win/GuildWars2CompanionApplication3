package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class itemHolder
{
    private   Drawable itemIcon;
    public   String itemName;
    public  String itemType;
  //  private final ImageView infusion1Icon;
  //  private final ImageView infusion2Icon;
   // private final ImageView infusion3Icon;










    public itemHolder( Drawable adraw, String aitemname, String aitemtype)
    {

        this.itemIcon = adraw;
        this.itemName = aitemname;
        this.itemType = aitemtype;
      //  this.infusion1Icon = ainfusion1;
      //  this.infusion2Icon = ainfusion2;
      //  this.infusion3Icon = ainfusion3;






    }

    public String GetItemName() {return itemName;}

    public String getItemType() {return itemType;}

    public Drawable getItemIcon() {return itemIcon;}
    public void setItemIcon(Drawable im) {this.itemIcon = im;}








}