package com.example.yeunjae.assignment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class HomePage extends AppCompatActivity {

    private static final String TAG = "HomePage";

    private Button studyButton;
    private Button testButton, beginButton;
    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //create animated gradient background
        myLayout = findViewById(R.id.activity_home);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        testButton = findViewById(R.id.testButton);
        testButton.setVisibility(View.GONE);
        studyButton = findViewById(R.id.studyButton);
        studyButton.setVisibility(View.GONE);

        //clicking button reveals activity buttons
        beginButton = findViewById(R.id.beginButton);
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginButton.setVisibility(View.GONE);
                testButton.setVisibility(View.VISIBLE);
                studyButton.setVisibility(View.VISIBLE);
            }});

        //button click opens up new activity class
        testButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
              Intent intent = new Intent(HomePage.this, TestActivity.class);
              startActivity(intent); }
              });

        studyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, StudyPage.class);
                startActivity(intent);

            }});
          }

}

