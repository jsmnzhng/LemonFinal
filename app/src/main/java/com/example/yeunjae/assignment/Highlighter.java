package com.example.yeunjae.assignment;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.EditText;
import android.widget.TextView;

import com.xeoh.android.texthighlighter.TextHighlighter;

public class Highlighter extends TestActivity {

    EditText highlightSearch;
    Button button;
    TextView titleSource2;
    TextView textSource2;

  //text starts off as not highlighted
    boolean highlighted = false;

    TextHighlighter textHighlighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlight);

        highlightSearch = findViewById(R.id.highlightSearch);
        button = findViewById(R.id.button);
        textSource2 = findViewById(R.id.textSource2);
        titleSource2 = findViewById(R.id.titleSource2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //starts a new highlight query
            public void onClick(View v) {
                if(!highlighted){
                    textHighlighter = new TextHighlighter();

                            //highlights the text based on input
                            //below uses information provided by https://github.com/xeoh/TextHighlighter
                            textHighlighter.setBackgroundColor(Color.parseColor("#FFF9E28E"))
                            .addTarget(titleSource2)
                            .addTarget(textSource2)
                            .highlight(highlightSearch.getText().toString(), TextHighlighter.CASE_INSENSITIVE_MATCHER);

                            //changes button so the user can stop the highlight
                            button.setText("Stop highlighting");
                }
                else {
                    //stops the highlight
                    textHighlighter.setBackgroundColor(Color.TRANSPARENT)
                            .invalidate(TextHighlighter.CASE_INSENSITIVE_MATCHER);

                    //changes button so user can start highlighting
                    button.setText("Enter");
                }

                highlighted = !highlighted;
            }
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
                intent = new Intent(Highlighter.this, HomePage.class);
                startActivity(intent);
                break;

            case R.id.nav_test:
                intent = new Intent(Highlighter.this, TestActivity.class);
                startActivity(intent);
                break;

            case R.id.topic1:
                intent = new Intent(Highlighter.this, Topic1.class);
                startActivity(intent);
                break;

            case R.id.topic2:
                intent = new Intent(Highlighter.this, Topic2.class);
                startActivity(intent);
                break;

            case R.id.topic3:
                intent = new Intent(Highlighter.this, Topic3.class);
                startActivity(intent);
                break;

            case R.id.nav_video:
                intent = new Intent(Highlighter.this, YoutubeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_highlight:
                intent = new Intent(Highlighter.this, Highlighter.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }}








