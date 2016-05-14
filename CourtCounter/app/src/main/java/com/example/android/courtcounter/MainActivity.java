package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int team_a_score=0;
    int team_b_score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void increaseThree(View view) {
        team_a_score+=3;
        displayForTeamA(team_a_score);
    }

    public void increaseTwo(View view) {
        team_a_score+=2;
        displayForTeamA(team_a_score);
    }

    public void increaseOne(View view) {
        team_a_score+=1;
        displayForTeamA(team_a_score);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void increaseThreeB(View view) {
        team_b_score+=3;
        displayForTeamB(team_b_score);
    }

    public void increaseTwoB(View view) {
        team_b_score+=2;
        displayForTeamB(team_b_score);
    }

    public void increaseOneB(View view) {
        team_b_score+=1;
        displayForTeamB(team_b_score);
    }

    public void reset(View view){
        team_a_score=0;
        team_b_score=0;
        displayForTeamA(team_a_score);
        displayForTeamB(team_b_score);
    }
}
