module com.tallerbicicletas.tallerbicicletas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tallerbicicletas to javafx.fxml;
    exports com.tallerbicicletas;
}