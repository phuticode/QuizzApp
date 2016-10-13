package com.example.android.quizzapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.android.quizzapp.R.id.topic;
import static com.example.android.quizzapp.R.id.welcome;
import static com.example.android.quizzapp.R.layout.activity_main;
import static com.example.android.quizzapp.R.layout.activity_questions;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioButton rdb_selected;
    RadioGroup radioM;
    TextView welcome;
    //Global Variables
    ViewFlipper VF;
    boolean is_first_run = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        radioM = (RadioGroup) findViewById(R.id.rdgMain);
        radioM.setOnCheckedChangeListener(this);
        welcome = (TextView) findViewById(R.id.welcome);
        Intent i = getIntent();
        String welcome1 = i.getStringExtra("Welcome");

    }

    @Override
    public void onResume()
    {
        super.onResume();

        if (is_first_run)
        {
            welcome.setText(getResources().getString(R.string.welcome_message));
        } else
        {
            welcome.setText(getResources().getString(R.string.topic));
        }
        is_first_run = false;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        rdb_selected = (RadioButton) findViewById(i);

        String heading = rdb_selected.getText().toString();
        //String question = rdb_selected.getText().toString();
        // welcome.setVisibility(View.GONE);
        Intent intent = new Intent(this, Questions.class);
        intent.putExtra("Head", heading);
        startActivity(intent);
    }
}










