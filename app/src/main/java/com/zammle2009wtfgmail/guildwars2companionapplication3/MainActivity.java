package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button milestone = (Button) findViewById(R.id.Milestone);
        final Button achievements = (Button) findViewById(R.id.Achievements);
        final Button blogs = (Button) findViewById(R.id.Blogs);
        final Button temp1 = (Button) findViewById(R.id.TempHolder1);
        final Button temp2 = (Button) findViewById(R.id.TempHolder2);


        milestone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milestone.setBackgroundResource(R.drawable.selected2);
                achievements.setBackgroundResource(R.drawable.lighterbackground);
                blogs.setBackgroundResource(R.drawable.lighterbackground);
                temp1.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.lighterbackground);
            }


        });

        achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milestone.setBackgroundResource(R.drawable.lighterbackground);
                achievements.setBackgroundResource(R.drawable.selected2);
                blogs.setBackgroundResource(R.drawable.lighterbackground);
                temp1.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.lighterbackground);
            }


        });

        blogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milestone.setBackgroundResource(R.drawable.lighterbackground);
                achievements.setBackgroundResource(R.drawable.lighterbackground);
                blogs.setBackgroundResource(R.drawable.selected2);
                temp1.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.lighterbackground);
            }


        });


        temp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milestone.setBackgroundResource(R.drawable.lighterbackground);
                achievements.setBackgroundResource(R.drawable.lighterbackground);
                blogs.setBackgroundResource(R.drawable.lighterbackground);
                temp1.setBackgroundResource(R.drawable.selected2);
                temp2.setBackgroundResource(R.drawable.lighterbackground);
            }


        });

        temp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milestone.setBackgroundResource(R.drawable.lighterbackground);
                achievements.setBackgroundResource(R.drawable.lighterbackground);
                blogs.setBackgroundResource(R.drawable.lighterbackground);
                temp1.setBackgroundResource(R.drawable.lighterbackground);
                temp2.setBackgroundResource(R.drawable.selected2);
            }


        });



        final Button companion = (Button) findViewById(R.id.companion);
        companion.setOnClickListener(new View.OnClickListener()
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


        final Button hero = (Button) findViewById(R.id.heroPanel);
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

        final Button forums = (Button) findViewById(R.id.forums);
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

        final Button WvW = (Button) findViewById(R.id.wvw);
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

        final Button more = (Button) findViewById(R.id.more);
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


        final ImageButton news1 = (ImageButton) findViewById(R.id.news1);
        news1.setOnClickListener(new View.OnClickListener()
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

        final ImageButton news2 = (ImageButton) findViewById(R.id.news2);
        news2.setOnClickListener(new View.OnClickListener()
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

        final ImageButton news3 = (ImageButton) findViewById(R.id.news3);
        news3.setOnClickListener(new View.OnClickListener()
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

        final ImageButton news4 = (ImageButton) findViewById(R.id.news4);
        news4.setOnClickListener(new View.OnClickListener()
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

        final ImageButton news5 = (ImageButton) findViewById(R.id.news5);
        news1.setOnClickListener(new View.OnClickListener()
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

        /** comments  more***/

    }}