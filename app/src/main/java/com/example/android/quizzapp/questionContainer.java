package com.example.android.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import static com.example.android.quizzapp.R.id.david;
import static com.example.android.quizzapp.R.id.greatBritain;

import static com.example.android.quizzapp.R.id.swimming;
import static com.example.android.quizzapp.R.layout.activity_questions;

public class questionContainer extends AppCompatActivity {

    RadioGroup radioM;

    //Global Variables
    ViewFlipper VF;
    TextView topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_questions);

        //set topic to relevant
        topic = (TextView) findViewById(R.id.topic);

        Intent i = getIntent();
        String top = i.getStringExtra("Head");
        topic.setText(top);

        VF = (ViewFlipper) findViewById(R.id.ViewFlipper);

        /*
         * Find the views declared in questions.xml. for nn_Vintage
         */
        RadioGroup rdgNN = (RadioGroup) findViewById(R.id.rdgNN_Vintage);
        RadioButton radNonhle = (RadioButton) findViewById(R.id.nonhle);
        RadioButton radNakhane = (RadioButton) findViewById(R.id.nakhane);
        RadioButton radNhlanhla = (RadioButton) findViewById(R.id.nhlanhla);



    /*
     * Define a OnClickListener that will change which view that is displayed by
     * the ViewFlipper
     */

           /*
         * Find the views declared in questions.xml. for LV
         */
        RadioGroup rdgLV = (RadioGroup) findViewById(R.id.rdgLV);
        RadioButton radPrada = (RadioButton) findViewById(R.id.prada);
        RadioButton radLoius = (RadioButton) findViewById(R.id.louisV);
        RadioButton radGucci = (RadioButton) findViewById(R.id.gucci);

           /*
         * Find the views declared in questions.xml. for Nike
         */
        RadioGroup rdgNike = (RadioGroup) findViewById(R.id.rdgNike);
        RadioButton radNike = (RadioButton) findViewById(R.id.nike);
        RadioButton radAdidas = (RadioButton) findViewById(R.id.adidas);
        RadioButton radPuma = (RadioButton) findViewById(R.id.puma);

           /*
         * Find the views declared in questions.xml. for Heels
         */
        RadioGroup rdgHeels = (RadioGroup) findViewById(R.id.rdgHeels);
        RadioButton radStiletto = (RadioButton) findViewById(R.id.stilleto);
        RadioButton radPump = (RadioButton) findViewById(R.id.pump);
        RadioButton radSandal = (RadioButton) findViewById(R.id.sandal);

           /*
         * Find the views declared in questions.xml. for Jeans
         */
        RadioGroup rdgJeans = (RadioGroup) findViewById(R.id.rdgJeans);
        RadioButton radJeans = (RadioButton) findViewById(R.id.jeans);
        RadioButton radDenim = (RadioButton) findViewById(R.id.denim);
        RadioButton radDungaree = (RadioButton) findViewById(R.id.dungaree);

           /*
         * Find the views declared in questions.xml. for Water
         */
        RadioGroup rdgWater = (RadioGroup) findViewById(R.id.rdgWater);
        RadioButton radFood = (RadioButton) findViewById(R.id.food);
        RadioButton radOxygen = (RadioButton) findViewById(R.id.oxygen);
        RadioButton radWater = (RadioButton) findViewById(R.id.water);

           /*
         * Find the views declared in questions.xml. for pregnancy
         */
        RadioGroup rdgPregnancy = (RadioGroup) findViewById(R.id.rdgPregnancy);
        RadioButton radMalnutririon = (RadioButton) findViewById(R.id.malnutrition);
        RadioButton radPregnancy = (RadioButton) findViewById(R.id.pregnancy);
        RadioButton radAnorexia = (RadioButton) findViewById(R.id.anorexia);

           /*
         * Find the views declared in questions.xml. for weight-loss
         */
        RadioGroup rdgWeight = (RadioGroup) findViewById(R.id.rdgWeight_Loss);
        RadioButton radTrue = (RadioButton) findViewById(R.id.True);
        RadioButton radFalse = (RadioButton) findViewById(R.id.False);

           /*
         * Find the views declared in questions.xml. for Jogging
         */
        RadioGroup rdgJogging = (RadioGroup) findViewById(R.id.rdgJogging);
        RadioButton radJogging = (RadioButton) findViewById(R.id.jogging);
        RadioButton radVodka = (RadioButton) findViewById(R.id.vodka);
        RadioButton radSex = (RadioButton) findViewById(R.id.sex);

           /*
         * Find the views declared in questions.xml. for Eggs
         */
        RadioGroup rdgEggs = (RadioGroup) findViewById(R.id.rdgEggs);
        RadioButton radEggs = (RadioButton) findViewById(R.id.egg);
        RadioButton radOrange = (RadioButton) findViewById(R.id.orange);
        RadioButton radPawpaw = (RadioButton) findViewById(R.id.pawpaw);

           /*
         * Find the views declared in questions.xml. for Jockeys
         */
        RadioGroup rdgJockeys = (RadioGroup) findViewById(R.id.rdgJockeys);
        RadioButton radBasketBall = (RadioButton) findViewById(R.id.basketBall);
        RadioButton radJockeys = (RadioButton) findViewById(R.id.jockeys);
        RadioButton radOlympians = (RadioButton) findViewById(R.id.olympians);

           /*
         * Find the views declared in questions.xml. for Golf Balls
         */
        RadioGroup rdgGolf = (RadioGroup) findViewById(R.id.rdgGolf);
        RadioButton radGolf = (RadioButton) findViewById(R.id.golf);
        RadioButton radTennis = (RadioButton) findViewById(R.id.tennis);
        RadioButton radCricket = (RadioButton) findViewById(R.id.cricket);

           /*
         * Find the views declared in questions.xml. for Tennis
         */
        RadioGroup rdgTennisSport = (RadioGroup) findViewById(R.id.tennisSport);
        RadioButton rdbUsa = (RadioButton) findViewById(R.id.usa);
        RadioButton rdbWimbledon = (RadioButton) findViewById(R.id.wimbledon);
        RadioButton rdbGreat = (RadioButton) findViewById(greatBritain);

        /*
         * Find the views declared in questions.xml. for Christiano
         */
        RadioGroup rdgChristiano = (RadioGroup) findViewById(R.id.christianoRonaldo);
        RadioButton rdbRonaldo = (RadioButton) findViewById(R.id.ronaldo);
        RadioButton rdbLionel = (RadioButton) findViewById(R.id.lionel);
        RadioButton rdbDavid = (RadioButton) findViewById(david);

          /*
         * Find the views declared in questions.xml. for Soccer
         */
        RadioGroup rdgFootball = (RadioGroup) findViewById(R.id.football);
        RadioButton rdbSoccer = (RadioButton) findViewById(R.id.soccer);
        RadioButton rdbBasket = (RadioButton) findViewById(R.id.basket);
        RadioButton rdbSwimming = (RadioButton) findViewById(swimming);


    }


}










