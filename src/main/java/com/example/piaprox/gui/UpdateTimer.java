package com.example.piaprox.gui;

import com.example.piaprox.calculate.Calculate;
import javafx.application.Platform;

import java.util.TimerTask;

public class UpdateTimer extends TimerTask {

    @Override
    public void run() {
        Platform.runLater(new Update());
    }
}