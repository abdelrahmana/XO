package com.example.trued.xo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Game_X_O extends AppCompatActivity {
    int X_OR_Y = 0; // im x or im y
    int[] number_row={3,3,3,3,3,3,3,3,3};// for x or y into position to force app not overide on value
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}}; // winnig position
    boolean gameactive= true;
    TextView winnerMessage;
    LinearLayout layout ;
    GridLayout mygrid;
    ImageView image;
  static  String getname ;
    checking_winner object = new checking_winner();

    int  n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__x__o);
       getname = getIntent().getStringExtra("name");
        Button mbutton = (Button)findViewById(R.id.playAgainButton);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i< 9; i++) {
                    if (i==0)
                    {

                        image = (ImageView)findViewById(R.id.image1);;
                        image.setImageResource(0);

                    }
                    if (i==1)
                    {

                        image = (ImageView)findViewById(R.id.image2);;
                        image.setImageResource(0);

                    }
                    if (i==2)
                    {

                        image = (ImageView)findViewById(R.id.image3);
                        image.setImageResource(0);

                    }
                    if (i==3)
                    {

                        image = (ImageView)findViewById(R.id.image4);
                        image.setImageResource(0);

                    }
                    if (i==4)
                    {

                        image = (ImageView)findViewById(R.id.image5);
                        image.setImageResource(0);

                    }
                    if (i==5)
                    {

                        image = (ImageView)findViewById(R.id.image6);
                        image.setImageResource(0);

                    }
                    if (i==6)
                    {

                        image = (ImageView)findViewById(R.id.image7);
                        image.setImageResource(0);

                    }
                    if (i==7)
                    {

                        image = (ImageView)findViewById(R.id.image8);
                        image.setImageResource(0);

                    }
                    if (i==8)
                    {

                        image = (ImageView)findViewById(R.id.image9);
                        image.setImageResource(0);

                    }
                }
                gameactive = true;

                LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

                layout.setVisibility(View.INVISIBLE);

                X_OR_Y = 0;

                for (int i = 0; i < number_row.length; i++) {

                    number_row[i] = 3;

                }
               // playAgain(v);
            }
        });

    }
    public void puthere(View view){
        mygrid = (GridLayout)findViewById(R.id.mygridv);
        winnerMessage = (TextView)findViewById(R.id.winnerMessage);
        layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        image = (ImageView)view; // this mean im in the specific image
        int where_im_in_board = Integer.parseInt(image.getTag().toString());

        if (number_row[where_im_in_board] == 3 && gameactive)

        {

            image.setTranslationY(-1000f);
            if (X_OR_Y == 0) {
                image.setImageResource(R.drawable.x);
                number_row[where_im_in_board] = X_OR_Y;

                X_OR_Y = 1;


            }

            image.animate().translationYBy(1000f).rotationYBy(720).setDuration(500);
           for (int []check : winningPositions) {
                if (number_row[check[0]] == number_row[check[1]] &&
                        number_row[check[1]] == number_row[check[2]] &&
                        number_row[check[0]] != 3 &&  number_row[check[0]] == number_row[check[2]]) {
                    gameactive = false;
                    String winner = "No one";
                    if (number_row[check[0]] == 0) {

                        winner = getname;

                    } else {
                        winner = "Computer";
                    }
                     X_OR_Y =2 ; //computer stop
                    winnerMessage.setText("Winner is :" + winner);
                    layout.setVisibility(View.VISIBLE);

                }


            }

            boolean gameover = true;
            for (int counter : number_row) {
                if (counter == 3){
                    gameover = false;
                }

            }

            if (gameover){
                int last_try =0;
                for (int []check : winningPositions) {
                    if (number_row[check[0]] == number_row[check[1]] &&
                            number_row[check[1]] == number_row[check[2]] &&
                            number_row[check[0]] != 3 && number_row[check[0]] == number_row[check[2]]) {
                        gameactive = false;
                        String winner = "No one";
                        if (number_row[check[0]] == 0) {

                            winner = getname;

                        } else {
                            winner = "Computer";
                        }

                        X_OR_Y = 2;
                        winnerMessage.setText("Winner is :" + winner);
                        layout.setVisibility(View.VISIBLE);
                        last_try =1;

                        break;

                    }
                }
                if (last_try!=1) {
                    X_OR_Y = 2;
                    winnerMessage.setText("it is draw");
                    layout.setVisibility(View.VISIBLE);

                }




            }
        }
        if(X_OR_Y==1)
        {
            putthere(view);
        }
    }


    private void putthere(View view) {
        Random rand = new Random();
        n  = rand.nextInt(8) + 0;
        while (number_row[n]!=3)
        {
            n = rand.nextInt(8) + 0;
        }
        if (n==0)
        {
            view =findViewById(R.id.image1);

        }
        if (n==1)
        {
            view =findViewById(R.id.image2);

        }
        if (n==2)
        {
            view =findViewById(R.id.image3);

        }
        if (n==3)
        {
            view =findViewById(R.id.image4);

        }
        if (n==4)
        {
            view =findViewById(R.id.image5);

        }
        if (n==5)
        {
            view =findViewById(R.id.image6);

        }
        if (n==6)
        {
            view =findViewById(R.id.image7);

        }
        if (n==7)
        {
            view =findViewById(R.id.image8);

        }
        if (n==8)
        {
            view =findViewById(R.id.image9);

        }

        image = (ImageView)view;
        image.setImageResource(R.drawable.o);
        image.animate().translationYBy(0f).alpha(0f).setDuration(0);
        image.animate().translationYBy(0f).rotationYBy(360).setDuration(1000);
        image.animate().alpha(1f).setDuration(1000);

        number_row[n]=X_OR_Y;
        for (int []check : winningPositions) {
            if (number_row[check[0]] == number_row[check[1]] &&
                    number_row[check[1]] == number_row[check[2]] &&
                    number_row[check[0]] != 3 && number_row[check[0]] == number_row[check[2]]) {
                gameactive = false;
                String winner = "No one";
                if (number_row[check[0]] == 0) {

                    winner = getname;

                } else {
                    winner = "Computer";
                }

                winnerMessage.setText("Winner is :" + winner);
                layout.setVisibility(View.VISIBLE);

            }
        }
        X_OR_Y = 0;
    }
   /* public void playAgain(View view) {

        gameactive = true;

        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);

        X_OR_Y = 0;

        for (int i = 0; i < number_row.length; i++) {

            number_row[i] = 3;

        }

        for (int i = 0; i< mygrid.getChildCount(); i++){

           // ((ImageView) mygrid.getChildAt(i)).setImageResource(0);
            if (i==0)
            {
                view =findViewById(R.id.image1);
                image = (ImageView)view;
                image.setImageResource(0);

            }
            if (i==1)
            {
                view =findViewById(R.id.image2);
                image = (ImageView)view;
                image.setImageResource(0);

            }
            if (i==2)
            {
                view =findViewById(R.id.image3);
                image = (ImageView)view;
                image.setImageResource(0);

            }
            if (i==3)
            {
                view =findViewById(R.id.image4);
                image = (ImageView)view;
                image.setImageResource(0);

            }
            if (i==4)
            {
                view =findViewById(R.id.image5);
                image = (ImageView)view;
                image.setImageResource(0);

            }
            if (i==5)
            {
                view =findViewById(R.id.image6);
                image = (ImageView)view;
                image.setImageResource(0);

            }
            if (i==6)
            {
                view =findViewById(R.id.image7);
                image = (ImageView)view;
                image.setImageResource(0);

            }
            if (i==7)
            {
                view =findViewById(R.id.image8);
                image = (ImageView)view;
                image.setImageResource(0);

            }
            if (i==8)
            {
                view =findViewById(R.id.image9);
                image = (ImageView)view;
                image.setImageResource(0);

            }

        }

    }*/
}
