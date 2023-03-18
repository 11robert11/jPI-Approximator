package com.example.piaprox.gui;

import java.text.DecimalFormat;

import static com.example.piaprox.calculate.Calculate.*;
import static com.example.piaprox.gui.HelloController.instance;
public class Update implements Runnable {
    @Override
    public void run() {
        instance.iterations.setText("Iterations: " + String.valueOf(iterations));
        instance.running.setText("Calculator: " + String.valueOf(running));
        instance.piApprox.setText(String.valueOf(new DecimalFormat("#0.0000000000000000").format(PI)));
        instance.polygonSides.setText("Polygon Sides: " + String.valueOf(polygonSides));
    }
}
