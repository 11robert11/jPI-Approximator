package com.example.piaprox.gui;

import com.example.piaprox.calculate.CalculateRunHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    public static HelloController instance = null;
    @FXML
    protected Button startStopCalculator;
    @FXML
    protected Label piApprox;
    @FXML
    protected Label iterations;
    @FXML
    protected Label running;
    @FXML
    protected Label polygonSides;


    @FXML
    protected void startStopCalculatorCallback() {
        switch (CalculateRunHelper.getRunningState())   {
            case STOPPED -> CalculateRunHelper.start();
            case RUNNING -> CalculateRunHelper.stop();
            default -> {}
        }
    }
    /*
    void updateToggleCalculate() {
        switch (CalculateProxy.getRunningState()) {
            case RUNNING -> {
                //startStopCalculator.setStyle("-fx-background-color: red; ");
                startStopCalculator.setText("Stop Calculate");
            }
            case STOPPED -> {
                //startStopCalculator.setStyle("-fx-background-color: green; ");
                startStopCalculator.setText("Start Calculate");
            }
            case THREAD_LOOPSTATE_MISMATCH -> {
                //startStopCalculator.setStyle("-fx-background-color: yellow; ");
                startStopCalculator.setText("?????");
            }
        }
    }

     */
    public HelloController()    {
        instance = this;
    }

}