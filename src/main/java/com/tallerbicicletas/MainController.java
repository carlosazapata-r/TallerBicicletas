package com.tallerbicicletas;

import com.tallerbicicletas.model.Taller;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

public class MainController {

    @FXML
    private StackPane contenidoCentral;

    private Taller taller = new Taller(1, "Taller Central", "123456");

    // ==========================
    // REGISTRAR CLIENTE
    // ==========================
    public void mostrarRegistrarCliente() {

        VBox vista = new VBox(10);
        vista.setStyle("-fx-padding: 20;");

        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        TextField txtId = new TextField();
        txtId.setPromptText("ID");

        TextField txtDireccion = new TextField();
        txtDireccion.setPromptText("Dirección");

        TextField txtTelefono = new TextField();
        txtTelefono.setPromptText("Teléfono");

        Button btnGuardar = new Button("Guardar");

        btnGuardar.setOnAction(e -> {
            taller.registrarCliente(
                    txtNombre.getText(),
                    txtId.getText(),
                    txtDireccion.getText(),
                    txtTelefono.getText()
            );
            limpiar(contenidoCentral);
        });

        vista.getChildren().addAll(
                new Label("Registrar Cliente"),
                txtNombre,
                txtId,
                txtDireccion,
                txtTelefono,
                btnGuardar
        );

        contenidoCentral.getChildren().setAll(vista);
    }

    // ==========================
    // REGISTRAR MECANICO
    // ==========================
    public void mostrarRegistrarMecanico() {

        VBox vista = new VBox(10);
        vista.setStyle("-fx-padding: 20;");

        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        TextField txtId = new TextField();
        txtId.setPromptText("ID");

        ComboBox<String> comboEspecialidad = new ComboBox<>();
        comboEspecialidad.getItems().addAll("FRENOS", "TRANSMISION", "SUSPENSION", "ELECTRICA");

        Button btnGuardar = new Button("Guardar");

        btnGuardar.setOnAction(e -> {
            taller.registrarMecanico(
                    txtId.getText(),
                    txtNombre.getText(),
                    taller,
                    com.tallerbicicletas.model.TipoEspecialidad.valueOf(
                            comboEspecialidad.getValue()
                    )
            );
        });

        vista.getChildren().addAll(
                new Label("Registrar Mecánico"),
                txtNombre,
                txtId,
                comboEspecialidad,
                btnGuardar
        );

        contenidoCentral.getChildren().setAll(vista);
    }

