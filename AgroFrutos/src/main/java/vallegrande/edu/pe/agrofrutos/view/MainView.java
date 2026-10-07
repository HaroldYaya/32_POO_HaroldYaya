package vallegrande.edu.pe.agrofrutoslambayeque.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

import vallegrande.edu.pe.agrofrutoslambayeque.controller.MainController;
import vallegrande.edu.pe.agrofrutoslambayeque.model.Contacto;

public class MainView extends Application {

    // ==========================================
    // COLORES Y ESTILOS
    // ==========================================

    private static final String COLOR_MENU = "#2c3e50";
    private static final String COLOR_MENU_BTN = "#34495e";
    private static final String COLOR_MENU_HOVER = "#3d566e";
    private static final String COLOR_VERDE = "#27ae60";
    private static final String COLOR_VERDE_CLARO = "#2ecc71";
    private static final String COLOR_VERDE_HOVER = "#1e8449";
    private static final String COLOR_FONDO = "#f4f6f8";

    private static final String ESTILO_CAMPO =
            "-fx-background-radius: 6;" +
                    "-fx-border-color: #d0d7de;" +
                    "-fx-border-radius: 6;" +
                    "-fx-padding: 8 10;" +
                    "-fx-font-size: 13px;";

    // NUEVO: estilos de las tarjetas de contacto
    private static final String ESTILO_CARD =
            "-fx-background-color: white;" +
                    "-fx-background-radius: 8;" +
                    "-fx-border-color: #e1e5ea #e1e5ea #e1e5ea " + COLOR_VERDE + ";" +
                    "-fx-border-width: 1 1 1 5;" +
                    "-fx-border-radius: 8;" +
                    "-fx-cursor: hand;";

    private static final String ESTILO_CARD_SELECCIONADA =
            "-fx-background-color: #eafaf1;" +
                    "-fx-background-radius: 8;" +
                    "-fx-border-color: " + COLOR_VERDE + ";" +
                    "-fx-border-width: 2 2 2 5;" +
                    "-fx-border-radius: 8;" +
                    "-fx-cursor: hand;";

    private Button btnInicio;
    private Button btnContactos;
    private Button botonActivo;
    private VBox contenedorCards;
    private BorderPane root;

    // Formulario de registro
    private final TextField txtNombre = new TextField();
    private final TextField txtApellido = new TextField();
    private final TextField txtTelefono = new TextField();
    private final TextField txtCorreo = new TextField();
    private final TextArea txtMensaje = new TextArea();
    private final Button btnRegistrar = new Button("Registrar contacto");

    // NUEVO: botones y selección
    private final Button btnActualizar = new Button("Actualizar");
    private final Button btnEliminar = new Button("Eliminar");
    private Contacto contactoSeleccionado;
    private VBox cardSeleccionada;

