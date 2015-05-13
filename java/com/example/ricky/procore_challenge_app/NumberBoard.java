package com.example.ricky.procore_challenge_app;

import android.graphics.Rect;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by Eric on 5/10/2015.
 */
public class NumberBoard extends View{
    // Declare variables
    int Root;
    int Leftover;
    int square;
    Paint black = new Paint();
    Paint green = new Paint();
    Paint red = new Paint();
    Paint gray = new Paint();
    ArrayList<ArrayList<NumberSquare>> board;
    ArrayList<Integer> ListOfPrimes;


    // Constructor for Number Board
    public NumberBoard(int number) {
        board = new ArrayList<ArrayList<NumberSquare>>(number);
        ListOfPrimes = new ArrayList<Integer>(0);

        // The Sieve of Eratosthenes Algorithm
        Root = (int) Math.sqrt(number);
        Leftover = number - Root^2;
        boolean[] isComposite = new boolean[number + 1];
        for (int m = 2; m <= Root; m++) {
            if (!isComposite[m]) {
                //System.out.print(m + " ");
                ListOfPrimes.add(m);
                for (int k = m * m; k <= number; k += m)
                    isComposite[k] = true;
            }
        }
        for (int m = Root; m <= number; m++)
            if (!isComposite[m])
                //System.out.print(m + " ");
                ListOfPrimes.add(m);
    }

    // Draw Number Board
    @Override
    protected void onDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int squareLength = width/Root; // Length of each number square
        square = width / SizeOfBoard;
        black.setColor(Color.BLACK);
        green.setColor(Color.rgb(0,153,0)); // DARK GREEN
        red.setColor(Color.rgb(220,20,60)); // CRIMSON RED
        gray.setColor(Color.rgb(192,192,192)); // LIGHT GRAY

        // Draw Board


    }
}