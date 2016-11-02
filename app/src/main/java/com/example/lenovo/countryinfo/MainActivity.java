package com.example.lenovo.countryinfo;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static com.example.lenovo.countryinfo.R.mipmap.ic_launcher;

public class MainActivity extends FragmentActivity  {

    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    ArrayList<String> data;
    DrawerAdapter adapter;
    EditText dialog_text;
    TextView dialog_message;
    String code_id;
    View v;
    ViewPager viewpager;
    private SlidingUpPanelLayout mLayout;
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

       /* mDrawerToggle = new ActionBarDrawerToggle(
                this,                  *//* host Activity *//*
                mDrawerLayout,         *//* DrawerLayout object *//*
                R.drawable.ic_drawer,  *//* nav drawer icon to replace 'Up' caret *//*
                ic_launcher,  *//* "open drawer" description *//*
                R.string.drawer_close  *//* "close drawer" description *//*
        ) {

            *//** Called when a drawer has settled in a completely closed state. *//*
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
            }

            *//** Called when a drawer has settled in a completely open state. *//*
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);


*/


        viewpager = (ViewPager)findViewById(R.id.pager);
        PagerAdapter padapter = new PagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(padapter);

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
               // Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
               // Log.i(TAG, "onPanelStateChanged " + newState);
            }
        });
        mLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });



        mDrawerList = (ListView) findViewById(R.id.left_drawer);



        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mLayout.setEnabled(false);
        }
        data = new ArrayList<>();
        data.add("Name");
        data.add("Code");
        data.add("Language");
        data.add("Currency");
        // Set the adapter for the list view
        adapter = new DrawerAdapter(this, data);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                v = getLayoutInflater().inflate(R.layout.dialog_view, parent, false);

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("Search By");

                dialogBuilder.setView(v);

                dialog_message = (TextView) v.findViewById(R.id.textview_dialogbuilder);
                dialog_text = (EditText) v.findViewById(R.id.edittext_dialogbuilder);


                if (((String) parent.getAdapter().getItem(position)).compareTo("Name") == 0) {
                    dialog_message.setText("Country Name: ");
                    dialog_text.setHint("Ex France");
                    code_id = "name";
                } else if (((String) parent.getAdapter().getItem(position)).compareTo("Code") == 0) {
                    dialog_message.setText("Country Code: ");
                    dialog_text.setHint("(2-letter or 3-letter country code)");
                    code_id = "code";
                } else if (((String) parent.getAdapter().getItem(position)).compareTo("Currency") == 0) {
                    dialog_message.setText("Country Currency: ");
                    dialog_text.setHint("Ex NOR");
                    code_id = "currency";
                } else if (((String) parent.getAdapter().getItem(position)).compareTo("Language") == 0) {
                    dialog_message.setText("Country Language: ");
                    dialog_text.setHint("Ex et (ISO 639-1 Language Code)");
                    code_id = "language";

                } else if (((String) parent.getAdapter().getItem(position)).compareTo("Region") == 0) {
                    dialog_message.setText("Region Name: ");
                    dialog_text.setHint("Ex Africa");
                    code_id = "region";
                }
                // dialogBuilder.setMessage((String)parent.getAdapter().getItem(position));
                dialogBuilder.setPositiveButton("Find", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String CountryValue = String.valueOf(dialog_text.getText());
                        dialog.dismiss();

                        Intent i = new Intent();
                        i.setClass(MainActivity.this, CountryContentActivity.class);
                        i.putExtra("CountryValue", CountryValue);
                        i.putExtra("Code", code_id);
                        startActivity(i);

                    }
                });
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent();
                        i.setClass(MainActivity.this , MainActivity.class);
                        startActivity(i);
                    }
                });

                dialogBuilder.create().show();


            }

        });



    }

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "Double Tap back button to exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }

/*
    @Override
    public void regionClicked(String name) {
        Intent i = new Intent();
        i.putExtra("CountryValue",name);
        i.putExtra("IsRegion","Yes");
        i.setClass(this,CountryContentActivity.class);
    }
*/
}



