package com.example.android.quizzapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.LV;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import static com.example.android.quizzapp.R.id.basketBall;
import static com.example.android.quizzapp.R.id.david;
import static com.example.android.quizzapp.R.id.fashion;
import static com.example.android.quizzapp.R.id.greatBritain;
import static com.example.android.quizzapp.R.id.nakhane;
import static com.example.android.quizzapp.R.id.nonhle;
import static com.example.android.quizzapp.R.id.rdgGolf;
import static com.example.android.quizzapp.R.id.rdgHeels;
import static com.example.android.quizzapp.R.id.rdgJockeys;
import static com.example.android.quizzapp.R.id.rdgLV;
import static com.example.android.quizzapp.R.id.rdgNN_Vintage;
import static com.example.android.quizzapp.R.id.rdgWater;
import static com.example.android.quizzapp.R.id.score;
import static com.example.android.quizzapp.R.id.sports;
import static com.example.android.quizzapp.R.id.swimming;
import static com.example.android.quizzapp.R.id.topic;
import static com.example.android.quizzapp.R.id.welcome;
import static com.example.android.quizzapp.R.layout.activity_main;
import static com.example.android.quizzapp.R.layout.activity_questions;
import static com.example.android.quizzapp.R.string.Jeans;
import static com.example.android.quizzapp.R.string.Jogging;
import static com.example.android.quizzapp.R.string.Nike;
import static com.example.android.quizzapp.R.string.rdbPregnancy;

public class Questions extends AppCompatActivity
{
    RadioGroup radioM;
    //Global Variables
    ViewFlipper VF;
    TextView topic;
    RadioButton selected;
    TextView question;
    TextView points;
    int scores = 0;
    Button button;
    TextView results;
    TextView results2;
    String selectedRad, selectedRad2, selectedRad3, selectedRad4, selectedRad5, selectedRad6, selectedRad7, selectedRad8, selectedRad9, selectedRad10, selectedRad11, selectedRad12, selectedRad13, selectedRad14, selectedRad15;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(activity_questions);

        //set topic to relevant
        topic = (TextView) findViewById(R.id.topic);
        points = (TextView) findViewById(score);
        points.setText("Score : " + scores);
        Intent i = getIntent();
        String top = i.getStringExtra("Head");
        topic.setText(top);

        VF = (ViewFlipper) findViewById(R.id.ViewFlipper);
        question = (TextView) findViewById(R.id.questions);
        results = (TextView) findViewById(R.id.answersLeft);
        results2 = (TextView) findViewById(R.id.answersRight);