    // ==========================
    // HISTORIAL POR BICICLETA
    // ==========================
    public void mostrarHistorial() {

        VBox vista = new VBox(10);
        vista.setStyle("-fx-padding: 20;");

        TextField txtSerial = new TextField();
        txtSerial.setPromptText("Número de Serie");

        TableView<com.tallerbicicletas.model.Servicio> tabla = new TableView<>();

        TableColumn<com.tallerbicicletas.model.Servicio, String> colRegistro =
                new TableColumn<>("Registro");
        colRegistro.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getNumeroRegistro()
                )
        );

        TableColumn<com.tallerbicicletas.model.Servicio, String> colFecha =
                new TableColumn<>("Fecha");
        colFecha.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getFecha().toString()
                )
        );

        tabla.getColumns().addAll(colRegistro, colFecha);

        Button btnBuscar = new Button("Buscar");

        btnBuscar.setOnAction(e -> {
            tabla.getItems().setAll(
                    taller.obtenerHistorialBicicleta(txtSerial.getText())
            );
        });

        vista.getChildren().addAll(
                new Label("Historial por Bicicleta"),
                txtSerial,
                btnBuscar,
                tabla
        );

        contenidoCentral.getChildren().setAll(vista);
    }

    // ==========================
    // ORDENES POR FECHA
    // ==========================
    public void mostrarOrdenesFecha() {

        VBox vista = new VBox(10);
        vista.setStyle("-fx-padding: 20;");

        DatePicker datePicker = new DatePicker();

        TableView<com.tallerbicicletas.model.Servicio> tabla = new TableView<>();

        TableColumn<com.tallerbicicletas.model.Servicio, String> colRegistro =
                new TableColumn<>("Registro");
        colRegistro.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getNumeroRegistro()
                )
        );

        tabla.getColumns().add(colRegistro);

        Button btnBuscar = new Button("Buscar");

        btnBuscar.setOnAction(e -> {
            tabla.getItems().setAll(
                    taller.obtenerOrdenFecha(datePicker.getValue())
            );
        });

        vista.getChildren().addAll(
                new Label("Órdenes por Fecha"),
                datePicker,
                btnBuscar,
                tabla
        );

        contenidoCentral.getChildren().setAll(vista);
    }

    private void limpiar(StackPane pane) {
        pane.getChildren().clear();
    }
    @FXML
    public void mostrarRegistrarBicicleta() {

        VBox vista = new VBox(10);
        vista.setStyle("-fx-padding: 20;");

        TextField txtColor = new TextField();
        txtColor.setPromptText("Color");

        TextField txtMarca = new TextField();
        txtMarca.setPromptText("Marca");

        TextField txtSerie = new TextField();
        txtSerie.setPromptText("Número de Serie");

        TextField txtAnio = new TextField();
        txtAnio.setPromptText("Año");

        TextField txtIdCliente = new TextField();
        txtIdCliente.setPromptText("ID Cliente");

        ComboBox<com.tallerbicicletas.model.TipoBicicleta> comboTipo =
                new ComboBox<>();
        comboTipo.getItems().addAll(
                com.tallerbicicletas.model.TipoBicicleta.values()
        );

        Button btnGuardar = new Button("Guardar");

        btnGuardar.setOnAction(e -> {

            com.tallerbicicletas.model.Persona persona =
                    taller.buscarCliente(txtIdCliente.getText());

            if (persona instanceof com.tallerbicicletas.model.Cliente cliente) {

                taller.registrarBicicletas(
                        txtColor.getText(),
                        txtMarca.getText(),
                        txtSerie.getText(),
                        comboTipo.getValue(),
                        Integer.parseInt(txtAnio.getText()),
                        taller,
                        cliente
                );

                limpiar(contenidoCentral);
            } else {
                System.out.println("Cliente no encontrado.");
            }
        });

        vista.getChildren().addAll(
                new Label("Registrar Bicicleta"),
                txtColor,
                txtMarca,
                txtSerie,
                txtAnio,
                txtIdCliente,
                comboTipo,
                btnGuardar
        );

        contenidoCentral.getChildren().setAll(vista);
    }
    @FXML
    public void mostrarNuevaOrden() {

        VBox vista = new VBox(10);
        vista.setStyle("-fx-padding: 20;");

        TextField txtRegistro = new TextField();
        txtRegistro.setPromptText("Número de Registro");

        DatePicker datePicker = new DatePicker();

        TextField txtHora = new TextField();
        txtHora.setPromptText("Hora");

        TextField txtMotivo = new TextField();
        txtMotivo.setPromptText("Motivo");

        TextField txtDiagnostico = new TextField();
        txtDiagnostico.setPromptText("Diagnóstico");

        TextField txtTrabajo = new TextField();
        txtTrabajo.setPromptText("Trabajo realizado");

        TextField txtCosto = new TextField();
        txtCosto.setPromptText("Costo");

        TextField txtIdMecanico = new TextField();
        txtIdMecanico.setPromptText("ID Mecánico");

        TextField txtSerialBici = new TextField();
        txtSerialBici.setPromptText("Serial Bicicleta");

        Button btnGuardar = new Button("Crear Orden");

        btnGuardar.setOnAction(e -> {

            com.tallerbicicletas.model.Persona persona =
                    taller.buscarMecanico(txtIdMecanico.getText());

            com.tallerbicicletas.model.Bicicleta bici =
                    taller.buscarBicicleta(txtSerialBici.getText());

            if (persona instanceof com.tallerbicicletas.model.Mecanico mecanico
                    && bici != null) {

                taller.registrarOrdenServicio(
                        txtRegistro.getText(),
                        datePicker.getValue(),
                        txtHora.getText(),
                        txtMotivo.getText(),
                        txtDiagnostico.getText(),
                        txtTrabajo.getText(),
                        Double.parseDouble(txtCosto.getText()),
                        mecanico,
                        taller,
                        bici
                );

                limpiar(contenidoCentral);
            } else {
                System.out.println("Mecánico o bicicleta no encontrados.");
            }
        });

        vista.getChildren().addAll(
                new Label("Nueva Orden de Servicio"),
                txtRegistro,
                datePicker,
                txtHora,
                txtMotivo,
                txtDiagnostico,
                txtTrabajo,
                txtCosto,
                txtIdMecanico,
                txtSerialBici,
                btnGuardar
        );

        contenidoCentral.getChildren().setAll(vista);
    }
}