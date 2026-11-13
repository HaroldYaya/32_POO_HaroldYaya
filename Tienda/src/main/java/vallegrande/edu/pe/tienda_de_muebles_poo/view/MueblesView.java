package vallegrande.edu.pe.tienda_de_muebles_poo.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import vallegrande.edu.pe.tienda_de_muebles_poo.model.Muebles;
import vallegrande.edu.pe.tienda_de_muebles_poo.controller.MueblesController;

public class MueblesView extends Application {

    private BorderPane principal;
    private final MueblesController controlador = new MueblesController();

    private Label titulo;
    private VBox contenido;

    @Override
    public void start(Stage stage) {

        principal = new BorderPane();
        principal.setStyle("-fx-background-color: #F5F3EF;");

        // MENU LATERAL
        VBox menu = new VBox(15);
        menu.setPadding(new Insets(25));
        menu.setPrefWidth(230);
        menu.setStyle("-fx-background-color: #302820;");

        Label logo = new Label("MUEBLES");
        logo.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label subtitulo = new Label("SISTEMA DE GESTIÓN");
        subtitulo.setStyle("-fx-text-fill: #C9B9A5; -fx-font-size: 10px;");

        Label menuTitulo = new Label("MENÚ PRINCIPAL");
        menuTitulo.setStyle("-fx-text-fill: #B8A995; -fx-font-size: 11px;");

        Button btnInicio = crearBoton("⌂   Inicio");
        Button btnMuebles = crearBoton("▣   Muebles");

        Region espacio = new Region();
        VBox.setVgrow(espacio, Priority.ALWAYS);

        Label pieMenu = new Label("Tienda de Muebles © 2026");
        pieMenu.setStyle("-fx-text-fill: #B8A995; -fx-font-size: 10px;");

        menu.getChildren().addAll(
                logo, subtitulo, menuTitulo,
                btnInicio, btnMuebles,
                espacio, pieMenu
        );

        // ENCABEZADO
        HBox encabezado = new HBox();
        encabezado.setPadding(new Insets(20, 30, 20, 30));
        encabezado.setAlignment(Pos.CENTER_LEFT);
        encabezado.setStyle("-fx-background-color: white;");

        titulo = new Label("Panel principal");
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #302820;");

        Region espacioTitulo = new Region();
        HBox.setHgrow(espacioTitulo, Priority.ALWAYS);

        Label usuario = new Label("Administrador");
        usuario.setStyle("-fx-font-size: 14px; -fx-text-fill: #66594B;");

        encabezado.getChildren().addAll(titulo, espacioTitulo, usuario);

        // CONTENIDO
        contenido = new VBox(22);
        contenido.setPadding(new Insets(30));

        principal.setLeft(menu);
        principal.setTop(encabezado);
        principal.setCenter(contenido);

        mostrarInicio();

        // ACCIONES DEL MENU
        btnInicio.setOnAction(e -> mostrarInicio());

        btnMuebles.setOnAction(e -> {
            titulo.setText("Gestión de muebles");
            mostrarMuebles();
        });

        Scene scene = new Scene(principal, 1100, 700);

        stage.setTitle("Sistema de Gestión - Tienda de Muebles");
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
    }

    private String contarMuebles() {
        try {
            return String.valueOf(controlador.listarMuebles().size());
        } catch (RuntimeException ex) {
            return "—";
        }
    }

    // PANEL DE INICIO
    private void mostrarInicio() {

        titulo.setText("Panel principal");

        VBox panel = new VBox(22);

        Label bienvenida = new Label("¡Bienvenido al sistema!");
        bienvenida.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #302820;");

        Label descripcion = new Label(
                "Administra tus muebles, clientes y ventas desde un solo lugar."
        );
        descripcion.setStyle("-fx-font-size: 14px; -fx-text-fill: #77716A;");

        GridPane tarjetas = new GridPane();
        tarjetas.setHgap(18);
        tarjetas.setVgap(18);

        tarjetas.add(crearTarjeta(
                "MUEBLES REGISTRADOS",
                contarMuebles(),
                "Inventario actual"
        ), 0, 0);

        VBox panelInferior = new VBox(12);
        panelInferior.setPadding(new Insets(22));
        panelInferior.setStyle("-fx-background-color: white; -fx-background-radius: 12;");

        Label tituloActividad = new Label("Actividad del sistema");
        tituloActividad.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #302820;");

        Label mensaje = new Label(
                "Conectado a MySQL. Ve a Muebles para gestionar el inventario."
        );
        mensaje.setStyle("-fx-text-fill: #77716A; -fx-font-size: 13px;");

        panelInferior.getChildren().addAll(tituloActividad, mensaje);

        panel.getChildren().addAll(
                bienvenida, descripcion, tarjetas, panelInferior
        );

        contenido.getChildren().setAll(panel);
    }

