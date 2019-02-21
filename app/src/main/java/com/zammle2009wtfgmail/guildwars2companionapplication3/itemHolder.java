package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.graphics.drawable.Drawable;
public class itemHolder
{
    private final Drawable itemIcon;
    private final String itemName;
    private final String itemType;
    private final Drawable infusion1Icon;
    private final Drawable infusion2Icon;
    private final Drawable infusion3Icon;









    public itemHolder(Drawable aitemicon, String aitemname, String aitemtype, Drawable ainfusion1, Drawable ainfusion2, Drawable ainfusion3)
    {

        this.itemIcon = aitemicon;
        this.itemName = aitemname;
        this.itemType = aitemtype;
        this.infusion1Icon = ainfusion1;
        this.infusion2Icon = ainfusion2;
        this.infusion3Icon = ainfusion3;






    }

    public String GetItemName() {return itemName;}

    public String getItemType() {return itemType;}


    public Drawable getInfusion1Icon()
    {
        return infusion1Icon;
    }
    public Drawable getInfusion2Icon()
    {
        return infusion2Icon;
    }
    public Drawable getInfusion3Icon()
    {
        return infusion3Icon;
    }


    public Drawable GetItemIcon() {return itemIcon;}





}