        //set question to relevant
        if (top.equalsIgnoreCase("fashion"))
        {
            question.setText(getString(R.string.nn_vintage));
            VF.setDisplayedChild(0);
            VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgNN_Vintage)));

        } else if (top.equalsIgnoreCase("health"))
        {
            question.setText(getString(R.string.Water));
            VF.setDisplayedChild(0);
            VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgWater)));
        } else if (top.equalsIgnoreCase("sports"))
        {
            question.setText(getString(R.string.Jockeys));
            VF.setDisplayedChild(0);
            VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgJockeys)));
        }
        //Find the views declared in questions.xml. for nn_Vintage
        final RadioGroup rdgNN = (RadioGroup) findViewById(R.id.rdgNN_Vintage);
        final RadioButton radNonhle = (RadioButton) findViewById(R.id.nonhle);
        final RadioButton radNakhane = (RadioButton) findViewById(R.id.nakhane);
        final RadioButton radNhlanhla = (RadioButton) findViewById(R.id.nhlanhla);

        rdgNN.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                question.setText(getString(R.string.nn_vintage));
                RadioButton sl = (RadioButton) findViewById(checkedId);
                String selected = sl.getText().toString();

                switch (checkedId)
                { //set the Model to hold the answer the user picked
                    case R.id.nonhle:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgLV)));
                        topic.setText("Fashion");
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radNonhle.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.nakhane:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgLV)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radNakhane.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.nhlanhla:
                        scores = scores + 10;
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgLV)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        points.setText("Score : " + scores);
                        radNhlanhla.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                }
                question.setText(getString(R.string.Louis_Vuitton));
                //set the Model to hold the answer the user picked
                checkedId = rdgNN.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad = radfood.getText().toString();
            }
        });
        //Find the views declared in questions.xml. for LV
        final RadioGroup rdgLV = (RadioGroup) findViewById(R.id.rdgLV);
        final RadioButton radPrada = (RadioButton) findViewById(R.id.prada);
        final RadioButton radLoius = (RadioButton) findViewById(R.id.louisV);
        final RadioButton radGucci = (RadioButton) findViewById(R.id.gucci);

        rdgLV.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                { //set the Model to hold the answer the user picked
                    case R.id.prada:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgNike)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radPrada.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.louisV:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgNike)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        radLoius.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.gucci:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgNike)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radGucci.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                }
                question.setText(getString(Nike));
                //set the Model to hold the answer the user picked
                checkedId = rdgLV.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad2 = radfood.getText().toString();
            }
        });
        //Find the views declared in questions.xml. for Nike
        final RadioGroup rdgNike = (RadioGroup) findViewById(R.id.rdgNike);
        final RadioButton radNike = (RadioButton) findViewById(R.id.nike);
        final RadioButton radAdidas = (RadioButton) findViewById(R.id.adidas);
        final RadioButton radPuma = (RadioButton) findViewById(R.id.puma);

        rdgNike.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                { //set the Model to hold the answer the user picked

                    case R.id.nike:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgHeels)));
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        radNike.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.adidas:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgHeels)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radAdidas.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.puma:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgHeels)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radPuma.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                }
                question.setText(getString(R.string.Stiletto));
                //set the Model to hold the answer the user picked
                checkedId = rdgNike.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad3 = radfood.getText().toString();

            }
        });
        //Find the views declared in questions.xml. for Heels
        final RadioGroup rdgHeels = (RadioGroup) findViewById(R.id.rdgHeels);
        final RadioButton radStiletto = (RadioButton) findViewById(R.id.stilleto);
        final RadioButton radPump = (RadioButton) findViewById(R.id.pump);
        final RadioButton radSandal = (RadioButton) findViewById(R.id.sandal);
        rdgHeels.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                { //set the Model to hold the answer the user picked
                    case R.id.stilleto:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgJeans)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        radStiletto.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.pump:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgJeans)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radPump.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.sandal:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgJeans)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radSandal.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                }
                question.setText(getString(Jeans));
                //set the Model to hold the answer the user picked
                checkedId = rdgHeels.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                radfood.setTextColor(getColor(android.R.color.holo_red_light));
                selectedRad4 = radfood.getText().toString();


            }
        });
        // Find the views declared in questions.xml. for Jeans
        final RadioGroup rdgJeans = (RadioGroup) findViewById(R.id.rdgJeans);
        final RadioButton radJeans = (RadioButton) findViewById(R.id.jeans);
        final RadioButton radDenim = (RadioButton) findViewById(R.id.denim);
        final RadioButton radDungaree = (RadioButton) findViewById(R.id.dungaree);

        rdgJeans.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                { //set the Model to hold the answer the user picked
                    case R.id.jeans:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.answers)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        topic.setText("Results");
                        radJeans.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.denim:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.answers)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        topic.setText("Results");
                        radDenim.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.dungaree:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.answers)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        topic.setText("Results");
                        radDungaree.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                }
                question.setText("Correct Answers    Your Answers");
                checkedId = rdgJeans.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad5 = radfood.getText().toString();
                //set the correct anaswers to the results window
                results.setText("" + getResources().getString(R.string.rdbNhlanhla_Nciza) +
                        "\n" + getResources().getString(R.string.rdbLouisV) +
                        "\n" + getResources().getString(R.string.rdbNike) +
                        "\n" + getResources().getString(R.string.rdbStilleto) +
                        "\n" + getResources().getString(R.string.rdbDenim));
                results2.setText(selectedRad +
                        "\n" + selectedRad2 +
                        "\n" + selectedRad3 +
                        "\n" + selectedRad4 +
                        "\n" + selectedRad5);

            }
        });
        //Find the views declared in questions.xml. for Water
        final RadioGroup rdgWater = (RadioGroup) findViewById(R.id.rdgWater);
        final RadioButton radFood = (RadioButton) findViewById(R.id.food);
        final RadioButton radOxygen = (RadioButton) findViewById(R.id.oxygen);
        final RadioButton radWater = (RadioButton) findViewById(R.id.water);
        rdgWater.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.food:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgPregnancy)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radFood.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.oxygen:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgPregnancy)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radOxygen.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.water:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgPregnancy)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        radWater.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                }
                question.setText(getString(R.string.Pregnancy));

                //set the Model to hold the answer the user picked
                checkedId = rdgWater.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad6 = radfood.getText().toString();
            }
        });
        //Find the views declared in questions.xml. for pregnancy
        final RadioGroup rdgPregnancy = (RadioGroup) findViewById(R.id.rdgPregnancy);
        final RadioButton radMalnutririon = (RadioButton) findViewById(R.id.malnutrition);
        final RadioButton radPregnancy = (RadioButton) findViewById(R.id.pregnancy);
        final RadioButton radAnorexia = (RadioButton) findViewById(R.id.anorexia);
        rdgPregnancy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                { //set the Model to hold the answer the user picked
                    case R.id.malnutrition:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgWeight_Loss)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radMalnutririon.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.pregnancy:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgWeight_Loss)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        radPregnancy.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.anorexia:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgWeight_Loss)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radAnorexia.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                }
                question.setText(getString(R.string.Weight_Loss));
                //set the Model to hold the answer the user picked
                checkedId = rdgPregnancy.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad7 = radfood.getText().toString();
            }
        });
        //Find the views declared in questions.xml. for weight-loss
        final RadioGroup rdgWeight = (RadioGroup) findViewById(R.id.rdgWeight_Loss);
        final RadioButton radTrue = (RadioButton) findViewById(R.id.True);
        final RadioButton radFalse = (RadioButton) findViewById(R.id.False);
        rdgWeight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                { //set the Model to hold the answer the user picked
                    case R.id.True:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgJogging)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radTrue.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.False:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgJogging)));
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        radFalse.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                }
                question.setText(getString(Jogging));
                //set the Model to hold the answer the user picked
                checkedId = rdgWeight.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad8 = radfood.getText().toString();
            }
        });
        //Find the views declared in questions.xml. for Jogging
        final RadioGroup rdgJogging = (RadioGroup) findViewById(R.id.rdgJogging);
        final RadioButton radJogging = (RadioButton) findViewById(R.id.jogging);
        final RadioButton radVodka = (RadioButton) findViewById(R.id.vodka);
        final RadioButton radSex = (RadioButton) findViewById(R.id.sex);

        rdgJogging.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                switch (checkedId)
                { //set the Model to hold the answer the user picked

                    case R.id.jogging:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgEggs)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        radJogging.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.vodka:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgEggs)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radVodka.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.sex:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgEggs)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radSex.setTextColor(getColor(android.R.color.holo_red_light));
                        break;

                }
                question.setText(getString(R.string.Eggs));
                //set the Model to hold the answer the user picked
                checkedId = rdgJogging.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad9 = radfood.getText().toString();
                radFalse.setTextColor(getColor(android.R.color.holo_green_light));
            }
        });
           /*
         * Find the views declared in questions.xml. for Eggs
         */
        final RadioGroup rdgEggs = (RadioGroup) findViewById(R.id.rdgEggs);
        final RadioButton radEggs = (RadioButton) findViewById(R.id.egg);
        final RadioButton radOrange = (RadioButton) findViewById(R.id.orange);
        final RadioButton radPawpaw = (RadioButton) findViewById(R.id.pawpaw);

        rdgEggs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                switch (checkedId)
                { //set the Model to hold the answer the user picked

                    case R.id.egg:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.answers)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        radEggs.setTextColor(getColor(android.R.color.holo_green_light));
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        topic.setText("Results");
                        break;
                    case R.id.orange:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.answers)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radOrange.setTextColor(getColor(android.R.color.holo_red_light));
                        topic.setText("Results");
                        break;
                    case R.id.pawpaw:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.answers)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        topic.setText("Results");
                        radPawpaw.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                }
                question.setText("Correct Answers         Your Answers");
                //set the Model to hold the answer the user picked
                checkedId = rdgEggs.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad10 = radfood.getText().toString();
                //set the correct anaswers to the results window
                results.setText("" + getResources().getString(R.string.rdbWater) +
                        "\n" + getResources().getString(rdbPregnancy) + "                  " +
                        "\n" + getResources().getString(R.string.rdbFalse) +
                        "\n" + getResources().getString(R.string.rdbJogging) +
                        "\n" + getResources().getString(R.string.rdbEgg));
                results2.setText(selectedRad6 +
                        "\n" + selectedRad7 +
                        "\n" + selectedRad8 +
                        "\n" + selectedRad9 +
                        "\n" + selectedRad10);
            }
        });
        //Find the views declared in questions.xml. for Jockeys
        final RadioGroup rdgJockeys = (RadioGroup) findViewById(R.id.rdgJockeys);
        final RadioButton radBasketBall = (RadioButton) findViewById(basketBall);
        final RadioButton radJockeys = (RadioButton) findViewById(R.id.jockeys);
        final RadioButton radOlympians = (RadioButton) findViewById(R.id.olympians);
        rdgJockeys.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                { //set the Model to hold the answer the user picked
                    case basketBall:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgGolf)));
                        radBasketBall.setTextColor(getColor(android.R.color.holo_red_light));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.jockeys:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgGolf)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        radJockeys.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.olympians:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.rdgGolf)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radOlympians.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                }
                question.setText(getString(R.string.Golf_balls));
                //set the Model to hold the answer the user picked
                checkedId = rdgJockeys.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad11 = radfood.getText().toString();

            }
        });

           /*
         * Find the views declared in questions.xml. for Golf Balls
         */
        final RadioGroup rdgGolf = (RadioGroup) findViewById(R.id.rdgGolf);
        final RadioButton radGolf = (RadioButton) findViewById(R.id.golf);
        final RadioButton radTennis = (RadioButton) findViewById(R.id.tennis);
        final RadioButton radCricket = (RadioButton) findViewById(R.id.cricket);
        rdgGolf.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                switch (checkedId)
                { //set the Model to hold the answer the user picked

                    case R.id.golf:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.tennisSport)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        radGolf.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.tennis:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.tennisSport)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radTennis.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.cricket:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.tennisSport)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        radCricket.setTextColor(getColor(android.R.color.holo_red_light));
                        break;

                }
                question.setText(getString(R.string.Tennis_Great_Britain));
                //set the Model to hold the answer the user picked
                checkedId = rdgGolf.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad12 = radfood.getText().toString();

            }
        });
           /*
         * Find the views declared in questions.xml. for Tennis
         */
        final RadioGroup rdgTennisSport = (RadioGroup) findViewById(R.id.tennisSport);
        final RadioButton rdbUsa = (RadioButton) findViewById(R.id.usa);
        final RadioButton rdbWimbledon = (RadioButton) findViewById(R.id.wimbledon);
        final RadioButton rdbGreat = (RadioButton) findViewById(greatBritain);

        rdgTennisSport.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                switch (checkedId)
                { //set the Model to hold the answer the user picked

                    case R.id.usa:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.christianoRonaldo)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        rdbUsa.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.wimbledon:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.christianoRonaldo)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        rdbWimbledon.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.greatBritain:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.christianoRonaldo)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        rdbGreat.setTextColor(getColor(android.R.color.holo_green_light));
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        break;

                }
                question.setText(getString(R.string.Christiano_Ronaldo));
                //set the Model to hold the answer the user picked
                checkedId = rdgTennisSport.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad13 = radfood.getText().toString();
            }
        });
        /*
         * Find the views declared in questions.xml. for Christiano
         */
        final RadioGroup rdgChristiano = (RadioGroup) findViewById(R.id.christianoRonaldo);
        final RadioButton rdbRonaldo = (RadioButton) findViewById(R.id.ronaldo);
        final RadioButton rdbLionel = (RadioButton) findViewById(R.id.lionel);
        final RadioButton rdbDavid = (RadioButton) findViewById(david);
        rdgChristiano.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                { //set the Model to hold the answer the user picked
                    case R.id.ronaldo:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.football)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        rdbRonaldo.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.lionel:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.football)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        rdbLionel.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                    case R.id.david:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.football)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        rdbDavid.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                }
                question.setText(getString(R.string.Soccer));
                //set the Model to hold the answer the user picked
                checkedId = rdgChristiano.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad14 = radfood.getText().toString();
            }
        });
          /*
         * Find the views declared in questions.xml. for Soccer
         */
        final RadioGroup rdgFootball = (RadioGroup) findViewById(R.id.football);
        final RadioButton rdbSoccer = (RadioButton) findViewById(R.id.soccer);
        final RadioButton rdbBasket = (RadioButton) findViewById(R.id.basket);
        final RadioButton rdbSwimming = (RadioButton) findViewById(R.id.swimming);
        rdgFootball.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                { //set the Model to hold the answer the user picked
                    case R.id.soccer:
                        VF.setDisplayedChild(0);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.answers)));
                        Toast.makeText(Questions.this, "Correct ", Toast.LENGTH_SHORT).show();
                        //VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.button)));
                        scores = scores + 10;
                        points.setText("Score : " + scores);
                        topic.setText("Results");
                        rdbSoccer.setTextColor(getColor(android.R.color.holo_green_light));
                        break;
                    case R.id.basket:
                        VF.setDisplayedChild(1);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.answers)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        // VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.button)));
                        topic.setText("Results");
                        rdbBasket.setTextColor(getColor(android.R.color.holo_red_light));
                        rdbBasket.invalidate();
                        break;
                    case R.id.swimming:
                        VF.setDisplayedChild(2);
                        VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.answers)));
                        Toast.makeText(Questions.this, "Incorrect ", Toast.LENGTH_SHORT).show();
                        //  VF.setDisplayedChild(VF.indexOfChild(findViewById(R.id.button)));
                        topic.setText("Results");
                        rdbSwimming.setTextColor(getColor(android.R.color.holo_red_light));
                        break;
                }
                question.setText("Correct Answers       Your Answers");
                //set the Model to hold the answer the user picked
                checkedId = rdgFootball.getCheckedRadioButtonId();
                RadioButton radfood = (RadioButton) findViewById(checkedId);
                selectedRad15 = radfood.getText().toString();
                //set the correct anaswers to the results rdbJockeys
                results.setText(getResources().getString(R.string.rdbJockeys) +
                        "\n" + getResources().getString(R.string.rdbGolf) +
                        "\n" + getResources().getString(R.string.rdbTennis) +
                        "\n" + getResources().getString(R.string.rdbChristiano) +
                        "\n" + getResources().getString(R.string.rdbSoccer));
                results2.setText(selectedRad11 +
                        "\n" + selectedRad12 +
                        "\n" + selectedRad13 +
                        "\n" + selectedRad14 +
                        "\n" + selectedRad15);
                // results.setTextColor(getColor(android.R.color.holo_red_light));
            }
        });
    }
}










