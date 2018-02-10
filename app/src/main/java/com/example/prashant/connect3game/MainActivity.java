package com.example.prashant.connect3game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // 0: yellow, 1: red, 2: empty

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    int activePlayer = 0;

    boolean gameActive = true;

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.red);

                activePlayer = 0;

            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {

                    // Somone has won!

                    gameActive = false;

                    String winner = "";

                    if (activePlayer == 1) {

                        winner = "Yellow";

                    } else {

                        winner = "Red";

                    }




                    Button playAgainButton = (Button) findViewById(R.id.playAgain);

                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

                    ImageView winImage = (ImageView) findViewById(R.id.winImageView);
                    winImage.setX(-1500);
                    winImage.animate().translationXBy(1500).rotation(360).setDuration(2000);
                    winImage.setVisibility(View.VISIBLE);

                    winnerTextView.setX(2500);
                    winnerTextView.animate().rotation(360).translationXBy(-2300);
                    winnerTextView.setText(winner + " has won!");

                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerTextView.setVisibility(View.VISIBLE);

                }else{
                    Button playAgainButton = (Button) findViewById(R.id.playAgain);
                    playAgainButton.setVisibility(View.VISIBLE);
                }





            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playAgain(View view) {

        Button playAgainButton = (Button) findViewById(R.id.playAgain);

        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

        ImageView winImage = (ImageView) findViewById(R.id.winImageView);
        winImage.setX(-1500);
        winImage.animate().translationXBy(1500).rotation(360).setDuration(2000);
        winImage.setVisibility(View.INVISIBLE);

      /*  winnerTextView.setX(2500);
        winnerTextView.animate().rotation(360).translationXBy(-2100);
        winnerTextView.setText(winner + " has won!");*/

        playAgainButton.setVisibility(View.INVISIBLE);

        winnerTextView.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }

        for(int i=0;i<9;i++){
            gameState[i]=2;
        }

        activePlayer = 0;

         gameActive = true;


    }

}


