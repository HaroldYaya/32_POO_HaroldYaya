package vallegrande.edu.pe.agrofrutoslambayeque.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import vallegrande.edu.pe.agrofrutoslambayeque.model.Contacto;
import vallegrande.edu.pe.agrofrutoslambayeque.model.ContactoDAO;
import vallegrande.edu.pe.agrofrutoslambayeque.view.MainView;

public class MainController {

    private MainView view;
    private ContactoDAO dao;

    public MainController(MainView view) {
        this.view = view;
        this.dao = new ContactoDAO();
        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnInicio().setOnAction(
                e -> view.mostrarInicio()
        );

        view.getBtnContactos().setOnAction(
                e -> view.mostrarContactos(
                        dao.listarContactos()
                )
        );

        // ==========================================
        // REGISTRAR
        // ==========================================

        view.getBtnRegistrar().setOnAction(e -> {

            Contacto c = view.leerFormulario();

            if (camposVacios(c)) {
                new Alert(Alert.AlertType.WARNING, "Completa todos los campos").show();
                return;
            }

            if (dao.registrar(c)) {
                view.limpiarFormulario();
                view.mostrarContactos(dao.listarContactos());
            } else {
                new Alert(Alert.AlertType.ERROR, "No se pudo registrar el contacto").show();
            }
        });

        // ==========================================
        // ACTUALIZAR (NUEVO)
        // ==========================================

        view.getBtnActualizar().setOnAction(e -> {

            Contacto seleccionado = view.getContactoSeleccionado();

            if (seleccionado == null) {
                new Alert(Alert.AlertType.WARNING, "Selecciona un contacto haciendo clic en su tarjeta").show();
                return;
            }

            Contacto c = view.leerFormulario();
            c.setId(seleccionado.getId());

            if (camposVacios(c)) {
                new Alert(Alert.AlertType.WARNING, "Completa todos los campos").show();
                return;
            }

            if (dao.actualizar(c)) {
                view.limpiarFormulario();
                view.mostrarContactos(dao.listarContactos());
            } else {
                new Alert(Alert.AlertType.ERROR, "No se pudo actualizar el contacto").show();
            }
        });

        // ==========================================
        // ELIMINAR (NUEVO)
        // ==========================================

        view.getBtnEliminar().setOnAction(e -> {

            Contacto seleccionado = view.getContactoSeleccionado();

            if (seleccionado == null) {
                new Alert(Alert.AlertType.WARNING, "Selecciona un contacto haciendo clic en su tarjeta").show();
                return;
            }

            Alert confirmar = new Alert(
                    Alert.AlertType.CONFIRMATION,
                    "¿Eliminar a " + seleccionado.getNombre() + " " + seleccionado.getApellido() + "?"
            );

            confirmar.showAndWait().ifPresent(respuesta -> {
                if (respuesta == ButtonType.OK) {
                    if (dao.eliminar(seleccionado.getId())) {
                        view.limpiarFormulario();
                        view.mostrarContactos(dao.listarContactos());
                    } else {
                        new Alert(Alert.AlertType.ERROR, "No se pudo eliminar el contacto").show();
                    }
                }
            });
        });
    }

    // NUEVO: validación reutilizable
    private boolean camposVacios(Contacto c) {
        return c.getNombre().isEmpty() || c.getApellido().isEmpty()
                || c.getTelefono().isEmpty() || c.getCorreo().isEmpty()
                || c.getMensaje().isEmpty();
    }
}