package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class heroPanels extends AppCompatActivity {


    static int heroCompleted = 0;

    static ArrayList <itemHolder> Holder = new ArrayList <>();
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

    private RelativeLayout gearlayout;

    private Handler handler = new Handler();


    static itemAdapter mWeaponAdapter;
    private itemAdapter mArmorAdapter;
    private itemAdapter mTrinketAdapter;
    private itemAdapter mAquaAdapter;
    private itemAdapter mGatherAdapter;


    static String urls2="";
    static String urls3="";

    static int selectedCharacter = 0;

    JSONArray characters;
    JSONObject characterInfo;
    static ArrayList <String> names = new ArrayList <>();
    static characterInfo currentCharacter = new characterInfo();




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

        final Button alterView = (Button) findViewById(R.id.altericon);
        final Button defaultView = (Button) findViewById(R.id.defaulticon);
        final TextView layoutGear = (Button) findViewById(R.id.textGearLayout);
        final LinearLayout horizontalGear = (LinearLayout) findViewById(R.id.horizontal);
        final LinearLayout verticalGear = (LinearLayout) findViewById(R.id.vertical);

        gearlayout = (RelativeLayout) findViewById(R.id.gearlayout);

        alterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                horizontalGear.setVisibility(View.INVISIBLE);
                verticalGear.setVisibility(View.VISIBLE);
                layoutGear.setText("Layout: Vertical");
                defaultView.setBackgroundResource(R.drawable.defaultlayouticon2);
                alterView.setBackgroundResource(R.drawable.alterlayouticon1);
            }


        });

        defaultView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                horizontalGear.setVisibility(View.VISIBLE);
                verticalGear.setVisibility(View.INVISIBLE);
                layoutGear.setText("Layout: Horizontal");
                defaultView.setBackgroundResource(R.drawable.defaultlayouticon1);
                alterView.setBackgroundResource(R.drawable.alterlayouticon2);
            }


        });

        gear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gear.setBackgroundResource(R.drawable.selectedheropanel);
                traits.setBackgroundResource(R.drawable.grayblackcolor);
                general.setBackgroundResource(R.drawable.grayblackcolor);
                inventory.setBackgroundResource(R.drawable.grayblackcolor);
                temp2.setBackgroundResource(R.drawable.grayblackcolor);

                gearlayout.setVisibility(View.VISIBLE);


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

                gearlayout.setVisibility(View.INVISIBLE);

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

                gearlayout.setVisibility(View.INVISIBLE);

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

                gearlayout.setVisibility(View.INVISIBLE);

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

                gearlayout.setVisibility(View.INVISIBLE);

                gear.setTextColor(Color.parseColor("#A0A0A0"));
                traits.setTextColor(Color.parseColor("#A0A0A0"));
                general.setTextColor(Color.parseColor("#A0A0A0"));
                inventory.setTextColor(Color.parseColor("#A0A0A0"));
                temp2.setTextColor(Color.parseColor("#FFFFFF"));
            }


        });


        final Button companion = (Button) findViewById(R.id.companion1);
        companion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent history = new Intent(heroPanels.this, MainActivity.class);
                startActivity(history);

            }

        });


        final Button hero = (Button) findViewById(R.id.heroPanel1);
        hero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 Intent history = new Intent (MainActivity.this, History.class );
                 startActivity(history);
                 **/
            }

        });

        final Button forums = (Button) findViewById(R.id.forums1);
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 Intent history = new Intent (MainActivity.this, History.class );
                 startActivity(history);
                 **/
            }

        });

        final Button WvW = (Button) findViewById(R.id.wvw1);
        WvW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent history = new Intent(heroPanels.this, worldVsWorld.class);
                startActivity(history);

            }

        });

        final Button more = (Button) findViewById(R.id.more1);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


        for (int i = 0; i < 4; i = ++i) {





            Drawable infusion1;
            Drawable infusion2;
            Drawable infusion3;
            try {


                Drawable draw = getDrawable(R.drawable.testinfusion);

                        String itemName = "YOU PASSED";
                        String itemType = "YOU PASSED";
                        Holder.add(new itemHolder(draw, itemName, itemType));








            } catch (Exception e) {
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

        //////////////////////////////////////////////////////////////
        ///////////////// JSONS for GEAR ////////////////////////////
        ////////////////////////////////////////////////////////////








        ////////////////////////////////////////////////////////////////////////
        /////////////// start of for loop /////////////////////////////////////
        ////////////// flooding with info /////////////////////////////////////
        //////////////////////////////////////////////////////////////////////

        /*

        for (int i = 0; i < Holder.size(); ++i) {

            final ImageView imageView = new ImageView(getApplicationContext());

            imageView.setImageDrawable(getResources().getDrawable(R.drawable.red));

            //     .load("https://render.guildwars2.com/file/D5A5A4083E97C4EF0226315226E610C01DEE2248/1423739.png")

            Drawable draw = imageView.getDrawable();
            Holder.get(i).setItemIcon(draw);

            final int pos = i;

            Picasso.with(this)
                    .load("https://render.guildwars2.com/file/D5A5A4083E97C4EF0226315226E610C01DEE2248/1423739.png")
                    .into(imageView, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {
                            Drawable draw = imageView.getDrawable();
                            Holder.get(pos).setItemIcon(draw);
                            mWeaponAdapter.notifyItemChanged(pos);




                        }

                        @Override
                        public void onError() {
                            Holder.get(pos).setItemIcon(getResources().getDrawable(R.drawable.xerror));
                            mWeaponAdapter.notifyItemChanged(pos);
                        }
                    });

        }
        */


        ///////////////////////////////////////////////////////////
        ///////////// start of copy //////////////////////
        ////////////////////////////////////////////

        new Thread(new Runnable(){

            public void run(){



                //TextView t; //to show the result, please declare and find it inside onCreate()




                try {
                    // Create a URL for the desired page

                    String linkAPI =ApiResources.charactersAPI + ApiResources.token + ApiResources.accountAPI;

                    URL url = new URL(linkAPI); //My text file location
                    //First open the connection
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(60000); // timing out in a minute

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()


                    urls2 = "";

                    String str;
                    while ((str = in.readLine()) != null) {
                        urls2 = urls2 + str;
                    }

                    characters = new JSONArray(urls2);

                    in.close();
                } catch (Exception e) {
                    Log.d("MyTag", e.toString());
                }


                //since we are in background thread, to post results we have to go back to ui thread. do the following for that

                heroPanels.this.runOnUiThread(new Runnable(){
                    public void run()
                    {



                        for (int i = 0; i < characters.length(); ++i) {
                            try {
                                names.add(characters.get(i).toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }






                        // part 2


                        ////////////////////////////////////////////////////
                        ///////////// selected character info //////////////
                        ////////////////////////////////////////////////////




                        new Thread(new Runnable(){

                            public void run(){



                                //TextView t; //to show the result, please declare and find it inside onCreate()




                                try {
                                    // Create a URL for the desired page

                                    String delimterName = names.get(selectedCharacter).replace(" ", "%20");

                                    String linkAPI = ApiResources.charactersAPI + "/" + delimterName + ApiResources.token + ApiResources.accountAPI;

                                    URL url = new URL(linkAPI); //My text file location
                                    //First open the connection
                                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                    conn.setConnectTimeout(60000); // timing out in a minute

                                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                                    //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()


                                    urls3 = "";

                                    String str;
                                    while ((str = in.readLine()) != null) {
                                        urls3 = urls3 + str;
                                    }

                                    characterInfo = new JSONObject(urls3);

                                    in.close();
                                } catch (Exception e) {
                                    Log.d("MyTag", e.toString());
                                }


                                //since we are in background thread, to post results we have to go back to ui thread. do the following for that

                                heroPanels.this.runOnUiThread(new Runnable(){
                                    public void run()
                                    {

                                        try {
                                            currentCharacter.name_ = "" + characterInfo.get("name");
                                            currentCharacter.race = "" + characterInfo.get("race");
                                            currentCharacter.gender = "" + characterInfo.get("gender");
                                            currentCharacter.profession = "" + characterInfo.get("profession");
                                            currentCharacter.guild = "" + characterInfo.get("guild");
                                            currentCharacter.age = "" + characterInfo.get("age");
                                            currentCharacter.created = "" + characterInfo.get("created");
                                            currentCharacter.deaths = "" + characterInfo.get("deaths");
                                            currentCharacter.level = "" + characterInfo.get("level");


                                            JSONArray crafting = characterInfo.getJSONArray("crafting");
                                            for (int i = 0; i < crafting.length(); ++i)
                                            {
                                                JSONObject source = (JSONObject) crafting.get(i);

                                                Crafting temp = new Crafting();
                                                temp.active = "" + source.get("active");
                                                temp.discipline = "" + source.get("discipline");
                                                temp.rating = "" + source.get("rating");

                                                currentCharacter.crafting.add(temp);

                                            }


                                            JSONObject specialization = characterInfo.getJSONObject("specializations");
                                            JSONArray PVE = specialization.getJSONArray("pve");
                                            for (int i = 0; i < PVE.length(); ++i)
                                            {
                                                JSONObject source = (JSONObject) PVE.get(i);

                                                Traits temp = new Traits();
                                                temp.id_ = "" + source.get("id");

                                                JSONArray traitLine = source.getJSONArray("traits");

                                                for (int x = 0; x < traitLine.length(); ++x)
                                                {
                                                    temp.traits_[x] = "" + traitLine.get(x).toString();
                                                }

                                                currentCharacter.specialization.pve_.add(temp);

                                            }


                                            JSONArray PVP = specialization.getJSONArray("pvp");
                                            for (int i = 0; i < PVP.length(); ++i)
                                            {
                                                JSONObject source = (JSONObject) PVP.get(i);

                                                Traits temp = new Traits();
                                                temp.id_ = "" + source.get("id");

                                                JSONArray traitLine = source.getJSONArray("traits");

                                                for (int x = 0; x < traitLine.length(); ++x)
                                                {
                                                    temp.traits_[x] = "" + traitLine.get(x).toString();
                                                }

                                                currentCharacter.specialization.pvp_.add(temp);

                                            }

                                            JSONArray WVW = specialization.getJSONArray("wvw");
                                            for (int i = 0; i < WVW.length(); ++i)
                                            {
                                                JSONObject source = (JSONObject) WVW.get(i);

                                                Traits temp = new Traits();
                                                temp.id_ = "" + source.get("id");

                                                JSONArray traitLine = source.getJSONArray("traits");

                                                for (int x = 0; x < traitLine.length(); ++x)
                                                {
                                                    temp.traits_[x] = "" + traitLine.get(x).toString();
                                                }

                                                currentCharacter.specialization.wvw_.add(temp);

                                            }



                                            // start of complicated items


                                            //////////////////////////////
                                            //// complicated items!!! ////
                                            //////////////////////////////

                                            JSONArray equipment = characterInfo.getJSONArray("equipment");
                                            for (int i = 0; i < equipment.length(); ++i)
                                            {
                                                JSONObject source = (JSONObject) equipment.get(i);

                                                final itemInfo tempItem = new itemInfo();




                                               // new Thread(new heroPanels.itemRunnable(i,source){}).start();
                                            }

                                            // end of complicated items


                                            //  String delimterName = names.get(selectedCharacter).replace(" ", "%20");
                                            //   testView.setText(currentCharacter.specialization.wvw_.get(0).traits_[1]);

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }


                                    }




                                });



                            }


                        }).start();

                        // end of part 2




                    }




                });



            }


        }).start();


    }
    public class itemRunnable implements Runnable
    {



        public int position;
        public JSONObject JSON;
        public JSONObject Linker;


        public itemRunnable(int _pos, JSONObject js)
        {

            this.position = _pos;
            this.JSON = js;



        }

        @Override
        public void run(){



            //TextView t; //to show the result, please declare and find it inside onCreate()


            itemInfo tempItem = new itemInfo();
            try
            {
                tempItem.id_ = "" + JSON.get("id");
                tempItem.type_ = "" + JSON.get("slot");
                try {
                    tempItem.skin = "" + JSON.get("skin");
                }
                catch (Exception e)
                {

                }


                try {
                    JSONArray infusion = JSON.getJSONArray("infusions");
                    for (int i = 0; i < infusion.length(); ++i) {

                        String temp = "" + infusion.get(i);

                        tempItem.infusions.add(temp);

                    }
                }
                catch (Exception e)
                {}

                try {
                    JSONArray upgrades = JSON.getJSONArray("upgrades");
                    for (int i = 0; i < upgrades.length(); ++i) {
                        String temp = "" + upgrades.get(i);

                        tempItem.upgrades.add(temp);

                    }
                }
                catch (Exception e)
                {}




                currentCharacter.equipment.add(tempItem);




            }catch (Exception e)
            {

            }



            try {
                // Create a URL for the desired page




                URL url = new URL(ApiResources.itemAPI + tempItem.id_); //My text file location
                //First open the connection
                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(60000); // timing out in a minute

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()


                String tempURL = "";

                String str;
                while ((str = in.readLine()) != null) {
                    tempURL = tempURL + str;
                }

                Linker =  new JSONObject(tempURL);

                in.close();
            } catch (Exception e) {
                Log.d("MyTag",e.toString());
            }



            //since we are in background thread, to post results we have to go back to ui thread. do the following for that

            heroPanels.this.runOnUiThread(new Runnable(){
                public void run()
                {

                    testPage.testView.setText(currentCharacter.equipment.get(position).id_);
                    try {

                        final ImageView imageView = new ImageView(getApplicationContext());
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.red));
                        Drawable draw = imageView.getDrawable();
                        Holder.get(position).setItemIcon(draw);



                        currentCharacter.name_ ="" + Linker.get("name");

                        String itemPNG = "" + Linker.get("icon");

                        Picasso.with(heroPanels.this)
                                .load(itemPNG)
                                .into(imageView, new com.squareup.picasso.Callback() {
                                    @Override
                                    public void onSuccess() {

                                        Drawable draw = imageView.getDrawable();
                                        Holder.get(position).setItemIcon(draw);
                                        mWeaponAdapter.notifyItemChanged(position);



                                    }

                                    @Override
                                    public void onError() {
                                        Holder.get(position).setItemIcon(getResources().getDrawable(R.drawable.xerror));
                                        mWeaponAdapter.notifyItemChanged(position);
                                    }
                                });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }




            });


        }






    }



}



