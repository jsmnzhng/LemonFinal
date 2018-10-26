package com.example.yeunjae.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StudyPage extends TestActivity  {

    EditText highlightSearch;
    Button button;
    TextView titleSource2;
    TextView textSource2;
    TextView textHighlighter;
    ImageView imageHighlighter;
    LinearLayout linearLayoutHighlighter;
    TextView textBook;
    ImageView imageBook;
    LinearLayout linearLayoutBook;
    TextView textVideo;
    ImageView imageVideo;
    LinearLayout linearLayoutVideo;
    LinearLayout allButtonsLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studyhome);

        //creating linearLayouts to make onClickListeners with images
        allButtonsLayout = (LinearLayout)findViewById(R.id.allButtonsLayout);
        Log.d(TAG, "onCreate: button layout created");

        textBook = (TextView)findViewById(R.id.textBook);
        imageBook = (ImageView)findViewById(R.id.imageBook);
        linearLayoutBook = (LinearLayout)findViewById(R.id.linearLayoutBook);

        linearLayoutBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyPage.this, FileViewer.class);
                startActivity(intent);
            }
        });
        textVideo = (TextView)findViewById(R.id.textVideo);
        imageVideo = (ImageView)findViewById(R.id.imageVideo);
        linearLayoutVideo = (LinearLayout)findViewById(R.id.linearLayoutVideo);

        linearLayoutVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyPage.this, YoutubeActivity.class);
                startActivity(intent);
            }
        });
        textHighlighter = (TextView)findViewById(R.id.textHighlighter);
        imageHighlighter = (ImageView)findViewById(R.id.imageHighlighter);
        linearLayoutHighlighter = (LinearLayout)findViewById(R.id.linearLayoutHighlighter);

        linearLayoutHighlighter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyPage.this, Highlighter.class);
                startActivity(intent);
            }
        });

        //Creating Navigation pane

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        final Intent intent;
        switch (item.getItemId()) {

            case R.id.nav_homepage:
                intent = new Intent(StudyPage.this, HomePage.class);
                startActivity(intent);
                break;

            case R.id.nav_test:
                intent = new Intent(StudyPage .this, TestActivity.class);
                startActivity(intent);
                break;

            case R.id.topic1:
                intent = new Intent(StudyPage.this, Topic1.class);
                startActivity(intent);
                break;

            case R.id.topic2:
                intent = new Intent(StudyPage.this, Topic2.class);
                startActivity(intent);
                break;

            case R.id.topic3:
                intent = new Intent(StudyPage.this, Topic3.class);
                startActivity(intent);
                break;

            case R.id.nav_video:
                intent = new Intent(StudyPage.this, YoutubeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_highlight:
                intent = new Intent(StudyPage.this, Highlighter.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }}




