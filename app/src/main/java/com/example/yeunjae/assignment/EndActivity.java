package com.example.yeunjae.assignment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Map;

public class EndActivity extends TestActivity {

    private static final String TAG = "End Activity";


    private Button restartButton, studyButton;
    private TextView resultView, feedbackText, resultText, score;
    private ProgressBar progressBar;
    TestActivity test = new TestActivity();
    int i = test.getCounter();
    Map<String, String> ql = Card.buildQuestions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Intent intent = getIntent();
        int intValue = intent.getIntExtra("count", 0);
        double value = (double) intValue;
        double percent = ((value / ql.size()) * 100);
        int percentage = (int) percent;
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circle_progress);

        //Progress bar that displays results
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(percentage);
        progressBar.setSecondaryProgress(100);
        progressBar.setMax(100);
        progressBar.setProgressDrawable(drawable);

        score = findViewById(R.id.score);
        score.setText(percentage + "%");

        //Setting score results based on number of correct answers
        resultText = findViewById(R.id.resultText);//       resultText2 = (TextView) findViewById(R.id.resultText2);
        resultView = findViewById(R.id.resultView);

        resultText.setText("You got: ");
        resultView.setText("That's " + intValue + "/" + ql.size() + " correct");

        //displaying feedback message based on score percentage
        feedbackText = findViewById(R.id.feedbackText);
        if (0 <= percentage && percentage <= 49) {

            feedbackText.setText("You failed. Revise the study material and try again!");
        } else if (50 <= percentage && percentage <= 74) {

            feedbackText.setText("You did alright, but you could do better. " +
                    "Read over the study notes again and make sure you understand the content.");
        } else if (75 <= percentage && percentage <= 90) {

            feedbackText.setText("Good job! Revise the study material again to get" +
                    " 100% next time!");
        } else if (100 == percentage) {

            feedbackText.setText("Well done, you got 100%! You should still go over the study material" +
                    " to make sure you understand everything.");
        }

        //initialising restart quiz
        restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EndActivity.this, TestActivity.class);
                startActivity(intent);
            }

        });

        //redirecting to study home page
        studyButton = findViewById(R.id.studyButton);
        studyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EndActivity.this, StudyPage.class);
                startActivity(intent);
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
                intent = new Intent(EndActivity.this, HomePage.class);
                startActivity(intent);
                break;

            case R.id.nav_test:
                intent = new Intent(EndActivity.this, TestActivity.class);
                startActivity(intent);
                break;

            case R.id.topic1:
                intent = new Intent(EndActivity.this, Topic1.class);
                startActivity(intent);
                break;

            case R.id.topic2:
                intent = new Intent(EndActivity.this, Topic2.class);
                startActivity(intent);
                break;

            case R.id.topic3:
                intent = new Intent(EndActivity.this, Topic3.class);
                startActivity(intent);
                break;

            case R.id.nav_video:
                intent = new Intent(EndActivity.this, YoutubeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_highlight:
                intent = new Intent(EndActivity.this, Highlighter.class);
                startActivity(intent);
                break;
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }}






