package com.example.gameconnect3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //0=yellow, 1=red...
    int activePlayer=0; boolean gameIsActive=true;
    int[] gameState={2,2,2,2,2,2,2,2,2};  //2= means unplayed
     int [][] winningPositions={{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};


    @SuppressLint("SetTextI18n")
    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 && gameIsActive) {

            gameState[tappedCounter]=activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(400);

            for(int[] winningPosition : winningPositions) {
                if(gameState[winningPosition[0]]== gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]]== gameState[winningPosition[2]] &&
                     gameState[winningPosition[0]]!=2 )  {
                    gameIsActive = false;
                     String winner="Red";

                    if (gameState[winningPosition[0]]==0) {
                       winner="Yellow";

                    }
                    //someone has won!!
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText( winner + " Has Won!!");

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                }  else {
                     boolean gameIsOver = true;
                     for (int counterState : gameState) {
                         if(counterState==2)  gameIsOver=false;
                         }
                     if(gameIsOver) {
                         TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                         winnerMessage.setText("It's a draw");

                         LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                         layout.setVisibility(View.VISIBLE);
                     }
                     }

                }
            }
        }
      public void playAgain(View view) {
        gameIsActive=true;
          LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
          layout.setVisibility(View.INVISIBLE);

          activePlayer=0;

          for(int i=0;i<=8;i++) {
              gameState[i] =2;
          }

           ImageView image1 = findViewById(R.id.imageView1);
          image1.setImageResource(0);

          ImageView image2 = findViewById(R.id.imageView2);
          image2.setImageResource(0);

          ImageView image3 = findViewById(R.id.imageView3);
          image3.setImageResource(0);

          ImageView image4 = findViewById(R.id.imageView4);
          image4.setImageResource(0);

          ImageView image5 = findViewById(R.id.imageView5);
          image5.setImageResource(0);

          ImageView image6 = findViewById(R.id.imageView6);
          image6.setImageResource(0);

          ImageView image7 = findViewById(R.id.imageView7);
          image7.setImageResource(0);

          ImageView image8 = findViewById(R.id.imageView8);
          image8.setImageResource(0);

          ImageView image9 = findViewById(R.id.imageView9);
          image9.setImageResource(0);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}