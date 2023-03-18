package com.example.piaprox.calculate;

import java.math.BigDecimal;

public class Calculate  {
    protected static String[] args;
     public static boolean running;

     public static double trigPrecision = Double.MIN_VALUE;
     public static double sinTerm = 0;
     public static short sinSign = 1;
     public static double sinus = 0;

     public static long polygonSides = 32;



    public static double PI = 3d;
    public static double iterations = 0;
    /*
    All state is protected
     */
    public static void main(String[] args) throws InterruptedException {


        System.out.println("Running");
        running = true;

        while (running) {
            for (int i = 0; i < 10; i++) {
                PI = ((sideLength((long) polygonSides) * polygonSides) / 2f);
                iterations++;
            }
            polygonSides+= (long) (iterations/10);
            Thread.sleep(0, 1);
        }
        System.out.println("~~");
    }
    public static double sin(double radians)  {
        int n = 1;
        //sin = o/h
        sinTerm = radians;
        sinus = 0f;
        sinSign = 1;
        while (sinTerm > trigPrecision) {
            sinus += sinSign*sinTerm;
            sinSign = (short) -sinSign;
            sinTerm *= sqr(radians) / (n + 1) / (n + 2);
            n+=2;
        }
        return sinus;
    }

    public static double cos(double radians)  {
        return sin(radians + PI/2d);
    }
    public static double tan(double radians)  {
        return sin(radians)/cos(radians);
    }
    public static double sqr(double num)  {
        return num * num;
    }
    public static double sideLength(long n)   {
        return 2 * (tan(PI / n ));
    }


}
