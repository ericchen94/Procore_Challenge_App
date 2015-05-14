package com.example.ricky.procore_challenge_app;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Eric on 5/10/2015.
 */
public class NumberSquare {

    float x;
    float y;
    float length;
    public boolean isPrime = false;
    public Paint color;

    // Constructor for Square
    public NumberSquare(float x, float y, float length){
        this.x = x;
        this.y = y;
        this.length = length;
        isPrime = false;
    }

    // Chooses square, which is prime, to find multiples of that number
    // Colors the square GREEN
    public void colorGreen(){

    }

    // "Marks" square if it is not a prime
    // Colors the square RED
    public void colorRed(){

    }

}
