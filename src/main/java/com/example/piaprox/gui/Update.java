package com.example.piaprox.gui;

import org.apfloat.Apfloat;

import java.text.DecimalFormat;

import static com.example.piaprox.calculate.Calculate.*;
import static com.example.piaprox.gui.HelloController.instance;
public class Update implements Runnable {
    @Override
    public void run() {
        instance.iterations.setText("Iterations: " + String.valueOf(iterations));
        instance.running.setText("Calculator: " + String.valueOf(running));
        instance.piApprox.setText(PI.toString(true));
        instance.polygonSides.setText("Polygon Sides: " + String.valueOf(polygonSides));
        instance.piAccuracy.setText("Diffrence of approx pi: " + new Apfloat(Math.PI).subtract(PI));
    }
}
