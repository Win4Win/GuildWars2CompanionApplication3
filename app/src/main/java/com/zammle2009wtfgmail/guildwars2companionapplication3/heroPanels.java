package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class heroPanels extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heropanel);




        final Button gear = (Button) findViewById(R.id.gear);
        final Button traits = (Button) findViewById(R.id.traits);
        final Button general = (Button) findViewById(R.id.general);
        final Button inventory = (Button) findViewById(R.id.inventory);
        final Button temp2 = (Button) findViewById(R.id.tempholder3);


        gear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gear.setBackgroundResource(R.drawable.selected2);
                traits.setBackgroundResource(R.drawable.lighterbackground);
                general.setBackgroundResource(R.drawable.lighterbackground);
                inventory.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.lighterbackground);


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
                gear.setBackgroundResource(R.drawable.lighterbackground);
                traits.setBackgroundResource(R.drawable.selected2);
                general.setBackgroundResource(R.drawable.lighterbackground);
                inventory.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.lighterbackground);

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
                gear.setBackgroundResource(R.drawable.lighterbackground);
                traits.setBackgroundResource(R.drawable.lighterbackground);
                general.setBackgroundResource(R.drawable.selected2);
                inventory.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.lighterbackground);

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
                gear.setBackgroundResource(R.drawable.lighterbackground);
                traits.setBackgroundResource(R.drawable.lighterbackground);
                general.setBackgroundResource(R.drawable.lighterbackground);
                inventory.setBackgroundResource(R.drawable.selected2);
                temp2.setBackgroundResource(R.drawable.lighterbackground);

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
                gear.setBackgroundResource(R.drawable.lighterbackground);
                traits.setBackgroundResource(R.drawable.lighterbackground);
                general.setBackgroundResource(R.drawable.lighterbackground);
                inventory.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.selected2);


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
                /**
                 Intent history = new Intent (MainActivity.this, History.class );
                 startActivity(history);
                 **/
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




    }}
