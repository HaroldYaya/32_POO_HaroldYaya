package vallegrande.edu.pe.agrofrutoslambayeque.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

import vallegrande.edu.pe.agrofrutoslambayeque.controller.MainController;
import vallegrande.edu.pe.agrofrutoslambayeque.model.Contacto;

public class MainView extends Application {

    private Button btnInicio;
    private Button btnContactos;
    private VBox contenedorCards;
    private BorderPane root;

    @Override
    public void start(Stage stage) {

        root = new BorderPane();

        // ==========================================
        // 1. BARRA LATERAL - MENÚ
        // ==========================================

        VBox menuLateral = new VBox(15);

        menuLateral.setPadding(new Insets(20));
        menuLateral.setPrefWidth(220);
        menuLateral.setStyle("-fx-background-color: #2c3e50;");

        btnInicio = crearBotonMenu("Agrofrutos Lambayeque");
        btnContactos = crearBotonMenu("Contactos");

        menuLateral.getChildren().addAll(
                btnInicio,
                btnContactos
        );

        root.setLeft(menuLateral);

        // ==========================================
        // 2. CONTENEDOR DE TARJETAS
        // ==========================================

        contenedorCards = new VBox(15);
        contenedorCards.setPadding(new Insets(25));

        mostrarInicio();

        // ==========================================
        // 3. CONTROLADOR
        // ==========================================

        new MainController(this);

        // ==========================================
        // 4. ESCENA
        // ==========================================

        Scene scene = new Scene(root, 900, 600);

        stage.setTitle("AGROFRUTOS LAMBAYEQUE");
        stage.setScene(scene);
        stage.show();
    }

    // ==========================================
    // CREAR BOTÓN DEL MENÚ
    // ==========================================

    private Button crearBotonMenu(String texto) {

        Button btn = new Button(texto);

        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setPrefHeight(40);

        btn.setStyle(
                "-fx-background-color: #34495e;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-cursor: hand;" +
                        "-fx-background-radius: 6;"
        );

        return btn;
    }

    // ==========================================
    // MOSTRAR INICIO
    // ==========================================

    public void mostrarInicio() {

        VBox inicioBox = new VBox(10);

        inicioBox.setAlignment(Pos.CENTER);

        Label titulo = new Label(
                "Bienvenido a Agrofrutos Lambayeque"
        );

        titulo.setStyle(
                "-fx-font-size: 26px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #2c3e50;"
        );

        Label subtitulo = new Label(
                "Selecciona una opción del menú lateral para comenzar."
        );

        subtitulo.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-text-fill: #555555;"
        );

        inicioBox.getChildren().addAll(
                titulo,
                subtitulo
        );

        root.setCenter(inicioBox);
    }

    // ==========================================
    // MOSTRAR CONTACTOS
    // ==========================================

    public void mostrarContactos(List<Contacto> lista) {

        contenedorCards.getChildren().clear();

        Label titulo = new Label(
                "Contactos Agrofrutos"
        );

        titulo.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #2c3e50;"
        );

        contenedorCards.getChildren().add(titulo);

        // ==========================================
        // RECORRER LOS CONTACTOS
        // ==========================================

        for (Contacto c : lista) {

            VBox card = new VBox(6);

            card.setPadding(new Insets(15));

            card.setStyle(
                    "-fx-background-color: #eef4ff;" +
                            "-fx-background-radius: 8;" +
                            "-fx-border-color: #d0d7de;" +
                            "-fx-border-radius: 8;"
            );

            // Nombre y apellido
            Label nombre = new Label(
                    c.getNombre() + " " + c.getApellido()
            );

            nombre.setStyle(
                    "-fx-font-weight: bold;" +
                            "-fx-font-size: 16px;" +
                            "-fx-text-fill: #111111;"
            );

            // Teléfono y correo
            Label datos = new Label(
                    "Tel: " + c.getTelefono() +
                            " | Correo: " + c.getCorreo()
            );

            datos.setStyle(
                    "-fx-font-size: 13px;" +
                            "-fx-text-fill: #333333;"
            );

            // Mensaje
            Label msg = new Label(
                    "Mensaje: " + c.getMensaje()
            );

            msg.setStyle(
                    "-fx-font-size: 13px;" +
                            "-fx-text-fill: #444444;"
            );

            // Agregar datos a la tarjeta
            card.getChildren().addAll(
                    nombre,
                    datos,
                    msg
            );

            // Agregar tarjeta al contenedor
            contenedorCards.getChildren().add(card);
        }

        // ==========================================
        // SCROLL
        // ==========================================

        ScrollPane scrollPane = new ScrollPane(
                contenedorCards
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-background: #ffffff;"
        );

        root.setCenter(scrollPane);
    }

    // ==========================================
    // GETTERS PARA EL CONTROLADOR
    // ==========================================

    public Button getBtnInicio() {
        return btnInicio;
    }

    public Button getBtnContactos() {
        return btnContactos;
    }
}