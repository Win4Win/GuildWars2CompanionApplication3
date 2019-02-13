package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class worldVsWorld extends AppCompatActivity {



    static borderlands Center = new borderlands();
    static borderlands redBorderlands = new borderlands();
    static borderlands blueBorderlands = new borderlands();
    static borderlands greenBorderlands = new borderlands();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.world_vs_world);
        {










            final Button companion = (Button) findViewById(R.id.companion2);
            companion.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                    Intent history = new Intent (worldVsWorld.this, MainActivity.class );
                    startActivity(history);

                }

            });


            final Button hero = (Button) findViewById(R.id.heroPanel2);
            hero.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                     Intent history = new Intent (worldVsWorld.this, heroPanels.class );
                     startActivity(history);

                }

            });

            final Button forums = (Button) findViewById(R.id.forums2);
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

            final Button WvW = (Button) findViewById(R.id.wvw2);
            WvW.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                    /**
                    Intent history = new Intent (heroPanels.this, worldVsWorld.class );
                    startActivity(history);
                     **/

                }

            });

            final Button more = (Button) findViewById(R.id.more2);
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
        }


    }}

