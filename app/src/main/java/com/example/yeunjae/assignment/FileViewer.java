package com.example.yeunjae.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class FileViewer extends TestActivity {

    private Button topic1Button;
    private Button topic2Button, topic3Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_viewer);

        topic1Button = findViewById(R.id.topic1Button);
        topic2Button = findViewById(R.id.topic2Button);
        topic3Button = findViewById(R.id.topic3Button);

        //clicking button leads to new activity to view study notes
        topic1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FileViewer.this, Topic1.class);
                startActivity(intent); }
        });

        topic2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FileViewer.this, Topic2.class);
                startActivity(intent); }
        });

        topic3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FileViewer.this, Topic3.class);
                startActivity(intent); }
        });


    //Creating Navigation bar
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
                intent = new Intent(FileViewer.this, HomePage.class);
                startActivity(intent);
                break;

            case R.id.nav_test:
                intent = new Intent(FileViewer.this, TestActivity.class);
                startActivity(intent);
                break;

            case R.id.topic1:
                intent = new Intent(FileViewer.this, Topic1.class);
                startActivity(intent);
                break;

            case R.id.topic2:
                intent = new Intent(FileViewer.this, Topic2.class);
                startActivity(intent);
                break;

            case R.id.topic3:
                intent = new Intent(FileViewer.this, Topic3.class);
                startActivity(intent);
                break;

            case R.id.nav_video:
                intent = new Intent(FileViewer.this, YoutubeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_highlight:
                intent = new Intent(FileViewer.this, Highlighter.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }}









