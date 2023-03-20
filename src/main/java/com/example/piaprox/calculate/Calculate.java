package com.example.piaprox.calculate;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.Apint;


public class Calculate  {
    protected static String[] args;
    public static boolean running;
    public static Apfloat trigPrecision = new Apfloat(1.0e-7);
    public static Apfloat sinTerm = Apfloat.ONE;
    public static short sinSign = 1;
    public static Apfloat sinus = Apfloat.ONE;
    public static Apint polygonSides = new Apint(3200000);
    public static Apfloat PI = new Apfloat(Math.PI);
    public static long iterations = 0;
    //All state is protected
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running");
        running = true;
        while (running) {
                PI = (sideLength(polygonSides).multiply(polygonSides))  //Perimeter
                        .divide(new Apfloat(2));
                //PI = ((sideLength((long) polygonSides) * polygonSides) / 2f);
                iterations++;

            polygonSides = polygonSides.add(new Apint((long) 1e16));
            //Thread.sleep(500, 0);

        }
        System.out.println("~~");
    }
    public static Apfloat sin(Apfloat radians)  {
        return ApfloatMath.sin(radians);
        /*
        //https://math.stackexchange.com/questions/4378919/algorithm-behind-sin-function
        int n = 1;
        sinTerm = radians;
        sinus = Apcomplex.ZERO;
        sinSign = 1;

        while (sinTerm.subtract(trigPrecision)  //if sinTerm minus trigPrecision > 1 sinTerm is greater than trigPrecision
                .signum() == 1)  //aka sign of number
        {
            sinus = sinus.add(sinTerm.multiply(new Apint(sinSign))); //sinus += sinSign*sinTerm;
            sinSign = (short) -sinSign;
            sinTerm = sqr(radians).precision(100L).divide(new Apint(n+1/n+2));    //sinTerm *= sqr(radians) / (n + 1) / (n + 2);
            n+=2;
        }
        return sinus;

         */
    }
    /*
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
     */

    public static Apfloat cos(Apfloat radians)  {
        return sin(radians.add(PI.divide(new Apfloat(2))));
    }
    public static Apfloat tan(Apfloat radians)  {
        ///System.out.println(radians + " " + sin(radians) + " " + cos(radians));
        return sin(radians).divide(cos(radians));
    }
    public static Apfloat sqr(Apfloat num)  {
        return num.multiply(num);
    }
    public static Apfloat sideLength(Apint polygonSides)   {
        //System.out.println(new Apfloat(2).divide(new Apfloat(1)));
        //TODO add trig functions
        return ApfloatMath.tan(PI.divide(polygonSides).multiply(new Apint(2)));
    }
}
