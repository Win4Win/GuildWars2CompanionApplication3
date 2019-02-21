package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class heroPanels extends AppCompatActivity {



    static ArrayList<itemHolder> Holder = new ArrayList<>();
    private RecyclerView mWeapon;
    private RecyclerView mArmor;
    private RecyclerView mTrinket;
    private RecyclerView mAqua;
    private RecyclerView mGather;

    private RecyclerView.LayoutManager weaponLayout;
    private RecyclerView.LayoutManager armorLayout;
    private RecyclerView.LayoutManager trinketLayout;
    private RecyclerView.LayoutManager aquaLayout;
    private RecyclerView.LayoutManager gatherLayout;



    private itemAdapter mWeaponAdapter;
    private itemAdapter mArmorAdapter;
    private itemAdapter mTrinketAdapter;
    private itemAdapter mAquaAdapter;
    private itemAdapter mGatherAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heropanel);


        MainActivity.selectedLayout = 1;

        final TextView t = (TextView) findViewById(R.id.YourName);
        t.setText(MainActivity.name_[1]); // My TextFile has 3 lines


        final Button gear = (Button) findViewById(R.id.gear);
        final Button traits = (Button) findViewById(R.id.traits);
        final Button general = (Button) findViewById(R.id.general);
        final Button inventory = (Button) findViewById(R.id.inventory);
        final Button temp2 = (Button) findViewById(R.id.tempholder3);


        gear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gear.setBackgroundResource(R.drawable.selectedheropanel);
                traits.setBackgroundResource(R.drawable.grayblackcolor);
                general.setBackgroundResource(R.drawable.grayblackcolor);
                inventory.setBackgroundResource(R.drawable.grayblackcolor);
                temp2.setBackgroundResource(R.drawable.grayblackcolor);


                gear.setTextColor(Color.parseColor("#FFFFFF"));
                traits.setTextColor(Color.parseColor("#A0A0A0"));
                general.setTextColor(Color.parseColor("#A0A0A0"));
                inventory.setTextColor(Color.parseColor("#A0A0A0"));
                temp2.setTextColor(Color.parseColor("#A0A0A0"));
            }


        });

        traits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gear.setBackgroundResource(R.drawable.grayblackcolor);
                traits.setBackgroundResource(R.drawable.selectedheropanel);
                general.setBackgroundResource(R.drawable.grayblackcolor);
                inventory.setBackgroundResource(R.drawable.grayblackcolor);
                temp2.setBackgroundResource(R.drawable.grayblackcolor);

                gear.setTextColor(Color.parseColor("#A0A0A0"));
                traits.setTextColor(Color.parseColor("#FFFFFF"));
                general.setTextColor(Color.parseColor("#A0A0A0"));
                inventory.setTextColor(Color.parseColor("#A0A0A0"));
                temp2.setTextColor(Color.parseColor("#A0A0A0"));
            }


        });

        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gear.setBackgroundResource(R.drawable.grayblackcolor);
                traits.setBackgroundResource(R.drawable.grayblackcolor);
                general.setBackgroundResource(R.drawable.selectedheropanel);
                inventory.setBackgroundResource(R.drawable.grayblackcolor);
                temp2.setBackgroundResource(R.drawable.grayblackcolor);

                gear.setTextColor(Color.parseColor("#A0A0A0"));
                traits.setTextColor(Color.parseColor("#A0A0A0"));
                general.setTextColor(Color.parseColor("#FFFFFF"));
                inventory.setTextColor(Color.parseColor("#A0A0A0"));
                temp2.setTextColor(Color.parseColor("#A0A0A0"));
            }


        });


        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gear.setBackgroundResource(R.drawable.grayblackcolor);
                traits.setBackgroundResource(R.drawable.grayblackcolor);
                general.setBackgroundResource(R.drawable.grayblackcolor);
                inventory.setBackgroundResource(R.drawable.selectedheropanel);
                temp2.setBackgroundResource(R.drawable.grayblackcolor);

                gear.setTextColor(Color.parseColor("#A0A0A0"));
                traits.setTextColor(Color.parseColor("#A0A0A0"));
                general.setTextColor(Color.parseColor("#A0A0A0"));
                inventory.setTextColor(Color.parseColor("#FFFFFF"));
                temp2.setTextColor(Color.parseColor("#A0A0A0"));
            }


        });

        temp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gear.setBackgroundResource(R.drawable.grayblackcolor);
                traits.setBackgroundResource(R.drawable.grayblackcolor);
                general.setBackgroundResource(R.drawable.grayblackcolor);
                inventory.setBackgroundResource(R.drawable.grayblackcolor);
                temp2.setBackgroundResource(R.drawable.selectedheropanel);


                gear.setTextColor(Color.parseColor("#A0A0A0"));
                traits.setTextColor(Color.parseColor("#A0A0A0"));
                general.setTextColor(Color.parseColor("#A0A0A0"));
                inventory.setTextColor(Color.parseColor("#A0A0A0"));
                temp2.setTextColor(Color.parseColor("#FFFFFF"));
            }


        });




        final Button companion = (Button) findViewById(R.id.companion1);
        companion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                 Intent history = new Intent (heroPanels.this, MainActivity.class );
                 startActivity(history);

            }

        });


        final Button hero = (Button) findViewById(R.id.heroPanel1);
        hero.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /**
                 Intent history = new Intent (MainActivity.this, History.class );
                 startActivity(history);
                 **/
            }

        });

        final Button forums = (Button) findViewById(R.id.forums1);
        forums.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /**
                 Intent history = new Intent (MainActivity.this, History.class );
                 startActivity(history);
                 **/
            }

        });

        final Button WvW = (Button) findViewById(R.id.wvw1);
        WvW.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                 Intent history = new Intent (heroPanels.this, worldVsWorld.class );
                 startActivity(history);

            }

        });

        final Button more = (Button) findViewById(R.id.more1);
        more.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /**
                 Intent history = new Intent (MainActivity.this, History.class );
                 startActivity(history);
                 **/
            }

        });



        /////////////////////////////////////
        /////// SETTING UP ADAPTES //////////
        /////////////////////////////////////

        Holder.clear();




        for (int i = 0; i < 4; i = ++i)
        {


                String itemName = "ItemNameLOL";
                String itemType = "ItemTypeLOL";

                Drawable item;
                Drawable infusion1;
                Drawable infusion2;
                Drawable infusion3;


                try
                {
                    item.
                }

                try {

                    Drawable icon = getPackageManager().getApplicationIcon(TextWithInfo[i+3]);



                        Holder.add(new itemHolder(icon,appName, bool, Time, true,PackageName));

                }
                catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();



                }

        }






        LinearLayoutManager layoutManager = new LinearLayoutManager(this);



        mWeapon = findViewById(R.id.weaponrecycle);
        mWeapon.setHasFixedSize(true);
        weaponLayout = new LinearLayoutManager(this);
        mWeaponAdapter = new itemAdapter(Holder);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mWeapon.getContext(), layoutManager.getOrientation());

        mWeapon.addItemDecoration(dividerItemDecoration);


        mWeapon.setLayoutManager(weaponLayout);
        mWeapon.setAdapter(mWeaponAdapter);











    }}