    @Override
    public void start(Stage stage) {

        root = new BorderPane();
        root.setStyle("-fx-background-color: " + COLOR_FONDO + ";");

        // ==========================================
        // 1. BARRA LATERAL - MENÚ
        // ==========================================

        VBox menuLateral = new VBox(12);

        menuLateral.setPadding(new Insets(25, 20, 20, 20));
        menuLateral.setPrefWidth(230);
        menuLateral.setStyle("-fx-background-color: " + COLOR_MENU + ";");

        Label marca = new Label("AGROFRUTOS");
        marca.setStyle(
                "-fx-font-size: 22px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        Label submarca = new Label("LAMBAYEQUE");
        submarca.setStyle(
                "-fx-font-size: 12px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: " + COLOR_VERDE_CLARO + ";"
        );

        VBox encabezado = new VBox(2, marca, submarca);
        encabezado.setPadding(new Insets(0, 0, 15, 0));

        Region linea = new Region();
        linea.setPrefHeight(1);
        linea.setStyle("-fx-background-color: #46607a;");

        Label seccion = new Label("MENÚ");
        seccion.setPadding(new Insets(10, 0, 0, 0));
        seccion.setStyle(
                "-fx-font-size: 11px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #8fa3b8;"
        );

        btnInicio = crearBotonMenu("Inicio");
        btnContactos = crearBotonMenu("Contactos");

        menuLateral.getChildren().addAll(
                encabezado,
                linea,
                seccion,
                btnInicio,
                btnContactos
        );

        root.setLeft(menuLateral);

        // ==========================================
        // 2. CONTENEDOR Y FORMULARIO
        // ==========================================

        contenedorCards = new VBox(18);
        contenedorCards.setPadding(new Insets(25));
        contenedorCards.setStyle("-fx-background-color: " + COLOR_FONDO + ";");

        configurarFormulario();

        mostrarInicio();

        // ==========================================
        // 3. CONTROLADOR
        // ==========================================

        new MainController(this);

        // ==========================================
        // 4. ESCENA
        // ==========================================

        Scene scene = new Scene(root, 950, 650);

        stage.setTitle("AGROFRUTOS LAMBAYEQUE");
        stage.setScene(scene);
        stage.show();
    }

    // ==========================================
    // CONFIGURAR CAMPOS DEL FORMULARIO
    // ==========================================

    private void configurarFormulario() {

        txtNombre.setPromptText("Ej: Juan");
        txtApellido.setPromptText("Ej: Perez");
        txtTelefono.setPromptText("Ej: 987654321");
        txtCorreo.setPromptText("Ej: juan@gmail.com");
        txtMensaje.setPromptText("Escribe tu mensaje...");

        txtNombre.setStyle(ESTILO_CAMPO);
        txtApellido.setStyle(ESTILO_CAMPO);
        txtTelefono.setStyle(ESTILO_CAMPO);
        txtCorreo.setStyle(ESTILO_CAMPO);

        txtMensaje.setStyle(
                "-fx-background-radius: 6;" +
                        "-fx-border-color: #d0d7de;" +
                        "-fx-border-radius: 6;" +
                        "-fx-font-size: 13px;"
        );
        txtMensaje.setPrefRowCount(3);
        txtMensaje.setWrapText(true);

        estilizarBoton(btnRegistrar, COLOR_VERDE, COLOR_VERDE_HOVER);
        estilizarBoton(btnActualizar, "#2980b9", "#1f6391");   // NUEVO
        estilizarBoton(btnEliminar, "#c0392b", "#922b21");     // NUEVO
    }

    // NUEVO: estilo reutilizable para los botones del formulario
    private void estilizarBoton(Button btn, String color, String hover) {

        String base =
                "-fx-background-color: " + color + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;" +
                        "-fx-background-radius: 6;" +
                        "-fx-padding: 10 24;";

        String over = base.replace(color, hover);

        btn.setStyle(base);
        btn.setOnMouseEntered(e -> btn.setStyle(over));
        btn.setOnMouseExited(e -> btn.setStyle(base));
    }

    // ==========================================
    // CAMPO CON ETIQUETA ARRIBA
    // ==========================================

    private VBox campo(String etiqueta, Control control) {

        Label lbl = new Label(etiqueta);
        lbl.setStyle(
                "-fx-font-size: 12px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #555555;"
        );

        control.setMaxWidth(Double.MAX_VALUE);

        return new VBox(5, lbl, control);
    }

    // ==========================================
    // TARJETA DEL FORMULARIO
    // ==========================================

    private VBox crearTarjetaFormulario() {

        Label tituloForm = new Label("Registrar nuevo contacto");
        tituloForm.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: " + COLOR_MENU + ";"
        );

        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(12);

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col, col);

        grid.add(campo("Nombre", txtNombre), 0, 0);
        grid.add(campo("Apellido", txtApellido), 1, 0);
        grid.add(campo("Teléfono", txtTelefono), 0, 1);
        grid.add(campo("Correo", txtCorreo), 1, 1);
        grid.add(campo("Mensaje", txtMensaje), 0, 2, 2, 1);

        // CAMBIO: ahora lleva los 3 botones en fila
        HBox zonaBoton = new HBox(10, btnRegistrar, btnActualizar, btnEliminar);
        zonaBoton.setAlignment(Pos.CENTER_RIGHT);

