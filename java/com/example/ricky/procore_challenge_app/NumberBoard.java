package com.example.ricky.procore_challenge_app;

import android.graphics.Rect;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;

import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;

import android.content.Context;


import java.util.ArrayList;

/**
 * Created by Eric on 5/10/2015.
 */
public class NumberBoard{

    int sizeOfBoard;  // Length of board, or integer square root of number
    int Leftover; // Leftover = number - Root^2
    int square;
    int numPrimes; // Total number of prime numbers found
    Paint black = new Paint();
    Paint green = new Paint();
    Paint red = new Paint();
    Paint gray = new Paint();
    Rect primeRect = new Rect();
    ArrayList<ArrayList<NumberSquare>> board;
    ArrayList<Integer> ListOfPrimes;


    // Constructor for Number Board
    public NumberBoard(int number){
        board = new ArrayList<ArrayList<NumberSquare>>(number);
        ListOfPrimes = new ArrayList<Integer>(0);
        sizeOfBoard = (int) Math.sqrt(number);
        Leftover = number - sizeOfBoard^2;

    }

    // Draw Number Board

    protected void onDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int squareLength = width/sizeOfBoard; // Length of each number square
        black.setColor(Color.BLACK);
        green.setColor(Color.rgb(0,153,0)); // DARK GREEN
        red.setColor(Color.rgb(220,20,60)); // CRIMSON RED
        gray.setColor(Color.rgb(192,192,192)); // LIGHT GRAY

        // Draw Board
        // ASSUMING HEIGHT IS GREATER THAN WIDTH
        int extraSpace = (height -  width) / 2; // Extra space above and under board
        new Rect(0,extraSpace,squareLength,extraSpace+squareLength);
        canvas.drawRect(primeRect, green);
    }


    public void findPrimes(int number){
        // The Sieve of Eratosthenes Algorithm

        boolean[] isComposite = new boolean[number + 1];
        for (int m = 2; m <= sizeOfBoard; m++) {
            if (!isComposite[m]) {
                //System.out.print(m + " ");
                ListOfPrimes.add(m);
                for (int k = m * m; k <= number; k += m)
                    isComposite[k] = true;
            }
        }
        for (int m = sizeOfBoard; m <= number; m++)
            if (!isComposite[m])
                //System.out.print(m + " ");
                ListOfPrimes.add(m);


    }



}