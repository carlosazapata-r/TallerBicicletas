module com.tallerbicicletas.tallerbicicletas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.tallerbicicletas to javafx.fxml;
    exports com.tallerbicicletas;
}