        VBox tarjeta = new VBox(15, tituloForm, grid, zonaBoton);
        tarjeta.setPadding(new Insets(20));
        tarjeta.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-color: #e1e5ea;" +
                        "-fx-border-radius: 10;"
        );

        return tarjeta;
    }

    // ==========================================
    // BOTONES DEL MENÚ (con estado activo)
    // ==========================================

    private Button crearBotonMenu(String texto) {

        Button btn = new Button(texto);

        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setPrefHeight(42);
        btn.setAlignment(Pos.CENTER_LEFT);

        aplicarEstiloBoton(btn, false);

        btn.setOnMouseEntered(e -> aplicarEstiloBoton(btn, true));
        btn.setOnMouseExited(e -> aplicarEstiloBoton(btn, false));

        return btn;
    }

    private void aplicarEstiloBoton(Button btn, boolean hover) {

        boolean activo = (btn == botonActivo);

        String fondo = activo
                ? COLOR_VERDE
                : (hover ? COLOR_MENU_HOVER : COLOR_MENU_BTN);

        btn.setStyle(
                "-fx-background-color: " + fondo + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: " + (activo ? "bold" : "normal") + ";" +
                        "-fx-cursor: hand;" +
                        "-fx-background-radius: 6;" +
                        "-fx-padding: 0 15;"
        );
    }

    private void marcarActivo(Button activo) {
        botonActivo = activo;
        aplicarEstiloBoton(btnInicio, false);
        aplicarEstiloBoton(btnContactos, false);
    }

    // ==========================================
    // MOSTRAR INICIO
    // ==========================================

    public void mostrarInicio() {

        marcarActivo(btnInicio);

        // ---------- Banner de bienvenida ----------

        Label titulo = new Label("Bienvenido a Agrofrutos Lambayeque");
        titulo.setWrapText(true);
        titulo.setStyle(
                "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        Label subtitulo = new Label(
                "Gestiona los contactos que llegan desde la página web de la cooperativa."
        );
        subtitulo.setWrapText(true);
        subtitulo.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-text-fill: #e8f8ee;"
        );

        Button btnIr = new Button("Ver contactos");
        String estiloIr =
                "-fx-background-color: white;" +
                        "-fx-text-fill: " + COLOR_VERDE_HOVER + ";" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;" +
                        "-fx-background-radius: 6;" +
                        "-fx-padding: 10 22;";
        btnIr.setStyle(estiloIr);
        btnIr.setOnAction(e -> btnContactos.fire());

        VBox banner = new VBox(10, titulo, subtitulo, btnIr);
        banner.setPadding(new Insets(30));
        banner.setStyle(
                "-fx-background-color: linear-gradient(to right, " +
                        COLOR_VERDE + ", " + COLOR_VERDE_HOVER + ");" +
                        "-fx-background-radius: 12;"
        );

        // ---------- Tarjetas informativas ----------

        Label seccion = new Label("¿Qué puedes hacer aquí?");
        seccion.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #555555;"
        );

        HBox tarjetas = new HBox(
                15,
                crearTarjetaInfo(
                        "Registrar contactos",
                        "Agrega nuevos contactos con nombre, teléfono, correo y mensaje."
                ),
                crearTarjetaInfo(
                        "Consultar mensajes",
                        "Revisa las consultas y pedidos que dejan los clientes."
                ),
                crearTarjetaInfo(
                        "Datos sincronizados",
                        "Toda la información se guarda en la misma base de datos de la web."
                )
        );

        VBox inicioBox = new VBox(22, banner, seccion, tarjetas);
        inicioBox.setPadding(new Insets(25));
        inicioBox.setStyle("-fx-background-color: " + COLOR_FONDO + ";");

        root.setCenter(inicioBox);
    }

    private VBox crearTarjetaInfo(String titulo, String descripcion) {

        Label lblTitulo = new Label(titulo);
        lblTitulo.setStyle(
                "-fx-font-weight: bold;" +
                        "-fx-font-size: 16px;" +
                        "-fx-text-fill: #111111;"
        );

        Label lblDesc = new Label(descripcion);
        lblDesc.setWrapText(true);
        lblDesc.setStyle(
                "-fx-font-size: 13px;" +
                        "-fx-text-fill: #666666;"
        );

        VBox card = new VBox(8, lblTitulo, lblDesc);
        card.setPadding(new Insets(18, 15, 18, 18));
        card.setMaxWidth(Double.MAX_VALUE);
        card.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-color: #e1e5ea #e1e5ea #e1e5ea " + COLOR_VERDE + ";" +
                        "-fx-border-width: 1 1 1 5;" +
                        "-fx-border-radius: 8;"
        );

        HBox.setHgrow(card, Priority.ALWAYS);

        return card;
    }

    // ==========================================
    // MOSTRAR CONTACTOS (formulario + tarjetas)
    // ==========================================

    public void mostrarContactos(List<Contacto> lista) {

        marcarActivo(btnContactos);

        // NUEVO: al recargar la lista no queda nada seleccionado
        contactoSeleccionado = null;
        cardSeleccionada = null;

        contenedorCards.getChildren().clear();

        Label titulo = new Label(
                "Contactos Agrofrutos"
        );

        titulo.setStyle(
                "-fx-font-size: 26px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: " + COLOR_MENU + ";"
        );

        contenedorCards.getChildren().addAll(
                titulo,
                crearTarjetaFormulario()
        );

        Label subtitulo = new Label(
                "Contactos registrados (" + lista.size() + ")"
        );

        subtitulo.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #555555;"
        );

        contenedorCards.getChildren().add(subtitulo);

        // ==========================================
        // RECORRER LOS CONTACTOS
        // ==========================================

        for (Contacto c : lista) {

            VBox card = new VBox(6);

            card.setPadding(new Insets(15, 15, 15, 18));

            card.setStyle(ESTILO_CARD);   // CAMBIO

            Label nombre = new Label(
                    c.getNombre() + " " + c.getApellido()
            );

            nombre.setStyle(
                    "-fx-font-weight: bold;" +
                            "-fx-font-size: 16px;" +
                            "-fx-text-fill: #111111;"
            );

            Label datos = new Label(
                    "Tel: " + c.getTelefono() +
                            " | Correo: " + c.getCorreo()
            );

            datos.setStyle(
                    "-fx-font-size: 13px;" +
                            "-fx-text-fill: #333333;"
            );

            Label msg = new Label(
                    "Mensaje: " + c.getMensaje()
            );

            msg.setWrapText(true);
            msg.setStyle(
                    "-fx-font-size: 13px;" +
                            "-fx-text-fill: #666666;"
            );

            card.getChildren().addAll(
                    nombre,
                    datos,
                    msg
            );

            // NUEVO: clic en la tarjeta = seleccionar y llenar el formulario
            card.setOnMouseClicked(e -> {
                if (cardSeleccionada != null) {
                    cardSeleccionada.setStyle(ESTILO_CARD);
                }
                cardSeleccionada = card;
                card.setStyle(ESTILO_CARD_SELECCIONADA);
                contactoSeleccionado = c;

                txtNombre.setText(c.getNombre());
                txtApellido.setText(c.getApellido());
                txtTelefono.setText(c.getTelefono());
                txtCorreo.setText(c.getCorreo());
                txtMensaje.setText(c.getMensaje());
            });

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
                        "-fx-background: " + COLOR_FONDO + ";"
        );

        root.setCenter(scrollPane);
    }

    // ==========================================
    // FORMULARIO
    // ==========================================

    public Contacto leerFormulario() {

        Contacto c = new Contacto();

        c.setNombre(txtNombre.getText().trim());
        c.setApellido(txtApellido.getText().trim());
        c.setTelefono(txtTelefono.getText().trim());
        c.setCorreo(txtCorreo.getText().trim());
        c.setMensaje(txtMensaje.getText().trim());

        return c;
    }

    public void limpiarFormulario() {
        txtNombre.clear();
        txtApellido.clear();
        txtTelefono.clear();
        txtCorreo.clear();
        txtMensaje.clear();

        // NUEVO
        contactoSeleccionado = null;
        cardSeleccionada = null;
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

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    // NUEVOS
    public Button getBtnActualizar() {
        return btnActualizar;
    }

    public Button getBtnEliminar() {
        return btnEliminar;
    }

    public Contacto getContactoSeleccionado() {
        return contactoSeleccionado;
    }
}