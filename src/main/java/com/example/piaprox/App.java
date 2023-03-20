package com.example.piaprox;

import com.example.piaprox.calculate.Calculate;
import com.example.piaprox.gui.HelloController;
import com.example.piaprox.gui.UpdateTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apfloat.Apfloat;

import java.io.IOException;
import java.util.Timer;

public class App extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        new Timer().scheduleAtFixedRate(new UpdateTimer(), 0, 1);

    }
    public static void main(String[] args)  {
        System.out.println(Calculate.sin(new Apfloat(Math.PI/2f)));
        launch(args);

    }

}