    // GESTION DE MUEBLES (CRUD con MySQL)
    private void mostrarMuebles() {

        VBox panel = new VBox(18);
        panel.setPadding(new Insets(22));
        panel.setStyle("-fx-background-color: white; -fx-background-radius: 12;");

        Label subtitulo = new Label("Registro de muebles");
        subtitulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField txtId = new TextField();
        txtId.setPromptText("Automático");
        txtId.setEditable(false);

        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre del mueble");
        TextField txtCategoria = new TextField();
        txtCategoria.setPromptText("Categoría");
        TextField txtMaterial = new TextField();
        txtMaterial.setPromptText("Material");
        TextField txtColor = new TextField();
        txtColor.setPromptText("Color");
        TextField txtDimensiones = new TextField();
        txtDimensiones.setPromptText("Ej: 120x60x75 cm");
        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");
        TextField txtStock = new TextField();
        txtStock.setPromptText("Stock");

        TextField[] campos = {txtId, txtNombre, txtCategoria, txtMaterial,
                txtColor, txtDimensiones, txtPrecio, txtStock};

        GridPane formulario = new GridPane();
        formulario.setHgap(12);
        formulario.setVgap(12);

        formulario.add(new Label("ID:"), 0, 0);
        formulario.add(txtId, 1, 0);
        formulario.add(new Label("Nombre:"), 2, 0);
        formulario.add(txtNombre, 3, 0);
        formulario.add(new Label("Categoría:"), 4, 0);
        formulario.add(txtCategoria, 5, 0);

        formulario.add(new Label("Material:"), 0, 1);
        formulario.add(txtMaterial, 1, 1);
        formulario.add(new Label("Color:"), 2, 1);
        formulario.add(txtColor, 3, 1);
        formulario.add(new Label("Dimensiones:"), 4, 1);
        formulario.add(txtDimensiones, 5, 1);

        formulario.add(new Label("Precio:"), 0, 2);
        formulario.add(txtPrecio, 1, 2);
        formulario.add(new Label("Stock:"), 2, 2);
        formulario.add(txtStock, 3, 2);

        // TABLA
        TableView<Muebles> tabla = new TableView<>();
        tabla.getColumns().addAll(
                columna("ID", "id"),
                columna("Nombre", "nombre"),
                columna("Categoría", "categoria"),
                columna("Material", "material"),
                columna("Color", "color"),
                columna("Dimensiones", "dimensiones"),
                columna("Precio", "precio"),
                columna("Stock", "stock"));
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Runnable refrescar = () -> {
            try {
                tabla.setItems(controlador.listarMuebles());
            } catch (RuntimeException ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de base de datos", ex.getMessage());
            }
        };
        refrescar.run();

        Button btnRegistrar = crearBoton("Registrar");
        Button btnActualizar = crearBoton("Actualizar");
        Button btnEliminar = crearBoton("Eliminar");
        Button btnLimpiar = crearBoton("Limpiar");

        btnRegistrar.setStyle("-fx-background-color: #526B45; -fx-text-fill: white;");
        btnActualizar.setStyle("-fx-background-color: #8B6846; -fx-text-fill: white;");
        btnEliminar.setStyle("-fx-background-color: #A94442; -fx-text-fill: white;");
        btnLimpiar.setStyle("-fx-background-color: #77716A; -fx-text-fill: white;");

        HBox botones = new HBox(12, btnRegistrar, btnActualizar, btnEliminar, btnLimpiar);

        btnLimpiar.setOnAction(e -> {
            limpiar(campos);
            tabla.getSelectionModel().clearSelection();
        });

        // SELECCIONAR FILA -> llena el formulario
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, ant, sel) -> {
            if (sel != null) {
                txtId.setText(String.valueOf(sel.getId()));
                txtNombre.setText(sel.getNombre());
                txtCategoria.setText(sel.getCategoria());
                txtMaterial.setText(sel.getMaterial());
                txtColor.setText(sel.getColor());
                txtDimensiones.setText(sel.getDimensiones());
                txtPrecio.setText(String.valueOf(sel.getPrecio()));
                txtStock.setText(String.valueOf(sel.getStock()));
            }
        });

        // REGISTRAR
        btnRegistrar.setOnAction(e -> {
            try {
                Muebles m = leerFormulario(0, txtNombre, txtCategoria, txtMaterial,
                        txtColor, txtDimensiones, txtPrecio, txtStock);
                controlador.registrarMueble(m);
                refrescar.run();
                limpiar(campos);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Mueble registrado correctamente.");
            } catch (NumberFormatException ex) {
                mostrarAlerta(Alert.AlertType.WARNING, "Validación", "Precio y stock deben ser números válidos.");
            } catch (IllegalArgumentException ex) {
                mostrarAlerta(Alert.AlertType.WARNING, "Validación", ex.getMessage());
            } catch (RuntimeException ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de base de datos", ex.getMessage());
            }
        });

        // ACTUALIZAR
        btnActualizar.setOnAction(e -> {
            if (txtId.getText().isBlank()) {
                mostrarAlerta(Alert.AlertType.WARNING, "Aviso", "Selecciona un mueble de la tabla.");
                return;
            }
            try {
                Muebles m = leerFormulario(Integer.parseInt(txtId.getText()), txtNombre, txtCategoria,
                        txtMaterial, txtColor, txtDimensiones, txtPrecio, txtStock);
                controlador.actualizarMueble(m);
                refrescar.run();
                limpiar(campos);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Mueble actualizado correctamente.");
            } catch (NumberFormatException ex) {
                mostrarAlerta(Alert.AlertType.WARNING, "Validación", "Precio y stock deben ser números válidos.");
            } catch (IllegalArgumentException ex) {
                mostrarAlerta(Alert.AlertType.WARNING, "Validación", ex.getMessage());
            } catch (RuntimeException ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de base de datos", ex.getMessage());
            }
        });

        // ELIMINAR (con confirmación)
        btnEliminar.setOnAction(e -> {
            Muebles sel = tabla.getSelectionModel().getSelectedItem();
            if (sel == null) {
                mostrarAlerta(Alert.AlertType.WARNING, "Aviso", "Selecciona un mueble de la tabla.");
                return;
            }
            Alert conf = new Alert(Alert.AlertType.CONFIRMATION,
                    "¿Eliminar \"" + sel.getNombre() + "\"?", ButtonType.YES, ButtonType.NO);
            conf.setHeaderText(null);
            if (conf.showAndWait().orElse(ButtonType.NO) != ButtonType.YES) return;
            try {
                controlador.eliminarMueble(sel.getId());
                refrescar.run();
                limpiar(campos);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Mueble eliminado correctamente.");
            } catch (RuntimeException ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de base de datos", ex.getMessage());
            }
        });

        Label tituloTabla = new Label("Inventario de muebles");
        tituloTabla.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        VBox.setVgrow(tabla, Priority.ALWAYS);
        panel.getChildren().addAll(subtitulo, formulario, botones, tituloTabla, tabla);
        VBox.setVgrow(panel, Priority.ALWAYS);
        contenido.getChildren().setAll(panel);
    }

    // Lee y valida el formulario
    private Muebles leerFormulario(int id, TextField nombre, TextField categoria, TextField material,
                                   TextField color, TextField dimensiones, TextField precio,
                                   TextField stock) {
        String n = nombre.getText().trim();
        String c = categoria.getText().trim();
        String mat = material.getText().trim();
        String col = color.getText().trim();
        String dim = dimensiones.getText().trim();

        if (n.isEmpty() || c.isEmpty() || mat.isEmpty() || col.isEmpty() || dim.isEmpty()
                || precio.getText().isBlank() || stock.getText().isBlank()) {
            throw new IllegalArgumentException("Completa todos los campos.");
        }
        double p = Double.parseDouble(precio.getText().trim());
        int s = Integer.parseInt(stock.getText().trim());
        if (p <= 0) throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        if (s < 0) throw new IllegalArgumentException("El stock no puede ser negativo.");
        return new Muebles(id, n, c, mat, col, dim, p, s);
    }

    private <T> TableColumn<Muebles, T> columna(String titulo, String propiedad) {
        TableColumn<Muebles, T> col = new TableColumn<>(titulo);
        col.setCellValueFactory(new PropertyValueFactory<>(propiedad));
        return col;
    }

    // CREAR BOTONES
    private Button crearBoton(String texto) {

        Button boton = new Button(texto);

        boton.setMaxWidth(Double.MAX_VALUE);
        boton.setAlignment(Pos.CENTER_LEFT);
        boton.setPadding(new Insets(12));

        boton.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-cursor: hand;"
        );

        return boton;
    }

    // CREAR TARJETAS
    private VBox crearTarjeta(
            String titulo,
            String numero,
            String descripcion
    ) {

        VBox tarjeta = new VBox(12);
        tarjeta.setPadding(new Insets(20));
        tarjeta.setPrefWidth(240);
        tarjeta.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;"
        );

        Label nombre = new Label(titulo);
        nombre.setStyle(
                "-fx-font-size: 11px;" +
                        "-fx-text-fill: #82796F;" +
                        "-fx-font-weight: bold;"
        );

        Label cantidad = new Label(numero);
        cantidad.setStyle(
                "-fx-font-size: 30px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #8B6846;"
        );

        Label detalle = new Label(descripcion);
        detalle.setStyle("-fx-font-size: 12px; -fx-text-fill: #77716A;");

        tarjeta.getChildren().addAll(nombre, cantidad, detalle);

        return tarjeta;
    }

    // LIMPIAR CAMPOS
    private void limpiar(TextField... campos) {

        for (TextField campo : campos) {
            campo.clear();
        }
    }

    // ALERTAS
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}