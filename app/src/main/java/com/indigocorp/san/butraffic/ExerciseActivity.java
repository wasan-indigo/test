package com.indigocorp.san.butraffic;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class ExerciseActivity extends AppCompatActivity {

    private TextView questionTestView;
    private ImageView trafficImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton,choice2RadioButton,choice3RadioButton,choice4RadioButton;

    private int timeAnInt = 0, scoreAnint =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        bindWidget();
        setupChoice();
    } // Main Method

    private void setupChoice() {
        String[] strMyChoice = getResources().getStringArray(R.array.time1);
        choice1RadioButton.setText(strMyChoice[0]);
        choice2RadioButton.setText(strMyChoice[1]);
        choice3RadioButton.setText(strMyChoice[2]);
        choice4RadioButton.setText(strMyChoice[3]);
    }


    public void  clickAnswer(View View) {
        checkScore();
        String[] strQuestion = new String[5];
        strQuestion[0] = "1. What is this ?";
        strQuestion[1] = "2. What is this ?";
        strQuestion[2] = "3. What is this ?";
        strQuestion[3] = "4. What is this ?";
        strQuestion[4] = "5. What is this ?";


        int[] intImage = new int[5];
        intImage[0] = R.drawable.traffic_01;
        intImage[1] = R.drawable.traffic_02;
        intImage[2] = R.drawable.traffic_03;
        intImage[3] = R.drawable.traffic_04;
        intImage[4] = R.drawable.traffic_05;

        int[] intChoice = new int[5];
        intChoice[0] = R.array.time1;
        intChoice[1] = R.array.time2;
        intChoice[2] = R.array.time3;
        intChoice[3] = R.array.time4;
        intChoice[4] = R.array.time5;



        timeAnInt += 1;

        if (timeAnInt<5) {
            questionTestView.setText(strQuestion[timeAnInt]);
            trafficImageView.setImageResource(intImage[timeAnInt]);
            String[] strMyChoice = getResources().getStringArray(intChoice[timeAnInt]);
            choice1RadioButton.setText(strMyChoice[0]);
            choice2RadioButton.setText(strMyChoice[1]);
            choice3RadioButton.setText(strMyChoice[2]);
            choice4RadioButton.setText(strMyChoice[3]);




        } else {
            //startActivity(new Intent(ExerciseActivity.this, ScoreActivity.class));
            Intent objIntent = new Intent(ExerciseActivity.this, ScoreActivity.class);
            objIntent.putExtra("Score", scoreAnint);
            startActivity(objIntent);

        }
        Log.d("test",Integer.toString(scoreAnint));
        //clickAnswer
    }

    private void checkScore() {

        final int[] intUserChoose ={1,2,3,4,4};
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("test",Integer.toString(checkedId));

                int intRadio;
                switch(checkedId) {
                    case R.id.radioButton:
                        intRadio = 1;
                        break;
                    case R.id.radioButton2:
                        intRadio = 2;
                        break;

                    case R.id.radioButton3:
                        intRadio = 3;
                        break;
                    case R.id.radioButton4:
                        intRadio = 4;
                        break;

                    default:
                        intRadio = 0;
                        break;

                }

                if (intUserChoose[timeAnInt] == intRadio) {
                    scoreAnint += 1;


                }

            }
        });

    } //Method Chk Score


    private void bindWidget() {
        questionTestView = (TextView) findViewById(R.id.textView5);
        trafficImageView = (ImageView) findViewById(R.id.imageView3);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.radChoie);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);

    }
}   //Main class
