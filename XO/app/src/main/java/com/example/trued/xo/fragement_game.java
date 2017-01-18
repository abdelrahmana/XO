package com.example.trued.xo;

import android.content.Context;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class fragement_game extends Fragment implements handling_calling_onclick_within_fragement_ui {
int X_OR_Y = 0; // im x or im y
    int[] number_row={3,3,3,3,3,3,3,3,3};// for x or y into position to force app not overide on value
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}}; // winnig position

    boolean gameactive= true;

    TextView winnerMessage;
    LinearLayout layout ;
    GridLayout mygrid;
    ImageView image;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View Rootview = inflater.inflate(R.layout.activity_fragement_game,container,false);
        mygrid = (GridLayout)Rootview.findViewById(R.id.mygridv);
        winnerMessage = (TextView)Rootview.findViewById(R.id.winnerMessage);
        layout = (LinearLayout)Rootview.findViewById(R.id.playAgainLayout);
        return Rootview;
    }
    public void puthere(View view){
         image = (ImageView)view; // this mean im in the specific image
        int where_im_in_board = Integer.parseInt(image.getTag().toString());

        if (number_row[where_im_in_board] == 3 && gameactive)

        {
            number_row[where_im_in_board] = X_OR_Y;
            image.setTranslationY(-1000f);
            if (X_OR_Y == 0) {
                image.setImageResource(R.drawable.x);

                X_OR_Y = 1;


            }
            else{
                image.setImageResource(R.drawable.o);
                X_OR_Y = 0;
            }
            image.animate().translationYBy(1000f).rotationYBy(3600f).setDuration(500);

            for (int []check : winningPositions) {
                if (number_row[check[0]] == number_row[check[1]] &&
                        number_row[check[1]] == number_row[check[2]] &&
                        number_row[check[0]] != 3) {
                    gameactive = false;
                    String winner = "No one";
                    if (number_row[check[0]] == 0) {

                        winner = "X";

                    } else {
                        winner = "O";
                    }

                    winnerMessage.setText("Winner is :" + winner);
                    layout.setVisibility(View.VISIBLE);

                } else {
                    boolean gameover = true;
                    for (int counter : number_row) {
                        if (counter == 3)
                            gameover = false;


                    }

                if (gameover) {
                    winnerMessage.setText("it is draw");
                    layout.setVisibility(View.VISIBLE);


                }

                }

            }


        }
    }

    @Override
    public void restartgame() {

        for (int i=0;i<number_row.length;i++)
        {
            number_row[i]=3;
        }
        layout.setVisibility(View.INVISIBLE);
        X_OR_Y =0;
        for (int i =0; i<mygrid.getChildCount();i++)
        {
            ((ImageView)mygrid.getChildAt(i)).setImageResource(0);
        }

    }

}
