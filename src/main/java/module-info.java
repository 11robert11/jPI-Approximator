module com.example.piaprox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.piaprox to javafx.fxml;
    exports com.example.piaprox;
    exports com.example.piaprox.gui;
    exports com.example.piaprox.calculate;
    opens com.example.piaprox.gui to javafx.fxml;

}
