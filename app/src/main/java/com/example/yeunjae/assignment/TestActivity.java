package com.example.yeunjae.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static android.content.ContentValues.TAG;

public class TestActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "Test Activity";

    private TextView questionText;
    private TextView answerText;
    private Button incorrectButton;
    private Button correctButton;
    private int i=1;
    private int counter =0;
    private int percentage = 0;

    //Calling hashmap from the Card class
    Map<String, String> ql = Card.buildQuestions();

    public int getCounter() {
        return counter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialising an array of keys (questions)
        Set<String> keySet = ql.keySet();
        final ArrayList<String> questionList = new ArrayList<String>(keySet);

        //initialising an array of values (answers)
        Collection<String> values = ql.values();
        final ArrayList<String> listOfValues = new ArrayList<String>(values);

//        dbHandler = new DBHandler(this, null, null, 1);
        questionText = findViewById(R.id.questionText);
        questionText.setText(questionList.get(0));

        //initialising action for clicking on the 'incorrect' button
        incorrectButton = findViewById(R.id.incorrectButton);
        incorrectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerText.setText("Tap to reveal answer");
                percentage = ((counter / ql.size()) * 100);

                //calling arrayList to set the next question
                if (i < questionList.size() - 1) {

                    questionText.setText(questionList.get(i++));

                } else if (i <= questionList.size() - 1) {

                    questionText.setText(questionList.get(i++));

                //for last question in array, change button text and open up end activity
                } else if (i == questionList.size()) {

                            incorrectButton.setText("End");
                            incorrectButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(TestActivity.this, EndActivity.class);
                                    intent.putExtra("count", counter);
                                    intent.putExtra("percent", percentage);
                                    startActivity(intent);
                                }
            });}}});

        //initialising action for clicking on the 'correct' button
        correctButton = findViewById(R.id.correctButton);
        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerText.setText("Tap to reveal answer");
                counter++;

                if (i < questionList.size() - 1) {

                    questionText.setText(questionList.get(i++));

            } else if (i <= questionList.size() - 1) {

                questionText.setText(questionList.get(i++));}

             else if (i == questionList.size()){

                correctButton.setText("End");
                correctButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(TestActivity.this, EndActivity.class);
                        intent.putExtra("count", counter);
                        intent.putExtra("percent", percentage);
                        startActivity(intent);
                    }
                });}}});

        //Click on card to reveal answer
        answerText = findViewById(R.id.answerText);
        answerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerText.setText(listOfValues.get(i-1));

            }
        });

        //Navigation Bar

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
                intent = new Intent(TestActivity.this, HomePage.class);
                startActivity(intent);
                break;

            case R.id.nav_test:
                intent = new Intent(TestActivity.this, TestActivity.class);
                startActivity(intent);
                break;

            case R.id.topic1:
                intent = new Intent(TestActivity.this, Topic1.class);
                startActivity(intent);
                break;

            case R.id.topic2:
                intent = new Intent(TestActivity.this, Topic2.class);
                startActivity(intent);
                break;

            case R.id.topic3:
                intent = new Intent(TestActivity.this, Topic3.class);
                startActivity(intent);
                break;


            case R.id.nav_video:
                intent = new Intent(TestActivity.this, YoutubeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_highlight:
                intent = new Intent(TestActivity.this, Highlighter.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }}

