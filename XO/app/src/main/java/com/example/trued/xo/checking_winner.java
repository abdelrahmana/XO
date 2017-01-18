package com.example.trued.xo;

import android.view.View;

public class checking_winner {
   public String checkwhowin()
    {
        String winner = "No one";
        int[] number_row={3,3,3,3,3,3,3,3,3};// for x or y into position to force app not overide on value
        int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}}; // winnig position
        for (int []check : winningPositions){
            if (number_row[check[0]] == number_row[check[1]] &&
                    number_row[check[1]] == number_row[check[2]] &&
                    number_row[check[0]] != 3 && number_row[check[0]] == number_row[check[2]]){
              //  gameactive = false;
                if (number_row[check[0]] == 0) {

                    winner =Game_X_O.getname;

                } else {
                    winner = "Computer";
                }

            break;

            }

        }
        return winner;
    }
}
